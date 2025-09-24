import java.util.Iterator;

public class GLLIterator <T> implements Iterator <T> {
	
	private GenericList.Node<T> curr;
	
	public GLLIterator (GenericList.Node<T> head) {
		this.curr = head;
	}
	
	public boolean hasNext() {
		return curr != null;
	}
	
	public T next() {
		T data = curr.data;
		curr = curr.next;
		
		return data;
	}
	
}
