package livelyrussell.Parser;

import java.io.PrintStream;

public class VarDecl extends Declaration{

    //if n=null, there was no parentheses
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
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
