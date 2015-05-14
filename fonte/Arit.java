import java.util.*;

class Arit {
	//recebe string e retorna número da variavel ou constante,
	// ex no código: "add a 2", retorna o valor contido em "a" ou a constante "2" 
	public double valorDaVariavel(String what, Var variable[], int top) {
		double v;
		try {
			v = Double.parseDouble(what);
			return v;	
		} 
		catch(Exception e) {
			int i;
			double g;
			// what nao eh int, eh uma coisa louca(procura nas variaveis)
			for(i = 0; i < top; i++) {
				if (what.equals(variable[i].getName())) { //achou
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
		for(who = 0; who < top; who++)
			if (what.equals(variable[who].getName()))//achou
				return who;
		return -1; //nao achou; 
		//CUIDADO COM ACESSOS INVALIDOS AO ARRAY
	}	
	
	private boolean ehOperador(String token){
		String[] operadores = new String[5];
		operadores[0] = "add";
		operadores[1] = "sub";
		operadores[2] = "mul";
		operadores[3] = "div";
		operadores[4] = "mod";
		
		token = token.toLowerCase();
		
		for(int i=0; i<operadores.length; i++)
			if(token.equals(operadores[i]))
				return true;
		
		return false;
	}
	
	public double avaliaExpressao(String token[], int idx, Var variable[], int top){
		double operando, op1, op2, result = 0.0;
		Stack<Double> p = new Stack<Double>();
		
		for (int i = token.length - 1; i >= idx; i--){
			if(ehOperador(token[i])){
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
						catch(Exception e){
							System.err.println("ERROR: Division by zero");
							System.exit(1);
						}
						break;
					case "mod":
						try{ result = op1 % op2; }
						catch(Exception e){
							System.err.println("ERROR: Division by zero");
							System.exit(1);
						}
						break;
					default:
						System.err.println("Syntax ERROR");
						break;
						
				}
				p.push(result);
			}
			else{
				operando = valorDaVariavel(token[i], variable, top);
				p.push(operando);
			}
		}
		
		return p.peek();
	}
}
