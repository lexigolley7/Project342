import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class GQTest {
	@Test
	void GenericQueueConstructorTest() {
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		assertNotNull(queue.getHead(), "head should not be null");
		assertEquals(1,queue.getHead().data, "head should be 1");
		assertEquals(queue.getHead(),queue.tail, "tail should be the same as head");
	}
	
	
	@Test
	void addTest() {
		
	}
	
	@Test
	void addCodeTest() {
		
	}
	
	
	@Test
	void deleteTest() {
		GenericQueue<Integer> myList = new GenericQueue<>(1);
        myList.enqueue(3);
        
		assertEquals(3, myList.delete(), "Wrong value. Last node value should be 3.");
		assertEquals(1, myList.delete(), "Wrong value. Last node value should be 1.");
		//null option?
	}
	
	@Test
	void enqueueTest() {
		GenericQueue<Integer> myList = new GenericQueue<>(1);
		myList.enqueue(3);
        myList.enqueue(4);
        
        assertEquals(3, myList.getLength(), "head should equal 1");
		assertEquals(1, myList.getHead(), "head should equal 1");
		assertEquals(4, myList.delete(), "delete should return and remove 4");
		assertEquals(1, myList.getHead(), "head should still equal 1");
		assertEquals(2, myList.getLength(), "head should equal 1");
	}
	
	@Test
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
