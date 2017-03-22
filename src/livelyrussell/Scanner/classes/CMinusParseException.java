
package livelyrussell.Scanner.classes;

public class CMinusParseException extends Exception{
    public CMinusParseException(String e){
        super(e);
    }
    
    public CMinusParseException(){
        super("Ya done messed up the parse!");
    }
}
