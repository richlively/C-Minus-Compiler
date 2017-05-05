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
    public int genLLCode(Function fun, CompoundStmt cs) {
        for (int i = arglist.size() - 1; i >= 0; i--){

            int regNum = arglist.get(i).genLLCode(fun, cs);
            Operation oper = new Operation(Operation.OperationType.PASS, fun.getCurrBlock());
            Operand opand1 = new Operand(Operand.OperandType.REGISTER, regNum);
            oper.setSrcOperand(0, opand1);
            oper.addAttribute(new Attribute("PARAM_NUM", Integer.toString(i)));
            fun.getCurrBlock().appendOper(oper);
        }
        
        Operation op = new Operation(Operation.OperationType.CALL, fun.getCurrBlock());
        op.addAttribute(new Attribute("numParams", Integer.toString(arglist.size())));
        op.setSrcOperand(0, new Operand(Operand.OperandType.STRING, id));
        
        //pull from the RetReg and store to a normal reg.
        Operation returner = new Operation(Operation.OperationType.ASSIGN, fun.genReturnBlock());
        Operand retreg = new Operand(Operand.OperandType.MACRO, "RetReg");
        Operand newreg = new Operand(Operand.OperandType.REGISTER, fun.getNewRegNum());
        returner.setSrcOperand(0, retreg);
        returner.setDestOperand(0, newreg);
        
        //return normal reg.
        return (Integer) newreg.getValue();
    }

}
