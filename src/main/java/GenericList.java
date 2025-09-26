
import java.util.ArrayList;
import java.util.Iterator;

/* stores elements in a linked structure. Adds, deletes, and iterated over elements
 * */

public abstract class GenericList<T> implements Iterable <T> {
	
	public static class Node<T>{
		
		//stores data of type T
		T data;
		//creates integer code
		int code;
		//reference to next node in linked list
		Node <T> next;
		
		public Node (T data) {
			//initialize nodes data with data passed in constructor
			this.data = data;
			//initialize code to 0
			this.code = 0;
			//initialize next pointer to null
			this.next = null;
		
		}
	}
	
	//reference to first node in linked list
	private Node<T> head;
	//track how many elements in list
	private int length;
	
	public void print() {
		
		//if the head is null the list is empty
		if(head == null) {
			System.out.println("Empty List");
			return;
		}
		
		//start at head node
		Node <T> curr = head;
		//while it hasn't reached the end of the list
		while(curr != null) {
			//print out the data of current
			System.out.println(curr.data);
			//go to the next node
			curr = curr.next;
		}
	}
	
	public abstract void add (T data);
	public abstract T delete(); 
	
	
	public ArrayList<T> dumpList(){
		//create new array list to hold data from linked list
		ArrayList<T> list = new ArrayList<>();
		//start with head node
		Node <T> curr = head;
		//while it hasn't reached the end of the list
		while(curr != null) {
			//add curr nodes data to the list
			list.add(curr.data);
			//go to the next node
			curr = curr.next;
		}
		//return the list
		return list;
	}
	
	public T get( int index) {
		//if the index is out of bounds return null
		if(index < 0 || index >= length) {
			return null;
		}
		
		//initialize counter to track current position
		int i = 0;
		//start with head node
		Node <T> curr = head;
		//while it hasn't reached the end of the list
		while(curr != null) {
			//if the current position is equal to the index
			if(i == index) {
				//return current nodes data
				return curr.data;
			}
			//go to the next node
			curr = curr.next;
			//add to counter
			i++;
		}
		//return null if else
		return null;
		
	}
	
	public T set(int index, T element) {
		
		//initialize counter to track current position
		if(index < 0 || index >= length) {
			return null;
		}
		
		//start with head node
		Node <T> curr = head;
		//initialize counter to track current position
		int i = 0;
		
		//while it hasn't reached the end of the list
		while(curr != null) {
			//if the current position is equal to the index
			if(i == index) {
				//save current nodes data to return later 
				T old = curr.data;
				//current data equals the element
				curr.data = element;
				//return past data
				return old;
			}
			//go to the next node
			curr = curr.next;
			//add to counter
			i++;
				
		}
		//return null if else
		return null;
		
	}
	
	//returns number of elements in the list
	public int getLength() {
		return length;
	}
	//sets length of list
	public void setLength(int length) {
		this.length = length;
	}
	//returns head node of list
	public Node<T> getHead(){
		return head;
	}
	//sets head node of list
	public void setHead(Node<T> head){
		this.head = head;
	}
	//returns iterator to traverse forward through the list
	public Iterator<T> iterator(){
		return new GLLIterator <> (getHead());
	}
	//returns iterator to traverse backwards through the list
	public Iterator<T> descendingIterator(){
		return new ReverseGLLIterator <> (getHead());
	}
	

}
