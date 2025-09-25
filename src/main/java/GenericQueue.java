import java.util.Iterator;


public class GenericQueue<T> extends GenericList<T> {
	Node <T> tail;
	
	//constructor
	public GenericQueue(T first) {
		Node<T> firstNode = new Node<>(first);
		setHead(firstNode);
		tail = firstNode;
		setLength(1);
	}
	//
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (getHead() == null) { 
	        setHead(newNode);
	        tail = newNode;
	    } 
		else {
	        tail.next = newNode; 
	        tail = newNode;      
	    }
		setLength(getLength() + 1);
	}
	
	public T delete() {
		if (getHead() == null) {
			return null;
		}
	
		if (getHead().next == null) { 
	        T data = getHead().data;
	        setHead(null);
	        tail = null;
	        setLength(getLength() - 1);
	        return data;
	    }
		else {
			
	    Node<T> curr = getHead();
	    while (curr.next != tail) {
	        curr = curr.next;
	    }

	    T data = tail.data;
	    curr.next = null;
	    tail = curr;
	    setLength(getLength() - 1);
	    return data;}
	}
	//hello
	public void add(T data, int code) {
		Node<T> newNode = new Node<>(data);	
		newNode.code = code;
		
		if (getHead() == null) { 
	        setHead(newNode);
	        tail = newNode;
	    } 
		else {
	        tail.next = newNode; 
	        tail = newNode;      
	    }
		setLength(getLength() + 1);
	}
	
	public void enqueue(T data) {
		add(data);
		
	}
	public T dequeue() {
		return delete();
	}
	
	public Iterator<T> iterator() {
        return new GLLIterator<>(getHead());
    }
	
}
