package livelyrussell.Scanner.classes;

import java.util.ArrayList;

public class FunDecl extends Declaration {
    public enum type{
        VOID, INT
    }
    private FunDecl.type kind;
    private String id;
    private CompoundStmt cs;
    private ArrayList<Param> params;

    FunDecl(String i, CompoundStmt c, ArrayList<Param> p, FunDecl.type t) {
        kind = t;
        id = i;
        cs = c;
        params = p;
    }

}
