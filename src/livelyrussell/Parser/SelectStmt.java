package livelyrussell.Parser;

import java.io.PrintStream;

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
        out.println(tabs + "(");
        exp.print(out, indent + 1);
        out.println(tabs + ")");
        ifstmt.print(out, indent + 1);
        if (elsestmt != null) {
            out.println(tabs + "ELSE");
            elsestmt.print(out, indent + 1);
        }
    }

}
