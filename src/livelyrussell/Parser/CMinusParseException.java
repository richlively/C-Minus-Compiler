
package livelyrussell.Parser;

import java.io.IOException;

public class CMinusParseException extends IOException{
    public CMinusParseException(String e){
        super(e);
    }
    
    public CMinusParseException(){
        super("Ya done messed up the parse!");
    }
}
