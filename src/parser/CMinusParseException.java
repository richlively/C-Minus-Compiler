package parser;

import java.io.IOException;

/**
 * Thrown during parse for code that is un-parseable
 * @author Rich Lively and Jesse Russell
 */
public class CMinusParseException extends IOException{
    public CMinusParseException(String message){
        super(message);
    }
    
    public CMinusParseException(){
        super();
    }
}
