import java.util.Iterator;
import java.util.ArrayList;


public class HMIterator<T> implements Iterator <T> {

	private ArrayList<GenericQueue<T>> map;
    private GenericList.Node<T> curr;
    private int index;
	
//	public HMIterator(ArrayList<GenericQueue<T>> map) {
//		this.map = map;
//        this.curr = null;
//        this.index = 0;
//    }
//	 
//	public boolean hasNext() {
//		// checking for nodes in the current bucket you're inside of 
//		if (curr != null) {
//			return true;
//        }
//		 
//		// checking remaining buckets
//		for (int i = index; i < map.size(); i++) {
//			GenericQueue<T> bucket = map.get(i);
//		    if (bucket != null && bucket.getHead() != null) {
//		        return true;
//		    }
//		}
//		return false; // no node found
//	}
//	 
//	public T next() {
//		// checking for nodes in the current bucket you're inside of 
//		if (curr != null && curr.next != null) {
//			curr = curr.next;
//		    return curr.data;
//		}
//		 
//		// checking remaining buckets
//		for (; index < map.size(); index++) {
//		GenericQueue<T> bucket = map.get(index);
//	    	if (bucket != null && bucket.getHead() != null) {
//	    		curr = bucket.getHead();
//	            index++; 
//	            return curr.data;
//	        }
//		}
//		return null; // no nodes in remaining buckets
//	}
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
	
	public boolean hasNext() {
		return curr != null;
	}
	 
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
