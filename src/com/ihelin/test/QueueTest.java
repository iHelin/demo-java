package com.ihelin.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		q.add("2");
		q.add("3");
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
	}

}
