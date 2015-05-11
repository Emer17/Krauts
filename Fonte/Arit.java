class Arit {
	//recebe string e retorna número da variavel ou constante, ex no código: "add a 2", retorna o valor contido em "a" ou a constante "2" 
	public double Arit1(String what, Var variable[]) {
						
		if (!Integer.parseInt(what)) {
			for(int i = 0; i < variable[].length; i++) {
				if (what == variable[i].getName()) {//achou
					break;
				}
			}
			i = variable[i].getValue();
			return i;
		}
		
		return Integer.parseInt(what);
	}
	
	//retorna o indice que se encontra a variavel
	public double Arit2(String what, Var variable[]) {
		for(int who = 0; who < variable[].length; who++) {
			if (what == variable[who].getName()) {//achou
				break;
			}
		}
		return who;
	}	
}
