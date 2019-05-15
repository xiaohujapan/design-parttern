package org.dxh.java.thread.lession;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 主线程首先初始化了一个TimerTask的匿名子类，改子类被重写的run()方法输出当前的系统时间
 * 之后默认主程序初始化了Timer并将task作为第一个参数来调用schedule()方法。
 *
 */
public class LessionFour6 {

	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println(System.currentTimeMillis());
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0,1000);
	}

}
