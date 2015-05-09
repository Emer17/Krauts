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
        Interpreter IT;
        // arquivo pode ter, no máximo, 2000 linhas.
        String lines[] = new String[2000]; 
		String dummy = new String();
        
        try {
            f = new File(args[0]);
            s = new Scanner(f);
            it = new Interpreter();
            variable[] = new var();

            int i = 0;
            while(s.hasNext()) {
            dummy = s.nextLine();
                if(dummy.equals("\t") != true && dummy.equals("") != true){  
                    lines[i] = dummy;
                    if(lines[i].equals("") != true){
                        i++;
                    }
                }
            }
            
            it.interprete(lines);
            
        } catch (Exception e) {
            System.out.printf("Unable to read file %s\n", args.length > 0 ? args[0] : "<unknown>");
            System.out.printf("Usage: java Krauts nomedoarquivo.krauts\n");
        }
    }
}
