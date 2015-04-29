/*
 this is the class that store all program variables
*/
class Var {
	private String name;
	private double value;
	
	public Var(String s, double d) { //the constructor
		this.name = s;
		this.value = d;
	}
	
	public void setName(String p) {
		this.name = p;
	}
	
	public void setValue(double n) {
		this.value = n;
	}
	
	public String getNome() {
		return this.name;
	}
	
	public double getValor() {
		return this.value;
	}
}

// YTPBR Courier Crisis by Mestre3224
// comentário non-sense só pra fins de teste
