
package livelyrussell.Parser;

//simple exp -> add exp -> term -> factor -> NUM

import java.io.PrintStream;

public class NumExp extends Expression {

    private int num;

    public NumExp(int n) {
        super(Expression.type.NUM);
        num = n;
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
