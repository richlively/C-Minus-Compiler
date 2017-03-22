package livelyrussell.Scanner.classes;

import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

/**
 *
 * @author Jesse
 */
public class VarDecl extends Declaration {

    //if n=0, there was no parentheses
    private int n;
    private String id;

    VarDecl(String i, int num, Declaration d) {
        super(d);
        n = num;
        id = i;

    }

    //For a non-array
    VarDecl(String i) {
        this(i, 0, null);
    }

    public VarDecl parseVarDecl(CMinusScanner scan, String ID) throws IOException, CMinusParseException {
        Token holder = scan.getNextToken();
        int num = 0;
        Declaration d = null;
        //vardecl -> ;
        if (holder.viewType() == Token.TokenType.SEMICOLON) {
            return new VarDecl(ID);
        } //vardecl -> [ NUM ] ;
        else if (holder.viewType() == Token.TokenType.LEFTSQUARE) {
            holder = scan.getNextToken();
            if (holder.viewType() == Token.TokenType.NUM) {
                num = (Integer) holder.viewData();
                scan.matchToken(Token.TokenType.RIGHTSQUARE);
                scan.matchToken(Token.TokenType.SEMICOLON);
            } else {
                throw new CMinusParseException("Error parsing vardecl: Expected NUM");
            }
            holder = scan.viewNextToken();

            //This is for the local-decls -> {vardecl'} case.
            //However, if we are in decl and we have multiple vardecls in a row
            //This will return all of them as one vardecl.  We may need to
            //talk to Dr. G about this.
            if (holder.viewType() == Token.TokenType.INT) {
                d = parseVarDeclPrime(scan);
            }
            return new VarDecl(ID, n, d);
        }
        throw new CMinusParseException("Error parsing vardecl: Expected [ or ;");
    }

    private Declaration parseVarDeclPrime(CMinusScanner scan) throws IOException, CMinusParseException {
        //This function will straight up parse a vardecl.
        //This is needed for the local-decls -> {vardecl'} case.
        scan.matchToken(Token.TokenType.INT);
        Token holder = scan.getNextToken();
        String id = "";
        int num = 0;
        Declaration d = null;
        if (holder.viewType() != Token.TokenType.ID) {
            throw new CMinusParseException("Error parsing vardecl: Expected ID");
        }
        id = (String) holder.viewData();
        holder = scan.getNextToken();
        if (null != holder.viewType()) {
            switch (holder.viewType()) {
                case SEMICOLON:
                    //Do nothing.
                    break;
                case LEFTSQUARE:
                    holder = scan.getNextToken();
                    if (holder.viewType() != Token.TokenType.NUM) {
                        throw new CMinusParseException("Error parsing vardecl: Expected NUM");
                    }
                    num = (Integer) holder.viewData();
                    scan.matchToken(Token.TokenType.RIGHTSQUARE);
                    scan.matchToken(Token.TokenType.SEMICOLON);
                    break;
                default:
                    throw new CMinusParseException("Error parsing vardecl: Expected [ or ;");
            }
        }
        //Checks if there are more vardecls to parse.
        holder = scan.viewNextToken();
        if (holder.viewType() == Token.TokenType.INT) {
            d = parseVarDeclPrime(scan);
        }
        return new VarDecl(id, n, d);
    }
}