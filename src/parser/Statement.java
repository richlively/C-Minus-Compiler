package parser;

import lowlevel.CodeItem;
import lowlevel.Function;

public abstract class Statement implements ParseObject {
    
    Integer register;
    
    public Integer getRegister() {
        return register;
    }
    
    public void setRegister(Integer r) {
        register = r;
    }

    public enum type {
        COMPOUND, EXP, SELECT, ITERATE, RETURN
    }
    protected final Statement.type kind;

    Statement(Statement.type t) {
        kind = t;
    }

    public abstract void genLLCode(Function fun);
    
}
