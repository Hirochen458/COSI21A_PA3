package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GraphNode;
//import main.HashMap;
import main.Entry;

public class EntryTest {
	
	@Test
	public void entryTest() {
		
		GraphNode g1 = new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false);
		Entry e = new Entry(g1, 0);
		assertEquals(e.node, g1);
		assertEquals(e.value, 0);
		GraphNode g2 = new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false);
		Entry e1 = new Entry(g2, 1);
		assertEquals(e1.node, g2);
		assertEquals(e1.value, 1);
		
		e.updateValue(10);
		assertEquals(e.value, 10);
		
		e1.updateValue(100);
		assertEquals(e1.value, 100);
		
	}
	
}
