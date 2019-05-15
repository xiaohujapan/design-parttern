package org.dxh.java.thread.lession;

/**
 * 
 * 将一个对象从父线程传到子线程中
 * 初始化InheritableThreadLocal后，将其赋值给一个用final修饰的，名为intVal的类属性，
 * 默认主线程创建了一条父线程，这条线程在IntVal中存储了一个值为10的Integer对象，
 *父线程之后创建了一条子线程，这条线程访问intVal并取得父线程中的Integer对象。
 */
public class LessionFour4 {
	
	private static final InheritableThreadLocal<Integer> intVal = new InheritableThreadLocal<Integer>();

	public static void main(String[] args) {
		Runnable rP = ()->{
			intVal.set(new Integer(10));
			Runnable rC = ()->{
				Thread thd = Thread.currentThread();
				String name = thd.getName();
				System.out.printf("%s%d%n", name,intVal.get());
			};
			Thread thdChild = new Thread(rC);
			thdChild.setName("Child");
			thdChild.start();
		};
		new Thread(rP).start();
	}
}
