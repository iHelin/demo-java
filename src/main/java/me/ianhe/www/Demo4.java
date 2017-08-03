package me.ianhe.www;

public class Demo4 {
	public void methodA(String str,Integer...is){
		
	}
	
public void methodA(String str,String...is){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo4 dm = new Demo4();
		dm.methodA("China", 0);
		dm.methodA("China", "people");
		//dm.methodA("China");
		String[] str = null;
		dm.methodA("China", str);

	}

}
