import java.util.Iterator;
import java.util.ArrayList;

//Iterator for traversing all values stored in a MyHashMap.
//Iterates through each bucket (GenericQueue) and each node inside.
public class HMIterator<T> implements Iterator <T> {

	private ArrayList<GenericQueue<T>> map;
    private GenericList.Node<T> curr;
    private int index;
	
    // Constructor initializes the iterator to the first available bucket/node
    public HMIterator(ArrayList<GenericQueue<T>> map) {
		this.map = map;
        this.curr = null;
        this.index = 0;
        
        // getting to the first available bucket and node to check
        while (index < map.size()) {
            GenericQueue<T> bucket = map.get(index);
            // set curr to the head of the new non-empty bucket we're using
            if (bucket != null && bucket.getHead() != null) {
                curr = bucket.getHead(); 
                break; 
            }
            index++; 
        }
    }
	
    // Returns true if there is another element to visit
	public boolean hasNext() {
		return curr != null;
	}
	 
    // Returns the next element in the map and continues the iterator forward
	public T next() {
		// case where there are not nodes left
		if (curr == null) {
			return null;
		}
		
		// grabbing node in the current bucket
		T data = curr.data; 
		if (curr.next != null) {
            curr = curr.next;
        } 
		// if no nodes left in current bucket, go to next available bucket
		else {
            index++; 
            curr = null; 
            while (index < map.size()) {
                GenericQueue<T> bucket = map.get(index);
                // set curr to the head of the new non-empty bucket we're using
                if (bucket != null && bucket.getHead() != null) {
                    curr = bucket.getHead(); 
                    break; 
                }
                index++;
            }
        }
		return data;
	}
}
