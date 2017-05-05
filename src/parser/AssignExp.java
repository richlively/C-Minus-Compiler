package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Function;

public class AssignExp extends Expression {

    //first thing on right side of line 18 on page 492

    private VarExp var;
    private Expression exp;

    public AssignExp(VarExp v, Expression e) {
        super(Expression.type.ASSIGN);
        var = v;
        exp = e;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Assign Expression: =");
        var.print(out, indent + 1);
        exp.print(out, indent + 1);
    }
    
    @Override
    public int genLLCode(Function fun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
