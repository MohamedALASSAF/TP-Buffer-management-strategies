package tp2;

import java.util.ArrayList;

public class Btree {
	
	Node root ;
	int m ;
	
	public Btree ( int m) {
		this.m = m ;
	}
	
	public static void main(String[] args) {
		int m = 5  ;
		
		
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
		
		System.out.println(b.search(79, n9));
		

	}
	
	public boolean search(int i, Node n) {
		
		boolean b = false ;
		
		for(Valeur v : n.valeurs ) {
			
			if (i == v.getValeur()) {
				b = true ;
				break ;
				
			}
			else if(v.getValeur() > i && v.filsG != null) {
				b = search(i, v.filsG);
				break;
			}
			
			else if(n.getMaxValeur().filsD != null && v.getValeur() == n.getMaxValeur().valeur) {
				b = search(i,n.getMaxValeur().filsD);
				break ;
			}
			
		}
		
		
		
		return b ;
	}


}
