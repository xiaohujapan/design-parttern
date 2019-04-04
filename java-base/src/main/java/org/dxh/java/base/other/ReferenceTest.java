package org.dxh.java.base.other;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ReferenceTest {
	
	public static void main(String[] args) {
		//強参照テスト
		//StrongReferenceTest();
		//ソフト参照テスト
		//SoftReferenceTest();
		//弱参照テスト
		//WeakReference();
	}
	
	public static void WeakReference() {
		//  弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它所管辖的内存区域的过程中,
		//一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程,
		//因此不一定会很快发现那些只具有弱引用的对象。 
		String str=new String("abc");    
		WeakReference<String> weakRef = new WeakReference<String>(str);
		System.out.println("str=" + str + ",weakRef = " + weakRef.get());
		str = null;
		System.gc();
		System.out.println(weakRef.get());
		if(weakRef.get()!=null) {
			System.out.println("str=" + str + ",weakRef = " + weakRef);
		}else {
			System.out.println("GC had collect weakRef");
		}
	}

	public static void SoftReferenceTest() {
		//如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，
		//就会回收这些对象的内存。只要垃圾回收器没有回收它，
		//该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存。      
		String str	=	new String("abc");                                     				// 强引用
		SoftReference<String> softRef	=	new SoftReference<String>(str);     // 软引用
		System.out.println("str=" + str + ",softRef = " + softRef);
		//内存不足时
		if(true) {
			str = null;
			System.gc();
		}
		System.out.println("str=" + str + ",softRef = " + softRef);
		//  软引用在实际中有重要的应用，例如浏览器的后退按钮。按后退时，这个后退时显示的网页内容是重新进行请求还是从缓存中取出呢？这就要看具体的实现策略了。
		//（1）如果一个网页在浏览结束时就进行内容的回收，则按后退查看前面浏览过的页面时，需要重新构建
		//（2）如果将浏览过的网页存储到内存中会造成内存的大量浪费，甚至会造成内存溢出
		if(softRef.get() != null) {
			str = softRef.get();
			System.out.println("str = " + str);
		}else {
			System.out.println("GC had collect softRef");
		}
		
	}
	
	public static void StrongReferenceTest() {
		//在list集合里的数据不会释放，即使内存不足也不会
		String str = "abc";
		List<String> list = new ArrayList<String>();
		list.add(str);
	}
	
}
