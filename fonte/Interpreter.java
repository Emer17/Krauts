/**
 * Krauts - an interpreted language with Assembly-like syntax
 * Developed by Vitor G. Forbrig and Leonardo D. Constantin
 * 
 * Contact us: 
 *  vitorforbrig at gmail dot com
 *  constantin dot leo at gmail dot com
 * 
 * Interpreter class: recognizes and executes commands
**/

import java.util.*;

class Interpreter {
	private Var variable[];
	private int i, top, scopeCounter, condCounter; //contador de números de variáveis
	private Arit arit;
	private Stack<Integer> loop;
	private static int flagIf, flagLoop;
	private Funcao f = new Funcao();
	public String ggizi[]; //vetor que guarda SOMENTE o escopo das funçoes.
	
	
	/* TO-DO: (mero detalhe)
	 * substituir o método de armazenamento
	 * das variáveis por algo mais eficiente, 
	 * como o TreeSet do Java.
	*/
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
		this.arit = new Arit();
		this.top = 0;
		this.loop = new Stack<Integer>();
		this.flagIf = 0;
		this.flagLoop = 0;
		this.scopeCounter = 0;
		this.condCounter = 0;
	}
	
	public void interpret(String lines[]) {
		String dummy; // String criada para evitar repetir código e funções
		
		//------------------------------------------------------------------------------------------------------
		int z,x = 0,cont =0,inicio = 0,aux; //vai ter o indice da linha onde o primeiro comando real vai estar (um comando fora de funçao.)
		for(z = 0; z < lines.length; z++){
			if(lines[z].contains("{")) cont++;
			else if(lines[z].contains("}")) cont--;
			
			if(lines[z].contains("new") && cont == 0 || lines[z].contains("prt") && cont == 0){
				inicio = z;
				break;
			}
		}
		aux = inicio;
		while(aux < lines.length){
			if(lines[aux] != null){
				if(lines[aux].contains("{")){
					arit.mostraErro(8);
					break;
				}
			}
			aux++;
		}
		
		this.ggizi = new String[inicio];
		for(z = 0; z < ggizi.length; z++){
			ggizi[x] = lines[z];
			//System.out.println("ggizi "+ggizi[x]); //veja a ggizi...
			x++;
		}
		
		//-------------------------------------------------------------------------------------------------------
		
		for (i = 0; i < lines.length && lines[i] != null; i++) {
			if (!(lines[i].startsWith("~") || lines[i].trim().isEmpty())) {
				// Se não for imprimir mensagem, "enxuga" os espaços excessivos da linha
				dummy = lines[i].toLowerCase();
				
				if(dummy.trim().contains("prt\"") == false){
					lines[i] = lines[i].replace("\t","");
					lines[i] = lines[i].trim();
				}
				
				if(dummy.contains("while") && flagLoop != 0)
					flagLoop++;
				
				if(dummy.contains("done") && flagLoop != 0)
					flagLoop--;
				
				else if(dummy.contains("done") && flagLoop == 0){
					i = loop.pop();
					dummy = lines[i].toLowerCase();
					scopeCounter--;
				}
				// verifica abertura e fechamento de escopos
				if(dummy.contains("if") || dummy.contains("while"))
					scopeCounter++;
					
				if(dummy.contains("fi") || dummy.contains("done"))
					scopeCounter--;
				
				if(dummy.contains("fi") && (condCounter == 0)){
					flagIf = 0;
				}
				
				if(flagIf == 1 && lines[i].toLowerCase().contains("if"))
					condCounter++;
				
				if(flagIf == 1 && lines[i].toLowerCase().contains("fi")) 
					condCounter--;
				//---------------------------------------------------------------------------------------------------------
				//invoca o método tokens quando quando os flags das condições dos "se" e "enquanto" forem verdadeiras
				if(flagIf == 0 && flagLoop == 0) 
					//---------------------------------------------------------------------------------------------------
					//aqui vai a verificação se tem funçao ou nao
					if(lines[i].contains("{") && i < inicio) i = inicio; //ignora a funçao... por momento é claro..
					if(lines[i].contains("{") && i > inicio){
						while(!lines[i-1].contains("}")){
							i++;
						}
					}
					//-----------------------------------------------------------------------------------------------------
					executa(lines[i]);
			}		
		}
		if(this.scopeCounter != 0){
			arit.mostraErro(5);
		}
	}
	
	public void executa(String tokens){
		String treated[] = tokens.split("~"); 
		// Esta linha dispensa comentários. Trocadilho não-intencional.
		
		treated = treated[0].split(" "); //linha tratada a ser interpretada
		//interpreta a linha
		int k;
		boolean validaNome = 
			treated.length > 1 ? Character.isLetter(treated[1].charAt(0)) : false;
		switch (treated[0].toLowerCase()) {
			case "new":
				//acha e insere no final (topo) do vetor
				if(validaNome == false)
					arit.mostraErro(6);
				if(arit.indiceDaVariavel(treated[1], variable, top) != -1){
					arit.mostraErro(1);
				}
				if(top < variable.length) {
					variable[top] = new Var();
					variable[top].setName(treated[1]);
					//System.out.println("aqui ");
					//System.out.println(variable[top].setName(treated[1]));
					top++;
				} else { 
					arit.mostraErro(2);
				}
			break;
			
			case "atr":
				if(validaNome == false)
					arit.mostraErro(3, "Invalid variable name: " + treated[1]);
				k = arit.indiceDaVariavel(treated[1], variable, top);
				if(k == -1){
					arit.mostraErro(4);
				}
				variable[k].setValue(arit.calculaExpressao(treated, 2, variable, top));
			break;
			case "prt":
				double resultado = 0.0;
				if(treated[1].startsWith("\"")){
					treated[1] = treated[1].substring(1, treated[1].length());
					for(int iter = 1; iter < treated.length; iter++){
						System.out.printf("%s%s", (iter > 1) ? " " : "", treated[iter]);
					}
					System.out.printf("\n");
				}
				else{
					resultado = arit.calculaExpressao(treated, 1, variable, top);
					if(arit.codigoDoOperador(treated[1]) < 5)
						System.out.println(resultado);
					else
						System.out.println((resultado == 0) ? "False" : "True");
				}
			break;
			case "if":
				if(arit.calculaExpressao(treated, 1, variable, top) == 0)
					flagIf = 1;
			break;
			case "fi": break;
			
			case "while":
				if(arit.calculaExpressao(treated, 1, variable, top) == 0)
					flagLoop++;
				else loop.push(i);
			break;

			case "func": //sem parametro e sem retorno.. por enquanto.
				String v[] = new String[ggizi.length];
				int iniciofunc = 0,x = 0;
				int vitor = 0;
				for(int z = 0; z < this.ggizi.length; z++){
					iniciofunc = z;
					if(ggizi[iniciofunc].contains("double")){
						//
					}else{
						if(ggizi[z].contains(treated[1])){
							//System.out.println(ggizi[z]);
							vitor++;
							while(z < ggizi.length){
								if(ggizi[z].contains("new") || ggizi[z].contains("prt") || ggizi[z].contains("atr") ||ggizi[z].contains("if")
									||ggizi[z].contains("fi") ||ggizi[z].contains("while") ||ggizi[z].contains("done")){
										
										v[x] = ggizi[z];
										x++;
									}else if(ggizi[z].contains("}")){
										break;
									}
									z++;
								}
								f.semRetorno(v);
								break;
							}
						}
					}
					if(vitor == 0)
						arit.mostraErro(7);
					break;
				
			case "return":
			//
			break;
							
			case "done": break;
			
				
			default:
				arit.mostraErro(3);
			break;
		}
	}
	
}
