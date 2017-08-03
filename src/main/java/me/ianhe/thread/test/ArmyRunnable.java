package me.ianhe.thread.test;

//军队线程
public class ArmyRunnable implements Runnable {

	//volatile线程保证了线程可以正确的读取其他线程写入的值
	//可见性 ref JMM,happens-before原则 
	volatile boolean keepRunning = true;
	volatile int count = 0;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始了战斗！");
		while (keepRunning) {
			//发动5连击
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "进攻对方[" + (i+1) + "]");
				count++;
				//让出处理器时间，下次该谁进攻还不一定呢！
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"一共攻击了"+count+"次");
		System.out.println(Thread.currentThread().getName()+"结束了战斗！");
	}

}
