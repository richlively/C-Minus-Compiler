package parser;

import java.io.PrintStream;

public class Param implements ParseObject {

    private boolean isvoid;
    public String id;
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
    
    public boolean isVoid(){
        return isvoid;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.print(tabs + "Param: ");
        if (isvoid) {
            out.print("VOID");
        } else {
            out.print(id);
            if (isArray) {
                out.print(" []");
            }
        }
        out.println();
    }
}
