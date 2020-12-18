package chap5;

import java.util.*;

public class Example512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a;
		Random rand = new Random(47);
		a = new int[rand.nextInt(20)];
		System.out.println("length of a = " + a.length);
		System.out.println(Arrays.toString(a));
	}

}/*
	 * Output: 
	 * length of a = 18 
	 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 */
