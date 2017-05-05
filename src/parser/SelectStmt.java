package parser;

import java.io.PrintStream;
import lowlevel.BasicBlock;
import lowlevel.CodeItem;
import lowlevel.Function;
import lowlevel.Operand;
import lowlevel.Operation;

public class SelectStmt extends Statement {

    //IF ( exp ) stmt [ELSE stmt]
    private Expression exp;
    private Statement ifstmt;
    private Statement elsestmt;

    public SelectStmt(Expression e, Statement ifs, Statement elses) {
        super(Statement.type.SELECT);
        exp = e;
        ifstmt = ifs;
        elsestmt = elses;
    }

    public SelectStmt(Expression e, Statement ifs) {
        this(e, ifs, null);
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Select Statement: IF");
        exp.print(out, indent + 1);
        ifstmt.print(out, indent + 1);
        if (elsestmt != null) {
            out.println(tabs + "ELSE");
            elsestmt.print(out, indent + 1);
        }
    }

    @Override
    public void genLLCode(Function fun) {
        BasicBlock postpart = new BasicBlock(fun);
        BasicBlock thenpart = new BasicBlock(fun);
        BasicBlock elsepart = null;
        if (elsestmt != null) {
            elsepart = new BasicBlock(fun);
        }
        int expreg = exp.genLLCode(fun);
        Operation booloper = new Operation(Operation.OperationType.BEQ, fun.getCurrBlock());
        Operand oper1 = new Operand(Operand.OperandType.REGISTER, expreg);
        Operand oper2 = new Operand(Operand.OperandType.INTEGER, 0);
        Operand oper3;
        if (elsestmt != null) {
            oper3 = new Operand(Operand.OperandType.BLOCK, elsepart);
        } else {
            oper3 = new Operand(Operand.OperandType.BLOCK, thenpart);
        }
        booloper.setSrcOperand(0, oper1);
        booloper.setSrcOperand(1, oper2);
        booloper.setDestOperand(0, oper3);

        fun.getLastBlock().appendOper(booloper);

        fun.appendBlock(thenpart);

        ifstmt.genLLCode(fun);

        fun.appendBlock(postpart);

        if (elsestmt != null) {
            fun.setCurrBlock(elsepart);

            elsestmt.genLLCode(fun);

            Operation postjump = new Operation(Operation.OperationType.JMP, fun.getCurrBlock());
            postjump.setSrcOperand(0, new Operand(Operand.OperandType.BLOCK, postpart));
            
            elsepart.appendOper(postjump);
            
            fun.appendUnconnectedBlock(elsepart);
        }
        
        fun.setCurrBlock(postpart);

    }
}
