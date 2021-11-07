package tp2;

public class Valeur {
	private int valeur;
	private Node filsD;
	private Node filsG;

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
		return " " + valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valeur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valeur other = (Valeur) obj;
		if (valeur != other.valeur)
			return false;
		return true;
	}

}
