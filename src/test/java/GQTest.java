import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;


public class GQTest {
	
	@Test
	void GenericQueueConstructorTest() {
		//creates a new generic queue for integers with one integer "1"
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		//makes sure the head doesn't equal null
		assertNotNull(queue.getHead(), "head should not be null");
		//makes sure the head equals 1
		assertEquals(1,queue.getHead().data, "head should be 1");
		//makes sure the head and tail are the same
		assertEquals(queue.getHead(),queue.tail, "tail should be the same as head");
		
	}
	
	
	@Test
	void addTest() {
		//creates a new generic queue for integers with one integer "1"
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		//adds 2 and 3 to the queue
		queue.add(2);
		queue.add(3);
		//checks that the size is equal to 3
		assertEquals(3, queue.getLength(), "size should equal 3");
		//checks that the head node is equal to 1
		assertEquals(1, queue.getHead().data, "head should equal 1");
		//checks that the tail node is equal to 3
		assertEquals(3, queue.tail.data, "tail should equal 3");
		
	}
	
	@Test
	void addCodeTest() {
		//creates a new generic queue for integers with one integer "1"		
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		//adds 2 and assigns 2's code to 10
		queue.add(2,10);
		//adds 3 and assigns 3's code to 20
		queue.add(3,20);
		
		//checks that the size is equal to 3
		assertEquals(3, queue.getLength(), "size should equal 3");
		//checks that the head node is 1 and it's code is the default(0)
		assertEquals(1, queue.getHead().data, "head should equal 1");
		assertEquals(0, queue.getHead().code, "code should equal 0");
		//checks that the next node is 2 and it's code is 10
		assertEquals(2, queue.getHead().next.data, "next node should equal 2");
		assertEquals(10, queue.getHead().next.code, "code should equal 10");
		//checks that the tail node is 3 and it's code is 20
		assertEquals(3, queue.tail.data, "tail should equal 3");
		assertEquals(20, queue.tail.code, "code should equal 20");

	}
	
	
	@Test
	void deleteTest() {
		
		//creates a new generic mylist for integers with one integer "1"	
		GenericQueue<Integer> myList = new GenericQueue<>(1);
        //enqueues 3 to the list
		myList.enqueue(3);
        
		//checks that once the delete function is called it returns 3
		assertEquals(3, myList.delete(), "Wrong value. Last node value should be 3.");
		//checks that once the delete function is called it returns 1
		assertEquals(1, myList.delete(), "Wrong value. Last node value should be 1.");
		
	}
	
	@Test
	void enqueueTest() {
		
		//creates a new generic mylist for integers with one integer "1"
		GenericQueue<Integer> myList = new GenericQueue<>(1);
		
		//checks that the size is equal to 1
		assertEquals(1, myList.getLength(), "size should equal 1");
		//checks that the head node is equal to 1
		assertEquals(1, myList.getHead().data, "head should still equal 1");
		//enqueues 3 and 4 into mylist
		myList.enqueue(3);
        myList.enqueue(4);
        
        //checks that the size is equal to 3
        assertEquals(3, myList.getLength(), "length should equal 3");
        //checks that the head node is equal to 1
		assertEquals(1, myList.getHead().data, "head should equal 1");
		//checks that the delete function removes and returns 4
		assertEquals(4, myList.delete(), "delete should return and remove 4");
		//checks that the head node is still equal to 1
		assertEquals(1, myList.getHead().data, "head should still equal 1");
		//checks that the size is now 2
		assertEquals(2, myList.getLength(), "length should equal 2");
	}
	
	@Test
	void dequeueTest() {
		//creates a new generic mylist for integers with one integer "1"
		GenericQueue<Integer> myList = new GenericQueue<>(1);
		
		//enqueues 2 and 3 into mylist
		myList.enqueue(2);
        myList.enqueue(3);
        
        //checks that dequeue returns 3
		assertEquals(3, myList.dequeue(), "Wrong value. Last node value should be 3.");

        //checks that dequeue returns 2
		assertEquals(2, myList.dequeue(), "Wrong value. Last node value should be 2.");

        //checks that dequeue returns 1
		assertEquals(1, myList.dequeue(), "Wrong value. Last node value should be 1.");
		
	}
	
	@Test
	void forLoopTest() {
		
		//creates a new generic mylist for integers with one integer "1"
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		//adds 3 and 4 into queue
		queue.add(3);
		queue.add(4);
		
		//initializes counter
		int count = 0;
		//for each item in queue
		for(Integer item : queue) {
			//add to the count
			count++;
		}
		//checks that the count is equal to 3
		assertEquals(3, count, "count should equal 3");
	}
	
	@Test
	void testIterator() {
		//creates a new generic mylist for integers with one integer "1"
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		
		//enqueues 2,3,7 
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(7);
		
		//expected array should equal 1,2,3,7
		int[] expected = {1,2,3,7};
		//initialize index
		int index = 0;
		//for each val in queue
		for(int val : queue) {
			//check that the index value equals that value
			assertEquals(expected[index],val);
			//add one to the index
			index++;
		}
		//check that the expected size is equal to the index count
		assertEquals(expected.length,index, "Index should equal 4");
	}
	
	@Test
	void testDescendingIterator() {
		
		//creates a new generic mylist for integers with one integer "1"
		GenericQueue<Integer> queue = new GenericQueue<>(1);
		//enqueues 2,3,7
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(7);
		//expected array should equal 1,2,3,7
		int[] expected = {1,2,3,7};
		//set index equal to the last number in array
		int index = expected.length-1;
		//get descending iterator from queue
		Iterator<Integer> descend = queue.descendingIterator();
		
		//iterate through queue in descending reverse
		while(descend.hasNext()) {
			//set val equal to the next element
			int val = descend.next();
			//compare value returned by iterator with expected value
			assertEquals(expected[index],val);
			//continue going backwards through queue
			index--;
		}
		//if all elements were matched the index should equal -1
		assertEquals(-1,index, "-1 all elements have been matched");
	}
	
	@Test
	void testingNode(){
		
		//creates a new generic list node for integers with one integer "7"
		GenericList.Node<Integer> node = new GenericList.Node<>(7);
		
		//checks that the node equals 7
		assertEquals(7,node.data, "node should equal 7");
		//checks that the next node equals null since it's the only one
		assertEquals(null, node.next, "the next node should equal null");
		//checks that the code associated is 0 by default
		assertEquals(0, node.code, "the code is 0 by default");
	}
	
}
