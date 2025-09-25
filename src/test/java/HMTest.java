import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HMTest {
	
	@Test
	void ConstructorTest() {
        MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
		assertEquals(100,map.get("key1"), "The value at key1 should be 100");
	}
	
	@Test
	void putTest() {
		MyHashMap<Integer> map = new MyHashMap<>("key1", 100);
        map.put("key2", 200);
        
        assertEquals(100, map.get("key1"), "The value at key1 should be 100");
		assertEquals(200, map.get("key2"), "The value at key2 should be 200");
		
//		assertEquals(200, map.get("key2"), "The value at key2 should be 200");
//        
//        map.put("key3", 300);

//		
//		assertEquals(300,map.get("key3"), "The value at key3 should be 300");
//		assertEquals(null,map.get("key4"), "The value at key4 doesn't exist");
		
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
