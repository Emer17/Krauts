/**
 * Krauts - an interpreted language with Assembly-like syntax
 * Developed by Vitor G. Forbrig and Leonardo D. Constantin
 * 
 * Contact us: 
 *  vitorforbrig at gmail dot com
 *  constantin dot leo at gmail dot com
 * 
 * Arit class: Arithmetic and Logic Unit
**/

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
	
	public int codigoDoOperador(String token){
		String[] operadores = new String[18];
		operadores[0] = "add";
		operadores[1] = "sub";
		operadores[2] = "mul";
		operadores[3] = "div";
		operadores[4] = "mod";
		
		operadores[5] = "eq";
		operadores[6] = "lt";
		operadores[7] = "gt";
		operadores[8] = "leq";
		operadores[9] = "geq";
		operadores[10] = "neq";
		
		operadores[11] = "not";
		operadores[12] = "and";
		operadores[13] = "or";
		operadores[14] = "xor";
		operadores[15] = "nand";
		operadores[16] = "nor";
		operadores[17] = "xnor";
		
		token = token.toLowerCase();
		
		for(int i=0; i<operadores.length; i++)
			if(token.equals(operadores[i]))
				return i;
		
		return -1;
	}
	private double ALU(String token, double op1, double op2){
		double result = 0.0;
		switch(token.toLowerCase()){
			/* Aritmetic operations */
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
					mostraErro(0);
				}
			break;
			case "mod":
				try{ result = op1 % op2; }
				catch(Exception e){
					mostraErro(0);
				}
			break;
			
			/* Comparison functions */
			case "eq": 
				result = cmp_eq(op1, op2)
					? 1 : 0; 
			break;
			case "lt": 
				result = cmp_lt(op1, op2) 
					? 1 : 0;
			break;
			case "gt": 
				result = cmp_gt(op1, op2) 
					? 1 : 0; 
			break;
			case "leq": 
				result = cmp_leq(op1, op2) 
					? 1 : 0; 
			break;
			case "geq": 
				result = cmp_geq(op1, op2) 
					? 1 : 0; 
			break;
			case "neq": 
				result = cmp_neq(op1, op2) 
					? 1 : 0; 
			break;
			
			/* Boolean operations */
			case "not":
				result = (cmp_eq(op1, 0))
					? 1 : 0;
			break;
			case "and":
				result = (cmp_neq(op1, 0) && cmp_neq(op2, 0))
					? 1 : 0;
			break;
			case "or":
				result = (cmp_neq(op1, 0) || cmp_neq(op2, 0))
					? 1 : 0;
			break;
			case "xor":
				result = (cmp_neq(op1, 0) ^ cmp_neq(op2, 0))
					? 1 : 0;
			break;
			case "nand":
				result = (cmp_eq(op1, 0) || cmp_eq(op2, 0)) 
					? 1 : 0;
			break;
			case "nor":
				result = (cmp_eq(op1, 0) && cmp_eq(op2, 0))
					? 1 : 0;
			break;
			
			default:
				mostraErro(3);
			break;
		}
		return result;
	}
	
	public double calculaExpressao(String token[], int idx, Var variable[], int top){
		double op1, op2, result;
		Stack<Double> p = new Stack<Double>();
		
		for (int i = token.length - 1; i >= idx; i--){
			if(codigoDoOperador(token[i]) != -1){
				op1 = p.pop();
				op2 = p.pop();
				result = ALU(token[i], op1, op2);
				if(token[i].toLowerCase().equals("not"))
					p.push(op2);
				p.push(result);
			}
			else{
				double operando = valorDaVariavel(token[i], variable, top);
				p.push(operando);
			}
		}
		
		return p.peek();
	}
	
	// metodos de comparacao de double, tratando erros de precisao
	private static final double EPS = 1.e-14;
	private static int cmp(double x, double y){
		return (x <= y + EPS) ? (x + EPS < y) ? -1 : 0 : 1;
	}
	
	private static boolean cmp_eq (double x, double y) {return cmp(x, y) == 0;}
	private static boolean cmp_lt (double x, double y) {return cmp(x, y) <  0;}
	private static boolean cmp_gt (double x, double y) {return cmp(x, y) >  0;}
	private static boolean cmp_leq(double x, double y) {return cmp(x, y) <= 0;}
	private static boolean cmp_geq(double x, double y) {return cmp(x, y) >= 0;}
	private static boolean cmp_neq(double x, double y) {return cmp(x, y) != 0;}
	
	
	public void mostraErro(int e){
        switch(e){ 
			case 0: 
                System.out.printf("ERROR(0): Division by zero\n");
			break;
            case 1:
                System.out.printf("ERROR(1): Variable already exists\n");
			break;
            case 2:
                System.out.printf("ERROR(2): Variables limit exceeded\n");
			break;
            case 3: 
                System.out.printf("ERROR(3): Syntax error\n");
			break;
            case 4: 
                System.out.printf("ERROR(4): Tried to print unexisting variable\n");
			break;
            case 5: 
                System.out.printf("ERROR(5): Variable doesn\'t exist\n");
			break;
            case 6: 
                System.out.printf("ERROR(6): Scope error.\n");
			break;
            case 7: 
                System.out.printf("ERROR(7): Invalid comparison\n");
			break;
        }
        System.exit(1);
    }
}
