
package livelyrussell.Parser;

import java.io.PrintStream;

public class ExpressionStmt extends Statement{
    // exp ;
    private Expression exp;
    
    public ExpressionStmt(Expression ee) {
        super(Statement.type.EXP);
        exp = ee;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
