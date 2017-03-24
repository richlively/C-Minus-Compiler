package livelyrussell.Parser;

import java.io.PrintStream;

public class VarDecl extends Declaration{

    //if n=null, there was no brackets
    private Integer n;

    VarDecl(String i, Integer num) {
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
        out.print(tabs + "VarDecl: INT " + id);
        if (n!=null) {
            out.print(" ["+n+"]");
        }
        out.println();
    }
}
