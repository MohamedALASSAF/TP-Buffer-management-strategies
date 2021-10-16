package tp1;

import java.util.*;

public class BufferManager {
	
	private  LinkedList<Integer> buffer ;
	private int nbFrame  ;
	
	public BufferManager(int nbFrame) {
		this.nbFrame = nbFrame ;
		this.buffer = new LinkedList<Integer>();
	}
	
	public static void main(String args[]) {
		
		BufferManager b = new BufferManager(3) ;
		List<Integer> tab = Arrays.asList(1,2,3,4,2,5,2,4);
		//List<Integer> tab = Arrays.asList(1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6);
		System.out.println(b.clock(tab));
		
	}
	
	public int clock (List<Integer> tab) {
		LinkedList<Integer> flags = new LinkedList<Integer>() ;
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
					else {
						
						flags.set(pointeur, 0);
					}
					
					
				}
			}
			
			else {
				int index = buffer.indexOf( tab.get(i) ) ;
				flags.set(index, 1);
			}
			
		}
		
		
		
		return pageMiss ;
	}
	
	public int LRU (List<Integer> tab) {
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
	
	
	
	public  int FIFO (List<Integer> tab) {
		
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
