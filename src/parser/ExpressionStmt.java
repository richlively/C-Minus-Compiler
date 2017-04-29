package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;

public class ExpressionStmt extends Statement {

    // exp ;
    private Expression exp;

    public ExpressionStmt(Expression ee) {
        super(Statement.type.EXP);
        exp = ee;
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

    public CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}