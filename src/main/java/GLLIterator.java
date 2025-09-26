import java.util.Iterator;

public class GLLIterator <T> implements Iterator <T> {
	
	//tracks current node
	private GenericList.Node<T> curr;
	//starts current node to head
	public GLLIterator (GenericList.Node<T> head) {
		this.curr = head;
	}
	//returns true if theres another element
	public boolean hasNext() {
		return curr != null;
	}
	//returns current elements data and moves to next node
	public T next() {
		//saves current data
		T data = curr.data;
		//goes to next node
		curr = curr.next;
		//returns saved data
		return data;
	}
	
}
