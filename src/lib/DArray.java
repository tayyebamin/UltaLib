package lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DArray {

	private Object[] ary;
	private int size;

	public DArray() {
		this(0);
	}

	public DArray(int size) {
		if (size >= 0) {
			ary = new Object[size];
			this.size = size;
		} else {
			throw new IllegalArgumentException("Array size must be positive!");
		}
	}

	public DArray(Object[] obj) {
		size = obj.length;
		ary = new Object[size];
		for (int i = 0; i < obj.length; i++) {
			ary[i] = obj[i];
		}
	}

	public void add(Object obj) {
		size++;
		ary[size - 1] = obj;
	}

	public Object get(int i) {
		try {
			return ary[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Index is out of bounds.");
		}
	}

	public void print() {
		print("\n");
	}

	public void print(String sep) {
		for (Object obj : ary) {
			System.out.print(obj.toString() + sep);
		}
	}

	public void remove(int i) {
		if(i<0){
			throw new IllegalArgumentException("Index must be positive!");
		}else{
			size--;
			try{
				List<Object> temp = new ArrayList<Object>(Arrays.asList(ary));
				temp.remove(i);
				ary = temp.toArray();
			}catch(ArrayIndexOutOfBoundsException e){
				throw new IllegalArgumentException("Index is out of bounds.");
			}
		}
	}
	
	public int size(){
		return size;
	}

}
