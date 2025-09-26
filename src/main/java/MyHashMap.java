import java.util.ArrayList;
import java.util.Iterator;

// a hash map implementation that stores key-value pairs
// Uses the key's hash code to determine which bucket to store values in.
public class MyHashMap<T> implements Iterable<T>{
	
	private ArrayList<GenericQueue<T>> map;
	private int size;
	
    // Constructor initializes the map with the first key-value pair.
	public MyHashMap(String key, T value) {
		map = new ArrayList<>(10);
		for(int i = 0; i < 10; i++) {
			map.add(null);
		}
		put(key,value);
	}
	
    // Adds a key-value pair to the map by creating a has code and hash value
	public void put(String key, T value) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;  // calculation for bucket index
		GenericQueue<T> bucket = map.get(index);
		// if bucket does not exist, create a new queue and add the corresponding fields to new element
		if(bucket == null) {
			bucket = new GenericQueue<>(value);
			bucket.getHead().code = hash;
			map.set(index, bucket);
			size++;
		} // if bucket already exists, add value 
		else { 
			bucket.add(value,hash);
			size++;
		}
	}
	
	// verifies if the given key exists in the hash map 
	// returns true if key exists, false otherwise
	// String key - key being checked for existence
	public boolean contains(String key) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		GenericQueue<T> bucket = map.get(index);
		// return false if bucket does not exist
		if(bucket == null) {
			return false;
		}
		// if bucket exists, iterate through the queue until given key is found
		GenericList.Node<T> curr = bucket.getHead();
		while(curr != null) {
			if(curr.code == hash) {
				return true; // key found
			}
			curr = curr.next;
		}
		return false; // if key is never found 
	}
		
	// returns the value at given key and returns null if key doesn't exist
	public T get(String key) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		GenericQueue<T> bucket = map.get(index);
		// return null if bucket does not exist
		if (bucket == null) {   
	        return null;
	    }
		// if bucket exists, iterate through the queue until given key is found
		GenericList.Node<T> curr = bucket.getHead();
		while(curr != null) {
			if(curr.code == hash) {
				return curr.data;
			}
			curr = curr.next;
		}
		return null; // return null if key never found
	}
	
	// returns the number of key-value mappings in the map
	public int size() {
		return size;
	}
	
	// returns true if this map contains no key-value mappings. 
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	// replaces the entry for the specified key only if it is currently mapped to some value
	// returns the old element before getting replaced
	public T replace(String key, T value) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		GenericQueue<T> bucket = map.get(index);
		GenericList.Node<T> curr = bucket.getHead();
		// iterate through the queue until given key is found
		while(curr != null) {
			if(curr.code == hash) {
				// save old value into a variable to return and replace with new value after				T old = curr.data;
				T old = curr.data;
				curr.data = value;
				return old;
			}
			curr = curr.next;
		}
		return null; // return null if not found
	}
	
	// Returns an iterator to traverse all values in the map.
	public Iterator<T> iterator() {
	    return new HMIterator<>(map);
	}
}
