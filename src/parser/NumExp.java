
package parser;

//simple exp -> add exp -> term -> factor -> NUM
import java.io.PrintStream;
import lowlevel.*;

public class NumExp extends Expression {

    private final int num;

    public NumExp(int n) {
        super(Expression.type.NUM);
        num = n;
    }
    
    public int getNum() {
        return num;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Num Expression: " + num);
    }

    public int genLLCode(Function fun) {
        int i = fun.getNewRegNum();
        Operand opand = new Operand(Operand.OperandType.INTEGER, num);
        Operand opand2 = new Operand(Operand.OperandType.REGISTER, i);
        Operation oper = new Operation(Operation.OperationType.ASSIGN, fun.getCurrBlock());
        oper.setSrcOperand(0, opand);
        oper.setDestOperand(0, opand2);
        return i;
    }
}
