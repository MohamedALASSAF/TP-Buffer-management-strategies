package tp2;

import java.util.ArrayList;

public class Node {
	
	//Node pere ;
	int m ;
	ArrayList<Valeur> valeurs ; 

	
	
	public Node( int m, ArrayList<Valeur> valeurs) {

		//this.pere = pere;
		this.m = m;
		this.valeurs = valeurs;
	}

	public boolean search(int i) {
		
		for(Valeur v : valeurs ) {
			if (i == v.getValeur()) {
				return true ;
			}
		}
		
		return false ;
	}
	
	public Valeur getMaxValeur() {
		return valeurs.get(valeurs.size()-1);
	}

}
