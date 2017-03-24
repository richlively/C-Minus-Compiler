
package livelyrussell.Parser;
import java.io.PrintStream;
import java.util.ArrayList;
//simple exp -> add exp -> term -> factor -> call
public class CallExp extends Expression{
    
    private String id;
    //args -> arg-list -> expression {, expression}
    //if arglist = null, no args
    private ArrayList<Expression> arglist;
    public CallExp(String i, ArrayList<Expression> a) {
        super(Expression.type.CALL);
        id = i;
        arglist = a;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
