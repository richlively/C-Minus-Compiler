package livelyrussell.Scanner.classes;

import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

/**
 *
 * @author Jesse
 */
public class FunDecl extends Declaration{
    private Token.TokenType type;
    private String id;
    private CompoundStmt cs;
    private Param params;
    
    FunDecl(String i, CompoundStmt c, Param p, Token.TokenType ttype, Declaration d){
        super(d);
        type = ttype;
        id = i;
        cs = c;
        params = p;
    }
    
    public FunDecl parseFunDecl(CMinusScanner scan, String ID, Token.TokenType t) throws IOException, CMinusParseException{
        scan.matchToken(Token.TokenType.LEFTPAREN);
        Param p = params.parseParams(scan);
        scan.matchToken(Token.TokenType.RIGHTPAREN);
        CompoundStmt c = cs.parseCompStmt(scan);
        return new FunDecl(ID, c, p, t, null);
    }
    
}
