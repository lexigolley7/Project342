import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HMTest {
	
	// verifies that the constructor inserts the first key-value pair
	@Test
	void ConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
	}
	
	// verifies that put() correctly stores key-value pairs
	@Test
	void putTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        // check keys
		assertTrue(map.contains("key1"), "Map should contain key1");
	    assertTrue(map.contains("key2"), "Map should contain key2");
        // check values
        assertEquals(100, map.get("key1"), "The value at key1 should be 100");
		assertEquals(200, map.get("key2"), "The value at key2 should be 200");
	}
	
	// verifies that contains() finds existing keys and rejects non-existing ones
	@Test
	void containsTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        // verify existing keys
		assertTrue(map.contains("key1"), "Map should contain key1");
	    assertTrue(map.contains("key2"), "Map should contain key2");
	    // verify key that doesn't exist
	    assertFalse(map.contains("key3"), "Map should not contain key3");
	}
	
	// verifies that get() returns the correct value corresponding to a key a
	// verifies that get() returns null for non-existing keys
	@Test
	void getTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        // verify existing key's value
		assertEquals(100,map.get("key1"), "The value at key1 should be 100"); 
	    // verify non-existent key's value
		assertNull(map.get("fake"), "the key fake should be null");
	}
	
	// verifies that size() tracks the number of elements properly
	@Test
	void sizeTest() {
		// add elements and check size after adding each
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(1, map.size(), "The size of map should be 1");
        map.put("key2", 200);
		assertEquals(2, map.size(), "The size of map should be 2");
		// replace an element and verify size
		map.replace("key2", 500);
		assertEquals(2, map.size(), "The size of map should be 2");
		// delete an element and verify size
		map.();  
	    assertEquals(1, map.size(), "The size of map should be 1 after removing key1");
	}
	
	// verifies that isEmpty() returns correctly depending on if the map is empty or not
	@Test
	void isEmptyTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertFalse(map.isEmpty(), "The map is not currently empty.");
		map.put("key2", 200);
		assertFalse(map.isEmpty(), "The map is not currently empty.");
	}
	
	// verifies that replace() updates values while keeping the keys the same
	@Test
	void replaceTest() {
		// create map with 2 elements and check that the keys are mapped to correct values 
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
		assertEquals(200,map.get("key2"), "The value at key2 should be 200");
		// replace the 2 elements and re-check that the keys are mapped to correct values 
		map.replace("key1", 500);
		map.replace("key2", 600);
		assertEquals(500,map.get("key1"), "The value at key1 should be 500");
		assertEquals(600,map.get("key2"), "The value at key2 should be 600");
	}
	
	// verifies that a for each loop properly iterates through map
	@Test
	void forLoopTest() {
		// create map with 3 elements
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);
        // increment count for each bucket in the map
        int count = 0;
        for(Integer bucket : map) {
        	count++;
        }
		assertEquals(3, count, "Map has 3 buckets"); // verify that count is 3
	}
	
	// verifies iterator visits all values in the map
	@Test
	void iteratorTest() {
		// create map with 3 elements
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);
        // add values to sum for each value in the map
        int sum = 0;
        for (int val : map) {
            sum += val;
        }
        assertEquals(600, sum, "Iterator should traverse all values"); // verify that sum is 600
	}
	
	//verifies that the Node constructor initializes all fields correctly
	@Test
	void testingNode(){
		// creates a new node and checks its data, next, and code fields
		GenericQueue.Node<Integer> node = new GenericQueue.Node<>(1);
	    assertEquals(1, node.data, "Node's value should be 1");
	    assertEquals(null, node.next, "The next node should equal null");
		assertEquals(0, node.code, "The code is 0 by default");
		// changes data field and re-varifies it
	    node.data = 2;
	    assertEquals(2, node.data, "Node's value should be 2");
	}
}
