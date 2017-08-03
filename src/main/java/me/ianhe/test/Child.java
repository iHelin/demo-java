package me.ianhe.test;

public class Child extends Person1 {

	public String grade;
	
	public Child(){
		//super();
		System.out.println("Child");
	}
	
	@Override
	public void say(){
		System.out.println("I can say!");
	}

	public static void main(String[] args) {
		Person1 p = new Child();
		p.say();
	}
}
