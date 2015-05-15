/**
 * Krauts - an interpreted language with Assembly-like syntax
 * Developed by Vitor G. Forbrig and Leonardo D. Constantin
 * 
 * Contact us: 
 *  vitorforbrig at gmail dot com
 *  constantin dot leo at gmail dot com
 * 
 * Interpreter class: recognizes and executes commands
**/
import java.util.*;

class Interpreter {
	private Var variable[];
	private int top; //contador de números de variáveis
	private Arit arit;
	private Stack<Integer> loop;
	
	/* TO-DO: (mero detalhe)
	 * substituir o método de armazenamento
	 * das variáveis por algo mais eficiente, 
	 * como o TreeSet do Java.
	*/
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
		this.arit = new Arit();
		this.top = 0;
		this.loop = new Stack<Integer>();
	}
	
	public void interpret(String lines[]) {
		for (int i = 0; i < lines.length && lines[i] != null; i++) {
			lines[i].replace("\t", "");
			
			if (!(lines[i].startsWith("~") || lines[i].trim().isEmpty())) {
				executa(lines[i]);
			}			
		}
	}
	
	public void executa(String tokens){
		String treated[] = tokens.split("~"); 
		// Esta linha dispensa comentários. Trocadilho não-intencional.
		
		treated = treated[0].split(" "); //linha tratada a ser interpretada
		//interpreta a linha
		int k;
		switch (treated[0].toLowerCase()) {
			case "new":
				//acha e insere no final (topo) do vetor
				if(arit.indiceDaVariavel(treated[1], variable, top) != -1){
					arit.mostraErro(1);
				}
				if(top < variable.length) {
					variable[top] = new Var();
					variable[top].setName(treated[1]);
					top++;
				} else { 
					arit.mostraErro(2);
				}
			break;
			
			case "atr":
				k = arit.indiceDaVariavel(treated[1], variable, top);
				if(k == -1){
					arit.mostraErro(5);
				}
				variable[k].setValue(arit.calculaExpressao(treated, 2, variable, top));
			break;
			case "prt":
				double resultado = 0.0;
				if(treated[1].startsWith("\"")){
					treated[1] = treated[1].substring(1, treated[1].length());
					for(int iter = 1; iter < treated.length; iter++){
						System.out.printf("%s%s", (iter > 1) ? " " : "", treated[iter]);
					}
					System.out.printf("\n");
				}
				else{
					resultado = arit.calculaExpressao(treated, 1, variable, top);
					if(arit.codigoDoOperador(treated[1]) < 5)
						System.out.println(resultado);
					else
						System.out.println((resultado == 0) ? "False" : "True");
				}
			break;
			//case "if":
				//break;
			//case "while":
				//break;
				
			/* TO-DO [1]: 
			 * implementar "IF" (delimitado por FI)
			 * implementar "WHILE" (delimitado por DONE)
			*/
			default:
				arit.mostraErro(3);
			break;
		}
	}
	
}
