/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner.classes;

/**
 *
 * @author Jesse
 */
public class AssignExp extends Expression{
    //first thing on right side of line 18 on page 492
    private VarDecl var;
    private Expression exp;
    
    
    public AssignExp(VarDecl v, Expression e) {
        super(Expression.type.ASSIGN);
        var = v;
        exp = e;
    }
    
}
