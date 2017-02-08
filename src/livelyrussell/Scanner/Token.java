package livelyrussell.Scanner;

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
}
