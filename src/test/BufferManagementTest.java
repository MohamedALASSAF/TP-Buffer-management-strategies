package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp1.BufferManager;

class BufferManagementTest {

	@Test
	void clockTest() {
		/*
		 * Buffer Management: Exercises Exercise 1
		 * 
		 * BufferManager b = new BufferManager(3) ; List<Integer> tab =
		 * Arrays.asList(1,2,3,4,2,5,2,4);
		 * 
		 * Assert.assertEquals(b.clock(tab),5);
		 */

		BufferManager b = new BufferManager(4);
		List<Integer> tab = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		List<Integer> tab2 = Arrays.asList(1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6);

		Assert.assertEquals(10, b.clock(tab));
		Assert.assertEquals(12, b.clock(tab2));

	}

	@Test
	void fifoTest() {
		/*
		 * Buffer Management: Exercises Exercise 2 BufferManager b = new
		 * BufferManager(4) ; List<Integer> tab =
		 * Arrays.asList(1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6);
		 * 
		 * Assert.assertEquals(b.fifo(tab),14);
		 */

		BufferManager b = new BufferManager(4);
		List<Integer> tab = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		List<Integer> tab2 = Arrays.asList(1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6);

		Assert.assertEquals(10, b.fifo(tab));
		Assert.assertEquals(14, b.fifo(tab2));

	}

	@Test
	void lruTest() {
		/*
		 * Buffer Management: Exercises Exercise 2 BufferManager b = new
		 * BufferManager(4) ; List<Integer> tab =
		 * Arrays.asList(1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6);
		 * 
		 * Assert.assertEquals(b.lru(tab),10);
		 */

		BufferManager b = new BufferManager(4);
		List<Integer> tab = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		List<Integer> tab2 = Arrays.asList(1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6);

		Assert.assertEquals(10, b.lru(tab));
		Assert.assertEquals(10, b.lru(tab2));

	}

}
