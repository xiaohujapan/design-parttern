package org.dxh.java.thread.lession.seven;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 1.主线程首先创建单词和定义的字符串数组，由于他们的从匿名类中访问，因而定义为final。
 * 2.创建了一个存储单词以及定义条目的map之后，线程获取一个重入的读写锁并开始访问读写锁
 * 3.写线程的run()方法遍历了单词的数组
 * 4.读线程的run()方法会重复的获取读锁
 *
 */
public class LessionSeven3 {

	public static void main(String[] args) {
		final String[] words = {
				"hypocalcemia",
				"prolixity",
				"assiduous",
				"indefatigable",
				"castellan"
		};
		
		final String[] definitions = {
		      "a deficiency of calcium in the blood",
		      "unduly prolonged or drawn out",
		      "showing great care,attention,and effort",
		      "able to work or continue for a lengthy time without tiring",
		      "the govenor or warden of a castle or fort"
		};
		
		final Map<String,String> dictionary = new HashMap<String,String>();
		
		ReadWriteLock rwl = new ReentrantReadWriteLock(true);
		final Lock rlock = rwl.readLock();
		final Lock wlock = rwl.writeLock();
		
		Runnable writer = ()->{
			for(int i=0;i<words.length;i++) {
				wlock.lock();
				try {
					dictionary.put(words[i], definitions[i]);
					System.out.println("writer storing " + words[i] + " entry");
				}finally {
					wlock.unlock();
				}
				try {
					Thread.sleep(1);
				}catch(InterruptedException ie) {
					System.err.println("writer " + "interrupted");
				}
			}
		};
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(writer);
		
		Runnable reader = ()->{
			while(true) {
				rlock.lock();
				try {
					int i= (int)(Math.random()*words.length);
					System.out.println("reader accessing " + words[i] + " : " + dictionary.get(words[i]) + " entry");
				}finally {
					rlock.unlock();
				}
			}
		};
		
		es = Executors.newFixedThreadPool(1);
		es.submit(reader);

	}

}
