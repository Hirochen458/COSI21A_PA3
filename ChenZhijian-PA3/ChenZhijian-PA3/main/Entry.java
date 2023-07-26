/**
 * Zhijian Chen
 * Chen5340@brandeis.edu
 * April 29th 2022
 * PA3
 * This class is used to create a way to store key value pairs with GraphNodes and its index of graph.
 * Known Bugs: null pointers/etc.
 */


package main;

public class Entry {
	public GraphNode node;
	public int value;
	//public Object key;
	
	public Entry(GraphNode node, int value) {
		this.node = node;
		this.value = value;
	}
	
	public void updateValue(int value) {
		//this.node = node;
		this.value = value;
	}

}
