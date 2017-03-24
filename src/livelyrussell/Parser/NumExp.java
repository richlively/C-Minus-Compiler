
package livelyrussell.Parser;

//simple exp -> add exp -> term -> factor -> NUM
public class NumExp extends Expression {

    private int num;

    public NumExp(int n) {
        super(Expression.type.NUM);
        num = n;
    }

}
