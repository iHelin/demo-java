package me.ianhe.patten;

/**
 * 单例模式
 * 
 * @author iHelin
 *
 */

public class Singleton {

	public static void main(String[] args) {
		Singleton a = getInstance();
		Singleton b = getInstance();
		System.out.println(a == b);
	}

	private static Singleton instance = null;

	private Singleton() {

	}

	/* 静态工程方法，创建实例，非线程同步的 */
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	public Object readResolve() {
		return instance;
	}
}
