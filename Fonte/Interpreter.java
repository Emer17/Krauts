class Interpreter {
	private Var variable[];
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
	
	public void interpret(String lines[]) {
		//System.out.println ("Debug: num linhas = "+ (lines.length));
		for (int i = 0; i < lines.length; i++) {
			if (lines[i] != null) {
				//a string no indice será quebrada em várias substrings para ser interpretada
				String treated[];
				treated = lines[i].split("~"); // Esta linha dispensa comentarios
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
						variable[k].setValue(arit.avaliaExpressao(treated, 2, variable, top));
						break;
					case "prt":
						double resultado = arit.avaliaExpressao(treated, 1, variable, top);
						System.out.println(String.valueOf(resultado));
						break;
						
					/* TO-DO:
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
