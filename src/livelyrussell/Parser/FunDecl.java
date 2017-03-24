package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FunDecl extends Declaration{
    public enum type{
        VOID, INT
    }
    private final FunDecl.type kind;
    private final CompoundStmt cs;
    private final ArrayList<Param> params;

    FunDecl(String i, CompoundStmt c, ArrayList<Param> p, FunDecl.type t) {
        super(i);
        cs = c;
        params = p;
        kind = t;
    }
    
    @Override
    public void print(PrintStream out) {
        out.println("FunDecl: " + kind + " " + id);
        if (params.isEmpty()) {
            out.println("\t()");
        }
        else {
            out.println("\t(");
            for (Iterator<Param> it = params.iterator(); it.hasNext();) {
                Param param = it.next();
                out.print("\t\t");
                param.print(out);
            }
            out.println("\t)");
        }
        out.print("\t");
        
    }
}
