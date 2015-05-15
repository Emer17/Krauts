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
		
		try{
			f = new File(args[0]);
			s = new Scanner(f);
			Inter = new Interpreter();
			
			int i = 0;
			while(s.hasNext()) {
				linhas[i] = s.nextLine();
				i++;
			}
			Inter.interpret(linhas);
		}catch(Exception e){
			System.out.println("FATAL: " + ((args.length > 0) 
				? "could not read file " + args[0]
				: "no input file"));
            System.out.println("Usage: java Krauts /path/to/file.krauts");
		}
	}
}
