package org.dxh.java.thread.lession.seven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 1.main()方法初始化了类Shared,Producer以及Consumer.Shared实例被传递到Producer和Consumer的构造函数中这些线程随后启动。
 * 2.主线程调用Producer和Consumer构造函数，由于Shared实例也被Producer和Consumer线程所访问，该实例必须对这些线程可见。
 * 
 *
 */
public class LessionSeven2 {

	public static void main(String[] args) {
		Shared s = new Shared();
		new Producer(s).start();
		new Consumer(s).start();
	}
	
}

/**
 * 
 *1. Shared的构造函数通过lock = new ReentrantLock();的方法创建了一个锁，并且通过condition = lock.newCondition();创建一个与之关联的条件。
 * 生产者和消费者可以通过lock getLock()方法访问这个锁。
 * 2.当变量available为true时，生产者调用条件的await()方法等待available变为false。
 * 3.消费者在消费字符之后，发出信号给这个条件来唤醒生产者。
 * 4.离开循环之后，生产者线程记录下新的字符，将available变成ture，表示一个新字符可被消费，同时发出信号给这个条件来唤醒一个等待中的消费者
 * 5.释放锁并且退出setSharedChar()方法。
 * 
 */
class Shared{
	private char c;
	private volatile boolean available;
	private final Lock lock;
	private final Condition condition;
	
	Shared(){
		available = false;
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}
	
	Lock getLock() {
		return lock;
	}
	
	char getSharedChar() {
		lock.lock();
		try {
			while(!available) {
				try {
					condition.await();
				}catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			available = false;
			condition.signal();
		}finally {
			lock.unlock();
			return c;
		}
	}
	
	void setSharedChar(char c) {
		lock.lock();
		try {
			while(available) {
				try {
					condition.await();
				}catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			this.c = c;
			available = true;
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
}

class Producer extends Thread{
	private final Lock l;
	private final Shared s;
	
	Producer(Shared s){
		this.s= s;
		l = s.getLock();
	}
	
	public void run() {
		for(char ch='A';ch<='Z';ch++) {
			l.lock();
			s.setSharedChar(ch);
			System.out.println(ch + " produced by producer.");
			l.unlock();
		}
	}
}

class Consumer extends Thread{
	private final Lock l;
	private final Shared s;
	
	Consumer(Shared s){
		this.s = s;
		l = s.getLock();
	}
	
	public void run() {
		char ch;
		do {
			l.lock();
			ch = s.getSharedChar();
			System.out.println(ch + " consumed by consumer.");
			l.unlock();
		}while(ch != 'Z');
	}
}