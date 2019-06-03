package org.dxh.java.thread.lession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 
 * 使用一个交换器来交换缓冲区
 * 1.主线程通过静态属性初始化创建了一个交换器和一对缓冲区。
 * 2.它初始化了本地的类EmptyingLoop和FillingLoop，并将这些runnable传递到新的线程实例当中。这些实例随后会被启动。
 * 
 *
 */
public class LessionSix3 {
	
	final static Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
	
	final static DataBuffer initialEmptyBuffer = new DataBuffer();
	
	final static DataBuffer initialFullBuffer = new DataBuffer("I");

	public static void main(String[] args) {
		class FillingLoop implements Runnable{
			int count = 0;
			
			public void run() {
				DataBuffer currentBuffer = initialEmptyBuffer;
				try {
					while(true) {
						addToBuffer(currentBuffer);
						if(currentBuffer.isFull()) {
							System.out.println("filling thread wants to exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							System.out.println("filling thread receives exchange");
						}
					}
				}catch(InterruptedException ie) {
					System.out.println("filling thread interrupted");
				}
			}
			
			void addToBuffer(DataBuffer buffer) {
				String item = "NI" + count++;
				System.out.println("Adding: " + item);
				buffer.add(item);
			}
			
		}
		
		class EmptyingLoop implements Runnable{
			public void run() {
				DataBuffer currentBuffer = initialFullBuffer;
				try {
					while(true) {
						takeFromBuffer(currentBuffer);
						if(currentBuffer.isEmpty()) {
							System.out.println("emptying thread wants to exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							System.out.println("emptying thread receives exchange");
						}
					}
				}catch(InterruptedException ie) {
					System.out.println("emptying thread interrupted");
				}
			}
			
			void takeFromBuffer(DataBuffer buffer) {
				System.out.println("taking:" + buffer.remove());
			}
			
		}
		
		new Thread(new EmptyingLoop()).start();
		new Thread(new FillingLoop()).start();
	}
}

class DataBuffer{
	private final static int MAXITEMS = 10;
	private final List<String> items = new ArrayList<>();
	
	DataBuffer(){
	}
	
	DataBuffer(String prefix){
		for(int i=0;i<MAXITEMS;i++) {
			String item = prefix + i;
			System.out.printf("Adding %s%n", item);
			items.add(item);
		}
	}
	
	synchronized void add(String s) {
		if(!isFull()) {
			items.add(s);
		}
	}
	
	synchronized boolean isEmpty() {
		return items.size() == 0;
	}
	
	synchronized boolean isFull() {
		return items.size() == MAXITEMS;
	}
	
	synchronized String remove() {
		if(!isEmpty()) {
			return items.remove(0);
		}else {
			return null;
		}
	}
	
}
