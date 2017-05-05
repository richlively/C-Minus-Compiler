package parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import lowlevel.CodeItem;

public class Program implements ParseObject {

    private final ArrayList<Declaration> decls;

    public Program(ArrayList<Declaration> d) {
        decls = d;
    }

    @Override
    public void print(PrintStream out, int indent) {
        out.println("Program:");
        for (Iterator<Declaration> it = decls.iterator(); it.hasNext();) {
            Declaration decl = it.next();
            decl.print(out, indent);
        }
    }

    
    public CodeItem genLLCode() {
        CodeItem head;
        CodeItem tail;
        if(decls.size() > 0){
            head = decls.get(0).genLLCode();
            tail = head;
        } else {
            //no decls - return null
            return null;
        }
        for(int i = 1; i < decls.size(); i++){
            CodeItem holder = decls.get(i).genLLCode();
            tail.setNextItem(holder);
            tail = tail.getNextItem();
        }
        return head;
    }

}
