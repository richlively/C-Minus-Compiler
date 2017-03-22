package livelyrussell.Scanner.classes;

import livelyrussell.Scanner.CMinusScanner;

public class SimpleExp extends Expression{
    private AdditiveExp left;
    private AdditiveExp right;
    private String relop;
    
    SimpleExp(AdditiveExp l, String op, AdditiveExp r){
        left = l;
        right = r;
        relop = op;
    }
    public SimpleExp parseSimpleExp(CMinusScanner scan){
        
    }
}
