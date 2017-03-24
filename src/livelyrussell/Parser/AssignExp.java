
package livelyrussell.Parser;

import java.io.PrintStream;

public class AssignExp extends Expression{
    //first thing on right side of line 18 on page 492
    private VarExp var;
    private Expression exp;
    
    
    public AssignExp(VarExp v, Expression e) {
        super(Expression.type.ASSIGN);
        var = v;
        exp = e;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
