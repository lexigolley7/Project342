import java.util.Iterator;
import java.util.Stack;
public class ReverseGLLIterator <T> implements Iterator <T> {

	private Stack<T> stack;
	
	public ReverseGLLIterator (GenericList.Node<T> head) {
		stack = new Stack <>();
		GenericList.Node<T> curr = head; 
		
		
		while(curr != null) {
			stack.push(curr.data);
			curr = curr.next;
				
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public T next() {
		return stack.pop();
	}
}
