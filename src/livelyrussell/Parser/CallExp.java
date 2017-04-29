package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import lowlevel.CodeItem;
//simple exp -> add exp -> term -> factor -> call

public class CallExp extends Expression {

    private final String id;
    //args -> arg-list -> expression {, expression}
    //if arglist = null, no args
    private final ArrayList<Expression> arglist;

    public CallExp(String i, ArrayList<Expression> a) {
        super(Expression.type.CALL);
        id = i;
        arglist = a;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Call Expression: " + id);
        for (Iterator<Expression> it = arglist.iterator(); it.hasNext();) {
            Expression arg = it.next();
            arg.print(out, indent + 1);
        }
    }

    @Override
    public CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
