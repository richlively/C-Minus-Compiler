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
        ELSE_TOKEN,         //else
        IF_TOKEN,           //if
        INT_TOKEN,          //int
        RETURN_TOKEN,       //return
        VOID_TOKEN,         //void
        WHILE_TOKEN,        //while
        EOF_TOKEN,          //EOF
        PLUS_TOKEN,         //+
        MINUS_TOKEN,        //-
        MULT_TOKEN,         //*
        DIV_TOKEN,          // /
        GREATERTHAN_TOKEN,  //>
        GREATEREQUAL_TOKEN, //>=
        LESSTHAN_TOKEN,     //<
        LESSEQUALS_TOKEN,   //<=
        EQUALS_TOKEN,       //==
        NOTEQUALS_TOKEN,    //!=
        ASSIGN_TOKEN,       //=
        SEMICOLON_TOKEN,    //;
        COMMA_TOKEN,        //,
        LEFTPAREN_TOKEN,    //(
        RIGHTPAREN_TOKEN,   //)
        LEFTSQUARE_TOKEN,   //[
        RIGHTSQUARE_TOKEN,  //]
        LEFTCURLY_TOKEN,    //{
        RIGHTCURLY_TOKEN,   //}
        COMMENTSTART_TOKEN, // /*
        COMMENTEND_TOKEN,   // */
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

    public TokenType viewType(){
       return tokenType;
    }
    
    public Object viewData(){
        return tokenData;
    }
}
