import java.util.ArrayList;
import java.util.Iterator;


public class MyHashMap<T>{
	
	private ArrayList<GenericQueue<T>> map;
	private int size;
	
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
		
		
		if(bucket == null) {
			bucket = new GenericQueue<>(value);
			
			bucket.getHead().code = hash;
			
			map.set(index, bucket);
		}else {
			bucket.add(value,hash);
		}
		
	
	}
	
	public boolean contains(String key) {
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		
		GenericQueue<T> bucket = map.get(index);
		
		if(bucket == null) {
			return false;
		}
		
		GenericList.Node<T> curr = bucket.getHead();
		
		while(curr != null) {
			if(curr.code == hash) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
		
	
	
	public T get(String key) {
		
		int hash = key.hashCode();
		int index = key.hashCode() & 9;
		
		GenericQueue<T> bucket = map.get(index);
		
		
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		
		return false;
	}
	
	public T replace(String key, T value) {
		
	}
	
	
}
