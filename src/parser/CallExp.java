package parser;

import java.io.PrintStream;
import java.util.ArrayList;
import lowlevel.Attribute;
import lowlevel.Function;
import lowlevel.Operand;
import lowlevel.Operation;
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
        for (Expression arg : arglist) {
            arg.print(out, indent + 1);
        }
    }

    @Override
    public int genLLCode(Function fun) {   
        Operation op = new Operation(Operation.OperationType.CALL, fun.getCurrBlock());
        op.addAttribute(new Attribute("numParams", Integer.toString(arglist.size())));
        
        for (int i = arglist.size() - 1; i >= 0; i--){
            //How do we get the parameter's register numbers?
            int regNum = arglist.get(i).getRegister();
            Operation oper = new Operation(Operation.OperationType.PASS, fun.getCurrBlock());
            Operand opand1 = new Operand(Operand.OperandType.REGISTER, regNum);
            oper.setSrcOperand(0, opand1);
            fun.getCurrBlock().appendOper(oper);
        }
        
        
        //we want to return the value where the function stores the data after it's done.
        //TODO: uninitialized
        return -1;
    }

}
