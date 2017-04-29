package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import lowlevel.CodeItem;
import lowlevel.FuncParam;
import lowlevel.Function;

public class FunDecl extends Declaration {

    @Override
    public CodeItem genLLCode() {
        int t;
        if(kind == type.VOID){
            t = 0;
        } else {
            t = 1;
        }
        String name = id;
        FuncParam param;
        if(params.size() > 0){
            
        } else {
            param = null;
        }
        for
    }

    public enum type {

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
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "FunDecl: " + kind + " " + id);

        for (Iterator<Param> it = params.iterator(); it.hasNext();) {
            Param param = it.next();
            param.print(out, indent + 1);
        }

        cs.print(out, indent + 1);
    }
}
