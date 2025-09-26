import java.util.Iterator;

/* a singly-linked queue implementation that extends GenericList
 * supports standard queue operations such as adding/removing to back
 * */
public class GenericQueue<T> extends GenericList<T> {
	Node <T> tail;
	
	// constructor adds a node to the queue
	// T first - element to be added to the queue
	public GenericQueue(T first) {
		Node<T> firstNode = new Node<>(first);
		setHead(firstNode);
		tail = firstNode;
		setLength(1);
	}
	
	// adds an element to the back of the queue 
	// T data - element's value (stored in a node)
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		// set head and tail to the new node if queue is empty
		if (getHead() == null) { 
	        setHead(newNode);
	        tail = newNode;
	    } // set the tail to the new node if queue is not empty
		else {
	        tail.next = newNode; 
	        tail = newNode;      
	    }
		setLength(getLength() + 1); // increment queue length
	}
	
	// deletes the last element in the queue 
	// returns the value of the element deleted
	public T delete() {
		// case where queue is empty
		if (getHead() == null) { return null;}
		// case where queue only has 1 element
		if (getHead().next == null) { 
	        T data = getHead().data;
	        setHead(null);
	        tail = null;
	        setLength(getLength() - 1);
	        return data;
	    } // case where queue has more than 1 element
		else {
			Node<T> curr = getHead();
			// iterate through queue to get to last element (tail)
			while (curr.next != tail) {
				curr = curr.next;
			}
		    T data = tail.data;
		    curr.next = null;
		    tail = curr;
		    setLength(getLength() - 1);
		    return data;
	    }
	}

	// overloaded add which adds an element to the back of the queue and sets the code
	// T data - element's value (stored in a node)
	// int code - the value which the data member code will be assigned to
	public void add(T data, int code) {
		Node<T> newNode = new Node<>(data);	
		newNode.code = code;
		// set head and tail to the new node if queue is empty
		if (getHead() == null) { 
	        setHead(newNode);
	        tail = newNode;
	    } // set the tail to the new node if queue is not empty
		else {
	        tail.next = newNode; 
	        tail = newNode;      
	    }
		setLength(getLength() + 1); // increment queue length
	}
	
	// uses the add method to add an element to the back of queue
	// T data - element's value (stored in a node)
	public void enqueue(T data) {
		add(data);	
	}
	
	// uses the delete method to remove an element from the back of queue
	// returns the value of the element deleted
	public T dequeue() {
		return delete();
	}
	
	// returns an iterator to traverse the queue from head to tail
	public Iterator<T> iterator() {
        return new GLLIterator<>(getHead());
    }
}