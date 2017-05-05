package parser;

import lowlevel.Function;

public abstract class Statement implements ParseObject {
    
    private Integer register;
    //parent is used for linking together parse objects for
    //the purpose of connecting all the local symbol tables
    private ParseObject parent;
    
    public Integer getRegister() {
        return register;
    }
    
    public void setRegister(Integer r) {
        register = r;
    }
    
    public ParseObject getParent() {
        return parent;
    }
    
    public void setParent(ParseObject po) {
        parent = po;
    }

    public enum type {
        COMPOUND, EXP, SELECT, ITERATE, RETURN
    }
    protected final Statement.type kind;

    Statement(Statement.type t) {
        kind = t;
        register = null;
        parent = null;
    }

    public abstract int genLLCode(Function fun, CompoundStmt cs);
    
}
