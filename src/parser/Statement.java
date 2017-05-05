package parser;

import lowlevel.Function;

public abstract class Statement implements ParseObject {
    
    private Integer register;
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

    public abstract void genLLCode(Function fun, CompoundStmt cs);
    
}
