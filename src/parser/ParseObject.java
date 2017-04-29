package parser;

import java.io.PrintStream;
import lowlevel.CodeItem;

/**
 * Interface for any AST objects from the parser
 * @author Rich Lively and Jesse Russell
 */
public interface ParseObject {
    /**
     * The register number used for code generation
     */
    public Integer registerNum = null;
    
    
    /**
     * Prints the object
     * @param out where to print (usually to file or System.out)
     * @param indent how many times each line should be indented
     */
    public void print(PrintStream out, int indent);
    
}