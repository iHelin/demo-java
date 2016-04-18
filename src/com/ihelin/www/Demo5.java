package com.ihelin.www;

public class Demo5 {
	public static void main(String[] args) {
		int count = 0;
		for (int i=0;i<10;i++) {
			count = count++;
		}
		System.out.println("count="+count);//输出0
		
		float bugUiOptNum = 0.0F;
		System.out.println(bugUiOptNum);
	}

}
