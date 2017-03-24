package livelyrussell.Parser;

public class VarDecl extends Declaration {

    //if n=0, there was no parentheses
    private Integer n;
    private String id;

    VarDecl(String i, Integer num) {
        n = num;
        id = i;

    }

    //For a non-array
    VarDecl(String i) {
        this(i, 0);
    }

    
}
