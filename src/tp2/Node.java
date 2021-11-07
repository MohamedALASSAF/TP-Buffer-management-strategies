package tp2;

import java.util.Collections;

import java.util.LinkedList;

public class Node implements Cloneable {

	private Valeur pere;
	private Node nodePere;
	private int m;
	private LinkedList<Valeur> valeurs;

	private boolean isRoot;

	public Node(Valeur pere, int m, LinkedList<Valeur> valeurs, Node nodePere) {
		this.nodePere = nodePere;
		this.pere = pere;
		this.m = m;
		this.valeurs = valeurs;
		this.isRoot = false;
	}

	public Node(int m) {
		this.m = m;
		this.nodePere = null;
		this.pere = null;
		this.valeurs = new LinkedList<>();
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

	public int getValMedian(int i) {
		int millieu = Math.round(((float) m) / 2);
		LinkedList<Integer> listValeurs = new LinkedList<>();
		for (Valeur v : this.valeurs) {
			listValeurs.add(v.getValeur());
		}
		listValeurs.add(i);
		Collections.sort(listValeurs);

		return listValeurs.get(millieu - 1);
	}

	public boolean isLeaf() {
		if (valeurs.get(0).getFilsD() == null) {
			return true;
		}
		return false;
	}

	public Valeur getPere() {
		return pere;
	}

	public void setPere(Valeur pere) {
		this.pere = pere;
	}

	public Node getNodePere() {
		return nodePere;
	}

	public void setNodePere(Node nodePere) {
		this.nodePere = nodePere;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public LinkedList<Valeur> getValeurs() {
		return valeurs;
	}

	public void setValeurs(LinkedList<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
