/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner;

/**
 *
 * @author Jesse
 */
public class Token {
    public enum TokenType {
        INT_TOKEN,
        DOUBLE_TOKEN,
        IF_TOKEN,
        EOF_TOKEN,
        // TODO: rest of tokens ....
    }

    private TokenType tokenType;
    private Object tokenData;
        
    public Token (TokenType type, Object data) {
        tokenType = type;
        tokenData = data;
    }
    
    public Token (TokenType type) {
        this (type, null);
    }

    public Token scanToken(){
        //TODO
        return new Token(TokenType.DOUBLE_TOKEN);//Garbage
    }

    public TokenType viewType(){
        //TODO
        return TokenType.IF_TOKEN;//Garbage
    }
}
