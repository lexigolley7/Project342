import java.util.ArrayList;
import java.util.Iterator;


public class MyHashMap<T> implements Iterable <T>{
	
	private ArrayList<GenericQueue<T>> map;
	
	public MyHashMap(String key, T value) {
		
		map = new ArrayList<>(10);
		
		for(int i = 0; i < 10; i++) {
			map.add(null);
		}
		
		put(key,value);
	}
	
	public void put(String key, T value) {
		
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		
		GenericQueue<T> bucket = map.get(index);
		
		
		bucket.enqueue((T)(Object)hash);
		
		
	}
	
	public boolean contains(String key) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		
		GenericQueue<T> bucket = map.get(index);
		
		for(T value : bucket) {
			if(value.equals((T)(Object)hash)) {
				return true;
			}
				
			}
		return false;
	}
		
	
	
	public T get(String key) {
		
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		
		GenericQueue<T> bucket = map.get(index);
		
		for(T key2 : bucket) {
			if(key2.equals((T)(Object)map.get(index))) {
				return key.value;
			}else {
				return null;
			}
		}
		
	}
	
	public int size() {
		
	}
	
	public boolean isEmpty() {
		
	}
	
	public T replace(String key, T value) {
		
	}
	
	
}
