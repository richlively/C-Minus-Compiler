package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Function;

public class ExpressionStmt extends Statement {

    // exp ;
    private Expression exp;

    public ExpressionStmt(Expression ee) {
        super(Statement.type.EXP);
        exp = ee;
    }
    
    public Expression getExp() {
        return exp;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Expression Statement:");
        if (exp != null) {
            exp.print(out, indent + 1);
        } else {
            out.println(tabs + "No Expression");
        }
    }

    @Override
    public int genLLCode(Function fun, CompoundStmt cs) {
        return exp.genLLCode(fun, cs);
    }
}
