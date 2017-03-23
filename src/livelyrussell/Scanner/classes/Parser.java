package livelyrussell.Scanner.classes;

import java.io.IOException;

public interface Parser {
    
    public abstract Program parseFile() throws IOException;
}
