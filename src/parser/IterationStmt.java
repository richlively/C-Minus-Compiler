package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Function;

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
        exp.print(out, indent + 1);
        stmt.print(out, indent + 1);
    }

    @Override
    public void genLLCode(Function fun) {
        
    }
}
