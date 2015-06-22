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
	private double vet[];

	public Var(){
		this.name = "";
		this.vet = new double[1];
		this.value = 0.0;
	}

	public void setName(String name, int tam) {
		this.name = name;
		this.vet = new double[tam];
	}

	public void setValue(double value, int indice) {
		this.value = value;
		this.vet[indice] = value;
		//System.out.println("V[" + indice + "]:" + this.vet[indice]);
	}

	public double getTam(){
		return this.vet.length;
	}

	public String getName() {
		return this.name;
	}

	public double getValue(int indice) {
		return this.vet[indice];
	}

	// Este método seria útil caso as variáveis fossem armazenadas em uma TreeSet
	public int compareTo(Var otherVar) {
        return this.name.compareTo(otherVar.getName());
    }
}
