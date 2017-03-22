/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner.classes;

import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

/**
 *
 * @author Jesse
 */
public class ReturnStmt extends Statement {
    public ExpressionStmt estmt;
    public ReturnStmt(ExpressionStmt e){
        super(null,"return");
        this.estmt = e;
    }
    public ReturnStmt parseReturn(CMinusScanner scan) throws Exception{
        scan.matchToken(Token.TokenType.RETURN);
        ExpressionStmt e = estmt.parseEStmt(scan);
        
        return new ReturnStmt(e);
    }
}
