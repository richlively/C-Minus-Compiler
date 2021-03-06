package parser;

import java.io.IOException;

/**
 * Provides a simple interface for language parsers
 * @author Rich Lively and Jesse Russell
 */
public interface Parser {
    
    /**
     * Builds the Abstract Syntax Tree
     * @return a Program
     * @throws IOException 
     * @throws parser.CMinusParseException 
     */
    public Program parse() throws IOException, CMinusParseException;
}
