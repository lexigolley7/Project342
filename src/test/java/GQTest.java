import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;



public class GQTest {
	void addTest() {
		
	}
	
	void addCodeTest() {
		
	}
	
	void deleteTest() {
		GenericQueue<Integer> myList = new GenericQueue<>(1);
        myList.enqueue(3);
        
		assertEquals(3, myList.delete(), "Wrong value. Last node value should be 3.");
		assertEquals(1, myList.delete(), "Wrong value. Last node value should be 1.");
		//null option?
	}
	
	void enqueueTest() {
		GenericQueue<Integer> myList = new GenericQueue<>(1);
		myList.enqueue(1);
        myList.enqueue(2);
//        
//		assertEquals(2, getHead(), ".");
//		assertEquals(1, myList.delete(), ".");
	}
	
	void dequeueTest() {
		GenericQueue<Integer> myList = new GenericQueue<>(1);
		myList.enqueue(2);
        myList.enqueue(3);
        
		assertEquals(3, myList.dequeue(), "Wrong value. Last node value should be 3.");
		assertEquals(2, myList.dequeue(), "Wrong value. Last node value should be 2.");
		assertEquals(1, myList.dequeue(), "Wrong value. Last node value should be 1.");
		// null option
	}
}
