
package livelyrussell.Parser;

//simple exp -> add exp -> term -> factor -> var

import java.io.PrintStream;

public class VarExp extends Expression {
    
    private String id;
    //var -> ID [ expression ]
    //(exp = null) if (var -> ID)
    private Expression exp;
    
    
    public VarExp(String i, Expression e) {
        super(Expression.type.VAR);
        id = i;
        exp = e;
    }
    public VarExp(String i){
        this(i, null);
    }

    @Override
    public void print(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
