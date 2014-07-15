package com.fm.thread;

public class ThreadTest implements Runnable{

	private int myItem;
	private int time;
	
	public ThreadTest(int myItem,int time) {
		super();
		this.myItem = myItem;
		this.time = time;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("-------这是第" + myItem + "线程---------=================" + i + "=================");
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
