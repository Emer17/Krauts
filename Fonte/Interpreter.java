class Interpreter {
	private Var variable[];
	private int top; //contador de números de variáveis
	private Arit arit;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
		this.arit = new Arit();
		this.top = 0;
	}
	
	/* Função de interpretação recursiva 
	 * Assim finalmente poderemos implementar
	 * a linguagem com notação polonesa
	 */
	//~ private void recursion(String token[], int i){
		//~ double op1, op2, result;
		//~ switch(token[i]){
			//~ case "add":
				//~ op1 = 
			//~ break;
		//~ }
	//~ }
	
	public void interpret(String lines[]) {
		System.out.println ("Debug: num linhas = "+ (lines.length));
		for (int i = 0; i < lines.length; i++) {
			
			if (!(lines[i]==null)) {
				
				//a string no indice será quebrada em várias substrings para ser interpretada
				String treated[];
				treated = lines[i].split(" "); //linha tratada a ser interpretada
				
				
				//interpreta a linha
				for(int j = 0; j < treated.length; j++) {
					int k;
					double a, b;
					System.out.println(treated[j]);
					switch (treated[j]) {
						case "new":
							//acha e insere no final (topo) do vetor
							variable[top] = new Var();
							variable[top].setName(treated[j+1]);
							top++;
							break;
						case "add":
							//retorna o indice do vetor de variavel que tem aquele nome, se houver
							a = arit.valorDaVariavel(treated[i+1], variable, top);
							b = arit.valorDaVariavel(treated[i+2], variable, top);
							k = arit.indiceDaVariavel(treated[i-1], variable, top);
							variable[0].setValue(arit.add(a, b));
							break;
						case "sub":
							//retorna o indice do vetor de variavel que tem aquele nome, se houver
							a = arit.valorDaVariavel(treated[i+1], variable, top);
							b = arit.valorDaVariavel(treated[i+2], variable, top);
							k = arit.indiceDaVariavel(treated[i-1], variable, top);
							variable[k].setValue(arit.sub(a, b));
							break;
						case "div":
							//retorna o indice do vetor de variavel que tem aquele nome, se houver
							a = arit.valorDaVariavel(treated[i+1], variable, top);
							b = arit.valorDaVariavel(treated[i+2], variable, top);
							k = arit.indiceDaVariavel(treated[i-1], variable, top);
							variable[k].setValue(arit.div(a, b));
							break;
						case "mul":
							//retorna o indice do vetor de variavel que tem aquele nome, se houver
							a = arit.valorDaVariavel(treated[i+1], variable, top);
							b = arit.valorDaVariavel(treated[i+2], variable, top);
							k = arit.indiceDaVariavel(treated[i-1], variable, top);
							variable[k].setValue(arit.mul(a, b));
							break;
						case "str":
						
						break;
						case "prt":
							//prt(treated[], int i);
						break;
						default:
						
						break;
					}
				}
			}			
		}
		System.out.println(variable[0].getValue());
	}
}
