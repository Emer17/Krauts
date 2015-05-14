/**
 * Krauts - an interpreted language with Assembly-like syntax
 * Developed by Vitor G. Forbrig and Leonardo D. Constantin
 * 
 * Contact us: 
 *  vitorforbrig at gmail dot com
 *  constantin dot leo at gmail dot com
 * 
 * Var class: stores the program variables
**/

class Var implements Comparable<Var> {
	private String name;
	private double value;
	
	public Var(){
		this.name = ""; this.value = 0.0;
	}

	public void setName(String p) { this.name = p; }
	public void setValue(double n) { this.value = n; }
	
	public String getName() { return this.name; }
	public double getValue() { return this.value; }
	
	// Este método seria útil caso as variáveis fossem armazenadas em uma TreeSet
	public int compareTo(Var otherVar) {
        return this.name.compareTo(otherVar.getName());
    }
}
