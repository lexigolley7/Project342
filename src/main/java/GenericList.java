
import java.util.ArrayList;
import java.util.Iterator;


public abstract class GenericList<T> implements Iterable <T> {
	
	public static class Node<T>{
		T data;
		int code;
		Node <T> next;
		
		public Node (T data) {
			this.data = data;
			this.code = 0;
			this.next = null;
		
		}
	}
	
	private Node<T> head;
	private int length;
	
	public void print() {
		
		if(head == null) {
			System.out.println("Empty List");
			return;
		}
		Node <T> curr = head;
		
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	public abstract void add (T data);
	public abstract T delete(); // return null if list empty
	
	public ArrayList<T> dumpList(){
		ArrayList<T> list = new ArrayList<>();
		Node <T> curr = head;
		
		while(curr != null) {
			list.add(curr.data);
			curr = curr.next;
		}
		
		return list;
	}
	
	public T get( int index) {
		
		if(index < 0 || index >= length) {
			return null;
		}
		
		int i = 0;
		Node <T> curr = head;
		
		while(curr != null) {
			if(i == index) {
				return curr.data;
			}
			curr = curr.next;
			i++;
		}
		
		return null;
		
	}
	
	public T set(int index, T element) {
		
		if(index < 0 || index >= length) {
			return null;
		}
		
		Node <T> curr = head;
		int i = 0;
		
		while(curr != null) {
			if(i == index) {
				T old = curr.data;
				curr.data = element;
				return old;
			}
			curr = curr.next;
			i++;
				
		}
		
		return null;
		
	}
	
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	public void setHead(Node<T> head){
		this.head = head;
	}
	
	public Iterator<T> iterator(){
		return new GLLIterator <> (getHead());
	}
	
	public Iterator<T> descendingIterator(){
		return new ReverseGLLIterator <> (getHead());
	}
	
	
	
	

}
