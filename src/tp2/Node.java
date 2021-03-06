package tp2;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

	Valeur pere;
	Node pereNode;
	int m;
	ArrayList<Valeur> valeurs;

	public Node(int m) {
		this.m = m;
		this.valeurs = new ArrayList<>();
	}

	public Node(Node pereNode, Valeur pere, int m, ArrayList<Valeur> valeurs) {
		this.pereNode = pereNode;
		this.pere = pere;
		this.m = m;
		this.valeurs = valeurs;
	}

	public boolean search(int i) {

		for (Valeur v : valeurs) {
			if (i == v.getValeur()) {
				return true;
			}
		}

		return false;
	}

	public Valeur getMaxValeur() {
		return valeurs.get(valeurs.size() - 1);
	}

	@Override
	public String toString() {
		return "Node : \n" + valeurs;
	}

	public boolean isFull() {
		if (valeurs.size() == m - 1) {
			return true;
		}
		return false;
	}

	public int getMedian(int i) {
		int millieu = Math.round(((float) m) / 2);
		ArrayList<Integer> listValeurs = new ArrayList<>();
		for (Valeur v : this.valeurs) {
			listValeurs.add(v.getValeur());
		}
		listValeurs.add(i);
		Collections.sort(listValeurs);

		return listValeurs.get(millieu - 1);
	}

	public boolean isLeaf() {
		if (valeurs.get(0).filsG == null) {
			return true;
		}
		return false;
	}

	public ArrayList<Valeur> getValeurs() {
		
		return this.valeurs;
	}
	

}
