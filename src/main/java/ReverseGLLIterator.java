import java.util.Iterator;
import java.util.Stack;
public class ReverseGLLIterator <T> implements Iterator <T> {

	//stack to hold elements for reverse iteration
	private Stack<T> stack;
	
	public ReverseGLLIterator (GenericList.Node<T> head) {
		//creates stack
		stack = new Stack <>();
		//starts at head node
		GenericList.Node<T> curr = head; 
		
		//while it hasn't reached the end of the list
		while(curr != null) {
			//pushed current nodes data onto the stack
			stack.push(curr.data);
			//goes to next node
			curr = curr.next;	
		}
	}
	
	//returns true if there are still elements
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//returns element in reverse order by popping
	public T next() {
		return stack.pop();
	}
}
