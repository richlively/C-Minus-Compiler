package livelyrussell.Scanner.classes;

public class IterationStmt extends Statement {
    //WHILE ( exp ) stmt
    private Expression exp;
    private Statement stmt;

    IterationStmt(Expression e, Statement s) {
        super(Statement.type.ITERATE);
        exp = e;
        stmt = s;
    }
}
