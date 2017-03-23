package livelyrussell.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;

/**
 * @author Jesse Russell
 * @author Rich Lively
 * @date Feb. 7, 2017 CMinusScanner.java This class provides an implementation
 * of a C- lexical scanner. The state DFA was designed by hand.
 */
public class CMinusScanner implements Scanner {

    //objects for file i/o
    private final BufferedReader inFile;
    private static final File OUT_FILE = new File("output.txt");

    private final static char EOF = (char) -1;
    //look-up of C- keywords
    private static final HashMap KEYWORDS = new HashMap();
    //stores what the next token will be for look-ahead behavior
    private Token nextToken;

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

    /**
     * Constructs the C- Scanner and automatically scans the first token.
     *
     * @param file BufferedReader for file that will be scanned
     * @param filename for the input file
     * @throws IOException
     */
    public CMinusScanner(BufferedReader file, String filename) throws IOException {
        inFile = file;

        //key: string representation of token, value: actual token type
        KEYWORDS.put("else", Token.TokenType.ELSE);
        KEYWORDS.put("if", Token.TokenType.IF);
        KEYWORDS.put("int", Token.TokenType.INT);
        KEYWORDS.put("return", Token.TokenType.RETURN);
        KEYWORDS.put("void", Token.TokenType.VOID);
        KEYWORDS.put("while", Token.TokenType.WHILE);

        //overwrite output file with introductory line
        PrintStream ps = new PrintStream(new FileOutputStream(OUT_FILE, false));
        ps.printf("C- Compiler Lex Debug Output: %s\r\n\r\n", filename);
        ps.close();

        nextToken = scanToken();
    }

    /**
     * Returns the next token and automatically looks-ahead at the next token
     *
     * @return the next token
     * @throws IOException
     */
    @Override
    public Token getNextToken() throws IOException {
        Token returnToken = nextToken;
        if (nextToken.viewType() != Token.TokenType.EOF) {
            nextToken = scanToken();
        }
        return returnToken;
    }

    /**
     * Return the next token without the look-ahead
     *
     * @return the next token
     */
    @Override
    public Token viewNextToken() {
        return nextToken;
    }

    /**
     * Scans and prints a complete, lexical token
     *
     * @return the token scanned
     * @throws IOException
     */
    private Token scanToken() throws IOException {
        State state = State.START;
        //default values in case something goes wrong
        Token.TokenType type = Token.TokenType.ERROR;
        Token token = new Token(type);
        //whether to save the character to the token data or not
        boolean save;
        while (state != State.DONE) {
            save = true;
            //mark where we were so that we can "unget" a character if necessary
            inFile.mark(1);
            char c = (char) inFile.read();

            //use c to determine what to do in the state
            switch (state) {
                case START:
                    if (isWhitespace(c)) {
                        save = false;
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
                        //these states are only one character
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

                //TODO: make sure there is whitespace between NUM and ID
                //i.e. xyz123 or 123xyz should be an error token
                case IN_NUM:
                    if (!isDigit(c)) {
                        state = State.DONE;
                        //a number cannot have a letter; lexical error
                        if (isLetter(c)) {
                            type = Token.TokenType.ERROR;
                        } //start of a new token
                        else {
                            //"unget" the character
                            inFile.reset();
                            save = false;
                            type = Token.TokenType.NUM;
                        }
                    }
                    break;
                case IN_ID:
                    if (!isLetter(c)) {
                        state = State.DONE;
                        //an ID cannot have a digit; lexical error
                        if (isDigit(c)) {
                            type = Token.TokenType.ERROR;
                        } //start of a new token
                        else {
                            //"unget" the character
                            inFile.reset();
                            save = false;
                            type = Token.TokenType.ID;
                        }
                    }
                    break;
                case IN_NOT:
                    if (c == '=') {
                        // !=
                        type = Token.TokenType.NOT_EQUALS;
                    } else {
                        // ! Error
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.ERROR;
                    }
                    state = State.DONE;
                    break;
                case IN_ASSIGN:
                    if (c == '=') {
                        // ==
                        type = Token.TokenType.EQUAL;
                    } else {
                        // =
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.ASSIGN;
                    }
                    state = State.DONE;
                    break;
                case IN_GT:
                    if (c == '=') {
                        // >=
                        type = Token.TokenType.GREATER_EQUAL;
                    } else {
                        // >
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.GREATER_THAN;
                    }
                    state = State.DONE;
                    break;
                case IN_LT:
                    if (c == '=') {
                        // <=
                        type = Token.TokenType.LESS_EQUAL;
                    } else {
                        // <
                        inFile.reset();
                        save = false;
                        type = Token.TokenType.LESS_THAN;
                    }
                    state = State.DONE;
                    break;
                case IN_SLASH:
                    if (c == '*') {
                        //beginning of comment
                        state = State.IN_COM1;
                        save = false;
                        //clear any data that was in the token
                        token.setData(null);
                    } else {
                        // a '/' token
                        inFile.reset();
                        save = false;
                        state = State.DONE;
                        type = Token.TokenType.SLASH;
                    }
                    break;
                /*
                 * handles being within a comment and transitions
                 * when the comment might end
                 */
                case IN_COM1:
                    save = false;
                    if (c == '*') {
                        state = State.IN_COM2;
                    } //handles a non-closing comment
                    else if (c == EOF) {
                        inFile.reset();
                        state = State.START;
                    }
                    break;
                /*
                 * determines if the comment actually ended, could end,
                 * or did not end
                 */
                case IN_COM2:
                    save = false;
                    switch (c) {
                        //end of comment
                        case '/':
                            state = State.START;
                            break;
                        case '*':
                            //stay in state
                            state = State.IN_COM2;
                            break;
                        case EOF:
                            //handles a non-closing comment
                            inFile.reset();
                            state = State.START;
                            break;
                        default:
                            state = State.IN_COM1;
                            break;
                    }
                    break;
                //this should never happen
                case DONE:
                default:
                    System.out.println("Unexpected behavior for token "
                            + "with data: " + token.viewData() + c);
                    state = State.DONE;
                    type = Token.TokenType.ERROR;
                    break;
            }
            //whether to append the character to the data or not
            if (save) {
                String temp = (String) token.viewData();
                //there is no data yet, set to empty
                if (temp == null) {
                    temp = "";
                }
                token.setData((Object) (temp + String.valueOf(c)));
            }
            if (state == State.DONE) {
                token.setType(type);
                Object data = token.viewData();
                if (token.viewType() == Token.TokenType.NUM) {
                    Integer number = Integer.parseInt((String) data);
                    token.setData(number);
                } else if (token.viewType() == Token.TokenType.ID) {
                    type = (Token.TokenType) KEYWORDS.get((String) data);
                    //if the ID is actually a keyword, set it to the correct type
                    if (type != null) {
                        token.setType(type);
                    }
                    //else the type is ID
                }
            }
        }
        return token;
    }



    /**
     * Uses the scanner to scan all the tokens from an input file
     *
     * @param args
     */
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

            CMinusScannerb cms = new CMinusScannerb(file, filename);

            //get all tokens
            while (cms.viewNextToken().viewType() != Token.TokenType.EOF) {
                Token tok = cms.getNextToken();
                tok.printToken(OUT_FILE);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("The file " + filename + " could not be found.");
        } catch (IOException ex) {
            Logger.getLogger(CMinusScanner.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
