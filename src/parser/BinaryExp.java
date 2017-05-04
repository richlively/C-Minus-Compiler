package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;
import lowlevel.Function;
import lowlevel.LowLevelException;
import lowlevel.Operand;
import lowlevel.Operation;

public class BinaryExp extends Expression {
    
    @Override
    public int genLLCode(Function fun) {
        int leftreg = left.genLLCode(fun);
        int rightreg = right.genLLCode(fun);
        Operation.OperationType lloptype;
        switch (optype){
            case PLUS:
                lloptype = Operation.OperationType.ADD_I;
                break;
            case MINUS:
                lloptype = Operation.OperationType.SUB_I;
                break;
            case STAR:
                lloptype = Operation.OperationType.MUL_I;
                break;
            case SLASH:
                lloptype = Operation.OperationType.DIV_I;
                break;
            case GREATER_THAN:
                lloptype = Operation.OperationType.GT;
                break;
            case GREATER_EQUAL:
                lloptype = Operation.OperationType.GTE;
                break;
            case LESS_THAN:
                lloptype = Operation.OperationType.LT;
                break;
            case LESS_EQUAL:
                lloptype = Operation.OperationType.LTE;
                break;
            case EQUAL:
                lloptype = Operation.OperationType.EQUAL;
                break;
            case NOT_EQUALS:
                lloptype = Operation.OperationType.NOT_EQUAL;
                break;
            default:
                throw new LowLevelException("Error; invalid Optype");
        }
        Operation oper = new Operation(lloptype, fun.getCurrBlock());
        
        oper.setSrcOperand(2, new Operand(Operand.OperandType.REGISTER, rightreg));
        oper.setSrcOperand(1, new Operand(Operand.OperandType.REGISTER, leftreg));
        Operand retoper = new Operand(Operand.OperandType.REGISTER, fun.getNewRegNum());
        oper.setDestOperand(1, retoper);
        fun.getCurrBlock().appendOper(oper);
        return (int) retoper.getValue();
    }

    public enum op {

        //Special Symbols
        PLUS, MINUS, STAR, SLASH,
        //Comparators
        GREATER_THAN, GREATER_EQUAL, LESS_THAN,
        LESS_EQUAL, EQUAL, NOT_EQUALS;

        @Override
        public String toString() {
            switch (this) {
                case PLUS:
                    return "+";
                case MINUS:
                    return "-";
                case STAR:
                    return "*";
                case SLASH:
                    return "/";
                case GREATER_THAN:
                    return ">";
                case GREATER_EQUAL:
                    return ">=";
                case LESS_THAN:
                    return "<";
                case LESS_EQUAL:
                    return "<=";
                case EQUAL:
                    return "==";
                case NOT_EQUALS:
                    return "!=";
                default:
                    return "nothing";
            }
        }
    };

    private final Expression left;
    private final BinaryExp.op optype;
    private final Expression right;

    BinaryExp(Expression l, BinaryExp.op o, Expression r) {
        super(Expression.type.BINARY);
        left = l;
        optype = o;
        right = r;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Binary Expression: " + optype);
        left.print(out, indent + 1);
        right.print(out, indent + 1);
    }
}
