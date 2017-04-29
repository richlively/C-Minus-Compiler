package parser;

public abstract class Statement implements ParseObject{

    public enum type {
        COMPOUND, EXP, SELECT, ITERATE, RETURN
    }
    protected final Statement.type kind;

    Statement(Statement.type t) {
        kind = t;
    }

}
