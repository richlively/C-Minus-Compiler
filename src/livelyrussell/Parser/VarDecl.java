package livelyrussell.Parser;

import java.io.PrintStream;

public class VarDecl extends Declaration{

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
            tabs+="\t";
        }
        out.println(tabs + "VarDecl: INT " + id);
        if (n!=null) {
            n.print(out, indent+1);
        }
    }
}
