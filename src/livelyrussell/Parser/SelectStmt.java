package livelyrussell.Parser;

import java.io.PrintStream;
import lowlevel.CodeItem;

public class SelectStmt extends Statement {

    //IF ( exp ) stmt [ELSE stmt]
    private Expression exp;
    private Statement ifstmt;
    private Statement elsestmt;

    public SelectStmt(Expression e, Statement ifs, Statement elses) {
        super(Statement.type.SELECT);
        exp = e;
        ifstmt = ifs;
        elsestmt = elses;
    }

    public SelectStmt(Expression e, Statement ifs) {
        this(e, ifs, null);
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Select Statement: IF");
        exp.print(out, indent + 1);
        ifstmt.print(out, indent + 1);
        if (elsestmt != null) {
            out.println(tabs + "ELSE");
            elsestmt.print(out, indent + 1);
        }
    }

    public CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
