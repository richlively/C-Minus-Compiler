/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesse
 */
public class CMinusScanner implements Scanner {

    private BufferedReader inFile;
    private File outFile;
    private Token nextToken;
    private final static char EOF = (char) -1;
    private static HashMap map = new HashMap();

    private enum State {
        //Movement
        START, DONE,
        //Midway states
        IN_NUM, IN_ID,
        IN_NOT, IN_ASSIGN,
        IN_GT, IN_LT, IN_SLASH,
        //Comments
        IN_COM1, IN_COM2
    }

    public CMinusScanner(BufferedReader file) throws IOException {
        inFile = file;
        nextToken = scanToken();
        outFile = new File("output.txt");

        map.put("else", Token.TokenType.ELSE);
        map.put("if", Token.TokenType.IF);
        map.put("int", Token.TokenType.INT);
        map.put("return", Token.TokenType.RETURN);
        map.put("void", Token.TokenType.VOID);
        map.put("while", Token.TokenType.WHILE);
    }

    @Override
    public Token getNextToken() throws IOException {
        Token returnToken = nextToken;
        if (nextToken.viewType() != Token.TokenType.EOF) {
            nextToken = scanToken();
        }
        return returnToken;
    }

    @Override
    public Token viewNextToken() {
        return nextToken;
    }

    public Token scanToken() throws IOException {

        State state = State.START;
        Token.TokenType type = Token.TokenType.ERROR;
        //Default token type should be changed later on.
        Token token = new Token(Token.TokenType.ERROR);
        boolean save;
        while (state != State.DONE) {
            save = true;
            //hold on to character so we don't run ahead
            inFile.mark(2);
            //read first char
            char c = (char) inFile.read();

            //switch on char for each case
            switch (state) {
                case START:
                    if (isWhitespace(c)) {
                        break;
                    } else if (isDigit(c)) {
                        state = State.IN_NUM;
                    } else if (isLetter(c)) {
                        state = State.IN_ID;
                    } else if (c == '=') {
                        state = State.IN_ASSIGN;
                    } else if (c == '>') {
                        state = State.IN_GT;
                    } else if (c == '<') {
                        state = State.IN_LT;
                    } else if (c == '/') {
                        state = State.IN_SLASH;
                    } else if (c == '!') {
                        state = State.IN_NOT;
                    } else {
                        state = State.DONE;
                        switch (c) {
                            case EOF:
                                save = false;
                                type = Token.TokenType.EOF;
                                break;
                            case '+':
                                type = Token.TokenType.PLUS;
                                break;
                            case '-':
                                type = Token.TokenType.MINUS;
                                break;
                            case '*':
                                type = Token.TokenType.STAR;
                                break;
                            case '(':
                                type = Token.TokenType.LEFTPAREN;
                                break;
                            case ')':
                                type = Token.TokenType.RIGHTPAREN;
                                break;
                            case '{':
                                type = Token.TokenType.LEFTCURLY;
                                break;
                            case '}':
                                type = Token.TokenType.RIGHTCURLY;
                                break;
                            case '[':
                                type = Token.TokenType.LEFTSQUARE;
                                break;
                            case ']':
                                type = Token.TokenType.RIGHTSQUARE;
                                break;
                            case ';':
                                type = Token.TokenType.SEMICOLON;
                                break;
                            case ',':
                                type = Token.TokenType.COMMA;
                                break;
                            default:
                                type = Token.TokenType.ERROR;
                                break;
                        }
                    }
                    break;

                case IN_NUM:
                    if (!isDigit(c)) {
                        inFile.reset();
                        save = false;
                        state = State.DONE;
                        type = Token.TokenType.NUM;
                    }
                    break;
                case IN_ID:
                    if (!isLetter(c)) {
                        inFile.reset();
                        save = false;
                        state = State.DONE;
                        type = Token.TokenType.ID;
                    }
                    break;
                case IN_NOT:
                    if (c == '=') {
                        type = Token.TokenType.NOT_EQUALS;
                        state = State.DONE;
                    } else {
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.ERROR;
                    }
                    break;
                case IN_ASSIGN:
                    if (c == '=') {
                        type = Token.TokenType.EQUAL;
                        state = State.DONE;
                    } else {
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.ASSIGN;
                        state = State.DONE;
                    }
                    break;
                case IN_GT:
                    if (c == '=') {
                        type = Token.TokenType.GREATER_EQUAL;
                        state = State.DONE;
                    } else {
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.GREATER_THAN;
                        state = State.DONE;
                    }
                    break;
                case IN_LT:
                    if (c == '=') {
                        type = Token.TokenType.LESS_EQUAL;
                        state = State.DONE;
                    } else {
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.LESS_THAN;
                        state = State.DONE;
                    }
                    break;
                case IN_SLASH:
                    if (c == '*') {
                        state = State.IN_COM1;
                        save = false;
                        token.setData(null);
                    } else {
                        inFile.reset();
                        save = false;
                        state = State.DONE;
                        type = Token.TokenType.SLASH;
                    }
                    break;
                case IN_COM1:
                    save = false;
                    if (c == '*') {
                        state = State.IN_COM2;
                    }
                    break;
                case IN_COM2:
                    save = false;
                    switch (c) {
                        case '/':
                            state = State.START;
                            break;
                        case '*':
                            state = State.IN_COM2;
                            break;
                        default:
                            state = State.IN_COM1;
                            break;
                    }
                    break;
                case DONE:
                default:
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGH!");
                    state = State.DONE;
                    type = Token.TokenType.ERROR;
                    break;
            }

            if (save) {
                String temp;
                temp = (String) token.viewData();
                token.setData((Object) (temp + String.valueOf(c)));
                break;
            }
            if (state == State.DONE) {
                token.setType(type);
                if (token.viewType() == Token.TokenType.NUM) {
                    Integer holder = Integer.parseInt((String) token.viewData());
                    token.setData(holder);
                } else if (token.viewType() == Token.TokenType.ID) {
                    String holder = (String) token.viewData();
                    type = (Token.TokenType) map.get(holder);
                    if (type != null) {
                        token.setType(type);
                    }
                }
            }
        }

        return token;
    }

    private void printToken(Token token) throws FileNotFoundException {
        PrintStream ps = new PrintStream(outFile);
        switch (token.viewType()) {
            case IF:
            case ELSE:
            case INT:
            case RETURN:
            case VOID:
            case WHILE:
                ps.printf("reserved word: %s\n", token.viewData());
            case PLUS:
                ps.printf("+\n");
            case MINUS:
                ps.printf("-\n");
            case STAR:
                ps.printf("*\n");
            case SLASH:
                ps.printf("/\n");
            case ASSIGN:
                ps.printf("=\n");
            case SEMICOLON:
                ps.printf(";\n");
            case COMMA:
                ps.printf(",\n");
            case GREATER_THAN:
                ps.printf(">\n");
            case GREATER_EQUAL:
                ps.printf(">=\n");
            case LESS_THAN:
                ps.printf("<\n");
            case LESS_EQUAL:
                ps.printf("<=\n");
            case EQUAL:
                ps.printf("==\n");
            case NOT_EQUALS:
                ps.printf("!=\n");
            case LEFTPAREN:
                ps.printf("(\n");
            case RIGHTPAREN:
                ps.printf(")\n");
            case LEFTSQUARE:
                ps.printf("[\n");
            case RIGHTSQUARE:
                ps.printf("]\n");
            case LEFTCURLY:
                ps.printf("{\n");
            case RIGHTCURLY:
                ps.printf("}\n");
            case ID:
                ps.printf("ID, name = %s\n", token.viewData());
            case NUM:
                ps.printf("NUM, value = %i\n", token.viewData());
            case ERROR:
                ps.printf("ERROR: %s\n", token.viewData());
            case EOF:
                ps.printf("EOF");
            default:
                ps.printf("wat");
        }
    }

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("File Name:");
        String filename = new String();
        BufferedReader file;

        try {
            //get filename
            filename = br.readLine();
            //create buffered reader BufferedReader file;
            file = new BufferedReader(new FileReader(filename));

            CMinusScanner cms = new CMinusScanner(file);
            while (cms.viewNextToken().viewType() != Token.TokenType.EOF) {
                cms.printToken(cms.getNextToken());
            }

        } catch (IOException ex) {
            Logger.getLogger(CMinusScanner.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
