
package parser;

//simple exp -> add exp -> term -> factor -> NUM

import java.io.PrintStream;

public class NumExp extends Expression {

    private final int num;

    public NumExp(int n) {
        super(Expression.type.NUM);
        num = n;
    }

    @Override
    public void print(PrintStream out, int indent) {
        String tabs = "";
        for (int i = 0; i < indent; i++) {
            tabs += "\t";
        }
        out.println(tabs + "Num Expression: " + num);
    }

}
