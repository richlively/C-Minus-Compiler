package livelyrussell.Scanner.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

public class CMinusParser implements Parser {

    private CMinusScanner scan;

    CMinusParser(BufferedReader file, String filename) throws IOException {
        this.scan = new CMinusScanner(file, filename);
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

    /**
     *
     * @return @throws java.io.IOException in the form of CMinusParseException
     */
    @Override
    public Program parseFile() throws IOException {
        ArrayList<Declaration> decls = new ArrayList<>();
        while (scan.viewNextToken().viewType() != Token.TokenType.EOF) {
            decls.add(parseDecl());
        }
        return new Program(decls);
    }

    /**
     *
     * @return @throws IOException
     * @throws CMinusParseException
     */
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
                        return parseFunDecl(idval, FunDecl.type.INT);
                    } else {
                        throw new CMinusParseException("Error parsing decl: Expected [, ;, or (");
                    }
                }
                case VOID: {//Decl -> VOID ID fun-decl
                    Token faker = scan.getNextToken();
                    if (faker.viewType() != Token.TokenType.ID) {
                        throw new CMinusParseException("Error parsing decl: Expected ID");
                    }
                    return parseFunDecl((String) faker.viewData(), FunDecl.type.VOID);
                }
                default:
                    throw new CMinusParseException("Error parsing decl: Expected INT or VOID");

            }
        }
        throw new CMinusParseException("Critical Error parsing decl: Expected INT or VOID");
    }

    /**
     *
     * @return @throws IOException
     * @throws CMinusParseException
     */
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
        throw new CMinusParseException("Critical Error parsing Expression: Expected ID, NUM or {");
    }

    /**
     *
     * @param id
     * @return
     * @throws IOException
     * @throws CMinusParseException
     */
    public Expression parseExpPrime(String id) throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case ASSIGN:
                    matchToken(Token.TokenType.ASSIGN);
                    return new AssignExp(new VarExp(id), parseExp());
                case LEFTPAREN:
                    matchToken(Token.TokenType.LEFTPAREN);
                    ArrayList<Expression> args = parseArgs();
                    matchToken(Token.TokenType.RIGHTPAREN);
                    return parseSimpleExpPrime(new CallExp(id, args));
                case LEFTSQUARE:
                    matchToken(Token.TokenType.LEFTSQUARE);
                    Expression e = parseExp();
                    matchToken(Token.TokenType.RIGHTSQUARE);
                    return parseExpDoublePrime(new VarExp(id, e));
                case SEMICOLON:
                case RIGHTPAREN:
                case STAR:
                case SLASH:
                case PLUS:
                case MINUS:
                case GREATER_THAN:
                case GREATER_EQUAL:
                case LESS_THAN:
                case LESS_EQUAL:
                case EQUAL:
                case NOT_EQUALS:
                case RIGHTCURLY:
                case RIGHTSQUARE:
                    return parseSimpleExpPrime(new VarExp(id));
                default:
                    throw new CMinusParseException("Error parsing expression': Expected =, (, [, or factor-follow stuff.");
            }
        }
        throw new CMinusParseException("Critical Error parsing expression': Expected =, (, [, or factor-follow stuff.");
    }

    /**
     *
     * @param left
     * @return
     * @throws IOException
     * @throws CMinusParseException
     */
    public Expression parseExpDoublePrime(VarExp left) throws IOException, CMinusParseException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case ASSIGN:
                    matchToken(Token.TokenType.ASSIGN);
                    return new AssignExp(left, parseExp());
                case SEMICOLON:
                case RIGHTPAREN:
                case RIGHTSQUARE:
                case STAR:
                case SLASH:
                case PLUS:
                case MINUS:
                case GREATER_THAN:
                case GREATER_EQUAL:
                case LESS_THAN:
                case LESS_EQUAL:
                case EQUAL:
                case NOT_EQUALS:
                    return parseSimpleExpPrime(left);
                default:
                    throw new CMinusParseException("Error parsing expression'': Expected = or factor-follow stuff.");

            }
        }
        throw new CMinusParseException("Critical Error parsing expression'': Expected = or factor-follow stuff.");
    }

    /**
     *
     * @param pass
     * @return
     * @throws IOException
     * @throws CMinusParseException
     */
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

    /**
     *
     * @return @throws java.io.IOException
     */
    public ArrayList<Statement> parseStmtList() throws IOException {
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

    /**
     *
     * @return @throws java.io.IOException
     */
    public Statement parseStmt() throws IOException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case LEFTCURLY:
                    return parseCompStmt();
                case IF:
                    return parseSelectStmt();
                case WHILE:
                    return parseIterationStmt();
                case RETURN:
                    return parseReturnStmt();
                case SEMICOLON:
                case NUM:
                case ID:
                case LEFTPAREN:
                    return parseEStmt();
                default:
                    throw new CMinusParseException("Error parsing Statement: Expected {, IF, WHILE, RETURN, ;, NUM, ID or (");

            }
        }
        throw new CMinusParseException("Critical Error parsing Statement: Expected {, IF, WHILE, RETURN, ;, NUM, ID or (");
    }

    /**
     *
     * @return @throws IOException
     * @throws CMinusParseException
     */
    public IterationStmt parseIterationStmt() throws IOException, CMinusParseException {
        matchToken(Token.TokenType.WHILE);
        matchToken(Token.TokenType.LEFTPAREN);
        Expression e = parseExp();
        matchToken(Token.TokenType.RIGHTPAREN);
        Statement s = parseStmt();
        return new IterationStmt(e, s);
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public CompoundStmt parseCompStmt() throws IOException {
        return new CompoundStmt(parseLocalDecls(), parseStmtList());
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public ExpressionStmt parseEStmt() throws IOException {
        if (scan.viewNextToken().viewType() == Token.TokenType.SEMICOLON) {
            matchToken(Token.TokenType.SEMICOLON);
            return null;
        } else {
            return new ExpressionStmt(parseExp());
        }
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public ReturnStmt parseReturnStmt() throws IOException {
        matchToken(Token.TokenType.RETURN);
        ExpressionStmt e = parseEStmt();
        return new ReturnStmt(e);
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public SelectStmt parseSelectStmt() throws IOException {
        matchToken(Token.TokenType.IF);
        matchToken(Token.TokenType.LEFTPAREN);
        Expression exp = parseExp();
        matchToken(Token.TokenType.RIGHTPAREN);
        Statement ifstmt = parseStmt();
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                //[else stmt]
                case ELSE:
                    matchToken(Token.TokenType.ELSE);
                    return new SelectStmt(exp, ifstmt, parseStmt());
                // no else
                case RIGHTCURLY:
                    return new SelectStmt(exp, ifstmt);
                default:
                    throw new CMinusParseException("Error parsing SelectStmt: Expected ELSE or }");
            }
        }
        throw new CMinusParseException("Critical Error parsing SelectStmt: Expected ELSE or }");
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public ArrayList<Param> parseParamList() throws IOException {
        ArrayList<Param> params = new ArrayList<>();
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case VOID:
                    params.add(new Param());
                    return params;
                case INT:
                    while (scan.viewNextToken().viewType() == Token.TokenType.LEFTPAREN) {
                        params.add(parseParam());
                    }
                    return params;
                default:
                    throw new CMinusParseException("Error parsing ParamList: Expected INT or VOID");
            }
        }
        throw new CMinusParseException("Critical Error parsing ParamList: Expected INT or VOID");
    }

    /**
     *
     * @return @throws IOException
     * @throws CMinusParseException
     */
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
        throw new CMinusParseException("Critical Error parsing Param: expected INT or Void");
    }

    /**
     *
     * @param ID
     * @return
     * @throws IOException
     * @throws CMinusParseException
     */
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
        throw new CMinusParseException("Critical Error parsing vardecl: Expected [ or ;");
    }

    /**
     *
     * @param id
     * @param type
     * @return
     */
    public Declaration parseFunDecl(String id, FunDecl.type type) {
        
    }

    private ArrayList<VarDecl> parseLocalDecls() throws IOException {
        ArrayList<VarDecl> localdecls = new ArrayList<>();
        //never mind, THIS is the worse while loop in the world
        while (scan.viewNextToken().viewType() != Token.TokenType.SEMICOLON
                && scan.viewNextToken().viewType() != Token.TokenType.NUM
                && scan.viewNextToken().viewType() != Token.TokenType.LEFTPAREN
                && scan.viewNextToken().viewType() != Token.TokenType.ID
                && scan.viewNextToken().viewType() != Token.TokenType.IF
                && scan.viewNextToken().viewType() != Token.TokenType.WHILE
                && scan.viewNextToken().viewType() != Token.TokenType.RETURN
                && scan.viewNextToken().viewType() != Token.TokenType.LEFTCURLY) {
            localdecls.add(parseVarDeclPrime());
        }
        return localdecls;
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

    /**
     *
     * @return @throws java.io.IOException
     */
    public BinaryExp parseAddExp() throws IOException {
        Expression left = parseTerm();
        BinaryExp.op oper = null; //initialize only to make Netbeans happy
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case PLUS:
                    matchToken(Token.TokenType.PLUS);
                    oper = BinaryExp.op.PLUS;
                    break;
                case MINUS:
                    matchToken(Token.TokenType.MINUS);
                    oper = BinaryExp.op.MINUS;
                    break;
                default:
                    throw new CMinusParseException("Error parsing AddExp: Expected + or -");
            }
        }
        Expression right = parseTerm();
        return new BinaryExp(left, oper, right);
    }

    /**
     *
     * @param exp
     * @return
     */
    public Expression parseAddExpPrime(Expression exp) throws IOException {
        Expression left = parseTermPrime(exp);
        BinaryExp.op oper = null; //initialize only to make Netbeans happy
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case PLUS:
                    matchToken(Token.TokenType.PLUS);
                    oper = BinaryExp.op.PLUS;
                    break;
                case MINUS:
                    matchToken(Token.TokenType.MINUS);
                    oper = BinaryExp.op.MINUS;
                    break;
                case NUM:
                case LEFTPAREN:
                case ID:
                    return left;
                default:
                    throw new CMinusParseException("Error parsing AddExp: Expected + or -");
            }
        }
        Expression right = parseTerm();
        return new BinaryExp(left, oper, right);

    }

    /**
     *
     * @param left
     * @return
     */
    public Expression parseTermPrime(Expression left) throws CMinusParseException, IOException {
        BinaryExp.op oper = null; //initialize only to make Netbeans happy
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case STAR:
                    matchToken(Token.TokenType.STAR);
                    oper = BinaryExp.op.STAR;
                    break;
                case SLASH:
                    matchToken(Token.TokenType.SLASH);
                    oper = BinaryExp.op.SLASH;
                    break;
                case NUM:
                case ID:
                case PLUS:
                case MINUS:
                case LEFTPAREN:
                    return left;
                default:
                    throw new CMinusParseException("Error parsing AddExp: Expected + or -");
            }
        }
        Expression right = parseFactor();
        return new BinaryExp(left, oper, right);
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public Expression parseTerm() throws IOException {
        Expression left = parseFactor();
        return parseTermPrime(left);
    }

    /**
     *
     * @return
     */
    public Expression parseFactor() throws IOException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case NUM:
                    //pass the integer value in the NUM token
                    return new NumExp((Integer) scan.getNextToken().viewData());
                case LEFTPAREN:
                    matchToken(Token.TokenType.LEFTPAREN);
                    Expression exp = parseExp();
                    matchToken(Token.TokenType.RIGHTPAREN);
                    return exp;
                case ID:
                    String id = scan.getNextToken().viewData().toString();
                    return parseVarCall(id);
                default:
                    throw new CMinusParseException("Error parsing factor: Expected NUM, ( or ID");
            }
        }
        throw new CMinusParseException("Critical Error parsing factor: Expected NUM, ( or ID");
    }

    /**
     *
     * @param id
     * @return
     */
    public Expression parseVarCall(String id) throws IOException {
        if (null != scan.viewNextToken().viewType()) {
            switch (scan.viewNextToken().viewType()) {
                case LEFTPAREN:
                    matchToken(Token.TokenType.LEFTPAREN);
                    ArrayList<Expression> args = parseArgs();
                    matchToken(Token.TokenType.RIGHTPAREN);
                    return new CallExp(id, args);
                case LEFTSQUARE:
                    matchToken(Token.TokenType.LEFTSQUARE);
                    Expression exp = parseExp();
                    matchToken(Token.TokenType.RIGHTSQUARE);
                    return new VarExp(id, exp);
                case SEMICOLON:
                case RIGHTPAREN:
                case STAR:
                case SLASH:
                case PLUS:
                case MINUS:
                case GREATER_THAN:
                case GREATER_EQUAL:
                case LESS_THAN:
                case LESS_EQUAL:
                case EQUAL:
                case NOT_EQUALS:
                case RIGHTSQUARE:
                    return new VarExp(id);
                default:
                    throw new CMinusParseException("Error Parsing varcall: expected (,),[,],; or an operator");
            }
        }
        throw new CMinusParseException("Critical Error Parsing varcall: expected (,),[,],; or an operator");
    }

    /**
     *
     * @return @throws IOException
     * @throws CMinusParseException
     */
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

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("File Name:");
        String filename = new String();
        BufferedReader file;

        try {
            //get filename
            filename = br.readLine();
            //create buffered reader BufferedReader file;
            file = new BufferedReader(new FileReader(filename));

            CMinusParser cmp = new CMinusParser(file, filename);

            cmp.parseFile();

            //print AST
        } catch (Exception ex) {
            System.out.println("bad stuff happened");
        }
    }
}
