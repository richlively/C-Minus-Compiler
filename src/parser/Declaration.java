package parser;

public abstract class Declaration implements ParseObject{
    //all declaration have an ID
    protected final String id;
    
    Declaration(String identifier){
        id = identifier;
    }
}
