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
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Iteration Statement: " + "WHILE");
        out.println(tabs + "(");
        exp.print(out, indent+1);
        out.println(tabs + ")");
    }
}
