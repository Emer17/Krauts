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
	public static void main(String args[]) throws Exception {
		File f;
		Scanner s;
		Interpreter Inter;
		String linhas[] = new String[2000];
		
		f = new File(args[0]);
		s = new Scanner(f);
		
		
		String verificador;
		
		int i = 0;
		while(s.hasNext()) {
				linhas[i] = s.nextLine();

			i++;
		}
		
		Inter = new Interpreter();
		Inter.interpret(linhas);
	}
}
