package livelyrussell.Parser;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import lowlevel.CodeItem;
import lowlevel.Function;

public class CompoundStmt extends Statement {

    private final ArrayList<VarDecl> localdecls;
    private final ArrayList<Statement> stmtlist;

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
        out.println(tabs + "\tLocal Decls:");
        if(localdecls.isEmpty()) {
            out.println(tabs + "\t\tNone");
        }
        for (Iterator<VarDecl> it = localdecls.iterator(); it.hasNext();) {
            VarDecl localdecl = it.next();
            localdecl.print(out, indent + 2);
        }
        out.println(tabs + "\tStatement List:");
        if(stmtlist.isEmpty()) {
            out.println(tabs + "\t\tNone");
        }
        for (Iterator<Statement> it = stmtlist.iterator(); it.hasNext();) {
            Statement stmt = it.next();
            stmt.print(out, indent + 2);
        }
    }

    public CodeItem genLLCode(Function fun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
