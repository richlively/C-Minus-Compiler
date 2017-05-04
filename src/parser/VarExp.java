package parser;

//simple exp -> add exp -> term -> factor -> var
import compiler.CMinusCompiler;
import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Function;
import lowlevel.LowLevelException;
import lowlevel.Operand;
import lowlevel.Operation;

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

    public int genLLCode(Function fun) {
        if(fun.getTable().containsKey(id)){
            return (Integer) fun.getTable().get(id);
        } else if(CMinusCompiler.globalHash.containsKey(id)) {
            return (Integer) CMinusCompiler.globalHash.get(id);
        } else {
            throw new LowLevelException("Error: variable " + id + " was not declared prior to use.");
        }
    }
}
