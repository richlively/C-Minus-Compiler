package parser;

import java.io.PrintStream;
import lowlevel.BasicBlock;
import lowlevel.Function;
import lowlevel.Operand;
import lowlevel.Operation;

public class ReturnStmt extends Statement {

    public ExpressionStmt estmt;

    public ReturnStmt(ExpressionStmt e) {
        super(Statement.type.RETURN);
        estmt = e;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Return Statement: RETURN");
        estmt.print(out, indent + 1);
    }

    @Override
    public int genLLCode(Function fun, CompoundStmt cs) {
        BasicBlock curr = fun.getCurrBlock();
        int r;
        //only assign to the RetReg if there is something to assign
        if (estmt.getExp() != null) {
            r = estmt.genLLCode(fun, cs);
            Operation oper = new Operation(Operation.OperationType.ASSIGN, curr);
            Operand opand = new Operand(Operand.OperandType.MACRO, "RetReg");
            Operand opand2 = new Operand(Operand.OperandType.REGISTER, r);
            oper.setSrcOperand(0, opand2);
            oper.setDestOperand(0, opand);
            fun.getCurrBlock().appendOper(oper);
        }
        fun.genReturnBlock();
        return 0;
    }
}
