package livelyrussell.Scanner.classes;

public abstract class Expression {
    
    public enum type{
        VAR,NUM,BINARY,CALL,ASSIGN
    }
    
    private Expression.type kind;
    
    Expression(Expression.type t){
        kind = t;
    }
    
    
}

