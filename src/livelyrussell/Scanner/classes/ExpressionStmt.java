
package livelyrussell.Scanner.classes;

public class ExpressionStmt extends Statement{
    // exp ;
    private Expression exp;
    
    public ExpressionStmt(Expression ee) {
        super(Statement.type.EXP);
        exp = ee;
    }
}
