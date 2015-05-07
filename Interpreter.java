class Interpreter {
	private var variable;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		variable = new Var[];
	}

	public void interpret(String linhas[]) {
		for (int i = 0; i < linhas.lenght; i++) {
			String treated[] = new String("");
			treated[] = linhas[i].split(" "); //linha tratada a ser interpretada
			
		
			swicth (treated) {
				case "add":
				
				break;
				case "sub":
				
				break;
				case "div":
				
				break;
				case "mul":
				
				break;
				case "str":
				
				break;
				case "new":
				
				break;
				case "prt":
					prt(treated[], int i);
				break;
				default:
				
				break;
			}
			
		
		}
	}
}
