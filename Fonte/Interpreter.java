class Interpreter {
	private var variable;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		variable = new Var[];
	}

	public void interprete(String lines[]) {
		//laço da interpretação
		for (int i = 0; i < lines.length; i++) {
			String treated[] = new String("");
			treated[] = lines[i].split(" "); //linha tratada a ser interpretada
			//interpreta a linha
			for(int j = 0; j < treated[].lengh; j++) {
				switch (treated[j]) {
					case "new":
						//acha e insere no final do vetor
						int k = variable[].lenght + 1;
						variable[k].setName(treated[j+1]);
						break;
						
					case "add":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = Arit.Arit1(treated[i+1], variable[]);
						double b = Arit.Arit1(treated[i+2], variable[]);
						int k = Arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(add(a, b));
						break;
					case "sub":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = Arit.Arit1(treated[i+1], variable[]);
						double b = Arit.Arit1(treated[i+2], variable[]);
						int k = Arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(sub(a, b));
						break;
					break;
					case "div":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = Arit.Arit1(treated[i+1], variable[]);
						double b = Arit.Arit1(treated[i+2], variable[]);
						int k = Arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(div(a, b));
						break;
					break;
					case "mul":
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = Arit.Arit1(treated[i+1], variable[]);
						double b = Arit.Arit1(treated[i+2], variable[]);
						int k = Arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(mul(a, b));
						break;
					break;
					case "str":
					
					break;
					case "prt":
						prt(treated[], int i);
					break;
					default:
					
					break;
				}
			}			
		
		}
	}
}
