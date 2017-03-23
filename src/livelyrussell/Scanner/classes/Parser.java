package livelyrussell.Scanner.classes;

import java.io.BufferedReader;
import livelyrussell.Scanner.Token;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author Jesse
 */
public interface Parser {

    public abstract Program parseFile(BufferedReader file, String filename);
}
