
package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;

public class ReturnStmt extends Statement {

    public ExpressionStmt estmt;

    public ReturnStmt(ExpressionStmt e) {
        super(Statement.type.RETURN);
        estmt = e;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Return Statement: RETURN");
        estmt.print(out, indent + 1);
    }

    public CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}