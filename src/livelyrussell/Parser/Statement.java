package livelyrussell.Parser;

import lowlevel.CodeItem;
import lowlevel.Function;

public abstract class Statement implements ParseObject {

    void genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum type {
        COMPOUND, EXP, SELECT, ITERATE, RETURN
    }
    protected final Statement.type kind;

    Statement(Statement.type t) {
        kind = t;
    }

}
