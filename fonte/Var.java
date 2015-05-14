/*
 this is the class that store all program variables
*/
class Var {
	private String name;
	private double value;
	
	public Var(){
		this.name = ""; this.value = 0.0;
	}

	public void setName(String p) { this.name = p; }
	public void setValue(double n) { this.value = n; }
	
	public String getName() { return this.name; }
	public double getValue() { return this.value; }
}
