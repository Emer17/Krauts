class Funcao{
	
	public void semRetorno(String v[]){
		Interpreter t = new Interpreter();
		v = Vremovenull(v);
		t.interpret(v);
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
