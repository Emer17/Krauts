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

class Interpreter {
	private Var variable[]; // Isto não deveria ficar na classe Arit?
	private int top; //contador de números de variáveis
	private Arit arit;
	
	/* TO-DO: (mero detalhe)
	 * substituir o método de armazenamento
	 * das variáveis por algo mais eficiente, 
	 * como o TreeSet do Java.
	*/
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
		this.arit = new Arit();
		this.top = 0;
	}
	
	/* TO-DO [1]:
	 * 
	 * Adicionar avisos de erros
	 * Tratar erros
	*/
	public void interpret(String lines[]) {
		//System.out.println ("Debug: num linhas = "+ (lines.length));
		for (int i = 0; i < lines.length && lines[i] != null; i++) {
			//System.out.printf("Linha %d: %s\n", i+1, lines[i]);
			if (!(lines[i].startsWith("~") || lines[i].isEmpty())) {
				//a string no indice será quebrada em várias substrings para ser interpretada
				String treated[] = lines[i].split("~"); 
				// Esta linhas dispensam comentarios
				// Trocadilho nao-intencional :v
				treated = treated[0].split(" "); //linha tratada a ser interpretada
				//interpreta a linha
				int k;
				switch (treated[0].toLowerCase()) {
					case "new":
						//acha e insere no final (topo) do vetor
						variable[top] = new Var();
						variable[top].setName(treated[1]);
						top++;
					break;
					case "atr":
						k = arit.indiceDaVariavel(treated[1], variable, top);
						variable[k].setValue(arit.calculaExpressao(treated, 2, variable, top));
					break;
					case "prt":
						double resultado = 0.0;
						if(treated[1].startsWith("\"")){
							treated[1] = treated[1].substring(1, treated[1].length());
							for(int iter = 1; iter < treated.length; iter++)
								System.out.printf("%s", treated[iter]);
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
					/* TO-DO [2]:
					 * implementar comparação entre variáveis
					 * lembrar da tolerância de precisão, EPS = 1e-9
					 * menor que: 		"LT"
					 * menor ou igual: 	"LEQ"
					 * igual: 			"EQ"
					 * maior ou igual: 	"GEQ"
					 * maior: 			"GT"
					 * diferente:		"NEQ" (Not EQual)
					 * 
					 * implementar "WHILE" (delimitado por DONE)
					 * implementar "IF" (delimitado por ENDIF)
					 * se possível, com "ELSE" e/ou "ELIF"
					*/
					default:
						System.err.println("Syntax Error: " + treated[0]);
					break;
				}
				//}
			}			
		}
	}
}
