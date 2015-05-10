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
<<<<<<< HEAD
        
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
=======
		
        f = new File(args[0]);
        s = new Scanner(f);
        IT = new Interpreter();
        variable[] = new var();

        int i = 0;
        while(s.hasNext()) {
            lines[i] = s.nextLine();
            i++;
        }
        b.interpret(lines);
        
        try {
            // Referencia o arquivo. args[0] conterá os dados passados pela linha de comando.
            f = new File(args[0]);
            // Mandamos o Scanner ler a partir do arquivo.
            s = new Scanner(f);
            // Instanciamos o interpretador.
            b = new Interpretador();
            
            // Lemos todas as lines do arquivo para dentro do
            // vetor "lines".
            int i = 0;
            while(s.hasNext()) {
            branco = s.nextLine();
                if(branco.equals("\t") != true && branco.equals("") != true){  
                    lines[i] = branco;
                    if(lines[i].equals("") != true){
                        i++;
                    }
                }
            }
            
            // Inicializamos o interpretador com o vetor de lines. A partir
            // desse ponto, o objeto "b" irá interpretar o código lido do arquivo.
            b.interpreta(lines);
            
        } catch (Exception e) {
            System.out.println("Nao consegui ler o arquivo: " + (args.length > 0 ? args[0] : "(desconhecido)"));
            System.out.println("Uso:");
            System.out.println("    java Krauts nomedoarquivo.krauts");
        }
>>>>>>> 9fe6536d81285b2f366ff248e3a1068a5225c337
    }
}
