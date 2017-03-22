package livelyrussell.Scanner.classes;

import java.io.BufferedReader;
import java.io.IOException;
import livelyrussell.Scanner.CMinusScanner;
import livelyrussell.Scanner.Token;

/**
 *
 * @author Jesse
 */
public class CMinusParser implements Parser {

    private BufferedReader br;
    private CMinusScanner cms;

    CMinusParser(BufferedReader file, String filename) throws IOException {
        this.cms = new CMinusScanner(file, filename);
        this.br = file;
    }

    @Override
    public Declaration parseFile(BufferedReader file, String filename) {
        
    }

}
