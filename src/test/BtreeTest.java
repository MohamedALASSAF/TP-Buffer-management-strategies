   
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp2.Btree;
import tp2.Node;
import tp2.Valeur;

class BtreeTest {

	@Test
	void insertTest1() {

		Btree b = new Btree(5);

		ArrayList<Integer> test = new ArrayList<>(Arrays.asList(10, 15, 30, 27, 35, 40, 10, 45, 37, 20, 50, 55, 46, 71,
				66, 74, 85, 90, 79, 78, 95, 25, 81, 68, 60, 65));
		for (int i : test) {
			Btree.insert(i, Btree.root,null,true,null);
		}

		LinkedList<Valeur> node1Values = new LinkedList<>();
		node1Values.add(new Valeur(10, null, null));
		node1Values.add(new Valeur(15, null, null));
		node1Values.add(new Valeur(20, null, null));
		node1Values.add(new Valeur(25, null, null));

		LinkedList<Valeur> node2Values = new LinkedList<>();
		node2Values.add(new Valeur(30, null, null));
		node2Values.add(new Valeur(35, null, null));

		LinkedList<Valeur> node3Values = new LinkedList<>();
		node3Values.add(new Valeur(40, null, null));
		node3Values.add(new Valeur(45, null, null));

		LinkedList<Valeur> node4Values = new LinkedList<>();
		node4Values.add(new Valeur(50, null, null));
		node4Values.add(new Valeur(55, null, null));
		node4Values.add(new Valeur(60, null, null));
		node4Values.add(new Valeur(65, null, null));

		LinkedList<Valeur> node5Values = new LinkedList<>();
		node5Values.add(new Valeur(68, null, null));
		node5Values.add(new Valeur(71, null, null));
		node5Values.add(new Valeur(74, null, null));
		node5Values.add(new Valeur(78, null, null));

		LinkedList<Valeur> node6Values = new LinkedList<>();
		node6Values.add(new Valeur(81, null, null));
		node6Values.add(new Valeur(85, null, null));
		node6Values.add(new Valeur(90, null, null));
		node6Values.add(new Valeur(95, null, null));

		LinkedList<Valeur> node7Values = new LinkedList<>();
		node7Values.add(new Valeur(27, null, null));
		node7Values.add(new Valeur(37, null, null));

		LinkedList<Valeur> node8Values = new LinkedList<>();
		node8Values.add(new Valeur(66, null, null));
		node8Values.add(new Valeur(79, null, null));

		LinkedList<Valeur> rootValues = new LinkedList<>();
		rootValues.add(new Valeur(46, null, null));

		Assert.assertEquals(node1Values,
				Btree.root.getValeurs().get(0).getFilsG().getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node2Values,
				Btree.root.getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsG().getValeurs());
		Assert.assertEquals(node3Values,
				Btree.root.getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsD().getValeurs());
		Assert.assertEquals(node4Values,
				Btree.root.getValeurs().get(0).getFilsD().getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node5Values,
				Btree.root.getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsG().getValeurs());
		Assert.assertEquals(node6Values,
				Btree.root.getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsD().getValeurs());

		Assert.assertEquals(node7Values,Btree.root.getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node8Values, Btree.root.getValeurs().get(0).getFilsD().getValeurs());

		Assert.assertEquals(rootValues, Btree.root.getValeurs()); // check root
	}
	
	
	@Test
	void insertTest2() {

		Btree b = new Btree(5);
		
		ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(50, 55, 66, 68, 70, 71, 72, 73, 79, 81, 85, 90, 95));
		for (int i : test1) {
			Btree.insert(i, Btree.root,null,true,null);
		}

		LinkedList<Valeur> node1Values = new LinkedList<>();
		node1Values.add(new Valeur(50, null, null));
		node1Values.add(new Valeur(55, null, null));


		LinkedList<Valeur> node2Values = new LinkedList<>();
		node2Values.add(new Valeur(68, null, null));
		node2Values.add(new Valeur(70, null, null));

		LinkedList<Valeur> node3Values = new LinkedList<>();
		node3Values.add(new Valeur(72, null, null));
		node3Values.add(new Valeur(73, null, null));

		LinkedList<Valeur> node4Values = new LinkedList<>();
		node4Values.add(new Valeur(81, null, null));
		node4Values.add(new Valeur(85, null, null));
		node4Values.add(new Valeur(90, null, null));
		node4Values.add(new Valeur(95, null, null));

		LinkedList<Valeur> rootValues = new LinkedList<>();
		rootValues.add(new Valeur(66, null, null));
		rootValues.add(new Valeur(71, null, null));
		rootValues.add(new Valeur(79, null, null));

		Assert.assertEquals(node1Values,
				Btree.root.getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node2Values,
				Btree.root.getValeurs().get(1).getFilsG().getValeurs());
		Assert.assertEquals(node3Values,
				Btree.root.getValeurs().get(2).getFilsG().getValeurs());
		Assert.assertEquals(node4Values,
				Btree.root.getValeurs().get(2).getFilsD().getValeurs());


		Assert.assertEquals(rootValues, Btree.root.getValeurs()); // check root
	}

}
