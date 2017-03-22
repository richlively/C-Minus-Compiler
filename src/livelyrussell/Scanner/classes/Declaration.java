package livelyrussell.Scanner.classes;

import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

public class Declaration {

    private Declaration nextDecl;
    //Null means there was only one decl

    Declaration(Declaration d) {
        nextDecl = d;
    }
    private void setNext(Declaration d){
        nextDecl = d;
    }

    public Declaration parseDecl(CMinusScanner scan) throws IOException, CMinusParseException {
        Declaration retDecl = null;
        Declaration next = null;
        Token.TokenType holder = scan.getNextToken().viewType();
        //Decl -> INT ID decl'
        if (holder == Token.TokenType.INT) {
            Token faker = scan.getNextToken();
            if (faker.viewType() != Token.TokenType.ID) {
                throw new CMinusParseException("Error parsing decl: Expected ID");
            }
            holder = scan.viewNextToken().viewType();
            //Decl'
            if (holder == Token.TokenType.LEFTSQUARE || holder == Token.TokenType.SEMICOLON) {
                //Var-decl
                VarDecl dummy = new VarDecl("Dummy");
                retDecl = dummy.parseVarDecl(scan, (String) faker.viewData());
            } else if (holder == Token.TokenType.LEFTPAREN) {
                //Fun-decl
                FunDecl dummy = new FunDecl("", null, null, null, null);
                retDecl = dummy.parseFunDecl(scan, (String) faker.viewData(), Token.TokenType.INT);
            } else {
                throw new CMinusParseException("Error parsing decl: Expected [, ;, or (");
            }
        } //Decl -> VOID ID fun-decl
        else if (holder == Token.TokenType.VOID) {
            Token faker = scan.getNextToken();
            if (faker.viewType() != Token.TokenType.ID) {
                throw new CMinusParseException("Error parsing decl: Expected ID");
            }
            FunDecl dummy = new FunDecl("", null, null, null, null);
            retDecl = dummy.parseFunDecl(scan, (String) faker.viewData(), Token.TokenType.VOID);
        } else {
            throw new CMinusParseException("Error parsing decl: Expected INT or VOID");
        }
        holder = scan.viewNextToken().viewType();
        //check the follow set if we need to do Program -> decl {decl}
        if (holder == Token.TokenType.INT || holder == Token.TokenType.VOID) {
            next = parseDecl(scan);
            retDecl.setNext(next);
        }
        return retDecl;
    }
}
