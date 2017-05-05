package parser;

import compiler.CMinusCompiler;
import java.io.PrintStream;
import lowlevel.Function;
import lowlevel.Operand;
import lowlevel.Operation;

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
    public int genLLCode(Function fun, CompoundStmt cs) {
        int v = var.genLLCode(fun, cs);
        String varid = var.getID();
        int e = exp.genLLCode(fun, cs);
        if (CMinusCompiler.globalHash.containsKey(varid)) {
            Operation oper = new Operation(Operation.OperationType.STORE_I, fun.getCurrBlock());
            Operand src0 = new Operand(Operand.OperandType.REGISTER, e);
            Operand src1 = new Operand(Operand.OperandType.STRING, varid);
            oper.setSrcOperand(0, src0);
            oper.setSrcOperand(1, src1);
            fun.getCurrBlock().appendOper(oper);
            return e;
        } else {
            Operation oper = new Operation(Operation.OperationType.ASSIGN, fun.getCurrBlock());
            Operand src = new Operand(Operand.OperandType.REGISTER, e);
            Operand dest = new Operand(Operand.OperandType.REGISTER, v);
            oper.setSrcOperand(0, src);
            oper.setDestOperand(0, dest);
            fun.getCurrBlock().appendOper(oper);
            return v;
        }
    }
}
