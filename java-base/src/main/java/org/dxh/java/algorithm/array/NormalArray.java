package org.dxh.java.algorithm.array;

public class NormalArray implements ArrayInterface{
	private long[] a;
	private int nElems;
	
	public NormalArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	public int find(long searchKey) {
		int j;
		for(j=0;j<nElems;j++) {
			if(a[j] == searchKey) {
				break;
			}
		}
		if(j == nElems) {
			return nElems;
		}else {
			return j;
		}
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j;
		for(j=0;j<nElems;j++) {
			if(value == a[j]) {
				break;
			}
		}
		if(j==nElems) {
			return false;
		}else {
			for(int k=j;k<nElems;k++) {
				a[k] = a[k+1];
			}
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j] + " ,  ");
		}
		System.out.println("");
		System.out.println("=================");
	}
}
