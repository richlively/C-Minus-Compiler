package livelyrussell.Parser;

//simple exp -> add exp -> term -> factor -> var
import java.io.PrintStream;

public class VarExp extends Expression {

    private String id;
    //var -> ID [ expression ]
    //(exp = null) if (var -> ID)
    private Expression exp;

    public VarExp(String i, Expression e) {
        super(Expression.type.VAR);
        id = i;
        exp = e;
    }

    public VarExp(String i) {
        this(i, null);
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Variable Expression: " + id);
        if (exp != null) {
            exp.print(out, indent + 1);
        }
    }

}
