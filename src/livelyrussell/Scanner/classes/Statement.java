package livelyrussell.Scanner.classes;

public abstract class Statement {

    public enum type {
        COMPOUND, EXP, SELECT, ITERATE, RETURN
    }
    private Statement.type kind;

    Statement(Statement.type t) {
        kind = t;
    }

}
