package tp2;

public class Valeur {  
	private int valeur ;
	private Node filsD ;
	private Node filsG ;
	
	
	
	public Valeur(int valeur, Node filsG, Node filsD) {
		this.valeur = valeur;
		this.filsD = filsD;
		this.filsG = filsG;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public Node getFilsD() {
		return filsD;
	}
	public void setFilsD(Node filsD) {
		this.filsD = filsD;
	}
	public Node getFilsG() {
		return filsG;
	}
	public void setFilsG(Node filsG) {
		this.filsG = filsG;
	}
	
	@Override
	public String toString() {
		return  " "+ valeur ;
	}
	

	

	
	

	

}
