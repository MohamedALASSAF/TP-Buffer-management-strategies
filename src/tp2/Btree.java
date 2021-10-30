package tp2;


import java.util.LinkedList;

public class Btree {
	
	private Node root ;
	private static int m = 5 ;
	
	public Btree (  ) {
		this.root = new Node(m) ;
	}
	
	public static void main(String[] args) {
		int m = 5  ;
		
		/*
		//Node n1 = new Node(null,m,null ) ;
		ArrayList<Valeur> v1 = new ArrayList<>();
		v1.add(new Valeur(10, null, null) ) ;
		v1.add(new Valeur(15, null, null) ) ;
		v1.add(new Valeur(20, null, null) ) ;
		
		Node n1 = new Node(m, v1);
		
		ArrayList<Valeur> v2 = new ArrayList<>();
		v2.add(new Valeur(30, null, null) ) ;
		v2.add(new Valeur(35, null, null) ) ;
		
		Node n2 = new Node(m, v2);
		
		ArrayList<Valeur> v3 = new ArrayList<>();
		v3.add(new Valeur(40, null, null) ) ;
		v3.add(new Valeur(45, null, null) ) ;

		
		Node n3 = new Node(m, v3);
		
		ArrayList<Valeur> v4 = new ArrayList<>();
		v4.add(new Valeur(50, null, null) ) ;
		v4.add(new Valeur(55, null, null) ) ;
		v4.add(new Valeur(60, null, null) ) ;
		
		Node n4 = new Node(m, v4);
		
		ArrayList<Valeur> v5 = new ArrayList<>();
		v5.add(new Valeur(68, null, null) ) ;
		v5.add(new Valeur(71, null, null) ) ;
		v5.add(new Valeur(74, null, null) ) ;
		
		Node n5 = new Node(m, v5);
		
		ArrayList<Valeur> v6 = new ArrayList<>();
		v6.add(new Valeur(81, null, null) ) ;
		v6.add(new Valeur(85, null, null) ) ;
		v6.add(new Valeur(90, null, null) ) ;
		
		Node n6 = new Node(m, v6);
		
		ArrayList<Valeur> v7 = new ArrayList<>();
		v7.add(new Valeur(27, n1, null) ) ;
		v7.add(new Valeur(37, n2, n3) ) ;

		
		Node n7 = new Node(m, v7);
		
		ArrayList<Valeur> v8 = new ArrayList<>();
		v8.add(new Valeur(66, n4, null) ) ;
		v8.add(new Valeur(79, n5, n6) ) ;
		
		
		Node n8 = new Node(m, v8);
		
		ArrayList<Valeur> v9 = new ArrayList<>();
		v9.add(new Valeur(46, n7, n8) ) ;
		
		
		
		Node n9 = new Node(m, v9);
		
		Btree b = new Btree(4);
		b.root = n9 ;
		b.insert(36, b.root);
		b.insert(34, n9);
		System.out.println(b.searchNode(31, b.root));
		
		*/
		Btree b = new Btree() ;
		b.root.setRoot(true);
		b.insert(10, b.root);
		b.insert(15, b.root);
		b.insert(30, b.root);
		b.insert(27, b.root);
		b.insert(35, b.root);
		b.insert(40, b.root);
		b.insert(45, b.root);
		b.insert(37, b.root);
		b.insert(20, b.root);
		b.insert(50, b.root);
		b.insert(55, b.root);
		b.insert(46, b.root);
		b.insert(71, b.root);
		b.insert(66, b.root);
		b.insert(74, b.root);
		b.insert(85, b.root);
		b.insert(90, b.root);
		b.insert(79, b.root);
		b.insert(78, b.root);
		b.insert(95, b.root);
		b.insert(25, b.root);
		b.insert(81, b.root);
		b.insert(68, b.root);
		b.insert(60, b.root);
		b.insert(65, b.root);

		System.out.println(b.root);


		System.out.println(b.root.getValeurs().get(0).getFilsG());
		System.out.println(b.root.getValeurs().get(0).getFilsD());
		
		System.out.println(b.root.getValeurs().get(0).getFilsG().getValeurs().get(0).getFilsG());
		System.out.println(b.root.getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsG());
		System.out.println(b.root.getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsD()); //probleme
		
		System.out.println(b.root.getValeurs().get(0).getFilsD().getValeurs().get(0).getFilsG());
		System.out.println(b.root.getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsG());
		System.out.println(b.root.getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsD()); //probleme
		

		
		
	}
	
	
	public boolean searchExist(int i, Node n) {
		
		boolean b = false ;
		
		for(Valeur v : n.getValeurs() ) {
			
			if (i == v.getValeur()) {
				b = true ;
				break ;
				
			}
			else if(v.getValeur() > i && v.getFilsG() != null) {
				b = searchExist(i, v.getFilsG());
				break;
			}
			
			else if(n.getMaxValeur().getFilsD() != null && v.getValeur() == n.getMaxValeur().getValeur()) {
				b = searchExist(i,n.getMaxValeur().getFilsD());
				break ;
			}
			
		}

		return b ;
	}

	
	public Node searchNode(int i, Node n) {
		
		if(n.getValeurs().isEmpty()) {
			return n ;
		}
		
		for(Valeur v : n.getValeurs() ) {

			 if (i == v.getValeur()) {
				return null ;

			}
			 
			 else if ( v.getValeur() == n.getMaxValeur().getValeur() && n.getMaxValeur().getFilsD() == null && n.getMaxValeur().getFilsG() == null ) {
				 return n ;
				}
			 
			else if(v.getValeur() > i && v.getFilsG() != null) {
				return  searchNode(i, v.getFilsG());
				
			}
			
			else if(n.getMaxValeur().getFilsD() != null && v.getValeur() == n.getMaxValeur().getValeur()) {
				return  searchNode(i,n.getMaxValeur().getFilsD());
				
			}
			

			
		}

		return null ;
	}

	
	
	public void insert(int i, Node n) {
		Valeur newV = new Valeur(i, null,null) ;
		Node node = searchNode(i, n) ;
		
		if(node != null && !searchExist(i,n)) {
			insertLeaf(node, newV);
				
		}	
	}
	
	private void insertNotLeaf(Valeur pere, Valeur median, Node nodePere) {
		
		
		if(! nodePere.isFull()) {
			
			insertNotFull(nodePere.getValeurs(), median);
		}
		else {
			
			if(nodePere.isRoot()) {
				Node newRoot =  new Node(m) ;
				newRoot.setRoot(true);
				Valeur nMedian = split(median, nodePere.getValeurs(),null , newRoot) ;
				newRoot.getValeurs().add(nMedian);
				this.root = newRoot ;
			}
			else {
				Valeur nMedian = split(median, nodePere.getValeurs(), pere, nodePere) ;
				insertNotLeaf(nodePere.getPere(),nMedian, nodePere.getNodePere());
			}
			
		}
		
	}

	public void insertLeaf(Node n, Valeur newV) {
		
		if(!n.isFull()) {

			insertNotFull(n.getValeurs(), newV);
		}
		else {
			if(n.isRoot()) {
				Node newRoot =  new Node(m) ;
				newRoot.setRoot(true);
				Valeur median = split(newV, n.getValeurs(),null , newRoot) ;
				newRoot.getValeurs().add(median);
				this.root = newRoot ;
				
			}
			else {
				Valeur median = split(newV, n.getValeurs(), n.getPere(), n.getNodePere()) ;
				
				insertNotLeaf(n.getPere(),median, n.getNodePere());
			}
			
		}
	}
	
	public static Valeur split (Valeur v , LinkedList<Valeur> valeurs, Valeur pere, Node nodePere) {
		ajout(v, valeurs);
		
		Valeur median = popMedian(valeurs) ;
		try {
		if(median.getFilsG() != null ) {
			
			int i = Math.round(((float)m)/2) -2 ;
			Object cloneFilsG = median.getFilsG().clone() ;
			
			if(cloneFilsG instanceof Node) {
				valeurs.get(i).setFilsD((Node) cloneFilsG); 
			}
		}
		}
		catch(CloneNotSupportedException e) {
			System.err.println(e);
		}
		
		if(pere == null) {
			
			median.setFilsG(new Node(median,m, new LinkedList<Valeur>( valeurs.subList(0, valeurs.size()/2)),nodePere ) );
			median.setFilsD(new Node(median,m, new LinkedList<Valeur>(valeurs.subList(valeurs.size()/2, valeurs.size())), nodePere));
		}
		
		else if(median.getValeur() < pere.getValeur() ) {
			median.setFilsG(new Node(median,m, new LinkedList<Valeur>(valeurs.subList(0, valeurs.size()/2)), nodePere ));
			valeurs = new LinkedList<Valeur> (valeurs.subList(valeurs.size()/2, valeurs.size())) ;
		}
		else {

			pere.setFilsD(null);
			median.setFilsG(new Node(median,m, new LinkedList<Valeur>( valeurs.subList(0, valeurs.size()/2)),nodePere ) );
			median.setFilsD(new Node(median,m, new LinkedList<Valeur>(valeurs.subList(valeurs.size()/2, valeurs.size())), nodePere));
		}
		
		return median ;
			
	}
	


	public static void ajout (Valeur v , LinkedList<Valeur> valeurs) {
		if(v.getValeur()> valeurs.getLast().getValeur()) {
			valeurs.add(valeurs.indexOf(valeurs.getLast())+1, v);
		}
		else {
			for(Valeur va : valeurs) {
				if(v.getValeur() < va.getValeur()) {
					valeurs.add(valeurs.indexOf(va), v);
					break;
				}
			}
		}
	}
	
	public static Valeur popMedian(LinkedList<Valeur> valeurs) {
		int millieu = Math.round(((float)m)/2) ;
			
		return valeurs.remove(valeurs.indexOf(valeurs.get (millieu-1))) ; 
		
	}
	
	public static void insertNotFull (LinkedList<Valeur> valeurs , Valeur newV) {
		if(valeurs.size() == 0) {
			valeurs.add(newV);
		}
		else {
			for (Valeur v : valeurs) {
				if(v.getValeur() > newV.getValeur() ) {
					
					int index = valeurs.indexOf(v) ;
					valeurs.add(index, newV);
					break ;
				}
				else if (v.getValeur() == valeurs.getLast().getValeur()) {
					valeurs.add( newV);
					break ;
				}
			}
		}

		
	}
}
