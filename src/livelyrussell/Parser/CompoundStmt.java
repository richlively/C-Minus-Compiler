package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;

public class CompoundStmt extends Statement implements ParseObject{
    private ArrayList<VarDecl> localdecls;
    private ArrayList<Statement> stmtlist;
    
    public CompoundStmt(ArrayList<VarDecl> d, ArrayList<Statement> s) {
        super(Statement.type.COMPOUND);
        localdecls = d;
        stmtlist = s;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
