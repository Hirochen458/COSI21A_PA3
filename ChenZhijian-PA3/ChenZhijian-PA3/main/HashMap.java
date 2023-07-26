/**
 * Zhijian Chen
 * Chen5340@brandeis.edu
 * April 29th 2022
 * PA3
 * This class is used to mapping graph nodes to their index in heap array so we can easily index and find the nodes.
 * Known Bugs: null pointers/etc.
 */


package main;

public class HashMap {
	public int size;
	public int capacity = 10;
	public Entry[] hashTable = new Entry[capacity];
	//public Entry entry;
	
	public int hash(String ID, int i) {
		int total = 0;
		for(int k = 0; k < ID.length(); k++) {
			total += (int)ID.charAt(k);
		}
		int key = (total%hashTable.length) + i;
		return key;
	}
	
	
	/**
	 * This method is used to check the hashmap to see if there is an entry for the GraphNode "key", if there is, change its value to "value", 
	 * otherwise, add it to the hashmap with that value.
	 * @param key the key is the node that used to check or inserted
	 * @param value value is the correspond value with node that used to check or inserted
	 */
	public void set(GraphNode key, int value) {
		int i = 0;
		boolean finished = false;
		boolean added = false;
		
		//System.out.println(i +"   40");
		//loop search from the hash value position
		while(finished == false) {
			int number = hash(key.getId(), i); 
			if(number + i < capacity) {
				if(hashTable[number+i] == null /*|| hashTable[number+i].value == -1*/) {
					hashTable[number+i] = new Entry(key, value);
					finished = true;
					added = true;
					size++;
					
				}else if(hashTable[number+i].node == key){
					hashTable[number+i].updateValue(value);
					finished = true;
					added = true;
					
				}else {
					i++;
				}
			}
			if(number+i >= capacity - 1) {
				finished = true;
			}
			
			
		}
		//loop search from the head of array
		
		if(added == false) {
			//i = 0;
			int number = hash(key.getId(), i);
			for(int k = 0; k < number; k++) {
				if(hashTable[k] == null) {
					hashTable[k] = new Entry(key, value);
					added = true;
					size++;
					k = number;
					
				}else if(hashTable[k].node == key){
					hashTable[number+i].updateValue(value);
					added = true;
					
				}else {
					i++;
				}
			}
		}
		/*
		while(added == false) {
			i = 0;
			//int k = 0;
			int number = hash(key.getId(), i);
			if(hashTable[i] == null) {
				hashTable[i] = new Entry(key, value);
				added = true;
				size++;
				
			}else if(hashTable[i].node == key){
				hashTable[i].updateValue(value);
				
			}else {
				i++;
			}
		}*/
		
		if(size >= capacity/2) {
				//rehash();
			Entry[] tmp = this.hashTable;
			this.capacity = this.capacity + this.capacity;
			this.hashTable = new Entry[this.capacity];
			this.size = 0;
			for(int r = 0; r < tmp.length; r++) {
				if(tmp[r]!=null) {
					this.set(tmp[r].node, tmp[r].value);
				}
			}
		}
		
	}
	
	
	/**
	 * This method is used to gets the value for the entry with g as the key
	 * @param g the given node g used to search
	 * @return return the value of found node or -1 is not found
	 */
	public int getValue(GraphNode g) {
		boolean finished = false;
		//boolean found = false;
		int i = 0;
		while(finished == false) {
			int number = hash(g.getId(), i); 
			if(number + i < capacity) {
				if(hashTable[number+i] == null) {
					return -1;
				}else if(hashTable[number+i].node == g){
					return hashTable[number+i].value;
				}else {
					i++;
				}
			}
			if(number+i == capacity - 1) {
				finished = true;
			}
			
			
		}
		i = 0;
		int number = hash(g.getId(), i);
		for(int k = 0; k < number; k++) {
			if(hashTable[k] == null) {
				return -1;
			}else if(hashTable[k].node == g) {
				return hashTable[k].value;
			}
		}
		return -1;
		
	}
	
	
	/**
	 * This method is used to check if the hashmap has that key.
	 * @param g the node that is used to be check
	 * @return return true if contains the key of node, false if not.
	 */
	public boolean hasKey(GraphNode g) {
		boolean finished = false;
		//boolean found = false;
		int i = 0;
		while(finished == false) {
			int number = hash(g.getId(), i); 
			if(number + i < capacity) {
				if(hashTable[number+i] == null) {
					return false;
				}else if(hashTable[number+i].node == g){
					return true;
				}else {
					i++;
				}
			}
			if(number+i == capacity - 1) {
				finished = true;
			}
			
			
		}
		i = 0;
		int number = hash(g.getId(), i);
		for(int k = 0; k < number; k++) {
			if(hashTable[k] == null) {
				return false;
			}else if(hashTable[k].node == g) {
				return true;
			}
		}
		return false;
	}

}
