package livelyrussell.Parser;

import java.io.PrintStream;

public class Param implements ParseObject{

    private boolean isvoid;
    private String id;
    //If id == VOID, there were no params
    //Also known as empty param-list.
    private boolean isArray;

    Param(String i, boolean a, boolean v) {
        id = i;
        isArray = a;
        isvoid = v;
    }

    Param(String i, boolean a) {
        id = i;
        isArray = a;
        isvoid = false;
    }

    

    Param(String i) {
        this(i, false, false);
    }

    Param() {
        this("", false, true);
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
