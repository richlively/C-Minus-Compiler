package livelyrussell.Parser;

/**
 * Thrown during parse for code that is un-parsable
 * @author Rich Lively and Jesse Russell
 */
public class CMinusParseException extends Exception{
    public CMinusParseException(String message){
        super(message);
    }
    
    public CMinusParseException(){
        super();
    }
}
