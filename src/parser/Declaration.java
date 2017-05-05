package parser;

import lowlevel.CodeItem;

public abstract class Declaration implements ParseObject {

    Integer register;
    
    public Integer getRegister() {
        return register;
    }
    
    public void setRegister(Integer r) {
        register = r;
    }
    
    //all declaration have an ID
    protected final String id;

    Declaration(String identifier) {
        id = identifier;
    }

    CodeItem genLLCode() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
}
