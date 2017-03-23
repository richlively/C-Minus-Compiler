
package livelyrussell.Scanner.classes;

public class AssignExp extends Expression{
    //first thing on right side of line 18 on page 492
    private VarExp var;
    private Expression exp;
    
    
    public AssignExp(VarExp v, Expression e) {
        super(Expression.type.ASSIGN);
        var = v;
        exp = e;
    }
    
}
