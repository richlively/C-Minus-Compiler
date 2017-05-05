package parser;

import lowlevel.CodeItem;

public abstract class Declaration implements ParseObject {

    private Integer register;
    
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
    
    public abstract CodeItem genLLCode();
}
