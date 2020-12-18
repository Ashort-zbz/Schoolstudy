package chap3;

import java.util.Random;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int coin = rand.nextInt();
		if (coin % 2 == 0) {
			System.out.println("正面");
		} else {
			System.out.println("反面");
		}
	}
}/*
	 * Output: 
	 * 正面/反面 
	 * 因为随机数随时间变化而变化，所以每次运行结果不同
	 */
