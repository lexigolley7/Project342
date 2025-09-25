import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HMTest {
	
	// adds the given key-value pair into map correctly 
	@Test
	void ConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
	}
	
	// check if put function ????
	@Test
	void putTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        
        // check keys
		assertTrue(map.contains("key1"), "Map should contain key1");
	    assertTrue(map.contains("key2"), "Map should contain key2");
	    assertFalse(map.contains("key3"), "Map should not contain key3");
        
        // check values
        assertEquals(100, map.get("key1"), "The value at key1 should be 100");
		assertEquals(200, map.get("key2"), "The value at key2 should be 200");
	}
	
	@Test
	void containsTest() {
		
	}
	
	@Test
	void getTest() {
		
		
	}
	
	@Test
	void sizeTest() {
		
	}
	
	@Test
	void isEmptyTest() {
		
	}
	
	@Test
	void replaceTest() {
		
	}
	
	@Test
	void iteratorTest() {
		
	}
	
	
}
