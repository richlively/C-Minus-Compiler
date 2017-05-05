package parser;

import java.io.PrintStream;

/**
 * Interface for any AST objects from the parser
 * @author Rich Lively and Jesse Russell
 */
public interface ParseObject {    
    /**
     * Prints the object
     * @param out where to print (usually to file or System.out)
     * @param indent how many times each line should be indented
     */
    public void print(PrintStream out, int indent);
    
}
