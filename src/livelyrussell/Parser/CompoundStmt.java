package livelyrussell.Parser;

import java.util.ArrayList;

public class CompoundStmt extends Statement {
    private ArrayList<VarDecl> localdecls;
    private ArrayList<Statement> stmtlist;
    
    public CompoundStmt(ArrayList<VarDecl> d, ArrayList<Statement> s) {
        super(Statement.type.COMPOUND);
        localdecls = d;
        stmtlist = s;
    }
}
