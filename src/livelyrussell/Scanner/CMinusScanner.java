/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner;

import java.io.BufferedReader;

/**
 *
 * @author Jesse
 */
public class CMinusScanner implements Scanner {

    private BufferedReader inFile;
    private Token nextToken;

    public CMinusScanner (BufferedReader file) {
        inFile = file;
        nextToken = scanToken();
    }
    @Override
    public Token getNextToken () {
        Token returnToken = nextToken;
        if (nextToken.viewType() != Token.TokenType.EOF)
            nextToken = scanToken();
        return returnToken;
    }
    @Override
    public Token viewNextToken () {
        return nextToken;
    }
    
    public Token scanToken(){
        //TODO
        return new Token(Token.TokenType.IF);//Garbage
    }
}

