package livelyrussell.Parser;

import java.io.PrintStream;
import lowlevel.CodeItem;

public class BinaryExp extends Expression {

    public CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
