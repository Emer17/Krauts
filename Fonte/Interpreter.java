class Interpreter {
	private Var variable[];
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
	}

	public void interpret(String lines[]) {
		double a, b;
		int k;
		Arit arit = new Arit();
		//laço da interpretação
		for (int i = 0; i < lines.length; i++) {
			String treated[] = new String[100];
			treated = lines[i].split(" "); //linha tratada a ser interpretada
			//interpreta a linha
			for(int j = 0; j < treated.length; j++) {
				switch (treated[j]) {
					case "new":
						//acha e insere no final do vetor
						k = variable.length + 1;
						variable[k].setName(treated[j+1]);
						break;
						
					case "add":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						a = arit.Arit1(treated[i+1], variable);
						b = arit.Arit1(treated[i+2], variable);
						k = arit.Arit2(treated[i-1], variable);
						variable[k].setValue(arit.add(a, b));
						break;
					case "sub":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						a = arit.Arit1(treated[i+1], variable);
						b = arit.Arit1(treated[i+2], variable);
						k = arit.Arit2(treated[i-1], variable);
						variable[k].setValue(arit.sub(a, b));
						break;
					case "div":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						a = arit.Arit1(treated[i+1], variable);
						b = arit.Arit1(treated[i+2], variable);
						k = arit.Arit2(treated[i-1], variable);
						variable[k].setValue(arit.div(a, b));
						break;
					case "mul":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						a = arit.Arit1(treated[i+1], variable);
						b = arit.Arit1(treated[i+2], variable);
						k = arit.Arit2(treated[i-1], variable);
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
				System.out.println(variable[0].getValue());
			}			
		
		}
	}
}
