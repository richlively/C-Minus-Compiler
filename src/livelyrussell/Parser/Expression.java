package livelyrussell.Parser;

public abstract class Expression implements ParseObject{
    protected enum type{
        VAR,NUM,BINARY,CALL,ASSIGN
    }
    
    protected final Expression.type kind;
    
    Expression(Expression.type t){
        kind = t;
    }
}

