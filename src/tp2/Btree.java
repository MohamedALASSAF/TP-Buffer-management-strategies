package tp2;

import java.util.ArrayList;
import java.util.Arrays;

public class Btree {

	static Node root;
	int m;

	public Btree(int m) {
		this.m = m;
		root = new Node(m);
	}

	public static void main(String[] args) {
		int m = 5;
		Btree b = new Btree(m);
		ArrayList<Valeur> v5 = new ArrayList<>();
		// v5.add(new Valeur(10, null, null));
		b.root = new Node(null, null, m, v5);
		ArrayList<Integer> test = new ArrayList<>(Arrays.asList(10, 15, 30, 27, 35, 40, 10, 45, 37, 20, 50, 55, 46, 71,
				66, 74, 85, 90, 79, 78, 95, 25, 81, 68, 60, 65));

		ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(50, 55, 66, 68, 70, 71, 72, 73, 79, 81, 85, 90, 95));

		ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		for (int i : test) {
			insert(i, b.root, null, true, null);
		}
		afficherTree(b.root);

	}

	/**
	 * @param i l'element qu'on cherche
	 * @param n la racine de l'abre dans lequel il faut chercher i
	 * @return true si i existe dans l'arbre sinon false
	 * 
	 */
	public static boolean searchExist(int i, Node n) {

		boolean b = false;

		for (Valeur v : n.valeurs) {

			if (i == v.getValeur()) {
				b = true;
				break;

			} else if (v.getValeur() > i && v.filsG != null) {
				b = searchExist(i, v.filsG);
				break;
			}

			else if (n.getMaxValeur().filsD != null && v.getValeur() == n.getMaxValeur().valeur) {
				b = searchExist(i, n.getMaxValeur().filsD);
				break;
			}

		}

		return b;
	}

	/**
	 * @param i l'element qu'on veut inserer
	 * @param n la racine de l'abre dans lequel il faut inserer i
	 * @return le node dans lequel il faut inserer i et si i existe dans l'arbre on
	 *         renvoie null
	 * 
	 */
	public static Node searchNode(int i, Node n) {

		for (Valeur v : n.valeurs) {

			if (i == v.getValeur()) {
				return null;

			}

			else if (v.getValeur() == n.getMaxValeur().valeur && n.getMaxValeur().filsD == null
					&& n.getMaxValeur().filsG == null) {
				return n;
			}

			else if (v.getValeur() > i && v.filsG != null) {
				return searchNode(i, v.filsG);

			}

			else if (v.getValeur() == n.getMaxValeur().valeur && n.getMaxValeur().filsD != null) {
				return searchNode(i, n.getMaxValeur().filsD);

			}

		}

		return null;
	}

	/**
	 * @param i          l'element qu'on veut inserer
	 * @param n          la racine de l'abre dans lequel il faut inserer i
	 * @param enfant     si i est une valeur qui existait déjà dans l'abre et qu'on
	 *                   fait donc remonter sur son père, enfant contient l'enfant
	 *                   de i sinon null
	 * @param islast     si i est une valeur qui existait déjà dans l'abre et qu'on
	 *                   fait donc remonter sur son père,islast=true si il faut
	 *                   inserer i à la fin de son node parent sinon islast=false
	 * @param iValObject si i est une valeur qui existait déjà dans l'abre et qu'on
	 *                   fait donc remonter sur son père, iValObject est donc
	 *                   l'object Valeur qui correspond à i
	 * 
	 */
	public static void insert(int i, Node n, Node enfant, boolean islast, Valeur iValObject) {
		if (n.valeurs.size() == 0) {
			insertNotFull(n, i, iValObject);
		} else {
			// on récupère le node ou il faut inserer i
			Node node = searchNode(i, n);
			if (node != null) {
				// si enfant est different de null cela veut dire que la valuer qu'on veut
				// insérer avait un enfant et qu'on essaye d'inserer cette valeur dans son pere
				// on est dans le cas donc ou n ici c'etait le pere de i
				if (enfant != null) {
					// ici on verifie si i doit être inserer ou non à la fin du node n
					if (islast) {
						// si oui le fils droit du dernier element de n devient le fils gauche de la
						// valeur qu'on veut inserer a la fin de n
						// et le fils droit de la valeur qu'on veut inserer à la fin de n c'est l'enfant
						// avec qui il est venu
						iValObject.filsG = n.getMaxValeur().filsD;
						n.getMaxValeur().filsD = null;
						iValObject.filsD = enfant;
					} else {

						// sinon cela veut dire que la valeur ne sera pas inserer à la fin du node et
						// son fils gauche est donc l'enfant avec lequel il est venu
						iValObject.filsG = enfant;
					}
					insertNotFull(n, i, iValObject);

				}

				if (!node.isFull() && iValObject == null) {
					// si le node n'est pas plein , si iValObject == null cela veut dire que c'est
					// l'insertion d'une nouvelle valeur dans l'abre et non pas celui d'une valeur
					// venu d'un autre node
					insertNotFull(node, i, null);

				} else {
					// sinon si node est plein, on recupere la median pour le split
					int median = node.getMedian(i);
					insertNotFull(node, i, null);
					int indexMedian = Math.round(((float) node.m) / 2) - 1;
					Valeur medianValObject = getValObject(median, node);

					if (node.pereNode != null) {
						splitNode(median, medianValObject, indexMedian, node);
					} else {
						splitRoot(medianValObject, indexMedian, node);

					}

				}

			}
		}

	}

	/**
	 * cette fonction insere une valeur dans un node
	 * 
	 * @param n          le node dans lequel il faut inserer i
	 * @param i          la valeur qu'il faut inserer
	 * @param iValObject si i est une valeur qui existait déjà dans l'abre et qu'on
	 *                   fait donc remonter sur son père, iValObject est donc
	 *                   l'object Valeur qui correspond à i
	 */

	public static void insertNotFull(Node n, int i, Valeur iValObject) {

		for (Valeur v : n.valeurs) {
			if (v.getValeur() > i) {

				int index = n.valeurs.indexOf(v);
				if (iValObject == null) {
					n.valeurs.add(index, new Valeur(i, null, null));
				} else {
					n.valeurs.add(index, iValObject);
				}

				break;
			} else if (v.getValeur() == n.getMaxValeur().valeur) {
				if (iValObject == null) {
					n.valeurs.add(new Valeur(i, null, null));
				} else {
					n.valeurs.add(iValObject);
				}
				break;
			}
		}

		if (n.valeurs.size() == 0) {
			n.valeurs.add(new Valeur(i, null, null));
		}
		if (!n.isLeaf() && n.pereNode == null && n.valeurs.size() == n.m) {
			int indexMedian = Math.round(((float) n.m) / 2) - 1;
			Valeur medianValObject = n.valeurs.get(indexMedian);
			splitRoot(medianValObject, indexMedian, n);

		}

	}

	/**
	 * cette fonction permet de couper en 2 le node si elle est pleine
	 * 
	 * @param median          la median du node, on se base sur cette mediane pour
	 *                        couper le node en 2
	 * @param medianValObject Object Valeur qui correspond à la médiane
	 * @param indexMedian     index de la mediane
	 * @param node            le node qu'il faut couper en 2
	 */
	public static void splitNode(int median, Valeur medianValObject, int indexMedian, Node node) {
		Valeur maxValuePere = node.pereNode.getMaxValeur();

		if (maxValuePere.valeur > median) {
			Node n2 = new Node(node.pereNode, medianValObject, node.m, subliste(node.valeurs, 0, indexMedian - 1));

			node.valeurs = subliste(node.valeurs, indexMedian + 1, node.valeurs.size() - 1);

			if (!node.isLeaf()) {
				n2.getMaxValeur().filsD = medianValObject.filsG;

			}
			insert(median, node.pereNode, n2, false, medianValObject);

		} else {
			Node n2 = new Node(node.pereNode, medianValObject, node.m,
					subliste(node.valeurs, indexMedian + 1, node.valeurs.size() - 1));

			node.valeurs = subliste(node.valeurs, 0, indexMedian - 1);
			if (!node.isLeaf()) {
				node.getMaxValeur().filsD = medianValObject.filsG;

			}
			insert(median, node.pereNode, n2, true, medianValObject);
		}

	}

	/**
	 * cette fonction permet de couper en 2 le node si elle est pleine et si le node
	 * était la racine, on crée une nouvelle racine
	 * 
	 * @param medianValObject Object Valeur qui correspond à la médiane, on se base
	 *                        sur cette median pour couper le node n en 2
	 * @param indexMedian     index de la mediane
	 * @param n               le node qu'il faut couper en 2
	 */
	public static void splitRoot(Valeur medianValObject, int indexMedian, Node n) {
		ArrayList<Valeur> valeursRoot = new ArrayList<>();
		Node n2 = new Node(null, medianValObject, n.m, subliste(n.valeurs, 0, indexMedian - 1));

		n.valeurs = subliste(n.valeurs, indexMedian + 1, n.valeurs.size() - 1);

		if (!n.isLeaf()) {
			n2.getMaxValeur().filsD = medianValObject.filsG;

		}
		Node newRoot = new Node(null, null, n.m, null);
		n2.pere = medianValObject;
		n.pere = medianValObject;
		n2.pereNode = newRoot;
		n.pereNode = newRoot;
		medianValObject.filsG = n2;
		medianValObject.filsD = n;
		valeursRoot.add(medianValObject);

		newRoot.valeurs = valeursRoot;

		root = newRoot;
	}

	/**
	 * 
	 * @param val  la valeur dont on veut savoir sa position dans le node
	 * @param node le node
	 * @return retourn index de val dans node sinon -1 si val n'existe pas dans node
	 */
	public static int getIndex(int val, Node node) {
		for (int i = 0; i < node.valeurs.size(); i++) {
			if (node.valeurs.get(i).valeur == val) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * cette fonction retourne l'objet Valeur correspondant à val
	 * 
	 * @param val
	 * @param node
	 * @return
	 */
	public static Valeur getValObject(int val, Node node) {
		for (int i = 0; i < node.valeurs.size(); i++) {
			if (node.valeurs.get(i).valeur == val) {
				return node.valeurs.get(i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param vals une liste de valeur
	 * @param a    la position à partir duquel on veut la sous liste de vals
	 * @param b    la position du dernier element de la sous liste
	 * @return une sous liste de vals
	 */
	public static ArrayList<Valeur> subliste(ArrayList<Valeur> vals, int a, int b) {
		ArrayList<Valeur> result = new ArrayList<>();
		if (a == b) {
			result.add(vals.get(a));
			return result;
		}
		for (int i = a; i <= b; i++) {
			result.add(vals.get(i));
		}
		return result;
	}

	/**
	 * cette fonction fait une parcours en profondeur de l'arbre et affiche les node
	 * 
	 * @param n la racine du de l'abre
	 */
	public static void afficherTree(Node n) {
		System.out.println(n);
		for (Valeur v : n.valeurs) {

			if (v.filsG != null) {
				afficherTree(v.filsG);

			}
			if (v.filsD != null) {
				afficherTree(v.filsD);
			}

		}

	}

}
