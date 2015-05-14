import java.util.*;

class Interpreter {
	private Var variable[];
	private int top; //contador de números de variáveis
	private Arit arit;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		this.variable = new Var[1000];
		this.arit = new Arit();
		this.top = 0;
	}
	
	private double eval(String token[], int idx){
		double operando, op1, op2, result = 0.0;
		
		Stack<Double> p = new Stack<Double>();
		
		for (int i = token.length - 1; i >= idx; i--){
			try {
				operando = Double.parseDouble(token[i]);
				p.push(operando);
			} 
			catch(Exception e){
				op1 = p.pop();
				op2 = p.pop();
				
				switch(token[i].toLowerCase()){
					case "add":
						result = op1 + op2;
						break;
					case "sub":
						result = op1 - op2;
						break;
					case "mul":
						result = op1 * op2;
						break;
					case "div":
						try{ result = op1 / op2; }
						catch(Exception exc){
							System.out.println("ERROR: Division by zero");
							System.exit(1);
						}
						break;
					case "mod":
						try{ result = op1 % op2; }
						catch(Exception exc){
							System.out.println("ERROR: Division by zero");
							System.exit(1);
						}
						break;
					default:
						System.out.println("Syntax ERROR");
						break;
						
				}
				p.push(result);
			}
		}
		
		return p.peek();
	}
	
	
	
	public void interpret(String lines[]) {
		//System.out.println ("Debug: num linhas = "+ (lines.length));
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
					switch (treated[j].toLowerCase()) {
						case "new":
							//acha e insere no final (topo) do vetor
							variable[top] = new Var();
							variable[top].setName(treated[j+1]);
							top++;
							break;
						case "atr":
							k = arit.indiceDaVariavel(treated[i+1], variable, top);
							variable[k].setValue(eval(treated, i+2));
							break;
						case "prt":
						//	prt(treated, i);
							break;
						default:
							System.out.println("Syntax Error");
							break;
						case "add":
							//retorna o indice do vetor de variavel que tem aquele nome, se houver
							a = arit.valorDaVariavel(treated[i+1], variable, top);
							b = arit.valorDaVariavel(treated[i+2], variable, top);
							k = arit.indiceDaVariavel(treated[i-1], variable, top);
							variable[k].setValue(arit.add(a, b));
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
					}
				}
			}			
		}
		System.out.println(variable[0].getValue());
	}
}
