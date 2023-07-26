package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GraphNode;
import main.MinPriorityQueue;

public class MinPriorityQueueTest {
	/*
	@Test
	public void insertTest() {
		MinPriorityQueue m = new MinPriorityQueue();
		assertTrue(m.isEmpty());
		GraphNode g1 = new GraphNode("c1dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g1.priority = 2;
		GraphNode g2 = new GraphNode("c2dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g2.priority = 7;
		GraphNode g3 = new GraphNode("c3dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g3.priority = 4;
		GraphNode g4 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g4.priority = 10;
		GraphNode g5 = new GraphNode("c5dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g5.priority = 8;
		GraphNode g6 = new GraphNode("c6dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g6.priority = 6;
		m.insert(g1);
		m.insert(g6);
		m.insert(g4);
		m.insert(g3);
		m.insert(g2);
		m.insert(g5);
		assertEquals(m.heap[1], g1);
		assertEquals(m.heap[2], g3);
		assertEquals(m.heap[3], g5);
		assertEquals(m.heap[4], g6);
		assertEquals(m.heap[5], g2);
		assertEquals(m.heap[6], g4);
	}
	
	@Test
	public void pullHighestPriorityElementTest() {
		MinPriorityQueue m = new MinPriorityQueue();
		GraphNode g1 = new GraphNode("c1dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g1.priority = 2;
		m.insert(g1);
		assertEquals(m.pullHighestPriorityElement(), g1);
		
		GraphNode g2 = new GraphNode("c2dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g2.priority = 7;
		GraphNode g3 = new GraphNode("c3dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g3.priority = 4;
		GraphNode g4 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g4.priority = 10;
		GraphNode g5 = new GraphNode("c5dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g5.priority = 8;
		GraphNode g6 = new GraphNode("c6dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g6.priority = 6;
		m.insert(g1);
		m.insert(g6);
		m.insert(g4);
		m.insert(g3);
		m.insert(g2);
		m.insert(g5);
		assertEquals(m.pullHighestPriorityElement(), g1);
		assertEquals(m.pullHighestPriorityElement(), g3);
		assertEquals(m.pullHighestPriorityElement(), g6);
		assertEquals(m.pullHighestPriorityElement(), g2);
		assertEquals(m.pullHighestPriorityElement(), g5);
		assertEquals(m.pullHighestPriorityElement(), g4);
		assertTrue(m.isEmpty());
	}
	*/
	@Test
	public void heapifyTest() {
		
		MinPriorityQueue m = new MinPriorityQueue();/*
		GraphNode g1 = new GraphNode("c1dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g1.priority = 1;
		GraphNode g2 = new GraphNode("c2dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g2.priority = 4;
		GraphNode g3 = new GraphNode("c3dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g3.priority = 2;
		GraphNode g4 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g4.priority = 6;
		GraphNode g5 = new GraphNode("c5dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g5.priority = 5;
		GraphNode g6 = new GraphNode("c6dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g6.priority = 3;
		m.insert(g1);
		m.insert(g6);
		m.insert(g4);
		m.insert(g3);
		m.insert(g2);
		m.insert(g5);
		assertEquals(m.heap[1], g1);
		assertEquals(m.heap[2], g3);
		assertEquals(m.heap[3], g5);
		assertEquals(m.heap[4], g6);
		assertEquals(m.heap[5], g2);
		assertEquals(m.heap[6], g4);
		g1.priority = 8;
		m.heapify(g1);
		assertEquals(m.heap[1], g3);
		assertEquals(m.heap[2], g6);
		assertEquals(m.heap[3], g2);
		assertEquals(m.heap[4], g5);
		assertEquals(m.heap[5], g4);
		assertEquals(m.heap[6], g1);
		g4.priority = 1;
		m.heapify(g4);
		assertEquals(m.heap[1], g4);
		assertEquals(m.heap[2], g1);
		assertEquals(m.heap[3], g3);
		assertEquals(m.heap[4], g6);
		assertEquals(m.heap[5], g2);
		assertEquals(m.heap[6], g5);*/
		GraphNode g1 = new GraphNode("c1dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g1.priority = 1;
		GraphNode g2 = new GraphNode("c2dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g2.priority = 4;
		GraphNode g3 = new GraphNode("c3dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g3.priority = 2;
		GraphNode g4 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		g4.priority = 6;
		m.insert(g1);
		m.printHeap();
		m.insert(g2);
		m.printHeap();
		m.insert(g3);
		m.printHeap();
		m.insert(g4);
		m.printHeap();
		
		assertEquals(m.heap[1], g1);
		assertEquals(m.heap[2], g2);
		assertEquals(m.heap[3], g3);
		assertEquals(m.heap[4], g4);
		g1.priority = 8;
		m.heapify(g1);
		assertEquals(m.heap[1], g3);
		assertEquals(m.heap[2], g2);
		assertEquals(m.heap[3], g4);
		assertEquals(m.heap[4], g1);
	}

}

