package livelyrussell.Parser;

import java.io.PrintStream;

public class BinaryExp extends Expression{

    private Expression left;

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum op {
        //Special Symbols
        PLUS, MINUS, STAR, SLASH,
        //Comparators
        GREATER_THAN, GREATER_EQUAL, LESS_THAN,
        LESS_EQUAL, EQUAL, NOT_EQUALS
    };
    
    private BinaryExp.op optype;

    private Expression right;
    
    BinaryExp(Expression l, BinaryExp.op o, Expression r){
        super(Expression.type.BINARY);
        left = l;
        optype = o;
        right = r;
    }

}
