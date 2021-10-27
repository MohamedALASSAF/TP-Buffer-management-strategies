package tp1;

import java.util.*;

public class BufferManager {
	
	/*
	 * Pour representer la structure du buffer,
	 * nous avons choisi une liste chainée car elle permet de faire les opérations pop() et add() 
	 * qui permettent respectivement de supprimer automatiquement un element en fin de liste
	 *  et d'ajouter automatiquement un element en début de list.
	 * Ces opérations sont très utile pour les fonctions LRU et FIFO. 
	 * */
	private  LinkedList<Integer> buffer ;
	private int nbFrame  ;
	

	public BufferManager(int nbFrame) {
		this.nbFrame = nbFrame ;
		this.buffer = new LinkedList<>();
	}
	
	public static void main(String args[]) {
		
		BufferManager b = new BufferManager(4) ;
		//List<Integer> tab = Arrays.asList(1,2,3,4,2,5,2,4);
		//List<Integer> tab = Arrays.asList(1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6);
		List<Integer> tab = Arrays.asList(0, 4 ,1, 4, 2, 4, 3, 4, 2, 4, 0, 4 ,1, 4, 2, 4, 3, 4);
		//List<Integer> tab = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
		//List<Integer> tab = Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2);
		System.out.println("FIFO page misses : "+b.fifo(tab));
		System.out.println("LRU page misses : "+b.lru(tab));
		System.out.println("Clock page misses : "+b.clock(tab));
		
	}
	
	
	/*Nous avons ici utilisé une autre liste chainée pour contenir les flags.
	 * Cette liste est modifiée en parallele du buffer. 
	 * */
	public int clock (List<Integer> tab) {
		this.buffer.clear();
		LinkedList<Integer> flags = new LinkedList<>() ;
		int pointeur = 0 ;
		int pageMiss = 0 ;
		int i ;
		
		for ( i = 0 ; i < nbFrame ; i++) {
			buffer.add(tab.get(i)) ;
			flags.add(1);
			pageMiss ++ ;
		}
		
		for(; i < tab.size(); i++) {
			
			if(! buffer.contains(tab.get(i))) {
				
				for(; pointeur < nbFrame +1 ; pointeur++) {
					pointeur = pointeur % nbFrame  ;
					
					if(flags.get(pointeur) == 0 ) {
						
						buffer.set(pointeur, tab.get(i));
						flags.set(pointeur, 1);
						pageMiss++ ;
						break ;
					}
					flags.set(pointeur, 0);
							
				}
			}
			else {
				int index = buffer.indexOf( tab.get(i) ) ;
				flags.set(index, 1);
			}
			
		}

		return pageMiss ;
	}
	
	public int lru (List<Integer> tab) {
		this.buffer.clear();
		int pageMiss = 0 ;
		int i ;
		
		for ( i = 0 ; i < nbFrame ; i++) {
			buffer.add(tab.get(i)) ;
			pageMiss ++ ;
		}
	
		for(; i < tab.size(); i++) {
			if(! buffer.contains(tab.get(i))) {
				pageMiss ++;
				buffer.pop();
				buffer.add(tab.get(i)) ;
			}
			else {
				buffer.remove((Integer) tab.get(i));
				buffer.add(tab.get(i)) ;
				
			}
			
		}
		
		return pageMiss ;
	}
	
	
	
	public  int fifo (List<Integer> tab) {
		this.buffer.clear();
		int pageMiss = 0 ;
		int i ;
		
		for ( i = 0 ; i < nbFrame ; i++) {
			buffer.add(tab.get(i)) ;
			pageMiss ++ ;
		}
	
		for(; i < tab.size(); i++) {
			if(! buffer.contains(tab.get(i))) {
				pageMiss ++;
				buffer.pop();
				buffer.add(tab.get(i)) ;
			}
			
		}
		
		return pageMiss ;
	}
	

}
