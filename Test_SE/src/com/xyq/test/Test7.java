package com.xyq.test;

import java.util.List;

public class Test7 {
	public static void main(String[] args) {
		float[] f = {1.3f, 2.4f, 4.5f};
		getIndexofArray(f);
		
	}
	public static int getIndexofArray(float[] f){
		int rtn=-1;
		float objf=(float) 3.4;
		List list=null;
		for(int i=0;i<f.length;i++){
			list.add(f[i]);
		}
		for(int i=0;i<list.size( );i++){
			float tmp=(float)list.get(i);
			if(objf==tmp){
				rtn=i;
			}
		}
		return rtn;
	}	
}
