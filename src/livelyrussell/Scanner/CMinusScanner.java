/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;

/**
 *
 * @author Jesse
 */
public class CMinusScanner implements Scanner {

    private BufferedReader inFile;
    private Token nextToken;
    private final static char EOF = (char) -1;

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
        Token.TokenType type;
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
            
            if(save){
                if(state == State.IN_NUM){
                    
                }
            }
            
        }
        return new Token(Token.TokenType.IF);//Garbage
    }

    public static void main(String args[]) {

    }
}
