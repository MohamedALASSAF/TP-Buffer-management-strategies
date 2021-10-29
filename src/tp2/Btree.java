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

		/*
		 * //Node n1 = new Node(null,m,null ) ; ArrayList<Valeur> v1 = new
		 * ArrayList<>(); v1.add(new Valeur(10, null, null) ) ; v1.add(new Valeur(15,
		 * null, null) ) ; v1.add(new Valeur(20, null, null) ) ;
		 * 
		 * Node n1 = new Node(m, v1);
		 * 
		 * ArrayList<Valeur> v2 = new ArrayList<>(); v2.add(new Valeur(30, null, null) )
		 * ; v2.add(new Valeur(35, null, null) ) ;
		 * 
		 * Node n2 = new Node(m, v2);
		 * 
		 * ArrayList<Valeur> v3 = new ArrayList<>(); v3.add(new Valeur(40, null, null) )
		 * ; v3.add(new Valeur(45, null, null) ) ;
		 * 
		 * 
		 * Node n3 = new Node(m, v3);
		 * 
		 * ArrayList<Valeur> v4 = new ArrayList<>(); v4.add(new Valeur(50, null, null) )
		 * ; v4.add(new Valeur(55, null, null) ) ; v4.add(new Valeur(60, null, null) ) ;
		 * 
		 * Node n4 = new Node(m, v4);
		 * 
		 * ArrayList<Valeur> v5 = new ArrayList<>(); v5.add(new Valeur(68, null, null) )
		 * ; v5.add(new Valeur(71, null, null) ) ; v5.add(new Valeur(74, null, null) ) ;
		 * 
		 * Node n5 = new Node(m, v5);
		 * 
		 * ArrayList<Valeur> v6 = new ArrayList<>(); v6.add(new Valeur(81, null, null) )
		 * ; v6.add(new Valeur(85, null, null) ) ; v6.add(new Valeur(90, null, null) ) ;
		 * 
		 * Node n6 = new Node(m, v6);
		 * 
		 * ArrayList<Valeur> v7 = new ArrayList<>(); v7.add(new Valeur(27, n1, null) ) ;
		 * v7.add(new Valeur(37, n2, n3) ) ;
		 * 
		 * 
		 * Node n7 = new Node(m, v7);
		 * 
		 * ArrayList<Valeur> v8 = new ArrayList<>(); v8.add(new Valeur(66, n4, null) ) ;
		 * v8.add(new Valeur(79, n5, n6) ) ;
		 * 
		 * 
		 * Node n8 = new Node(m, v8);
		 * 
		 * ArrayList<Valeur> v9 = new ArrayList<>(); v9.add(new Valeur(46, n7, n8) ) ;
		 * 
		 * 
		 * 
		 * Node n9 = new Node(m, v9);
		 * 
		 * Btree b = new Btree(4); b.root = n9 ; b.insert(36, b.root); b.insert(34, n9);
		 * System.out.println(b.searchNode(31, b.root));
		 * 
		 */
		Btree b = new Btree(m);

		/*
		 * ArrayList<Integer> test = new ArrayList<>(Arrays.asList(15, 30, 27, 35, 40,
		 * 45, 37, 20, 50, 55, 46, 71, 66, 74, 85, 90, 79, 78, 95, 25, 81, 68, 60, 65));
		 */
		ArrayList<Integer> test = new ArrayList<>(Arrays.asList(50, 55, 66, 68, 70, 71, 72, 73, 79, 81, 85, 90, 95));
		for (int i : test) {
			insert(i, b.root, null, true, null);
		}

		System.out.println("iti");
		System.out.println(b.root);
		// System.out.println(b.root.valeurs.get(0).filsG);
		// System.out.println(b.root.valeurs.get(0).filsD);
		// System.out.println(b.searchNode(67, b.root));

		System.out.println("fini");

	}

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

			else if (n.getMaxValeur().filsD != null && v.getValeur() == n.getMaxValeur().valeur) {
				return searchNode(i, n.getMaxValeur().filsD);

			}

		}

		return null;
	}

	public static void insert(int i, Node n, Node enfant, boolean islast, Valeur iValObject) {
		if (n.valeurs.size() == 0) {
			insertNotFull(n, i, iValObject);
		} else {

			Node node = searchNode(i, n);
			if (node != null) {
				if (enfant != null) {
					if (islast) {
						iValObject.filsG = n.getMaxValeur().filsD;
						n.getMaxValeur().filsD = null;
						iValObject.filsD = enfant;
					} else {
						iValObject.filsG = enfant;
					}
					insertNotFull(n, i, iValObject);
				}

				if (!node.isFull()) {
					if (iValObject == null) {
						insertNotFull(node, i, null);
					}

				}
				// else de if full
				else {

					int median = node.getMedian(i);
					// if (searchExist(median, node)) {

					insertNotFull(node, i, null);

					int indexMedian = Math.round(((float) node.m) / 2) - 1;
					Valeur medianValObject = getValObject(median, node);
					// if ce n'est pas une feuille
					if (node.pereNode != null) {

						Valeur maxValuePere = node.pereNode.getMaxValeur();

						if (maxValuePere.valeur > median) {
							Node n2 = new Node(node.pereNode, medianValObject, node.m,
									(ArrayList) node.valeurs.subList(0, indexMedian - 1));

							node.valeurs = (ArrayList) node.valeurs.subList(indexMedian + 1, node.valeurs.size() - 1);

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
						// fin if ce n'est pas une feuille
					} else {
						ArrayList<Valeur> valeursRoot = new ArrayList<>();

						//
						Node n2 = new Node(null, medianValObject, node.m, subliste(node.valeurs, 0, indexMedian - 1));

						node.valeurs = subliste(node.valeurs, indexMedian + 1, node.valeurs.size() - 1);

						if (!node.isLeaf()) {
							n2.getMaxValeur().filsD = medianValObject.filsG;

						}
						Node newRoot = new Node(null, null, node.m, null);
						n2.pere = medianValObject;
						node.pere = medianValObject;
						n2.pereNode = newRoot;
						node.pereNode = newRoot;
						medianValObject.filsG = n2;
						medianValObject.filsD = node;
						valeursRoot.add(medianValObject);

						newRoot.valeurs = valeursRoot;
						// System.out.println("here");
						// System.out.println(newRoot);
						root = newRoot;

					}
					// end is leaf

					// }

				}

			}
		}
	}

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
	}

	public static int getIndex(int val, Node node) {
		for (int i = 0; i < node.valeurs.size(); i++) {
			if (node.valeurs.get(i).valeur == val) {
				return i;
			}
		}
		return -1;
	}

	public static Valeur getValObject(int val, Node node) {
		for (int i = 0; i < node.valeurs.size(); i++) {
			if (node.valeurs.get(i).valeur == val) {
				return node.valeurs.get(i);
			}
		}
		return null;
	}

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

}
