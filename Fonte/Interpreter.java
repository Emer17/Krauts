class Interpreter {
	private var variable;
	
	public Interpreter( ) { //init the interpretar already whit "variable"
		variable = new Var[];
	}

	public void interprete(String lines[]) {
		for (int i = 0; i < lines.length; i++) {
			String treated[] = new String("");
			treated[] = lines[i].split(" "); //linha tratada a ser interpretada
			
		
			switch (treated) {
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
