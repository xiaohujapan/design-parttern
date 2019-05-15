package org.dxh.java.thread.lession;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 默认主线程首先初始化了一个TimerTask的匿名子类，由于程序奥等到非守护任务执行线程终止后才能终止
 * 所以这个子类被重写的run()方法会在输出一条警告信息后执行System.exit(0);，然后默认主线程初始化了Timer，
 * 然后用task作为第一个参数调用timer的schedule()方法，由此第2个参数使得任务经过2000毫秒的初始延时之后执行一次
 */
public class LessionFour5 {

	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("alarm going off");
				System.exit(0);
			}
		};
		Timer timer = new Timer();
		System.out.println("start!");
		timer.schedule(task, 2000);
		System.out.println("end!");
	}

}
