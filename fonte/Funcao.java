class Funcao{
	private Arit arit;
	
	public void semRetorno(String v[]){
		Interpreter t = new Interpreter();
		v = Vremovenull(v);
		t.interpret(v);
	}
	
	public double comRetorno(String v[]){
		this.arit = new Arit();
		Interpreter t = new Interpreter();
		double resultado = 0.0;
		int z = 0,top = 1000,k;
		for(z = 0; z < v.length; z++){
			if(!v[z].contains("return")){
				t.executa(v[z]);
			}else{
				break;
			}
		}
		//agora v[z] tem a linha do return
		String treated[] = new String[10];
		treated = v[z].split(" ");
		k = arit.indiceDaVariavel(treated[1],t.variable,top);
		resultado = arit.calculaExpressao(treated, 1, t.variable, top);
		return resultado;
	}
	
	public String[] Vremovenull(String l[]){
		int w = 0;
		String linhas[];

		while(true){
			if(l[w] != null){
				w++;
			}
			else{
				break;
			}
		}

		linhas = new String[w];
		w--;

		while((w + 1) != 0){
			linhas[w] = l[w];
			w--;
		}

		return linhas;
	}
}
