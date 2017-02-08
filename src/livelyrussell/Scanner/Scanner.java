/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livelyrussell.Scanner;

import java.io.IOException;

/**
 *
 * @author Jesse and Rich
 */
public interface Scanner {

    public Token getNextToken() throws IOException;
    public Token viewNextToken ();
    
}
