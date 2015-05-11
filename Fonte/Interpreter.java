class Interpreter {
	private var variable;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		variable = new Var[];
	}

	public void interprete(String lines[]) {
		Arit arit = new Arit;
		//laço da interpretação
		for (int i = 0; i < lines.length; i++) {
			String treated[] = new String("");
			treated[] = lines[i].split(" "); //linha tratada a ser interpretada
			//interpreta a linha
			for(int j = 0; j < treated[].length; j++) {
				switch (treated[j]) {
					case "new":
						//acha e insere no final do vetor
						int k = variable[].length + 1;
						variable[k].setName(treated[j+1]);
						break;
						
					case "add":
						Add a = new Add;
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = arit.Arit1(treated[i+1], variable[]);
						double b = arit.Arit1(treated[i+2], variable[]);
						int k = arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(a.add(a, b));
						break;
					case "sub":
						Sub a = new Sub;
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = arit.Arit1(treated[i+1], variable[]);
						double b = arit.Arit1(treated[i+2], variable[]);
						int k = arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(a.sub(a, b));
						break;
					break;
					case "div":
						Div a = new Div;
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = arit.Arit1(treated[i+1], variable[]);
						double b = arit.Arit1(treated[i+2], variable[]);
						int k = arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(a.div(a, b));
						break;
					break;
					case "mul":
						Mul a = new Mul;
						//retorna o indice do vetor de variavel que tem aquele nome, se houver
						double a = arit.Arit1(treated[i+1], variable[]);
						double b = arit.Arit1(treated[i+2], variable[]);
						int k = arit.Arit2((treated[i-1], variable[]);
						variable[k].setValue(a.mul(a, b));
						break;
					break;
					case "str":
					
					break;
					case "prt":
						//prt(treated[], int i);
					break;
					default:
					
					break;
				}
				System.out.println(variable[0].getValue);
			}			
		
		}
	}
}
