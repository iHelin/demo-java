package com.ihelin.test;

public class Child extends Person1 {

	public String grade;
	
	public Child(){
		//super();
		System.out.println("Child");
	}

	public static void main(String[] args) {
		Person1 p = new Child();
	}
}
