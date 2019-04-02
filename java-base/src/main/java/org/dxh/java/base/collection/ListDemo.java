package org.dxh.java.base.collection;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		//List初期化
		//List<String> list = setSampleList();
		//基本のメッソト
		//baseMethodTest(list);
		
		//エラーテスト
		/**
		 * 在迭代过程中，使用了集合的方法对元素进行操作。导致迭代器并不知道集合中的变化，容易引发数据的不确定性。
		 * 并发修改异常解决办法：在迭代时，不要使用集合的方法操作元素。
		 */
		//iteratorErrorTest(list);
		//listIteratorTest(list);
		
		//ArrayListとLinkedListの比較（1万件データ）
		//arrayListTest();
		//linkedListTest();
		//LinkedList集合也可以作为堆栈，队列的结构使用
		//useLinkedList();
		
		
		
	}
	
	
	public static void useLinkedList() {
		LinkedList<String> link = new LinkedList<String>();
		//做为队列来使用
		link.addFirst("user1");
		link.addFirst("user2");
		System.out.println(link.getLast());
		
		//做为堆栈使用
		link.addFirst("user1");
		link.addFirst("user2");
		System.out.println(link.getFirst());
	}
	
	public static void arrayListTest() {
		long start = System.currentTimeMillis();
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
		List<String> list = new ArrayList<String>();
		for(int i=0;i<100000;i++) {
			list.add("userId="+i);
		}
		long end = System.currentTimeMillis(); 
		System.out.println("10万件データArrayListの作成時間は「" + (end-start)  + "」");
		start = System.currentTimeMillis();
		list.remove(25300);
		list.set(25300,"userId=25300");
		end = System.currentTimeMillis(); 
		System.out.println("データ削除及び変更は「" + (end-start)  + "」");
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
		start = System.currentTimeMillis();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {String var = it.next();}
		end = System.currentTimeMillis(); 
		System.out.println("10万件データArrayListの抽出時間は「" + (end-start)  + "」");
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
	}
	
	public static void linkedListTest() {
		long start = System.currentTimeMillis();
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
		List<String> list = new LinkedList<String>();
		for(int i=0;i<100000;i++) {
			list.add("userId="+i);
		}
		long end = System.currentTimeMillis(); 
		System.out.println("10万件データLinkedListの作成時間は「" + (end-start)  + "」");
		start = System.currentTimeMillis();
		list.remove(25300);
		list.set(25300,"userId=25300");
		end = System.currentTimeMillis(); 
		System.out.println("データ削除及び変更は「" + (end-start)  + "」");
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
		start = System.currentTimeMillis();
		Iterator<String> it = list.iterator();
		while(it.hasNext())  {String var = it.next();}
		end = System.currentTimeMillis(); 
		System.out.println("10万件データLinkedListの抽出時間は「" + (end-start)  + "」");
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" );
	}
	
	
	public static void listIteratorTest(List<String> list) {
		try {
			ListIterator<String> it = list.listIterator();
			while(it.hasNext()) {
				if("競馬　二郎".equals(it.next())) {
					it.add("競馬　五郎");
				}
			}
			printListByiterator(list);
		}catch(ConcurrentModificationException ex) {
			System.out.println(ex.toString());
		}
	}
	
	
	public static void iteratorErrorTest(List<String> list) {
		try {
			Iterator<String> it = list.iterator();
			while(it.hasNext()) {
				if("競馬　二郎".equals(it.next())) {
					list.add("競馬　五郎");
				}
			}
		}catch(ConcurrentModificationException ex) {
			System.out.println("iterator データ挿入失敗、エラー：" + ex.toString());
		}
	}
	
	
	public static void baseMethodTest(List<String> list ){
		//追加
		list.add("競馬　五郎");
		
		list.add("競馬　六郎");
		
		System.out.println("=========追加完了===========");
		printListByiterator(list);
		//削除
		list.remove(3);
		System.out.println("=========削除完了=========");
		printListByiterator(list);
		//変更
		list.set(2, "競馬　七郎");
		System.out.println("=========変更完了=========");
		printListByFor(list);
	}
	
	public static List<String> setSampleList(){
		List<String> list = new ArrayList<String>();
		list.add("競馬　太郎");
		list.add("競馬　二郎");
		list.add("競馬　三郎");
		list.add("競馬　四郎");
		return list;
	}
	
	public static void printListByiterator(List<String> list) {
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void printListByFor(List<String> list) {
		for(String value:list) {
			System.out.println(value);
		}
	}
}
