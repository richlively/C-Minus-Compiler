package parser;

import java.io.PrintStream;
import lowlevel.BasicBlock;
import lowlevel.Function;

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

    @Override
    public void genLLCode(Function fun, CompoundStmt cs) {
        BasicBlock curr = fun.getCurrBlock();
        if (estmt != null) {
            estmt.genLLCode(fun, cs);
        }
        fun.genReturnBlock();
    }
}
