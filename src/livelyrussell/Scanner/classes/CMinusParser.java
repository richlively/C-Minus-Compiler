package livelyrussell.Scanner.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

public class CMinusParser implements Parser {

    private BufferedReader br;
    private CMinusScanner scan;

    CMinusParser(BufferedReader file, String filename) throws IOException {
        this.scan = new CMinusScanner(file, filename);
        this.br = file;
    }

    /**
     * Allows for matching tokens in the parser; throws an error if the tokens
     * don't match
     *
     * @param t
     * @throws IOException
     * @throws CMinusParseException
     */
    public void matchToken(Token.TokenType t) throws IOException, CMinusParseException {
        Token holder = scan.getNextToken();
        if (holder.viewType() != t) {
            String tval = "";
            String holderval = "";
            switch (t) {
                //format for reserved words
                case IF:
                    tval = "IF";
                    break;
                case ELSE:
                    tval = "ELSE";
                    break;
                case INT:
                    tval = "INT";
                    break;
                case RETURN:
                    tval = "";
                    break;
                case VOID:
                    tval = "Return";
                    break;
                case WHILE:
                    tval = "While";
                    break;
                //format for operators
                case PLUS:
                    tval = "+";
                    break;
                case MINUS:
                    tval = "-";
                    break;
                case STAR:
                    tval = "*";
                    break;
                case SLASH:
                    tval = "/";
                    break;
                case ASSIGN:
                    tval = "=";
                    break;
                case GREATER_THAN:
                    tval = ">";
                    break;
                case GREATER_EQUAL:
                    tval = "=>";
                    break;
                case LESS_THAN:
                    tval = "<";
                    break;
                case LESS_EQUAL:
                    tval = "<=";
                    break;
                case EQUAL:
                    tval = "==";
                    break;
                case NOT_EQUALS:
                    tval = "!=";
                    break;
                //format for syntax and grouping
                case SEMICOLON:
                    tval = ";";
                    break;
                case COMMA:
                    tval = ",";
                    break;
                case LEFTPAREN:
                    tval = "(";
                    break;
                case RIGHTPAREN:
                    tval = ")";
                    break;
                case LEFTSQUARE:
                    tval = "[";
                    break;
                case RIGHTSQUARE:
                    tval = "]";
                    break;
                case LEFTCURLY:
                    tval = "{";
                    break;
                case RIGHTCURLY:
                    tval = "}";
                    break;
                //format for special cases
                case ID:
                    tval = "ID";
                    break;
                case NUM:
                    tval = "NUM";
                    break;
                case ERROR:
                    tval = "ERROR";
                    break;
                case EOF:
                    tval = "EOF";
                    break;
                //should never happen
                default:
                    tval = "Something really messed up";
                    break;
            }
            switch (holder.viewType()) {
                //format for reserved words
                case IF:
                    holderval = "IF";
                    break;
                case ELSE:
                    holderval = "ELSE";
                    break;
                case INT:
                    holderval = "INT";
                    break;
                case RETURN:
                    holderval = "";
                    break;
                case VOID:
                    holderval = "Return";
                    break;
                case WHILE:
                    holderval = "While";
                    break;
                //format for operators
                case PLUS:
                    holderval = "+";
                    break;
                case MINUS:
                    holderval = "-";
                    break;
                case STAR:
                    holderval = "*";
                    break;
                case SLASH:
                    holderval = "/";
                    break;
                case ASSIGN:
                    holderval = "=";
                    break;
                case GREATER_THAN:
                    holderval = ">";
                    break;
                case GREATER_EQUAL:
                    holderval = "=>";
                    break;
                case LESS_THAN:
                    holderval = "<";
                    break;
                case LESS_EQUAL:
                    holderval = "<=";
                    break;
                case EQUAL:
                    holderval = "==";
                    break;
                case NOT_EQUALS:
                    holderval = "!=";
                    break;
                //format for syntax and grouping
                case SEMICOLON:
                    holderval = ";";
                    break;
                case COMMA:
                    holderval = ",";
                    break;
                case LEFTPAREN:
                    holderval = "(";
                    break;
                case RIGHTPAREN:
                    holderval = ")";
                    break;
                case LEFTSQUARE:
                    holderval = "[";
                    break;
                case RIGHTSQUARE:
                    holderval = "]";
                    break;
                case LEFTCURLY:
                    holderval = "{";
                    break;
                case RIGHTCURLY:
                    holderval = "}";
                    break;
                //format for special cases
                case ID:
                    holderval = "ID with value " + holder.viewData().toString();
                    break;
                case NUM:
                    holderval = "NUM with value " + ((Integer) holder.viewData()).toString();
                    break;
                case ERROR:
                    holderval = "ERROR";
                    break;
                case EOF:
                    holderval = "EOF";
                    break;
                //should never happen
                default:
                    holderval = "Something really messed up";
                    break;
            }
            throw new CMinusParseException("Error parsing: Expected " + tval + " but found " + holderval);
        }
    }

    @Override
    public Program parseFile(BufferedReader file, String filename) {
        //Iterate over parseDecl()
    }

    public Declaration parseDecl() throws IOException, CMinusParseException {
        Token.TokenType holder = scan.getNextToken().viewType();
        if (null != holder) //Decl -> INT ID decl'
        {
            switch (holder) {
                case INT: {
                    Token faker = scan.getNextToken();
                    if (faker.viewType() != Token.TokenType.ID) {
                        throw new CMinusParseException("Error parsing decl: Expected ID");
                    }
                    String idval = (String) faker.viewData();
                    holder = scan.viewNextToken().viewType();
                    //Decl'
                    if (holder == Token.TokenType.LEFTSQUARE || holder == Token.TokenType.SEMICOLON) {
                        //Var-decl
                        return parseVarDecl(idval);
                    } else if (holder == Token.TokenType.LEFTPAREN) {
                        //Fun-decl
                        return parseFunDecl(idval, "Int");
                    } else {
                        throw new CMinusParseException("Error parsing decl: Expected [, ;, or (");
                    }
                }
                case VOID: {//Decl -> VOID ID fun-decl
                    Token faker = scan.getNextToken();
                    if (faker.viewType() != Token.TokenType.ID) {
                        throw new CMinusParseException("Error parsing decl: Expected ID");
                    }
                    return parseFunDecl((String) faker.viewData(), "Void");
                }
                default:
                    throw new CMinusParseException("Error parsing decl: Expected INT or VOID");

            }
        }
        //Should never get here
        return null;
    }

    //J: This Exp group will be really tricky.
    //Be careful that you return the right subclasses of Expression here.
    //Also be mindful that you will have to pass some IDs and NUMs down.
    //For the part of the grammar called factor-follow, just do a switch
    //where all the cases in factor-follow match that token, and call
    //parseSimpleExpPrime()
    public Expression parseExp() throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case NUM: {
                    int holder = (Integer) scan.getNextToken().viewData();
                    return parseSimpleExpPrime(new NumExp(holder));
                }
                case LEFTPAREN:
                    matchToken(Token.TokenType.LEFTPAREN);
                    Expression exp = parseExp();
                    matchToken(Token.TokenType.RIGHTPAREN);
                    return parseSimpleExpPrime(exp);
                case ID: {
                    String holder = (String) scan.getNextToken().viewData();
                    return parseExpPrime(holder);
                }
                default:
                    throw new CMinusParseException("Error parsing Expression: Expected ID, NUM or {");
            }
        }
        //Netbeans is angry if you delete this.
        return null;
    }

    public Expression parseExpPrime(String id) throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case ASSIGN:
                    matchToken(Token.TokenType.ASSIGN);
                    return new AssignExp(new VarDecl(id), parseExp());
                case LEFTPAREN:
                    matchToken(Token.TokenType.LEFTPAREN);
                    ArrayList<Expression> args = parseArgs();
                    matchToken(Token.TokenType.RIGHTPAREN);
                    return parseSimpleExpPrime(new CallExp(id, args));
                case LEFTSQUARE:
                    matchToken(Token.TokenType.LEFTSQUARE);
                    Expression e = parseExp();
                    matchToken(Token.TokenType.RIGHTSQUARE);
                    return parseExpDoublePrime(new VarExp(id,e));
                case SEMICOLON //factor follow stuff
                case RIGHTCURLY//J: I'm not sure I understand this part
                case RIGHTPAREN
                case RIGHTSQUARE
                case STAR
                case SLASH
                case PLUS
                case MINUS
                default:
                    throw new CMinusParseException("Error parsing expression': Expected =, (, [, or factor-follow stuff.");
            }
        }
    }

    public Expression parseExpDoublePrime(Expression left) {

    }

    public Expression parseSimpleExpPrime(Expression pass) throws IOException, CMinusParseException {
        Expression left = parseAddExpPrime(pass);
        BinaryExp.op oper = null;
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case GREATER_THAN:
                    matchToken(Token.TokenType.GREATER_THAN);
                    oper = BinaryExp.op.GREATER_THAN;
                    break;
                case GREATER_EQUAL:
                    matchToken(Token.TokenType.GREATER_EQUAL);
                    oper = BinaryExp.op.GREATER_EQUAL;
                    break;
                case LESS_THAN:
                    matchToken(Token.TokenType.LESS_THAN);
                    oper = BinaryExp.op.LESS_THAN;
                    break;
                case LESS_EQUAL:
                    matchToken(Token.TokenType.LESS_EQUAL);
                    oper = BinaryExp.op.LESS_EQUAL;
                    break;
                case EQUAL:
                    matchToken(Token.TokenType.EQUAL);
                    oper = BinaryExp.op.EQUAL;
                    break;
                case NOT_EQUALS:
                    matchToken(Token.TokenType.NOT_EQUALS);
                    oper = BinaryExp.op.NOT_EQUALS;
                    break;
                case SEMICOLON:
                case RIGHTCURLY:
                case RIGHTPAREN:
                case RIGHTSQUARE:
                    return left;
                default:
                    throw new CMinusParseException("Error parsing SimpleExp': Expected a relop");
            }
        }
        Expression right = parseAddExp();
        return new BinaryExp(left, oper, right);
    }

    public ArrayList<Statement> parseStmtList() {
        ArrayList<Statement> al = new ArrayList<>();
        //Wanna see the worst while loop in history?
        while (scan.viewNextToken().viewType() != Token.TokenType.SEMICOLON
                && scan.viewNextToken().viewType() != Token.TokenType.RIGHTCURLY
                && scan.viewNextToken().viewType() != Token.TokenType.RIGHTSQUARE
                && scan.viewNextToken().viewType() != Token.TokenType.RIGHTPAREN) {
            al.add(parseStmt());
        }
        return al;
    }

    public Statement parseStmt() {
        //switch on first sets of the other stmts
    }

    public IterationStmt parseIterationStmt() throws IOException, CMinusParseException {
        matchToken(Token.TokenType.WHILE);
        matchToken(Token.TokenType.LEFTPAREN);
        Expression e = parseExp();
        matchToken(Token.TokenType.RIGHTPAREN);
        Statement s = parseStmt();
        return new IterationStmt(e, s);
    }

    public CompoundStmt parseCompStmt() {

    }

    public ExpressionStmt parseEStmt() {

    }

    public ReturnStmt parseReturnStmt() throws Exception {
        matchToken(Token.TokenType.RETURN);
        ExpressionStmt e = parseEStmt();
        return new ReturnStmt(e);
    }

    public SelectStmt parseSelectStmt() {

    }

    public ArrayList<Param> parseParamList() {
        //iterate over parseParam() until you get ")"
    }

    public Param parseParam() throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case VOID:
                    matchToken(Token.TokenType.VOID);
                    return new Param("VOID");
                case INT:
                    matchToken(Token.TokenType.INT);
                    boolean array = false;
                    Param next = null;
                    Token holder = scan.getNextToken();
                    if (holder.viewType() != Token.TokenType.ID) {
                        throw new CMinusParseException("Error parsing Param: expected ID");
                    }
                    if (scan.viewNextToken().viewType() == Token.TokenType.LEFTSQUARE) {
                        matchToken(Token.TokenType.LEFTSQUARE);
                        matchToken(Token.TokenType.RIGHTSQUARE);
                        return new Param((String) holder.viewData(), true, next);
                    } else if (scan.viewNextToken().viewType() == Token.TokenType.COMMA) {
                        return new Param((String) holder.viewData(), false, next);
                    }
                default:
                    throw new CMinusParseException("Error parsing Param: expected INT or Void");
            }
        }
        //Should never execute
        return null;
    }

    public VarDecl parseVarDecl(String ID) throws IOException, CMinusParseException {
        Token holder = scan.getNextToken();
        int num = 0;
        //vardecl -> ;
        if (holder.viewType() == Token.TokenType.SEMICOLON) {
            return new VarDecl(ID);
        } //vardecl -> [ NUM ] ;
        else if (holder.viewType() == Token.TokenType.LEFTSQUARE) {
            holder = scan.getNextToken();
            if (holder.viewType() == Token.TokenType.NUM) {
                num = (Integer) holder.viewData();
                matchToken(Token.TokenType.RIGHTSQUARE);
                matchToken(Token.TokenType.SEMICOLON);
            } else {
                throw new CMinusParseException("Error parsing vardecl: Expected NUM");
            }
            return new VarDecl(ID, num);
        }
        throw new CMinusParseException("Error parsing vardecl: Expected [ or ;");
    }

    public Declaration parseFunDecl(String id, String type) {
        //call parseParamList
    }

    private ArrayList<VarDecl> parseLocalDecls() {
        //iterate over parseVarDeclPrime(), being sure to check for empty
    }

    private VarDecl parseVarDeclPrime() throws IOException, CMinusParseException {
        //This function will straight up parse a vardecl.
        //This is needed for the local-decls -> {vardecl'} case.
        matchToken(Token.TokenType.INT);
        Token holder = scan.getNextToken();
        String id = "";
        int num = 0;
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
                    matchToken(Token.TokenType.RIGHTSQUARE);
                    matchToken(Token.TokenType.SEMICOLON);
                    break;
                default:
                    throw new CMinusParseException("Error parsing vardecl: Expected [ or ;");
            }
        }

        return new VarDecl(id, num);
    }

    public BinaryExp parseAddExp() {
        //parseTerm()
    }

    public BinaryExp parseAddExpPrime(Expression exp) {
        //it depends on where this came from what catchall actually is.
        //This is sloppy and will need fixing
    }

    public BinaryExp parseTermPrime(Expression left) {

    }

    public BinaryExp parseTerm() {
        //in theory, you could call parseTermPrime() in here.
    }

    public Expression parseFactor() {

    }

    public Expression parseVarCall() {
        //check for empty case using follow set
    }

    public ArrayList<Expression> parseArgs() throws IOException, CMinusParseException {
        if (scan.viewNextToken().viewType() == Token.TokenType.RIGHTPAREN) {
            return null;
        }
        ArrayList<Expression> retval = new ArrayList<>();
        retval.add(parseExp());
        while (scan.viewNextToken().viewType() == Token.TokenType.COMMA) {
            matchToken(Token.TokenType.COMMA);
            retval.add(parseExp());
        }
        return retval;
    }

}
