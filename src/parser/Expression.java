package parser;

import lowlevel.CodeItem;
import lowlevel.Function;

public abstract class Expression implements ParseObject{

    public int genLLCode(Function fun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    protected enum type{
        VAR,NUM,BINARY,CALL,ASSIGN
    }
    
    protected final Expression.type kind;
    
    Expression(Expression.type t){
        kind = t;
    }
}

