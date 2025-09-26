import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HMTest {
	
	// adds the given key-value pair into map correctly 
	@Test
	void ConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
	}
	
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
	
	@Test
	void containsTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        
        // check keys
		assertTrue(map.contains("key1"), "Map should contain key1");
	    assertTrue(map.contains("key2"), "Map should contain key2");
	    // key that doesn't exist
	    assertFalse(map.contains("key3"), "Map should not contain key3");
	}
	
	@Test
	void getTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
		assertNull(map.get("fake"), "the key fake should be null");
		
	}
	
	@Test
	void sizeTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(1, map.size(), "The size of map should be 1");
        map.put("key2", 200);
		assertEquals(2, map.size(), "The size of map should be 2");
		map.replace("key2", 500);
		assertEquals(2, map.size(), "The size of map should be 2");
		// TODO: delete a node and test size
	}
	
	@Test
	void isEmptyTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertFalse(map.isEmpty(), "The map is not currently empty.");
		map.put("key2", 200);
		assertFalse(map.isEmpty(), "The map is not currently empty.");
	}
	
	@Test
	void replaceTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
		assertEquals(200,map.get("key2"), "The value at key2 should be 200");
		
		map.replace("key1", 500);
		map.replace("key2", 600);
		assertEquals(500,map.get("key1"), "The value at key1 should be 500");
		assertEquals(600,map.get("key2"), "The value at key2 should be 600");
	}
	
	@Test
	void forLoopTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);
        
        int count = 0;
        for(Integer bucket : map) {
        	count++;
        }
		assertEquals(3, count, "Map has 3 buckets");
	}
	
	@Test
	void iteratorTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);
        
        int sum = 0;
        for (int val : map) {
            sum += val;
        }
        assertEquals(600, sum, "Iterator should traverse all values");
	}
	
	@Test
	void testingNode(){
		GenericQueue.Node<Integer> node = new GenericQueue.Node<>(1);
	    assertEquals(1, node.data, "Node's value should be 1");
	    assertEquals(null, node.next, "The next node should equal null");
		assertEquals(0, node.code, "The code is 0 by default");
		
	    node.data = 2;
	    assertEquals(2, node.data, "Node's value should be 2");
	}
}
