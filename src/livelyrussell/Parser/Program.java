
package livelyrussell.Parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;


public class Program implements ParseObject{
    private final ArrayList<Declaration> decls;
    
    public Program(ArrayList<Declaration> d){
        decls = d;
    }

    @Override
    public void print(PrintStream out, int indent) {
        for (Iterator<Declaration> it = decls.iterator(); it.hasNext();) {
            Declaration decl = it.next();
            decl.print(out, indent);
        }
    }
    
}
