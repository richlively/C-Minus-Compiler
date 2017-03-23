package livelyrussell.Scanner.classes;

public class VarDecl extends Declaration {

    //if n=0, there was no parentheses
    private int n;
    private String id;

    VarDecl(String i, int num) {
        n = num;
        id = i;

    }

    //For a non-array
    VarDecl(String i) {
        this(i, 0);
    }

    
}
