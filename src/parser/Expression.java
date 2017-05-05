package parser;

import lowlevel.Function;

public abstract class Expression implements ParseObject{

    Integer register;
    
    public Integer getRegister() {
        return register;
    }
    
    public void setRegister(Integer r) {
        register = r;
    }
    
    protected enum type{
        VAR,NUM,BINARY,CALL,ASSIGN
    }
    
    protected final Expression.type kind;
    
    Expression(Expression.type t){
        kind = t;
    }
    
    public abstract int genLLCode(Function fun);
}

