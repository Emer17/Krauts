/*
 this is the class that store all program variables
*/
class Var {
	private String name;
	private double value;

	public void setName(String p) {
		this.name = p;
		this.setValue(0);
	}
	
	public void setValue(double n) {
		this.value = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getValue() {
		return this.value;
	}
}
