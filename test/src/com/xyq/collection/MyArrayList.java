package com.xyq.collection;

public class MyArrayList {
	
	Object[] value;
	
	int count;
	
	public MyArrayList(int len) {
		value = new Object[len];
	}
	
	public MyArrayList() {
		value = new Object[3];
	}

	public void add(Object object) {
		
		if(count >= value.length) {
			Object[] newValue = new Object[(value.length << 1) + 2];
			for(int i=0; i<value.length; i++) {
				newValue[i] = value[i];
			}
			value = newValue;
		}
		
		value[count++] = object;
	}
	
	public Object get(int index) {
		
		return value[index];
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<count; i++) {
			sb.append(value[i].toString()+" ");
		}
//		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
}
