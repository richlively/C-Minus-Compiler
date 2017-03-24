
package livelyrussell.Parser;
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
    
}
