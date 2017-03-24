package livelyrussell.Parser;

import java.io.PrintStream;

public abstract class Declaration implements ParseObject{
    @Override
    public abstract void print(PrintStream out);
}
