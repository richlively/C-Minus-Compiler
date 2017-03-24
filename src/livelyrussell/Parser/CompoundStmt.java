package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class CompoundStmt extends Statement {

    private ArrayList<VarDecl> localdecls;
    private ArrayList<Statement> stmtlist;

    public CompoundStmt(ArrayList<VarDecl> d, ArrayList<Statement> s) {
        super(Statement.type.COMPOUND);
        localdecls = d;
        stmtlist = s;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Compound Statement:");
        out.println(tabs + "{");
        out.println(tabs + "\tLocal Decls:");
        for (Iterator<VarDecl> it = localdecls.iterator(); it.hasNext();) {
            VarDecl localdecl = it.next();
            localdecl.print(out, indent + 2);
        }
        out.println(tabs + "\tStatement List:");
        for (Iterator<Statement> it = stmtlist.iterator(); it.hasNext();) {
            Statement stmt = it.next();
            stmt.print(out, indent + 2);
        }
        out.println(tabs + "}");
    }
}
