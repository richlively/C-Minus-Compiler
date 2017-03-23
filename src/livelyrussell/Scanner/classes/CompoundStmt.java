package livelyrussell.Scanner.classes;

import java.util.ArrayList;

public class CompoundStmt extends Statement {
    private ArrayList<Declaration> localdecls;
    private ArrayList<Statement> stmtlist;
    
    public CompoundStmt(ArrayList<Declaration> d, ArrayList<Statement> s) {
        super(Statement.type.COMPOUND);
        localdecls = d;
        stmtlist = s;
    }
}
