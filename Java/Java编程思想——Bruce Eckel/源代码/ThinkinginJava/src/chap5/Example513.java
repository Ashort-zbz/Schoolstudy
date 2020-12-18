package chap5;

import java.util.*;

public class Example513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(47);
		Integer[] a = new Integer[rand.nextInt(20)];
		System.out.println("length of a = " + a.length);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(500);
		}
		System.out.println(Arrays.toString(a));
	}

}/*
	 * Output: 
	 * length of a = 18 
	 * [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null] 
	 * [55, 193, 361, 461, 429, 368, 200, 22, 207, 288, 128, 51, 89, 309, 278, 498, 361, 20]
	 */
