/**
 * Krauts - an interpreted language with Assembly-like syntax
 * Developed by Vitor G. Forbrig and Leonardo D. Constantin
 * 
 * Contact us: 
 *  vitorforbrig at gmail dot com
 *  constantin dot leo at gmail dot com
 * 
 * Main class: reads file
**/

import java.util.Scanner;
import java.io.*;

class Krauts {
    public static void main(String args[]) {
        File f;
        Scanner s;
        Interpreter Inter;
        // arquivo pode ter, no máximo, 2000 linhas.
        String lines[] = new String[2000]; 
		
        f = new File(args[0]);
        s = new Scanner(f);
        Inter = new Interpreter();
        variable[] = new var();

        int i = 0;
        while(s.hasNext()) {
            lines[i] = s.nextLine();
            i++;
        }
        Inter.interpret(lines);
      
}
