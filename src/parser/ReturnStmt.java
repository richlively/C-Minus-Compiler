package parser;

import java.io.PrintStream;
import lowlevel.BasicBlock;
import lowlevel.CodeItem;
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
    public void genLLCode(Function fun) {
        BasicBlock curr = fun.getCurrBlock();
        Operation oper = new Operation(Operation.OperationType.RETURN, curr);
        if (estmt != null) {
            estmt.genLLCode(fun);
        }
        oper.setSrcOperand(0, new Operand(Operand.OperandType.MACRO, "RetReg"));
        curr.appendOper(oper);
        BasicBlock temp = new BasicBlock(fun);
        curr.setNextBlock(temp);
        curr = curr.getNextBlock();
        Operation oper2 = new Operation(Operation.OperationType.JMP, curr);
        temp.setFirstOper(oper2);
        //not sure what the BB target is.
        oper2.setSrcOperand(0, new Operand(Operand.OperandType.BLOCK, temp));
    }
}
