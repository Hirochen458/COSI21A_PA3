/**
 * Zhijian Chen
 * Chen5340@brandeis.edu
 * April 29th 2022
 * PA3
 * This class is used to able to add items with certain priorities and able to extract them with lowest priorities in O(1) times.
 * Known Bugs: null pointers/etc.
 */


package main;

public class MinPriorityQueue {
	public GraphNode[] heap = new GraphNode[10];
	public int numberOfNode = 1;
	public HashMap hashMap = new HashMap();
	
	
	/**
	 * This method is used to insert node g into the queue with priority
	 * @param g the node g that used to be inserted
	 */
	public void insert(GraphNode g) {
		if(numberOfNode >= heap.length) {
			GraphNode[] tmp = new GraphNode[heap.length*2];
			for(int i = 1; i < heap.length; i++) {
				tmp[i] = heap[i];
			}
			heap = tmp;
		}
		heap[numberOfNode] = g;
		hashMap.set(g, numberOfNode);
		//numberOfNode ++;
		//System.out.println(numberOfNode +"   34");
		heapifyUp(numberOfNode);
		//heapify(g);
		//System.out.println(numberOfNode +"   37");
		numberOfNode ++;
		
		
	}
	
	
	/**
	 * This method is used to remove the node highest priority and return that node
	 * @return return the node with highest priority.
	 */
	public GraphNode pullHighestPriorityElement() {
		GraphNode min = heap[1];
		heap[1] = heap[numberOfNode - 1];
		hashMap.set(min, -1);
		numberOfNode --;
		heapifyDown(1);
		//heapify(heap[1]);
		return min;
	}
	
	
	/**
	 * This method is used to move the node up until reach the position it should be
	 * @param i the position the node that need to move
	 */
	public void heapifyUp(int i) {
		//System.out.println(i +"   64");
		while(i > 1 && heap[i].priority < heap[parent(i)].priority) {
			//System.out.println(numberOfNode +"   64");
			GraphNode tmp = heap[i];
			
			heap[i] = heap[parent(i)];
			//System.out.println(i +"   72   " + heap[parent(i)].getId());
			hashMap.set(heap[parent(i)], i);
			//System.out.println(numberOfNode +"   72");
			heap[parent(i)] = tmp;
			hashMap.set(tmp, parent(i));
			//System.out.println(numberOfNode +"   71");
			i = parent(i);
		}
	}
	
	
	/**
	 * This method is used to move the node down until reach the position it should be
	 * @param i the position of the node that need to move
	 */
	public void heapifyDown(int i) {
		int left = i*2;
		int right = i*2 + 1;
		int smallest = i;
		if(left <= numberOfNode - 1 && heap[left].priority < heap[i].priority) {
			smallest = left;
			//System.out.println("left " + smallest);
			
		}else {
			smallest = i;
			
		}
		if(right <= numberOfNode - 1 && heap[right].priority < heap[smallest].priority) {
			smallest = right;
			System.out.println("right " + smallest);
			
		}
		if(smallest != i) {
			GraphNode tmp = heap[i];
			heap[i] = heap[smallest];
			hashMap.set(heap[smallest], i);
			heap[smallest] = tmp;
			hashMap.set(tmp, smallest);
			heapifyDown(smallest);
			
		}
	}
	
	
	/**
	 * This method calls the heapify method described below
	 * @param the node that used to rebalance
	 */
	public void reBalance(GraphNode g) {
		heapify(g);
	}
	
	
	/**
	 * This method is used to restore the heap-like property of the priority queue at g.
	 * @param the node that used op heapify
	 */
	public void heapify(GraphNode g) {
		int i = hashMap.getValue(g);
		int parent = parent(i);
		int left = i*2;
		int right = i*2 + 1;
		//System.out.println(g.priority);
		//System.out.println(heap[left].priority);
		//System.out.println(heap[right].priority);
		//System.out.println(left +"   116");
		//System.out.println(i + "     117");
		if(heap[parent]!= null && g.priority < heap[parent].priority) {
			//System.out.println("133");
			heapifyUp(i);
		}else if((heap[left] != null && g.priority > heap[left].priority) || (heap[right] != null &&  g.priority > heap[right].priority)) {
			//System.out.println("135");
			heapifyDown(i);
		}
		
	}
	
	
	public boolean isEmpty() {
		if(numberOfNode == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * This method is used to get the parent priority of a given node priority.
	 * @param i the given node priority, usually is the last priority
	 * @return return the parent node's priority.
	 */
	public int parent(int i) {
		if(i%2 == 0) {
			return i/2;
		}else {
			return (i-1)/2;
		}
	}
	
	public void printHeap() {
		for(int i = 1; i< heap.length; i++) {
			if(heap[i] != null) {
				System.out.println(heap[i].getId());
			}
			
		}
		System.out.println();
	}
}
