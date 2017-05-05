package parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import lowlevel.Function;

public class CompoundStmt extends Statement {

    private final ArrayList<VarDecl> localdecls;
    private final ArrayList<Statement> stmtlist;
    private final HashMap symbolTable;

    public CompoundStmt(ArrayList<VarDecl> d, ArrayList<Statement> s) {
        super(Statement.type.COMPOUND);
        localdecls = d;
        stmtlist = s;
        symbolTable = new HashMap();
    }
    
    public HashMap getTable() {
        return symbolTable;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Compound Statement:");
        out.println(tabs + "\tLocal Decls:");
        if (localdecls.isEmpty()) {
            out.println(tabs + "\t\tNone");
        }
        for (VarDecl localdecl : localdecls) {
            localdecl.print(out, indent + 2);
        }
        out.println(tabs + "\tStatement List:");
        if (stmtlist.isEmpty()) {
            out.println(tabs + "\t\tNone");
        }
        for (Statement stmt : stmtlist) {
            stmt.print(out, indent + 2);
        }
    }

    @Override
    public int genLLCode(Function fun, CompoundStmt cs) {
        //gen local_decls
        for (Declaration decl : localdecls) {
            symbolTable.put(decl.id, fun.getNewRegNum());
        }

        //gen stmts
        for(Statement stmt : stmtlist){
            stmt.genLLCode(fun, this);
        }
        return 0;
    }
}
