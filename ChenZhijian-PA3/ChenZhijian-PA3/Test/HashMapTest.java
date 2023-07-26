package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GraphNode;
import main.HashMap;

public class HashMapTest {
	
	
	@Test
	public void HashTest(){
		HashMap h = new HashMap();
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		GraphNode g2 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
		GraphNode g3 = new GraphNode("0fd76b04-1df7-4838-b854-e270f42a5dd6", false);
		GraphNode g4 = new GraphNode("d76ed44b-6c4f-40db-a605-a19210f64f7d", false);
		GraphNode g5 = new GraphNode("fedf90fe-7e00-4155-93d6-b3d2e612f737", false);
		GraphNode g6 = new GraphNode("E", false);
		
		int a = h.hash(g1.getId(), 0);
		assertEquals(a, 0);
		
		int b = h.hash(g2.getId(), 0);
		assertEquals(b, 6);
		
		int c = h.hash(g3.getId(), 0);
		assertEquals(c, 9);
		
		int d = h.hash(g4.getId(), 0);
		assertEquals(d, 4);
		
		int e = h.hash(g5.getId(), 0);
		assertEquals(e, 0);
		
		int f = h.hash(g6.getId(), 0);
		assertEquals(f, 9);
		
	}
	@Test
	public void Settest() {
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		HashMap h = new HashMap();
		int j = h.hash(g1.getId(), 0);
		h.set(g1, 0);
		assertEquals(j, 0);
		assertEquals(h.hashTable[0].node.getId(), "c4dbe07b-f0b5-4b8a-bf11-28780d609a91");
		assertEquals(h.hashTable[0].value, 0);
		
		GraphNode g2 = new GraphNode("0fd76b04-1df7-4838-b854-e270f42a5dd6", false);
		h.set(g2, 1);
		assertEquals(h.hashTable[9].node.getId(), "0fd76b04-1df7-4838-b854-e270f42a5dd6");
		assertEquals(h.hashTable[9].value, 1);
		
		GraphNode g3 = new GraphNode("fedf90fe-7e00-4155-93d6-b3d2e612f737", false);
		h.set(g3, 2);
		assertEquals(h.hashTable[2].node.getId(), "fedf90fe-7e00-4155-93d6-b3d2e612f737");
		assertEquals(h.hashTable[2].value, 2);
		
		GraphNode g4 = new GraphNode("c", false);
		h.set(g4, 3);
		assertEquals(h.hashTable[1].node.getId(), "c");
		assertEquals(h.hashTable[1].value, 3);
		
	}
	
	@Test
	public void getValuetest() {
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		HashMap h = new HashMap();
		//int j = h.hash(g1.getId(), 0);
		h.set(g1, 0);
		assertEquals(h.getValue(g1), 0);
		GraphNode g2 = new GraphNode("0fd76b04-1df7-4838-b854-e270f42a5dd6", false);
		h.set(g2, 1);
		assertEquals(h.getValue(g2), 1);
		GraphNode g3 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
		assertEquals(h.getValue(g3), -1);
		
	}
	
	@Test
	public void hasKeytest() {
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		HashMap h = new HashMap();
		//int j = h.hash(g1.getId(), 0);
		h.set(g1, 0);
		assertTrue(h.hasKey(g1));
		GraphNode g2 = new GraphNode("0fd76b04-1df7-4838-b854-e270f42a5dd61", false);
		h.set(g2, 1);
		assertTrue(h.hasKey(g2));
		GraphNode g3 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
		assertFalse(h.hasKey(g3));
	}
	
	@Test
	public void reHashTest() {
		HashMap h = new HashMap();
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		h.set(g1, 0);
		GraphNode g2 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
		h.set(g2, 0);
		GraphNode g3 = new GraphNode("0fd76b04-1df7-4838-b854-e270f42a5dd6", false);
		h.set(g3, 0);
		GraphNode g4 = new GraphNode("d76ed44b-6c4f-40db-a605-a19210f64f7d", false);
		h.set(g4, 0);
		GraphNode g5 = new GraphNode("fedf90fe-7e00-4155-93d6-b3d2e612f737", false);
		h.set(g5, 0);
		
		assertEquals(h.capacity, 20);
		
		GraphNode g6 = new GraphNode("794a689b-5cba-4c24-8a08-8abee1d17eb", false);
		h.set(g6, 0);
		GraphNode g7 = new GraphNode("1143c9aa-e3d5-4158-809a-c455d0984c0a", false);
		h.set(g7, 0);
		GraphNode g8 = new GraphNode("fe30169b-655f-430e-a437-2b4892e7abfd", false);
		h.set(g8, 0);
		GraphNode g9 = new GraphNode("c9be1adf-8b15-4d0c-966e-4c9234b6ea96", false);
		h.set(g9, 0);
		GraphNode g10 = new GraphNode("b3623310-deca-4fbe-b11d-735a170468e6", false);
		h.set(g10, 0);
		
		assertEquals(h.capacity, 40);
		
	}

}
