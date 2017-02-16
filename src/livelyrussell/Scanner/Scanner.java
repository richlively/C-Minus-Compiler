package livelyrussell.Scanner;

import java.io.IOException;

/**
 * @author Jesse Russel
 * @author Rich Lively
 * @date Feb. 7, 2017
 * Interface for a scanner
 */
public interface Scanner {

    public Token getNextToken() throws IOException;
    public Token viewNextToken ();
    
}
