
package livelyrussell.Scanner.classes;

import livelyrussell.Scanner.CMinusScanner;


public abstract class Statement {
    private Statement next;
    private String type;
    
    Statement(Statement n, String t){
        next = n;
        type = t;
    }
    
    public Statement parseStmt(CMinusScanner scan){
        
    }
    
    public Statement parseStmtList(CMinusScanner scan){
        
    }
}
