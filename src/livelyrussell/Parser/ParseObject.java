package livelyrussell.Parser;

import java.io.PrintStream;

/**
 * Interface for any AST objects from the parser
 * @author Rich Lively and Jesse Russell
 */
public interface ParseObject {
    /**
     * Prints the object
     * @param out where to print (usually to file or System.out)
     */
    public void print(PrintStream out);
}
