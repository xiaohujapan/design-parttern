package org.dxh.java.base.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	
	public static void main(String[] args) {
		//arrayIntegerSort();
		
		//arrayStringSort();
		
		collectSort();
	}
	
	
	
	public static void collectSort() {
		List<String> strings = Arrays.asList("6", "1", "3", "1","2");
		Collections.sort(strings);
		for (String string : strings) {
            System.out.println(string);
        }
	}
	
	public static void arrayStringSort() {
		String[] strArray = new String[]{"Zs","ZA", "aa", "Az","D","w","A","z"};
		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));
		
		strArray = new String[]{"hello","Hello", "Hello kity", "hello kity","D","w","A"};
		Arrays.sort(strArray ,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArray));
	}
	
	
	public static void arrayIntegerSort() {
		Integer[] a = {1, 3, 4, 67, 78, 9, 90, 6, 3, 2};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		Comparator cmp = new MyComparator();
		Arrays.sort(a, cmp);
		System.out.println(Arrays.toString(a));
	}
}


class MyComparator implements Comparator<Integer>{
	
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2) { 
			return 1;
		}else if(o1 > o2) {
			return -1;
		}else {
			return 0;
		}
	}
}
