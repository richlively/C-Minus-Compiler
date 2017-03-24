package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;

public class FunDecl extends Declaration{

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public enum type{
        VOID, INT
    }
    private FunDecl.type kind;
    private CompoundStmt cs;
    private ArrayList<Param> params;

    FunDecl(String i, CompoundStmt c, ArrayList<Param> p, FunDecl.type t) {
        super(i);
        kind = t;
        cs = c;
        params = p;
    }
}
