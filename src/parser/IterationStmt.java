package parser;

import java.io.PrintStream;
import lowlevel.BasicBlock;
import lowlevel.CodeItem;
import lowlevel.Function;
import lowlevel.Operand;
import lowlevel.Operation;

public class IterationStmt extends Statement {

    //WHILE ( exp ) stmt
    private Expression exp;
    private Statement stmt;

    IterationStmt(Expression e, Statement s) {
        super(Statement.type.ITERATE);
        exp = e;
        stmt = s;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Iteration Statement: " + "WHILE");
        exp.print(out, indent + 1);
        stmt.print(out, indent + 1);
    }

    @Override
    public void genLLCode(Function fun) {
        BasicBlock mainpart = new BasicBlock(fun);
        BasicBlock post = new BasicBlock(fun);
        int expreg = exp.genLLCode(fun);

        Operation booloper = new Operation(Operation.OperationType.BEQ, fun.getCurrBlock());
        Operand oper1 = new Operand(Operand.OperandType.REGISTER, expreg);
        Operand oper2 = new Operand(Operand.OperandType.INTEGER, 0);
        Operand oper3 = new Operand(Operand.OperandType.BLOCK, post);
        booloper.setSrcOperand(0, oper1);
        booloper.setSrcOperand(1, oper2);
        booloper.setDestOperand(0, oper3);

        fun.getLastBlock().appendOper(booloper);
        fun.appendBlock(mainpart);
        
        stmt.genLLCode(fun);
        
        Operation booloper2 = new Operation(Operation.OperationType.BEQ, mainpart);
        booloper.setSrcOperand(0, oper1);
        booloper.setSrcOperand(1, oper2);
        booloper.setDestOperand(0, oper3);
        
        mainpart.appendOper(booloper2);
        
        fun.appendBlock(post);
        fun.setCurrBlock(post);
        
    }
}
