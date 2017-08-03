package me.ianhe.test;

public class NineNine {

	public static void main(String[] args) {
		for (int j = 1; j < 10; j++) {
			for (int k = 1; k <= j; k++) { // 老师的做法，判断语句里的 k<=j，省去下列的if语句。
				System.out.print(k + "*" + j + "=" + j * k + " ");
			}
			System.out.println();
		}
	}

}
