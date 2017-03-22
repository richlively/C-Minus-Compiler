package livelyrussell.Scanner.classes;

import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

/**
 *
 * @author Jesse
 */
public class Param {

    private String id;
    //If id == VOID, there were no params
    private boolean isArray;
    private Param nextParam;

    Param(String i, boolean a, Param p) {
        id = i;
        isArray = a;
        nextParam = p;
    }

    Param(String i, boolean a) {
        this(i, a, null);
    }

    Param(String i) {
        this(i, false, null);
    }

    public Param parseParams(CMinusScanner scan) throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) switch (scan.viewNextToken().viewType()) {
            case VOID:
                scan.matchToken(Token.TokenType.VOID);
                return new Param("VOID");
            case INT:
                scan.matchToken(Token.TokenType.INT);
                boolean array = false;
                Param next = null;
                Token holder = scan.getNextToken();
                if (scan.viewNextToken().viewType() == Token.TokenType.LEFTSQUARE) {
                    scan.matchToken(Token.TokenType.LEFTSQUARE);
                    scan.matchToken(Token.TokenType.RIGHTSQUARE);
                    array = true;
                }
                if (scan.viewNextToken().viewType() == Token.TokenType.COMMA) {
                    scan.matchToken(Token.TokenType.COMMA);
                    next = parseParams(scan);
                }
                return new Param((String) holder.viewData(), array, next);
            default:
                throw new CMinusParseException("Error parsing Param: expected ID or Void");
        }
        //Should never execute
        return null;
    }

}
