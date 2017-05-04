package parser;

import static compiler.CMinusCompiler.globalHash;
import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Data;
import static lowlevel.Data.*;

public class VarDecl extends Declaration {

    //if n=null, there was no brackets
    private NumExp n;

    VarDecl(String i, NumExp num) {
        super(i);
        n = num;
    }

    //For a non-array
    VarDecl(String i) {
        this(i, null);
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "VarDecl: INT " + id);
        if (n != null) {
            n.print(out, indent + 1);
        }
    }

    @Override
    public CodeItem genLLCode() {
        boolean isNotArray = (n == null);
        Data retval;
        if (isNotArray) {
            retval = new Data(TYPE_INT, id);
        } else {
            retval = new Data(TYPE_INT, id, true, n.getNum());
        }
        globalHash.put(id, retval);
        return retval;
    }
}
