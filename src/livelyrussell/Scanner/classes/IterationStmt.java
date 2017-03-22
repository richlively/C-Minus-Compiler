package livelyrussell.Scanner.classes;

import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

public class IterationStmt extends Statement {
    private Expression exp;
    private Statement stmt;
    
    IterationStmt(Expression e, Statement s, Statement n){
        super(n,"iteration");
        exp = e;
        stmt = s;
    }

    public IterationStmt parseWhileStmt(CMinusScanner scan) throws IOException, CMinusParseException {
        scan.matchToken(Token.TokenType.WHILE);
        scan.matchToken(Token.TokenType.LEFTPAREN);
        Expression dummy = new AdditiveExp(); //will need to update this
        Expression e = dummy.parseExpression(scan);
        scan.matchToken(Token.TokenType.RIGHTPAREN);
        Statement stupid = new IterationStmt(null, null, null);
        Statement s = stupid.parseStmt(scan);
        return new IterationStmt(e, s, null);//Statement will check nexts.
    }
}
