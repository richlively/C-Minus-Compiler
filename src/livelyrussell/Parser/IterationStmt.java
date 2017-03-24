package livelyrussell.Parser;

import java.io.PrintStream;

public class IterationStmt extends Statement {
    //WHILE ( exp ) stmt
    private Expression exp;
    private Statement stmt;

    IterationStmt(Expression e, Statement s) {
        super(Statement.type.ITERATE);
        exp = e;
        stmt = s;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
