/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner.classes;

import livelyrussell.Scanner.CMinusScanner;

/**
 *
 * @author Jesse
 */
public class ExpressionStmt extends Statement{
    
    
    public ExpressionStmt parseEStmt(CMinusScanner scan){
        return new ExpressionStmt();
    }
}
