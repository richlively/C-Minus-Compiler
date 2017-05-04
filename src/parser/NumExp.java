
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

    
    public CodeItem genLLCode() {
        Data retval = new Data(Data.TYPE_INT, "");
        return retval;
    }
}
