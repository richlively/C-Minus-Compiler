package livelyrussell.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Jesse Russel
 * @author Rich Lively
 * @date Feb. 7, 2017
 * Object representation of a lexical token for use in a scanner
 */
public class Token {

    public enum TokenType {
        //Bookkeeping tokens
        EOF, ERROR,
        //Reserved words
        ELSE, IF, INT, RETURN, VOID, WHILE,
        //Special Symbols
        PLUS, MINUS, STAR, SLASH, ASSIGN, SEMICOLON, COMMA,
        //Comparators
        GREATER_THAN, GREATER_EQUAL, LESS_THAN,
        LESS_EQUAL, EQUAL, NOT_EQUALS,
        //Separators
        LEFTPAREN, RIGHTPAREN, LEFTSQUARE, RIGHTSQUARE,
        LEFTCURLY, RIGHTCURLY,
        //Multicharacter token
        ID, NUM,
    }

    private TokenType tokenType;
    private Object tokenData;

    public Token(TokenType type, Object data) {
        tokenType = type;
        tokenData = data;
    }

    public Token(TokenType type) {
        this(type, null);
    }

    public TokenType viewType() {
        return tokenType;
    }

    public Object viewData() {
        return tokenData;
    }

    public void setType(TokenType t) {
        tokenType = t;
    }

    public void setData(Object o) {
        tokenData = o;
    }
    
    /**
     * Prints the token in the correct format based on its type
     *
     * @param outFile
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void printToken(File outFile) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(outFile, true);
        PrintStream ps = new PrintStream(fos);
        switch (tokenType) {
            //format for reserved words
            case IF:
            case ELSE:
            case INT:
            case RETURN:
            case VOID:
            case WHILE:
                ps.printf("reserved word: %s\r\n", tokenData);
                break;
            //format for operators
            case PLUS:
                ps.printf("operator: +\r\n");
                break;
            case MINUS:
                ps.printf("operator: -\r\n");
                break;
            case STAR:
                ps.printf("operator: *\r\n");
                break;
            case SLASH:
                ps.printf("operator: /\r\n");
                break;
            case ASSIGN:
                ps.printf("operator: =\r\n");
                break;
            case GREATER_THAN:
                ps.printf("operator: >\r\n");
                break;
            case GREATER_EQUAL:
                ps.printf("operator: >=\r\n");
                break;
            case LESS_THAN:
                ps.printf("operator: <\r\n");
                break;
            case LESS_EQUAL:
                ps.printf("operator: <=\r\n");
                break;
            case EQUAL:
                ps.printf("operator: ==\r\n");
                break;
            case NOT_EQUALS:
                ps.printf("operator: !=\r\n");
                break;
            //format for syntax and grouping
            case SEMICOLON:
                ps.printf(";\r\n");
                break;
            case COMMA:
                ps.printf(",\r\n");
                break;
            case LEFTPAREN:
                ps.printf("(\r\n");
                break;
            case RIGHTPAREN:
                ps.printf(")\r\n");
                break;
            case LEFTSQUARE:
                ps.printf("[\r\n");
                break;
            case RIGHTSQUARE:
                ps.printf("]\r\n");
                break;
            case LEFTCURLY:
                ps.printf("{\r\n");
                break;
            case RIGHTCURLY:
                ps.printf("}\r\n");
                break;
            //format for special cases
            case ID:
                ps.printf("ID, name = %s\r\n", tokenData);
                break;
            case NUM:
                ps.printf("NUM, value = %d\r\n", tokenData);
                break;
            case ERROR:
                ps.printf("ERROR: %s\r\n", tokenData);
                break;
            case EOF:
                ps.printf("EOF");
                break;
            //should never happen
            default:
                ps.printf("Unknown token type");
                break;
        }
        ps.close();
        fos.close();
    }
}
