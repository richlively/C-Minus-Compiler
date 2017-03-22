package livelyrussell.Scanner.classes;

public class SimpleExp extends Expression{
    private AdditiveExp left;
    private AdditiveExp right;
    private String relop;
    
    SimpleExp(AdditiveExp l, String op, AdditiveExp r){
        left = l;
        right = r;
        relop = op;
    }
}
