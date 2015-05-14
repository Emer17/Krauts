class Interpreter {
	private Var variable[];
	private int top; //contador de números de variáveis
	private Arit arit;
	
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
				treated = lines[i].split(" "); //linha tratada a ser interpretada
				
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
					default:
						System.err.println("Syntax Error: " + treated[0]);
						break;
				}
				//}
			}			
		}
	}
}
