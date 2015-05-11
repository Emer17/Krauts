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
	
	//recebe string e retorna número da variavel ou constante, ex no código: "add a 2", retorna o valor contido em "a" ou a constante "2" 
	public double Arit1(String what, Var variable[]) {
		int v;
		try {
			v = Integer.parseInt(what);
			return v;
			
		} catch(Exception e) {
			int i;
			double g;
			// what nao eh int, eh uma coisa louca(procura nas variaveis)
			for(i = 0; i < variable.length; i++) {
				if (what == variable[i].getName()) {//achou
					break;
				}
			}
			g = variable[i].getValue();
			return g;
		}
	}
	
	//retorna o indice que se encontra a variavel
	public int Arit2(String what, Var variable[]) {
		int who;
		for(who = 0; who < variable.length; who++) {
			if (what == variable[who].getName()) {//achou
				break;
			}
		}
		return who;
	}	
}
