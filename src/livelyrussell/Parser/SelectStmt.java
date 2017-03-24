package livelyrussell.Parser;

import java.io.PrintStream;

public class SelectStmt extends Statement {

    //IF ( exp ) stmt [ELSE stmt]
    private Expression exp;
    private Statement ifstmt;
    private Statement elsestmt;

    public SelectStmt(Expression e, Statement ifs, Statement elses) {
        super(Statement.type.SELECT);
        exp = e;
        ifstmt = ifs;
        elsestmt = elses;
    }
    
    public SelectStmt(Expression e, Statement ifs){
        this(e, ifs, null);
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
