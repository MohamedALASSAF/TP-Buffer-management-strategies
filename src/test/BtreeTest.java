package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp2.Btree;
import tp2.Node;
import tp2.Valeur;

class BtreeTest {

	@Test
	void insertTest() {

		Btree b = new Btree();
		b.getRoot().setRoot(true);
		b.insert(10, b.getRoot());
		b.insert(15, b.getRoot());
		b.insert(30, b.getRoot());
		b.insert(27, b.getRoot());
		b.insert(35, b.getRoot());
		b.insert(40, b.getRoot());
		b.insert(45, b.getRoot());
		b.insert(37, b.getRoot());
		b.insert(20, b.getRoot());
		b.insert(50, b.getRoot());
		b.insert(55, b.getRoot());
		b.insert(46, b.getRoot());
		b.insert(71, b.getRoot());
		b.insert(66, b.getRoot());
		b.insert(74, b.getRoot());
		b.insert(85, b.getRoot());
		b.insert(90, b.getRoot());
		b.insert(79, b.getRoot());
		b.insert(78, b.getRoot());
		b.insert(95, b.getRoot());
		b.insert(25, b.getRoot());
		b.insert(81, b.getRoot());
		b.insert(68, b.getRoot());
		b.insert(60, b.getRoot());
		b.insert(65, b.getRoot());

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
				b.getRoot().getValeurs().get(0).getFilsG().getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node2Values,
				b.getRoot().getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsG().getValeurs());
		Assert.assertEquals(node3Values,
				b.getRoot().getValeurs().get(0).getFilsG().getValeurs().get(1).getFilsD().getValeurs());
		Assert.assertEquals(node4Values,
				b.getRoot().getValeurs().get(0).getFilsD().getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node5Values,
				b.getRoot().getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsG().getValeurs());
		Assert.assertEquals(node6Values,
				b.getRoot().getValeurs().get(0).getFilsD().getValeurs().get(1).getFilsD().getValeurs());

		Assert.assertEquals(node7Values, b.getRoot().getValeurs().get(0).getFilsG().getValeurs());
		Assert.assertEquals(node8Values, b.getRoot().getValeurs().get(0).getFilsD().getValeurs());

		Assert.assertEquals(rootValues, b.getRoot().getValeurs()); // check root
	}

}
