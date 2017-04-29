package livelyrussell.Parser;

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
     * @throws livelyrussell.Parser.CMinusParseException 
     */
    public Program parseFile() throws IOException, CMinusParseException;

    public static class CodeGenerationException extends Exception {

        public CodeGenerationException(String operand_invalid_type) {
            System.out.println(operand_invalid_type);
            printStackTrace();
        }
    }
}
