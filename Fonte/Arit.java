class Arit {
	public double mul(double a, double b) {
		return a * b;
	}
	
	public double sub(double a, double b) {
		return a - b;
	}
	
	public double div(double a, double b) {
		return a / b;
	}
	
	public double add(double a, double b) {
		return a + b;
	}
	
	//recebe string e retorna número da variavel ou constante,
	// ex no código: "add a 2", retorna o valor contido em "a" ou a constante "2" 
	public double valorDaVariavel(String what, Var variable[], int top) {
		double v;
		try {
			v = Double.parseDouble(what);
			return v;
			
		} catch(Exception e) {
			int i;
			double g;
			// what nao eh int, eh uma coisa louca(procura nas variaveis)
			for(i = 0; i < top; i++) {
				if (what == variable[i].getName()) { //achou
					break;
				}
			}
			g = variable[i].getValue();
			return g;
		}
	}
	
	// retorna o indice que se encontra a variavel
	public int indiceDaVariavel(String what, Var variable[], int top) {
		int who;
		for(who = 0; who < top; who++) {
			if (what == variable[who].getName()) {//achou
				break;
			}
		}
		return who;
	}	
}
