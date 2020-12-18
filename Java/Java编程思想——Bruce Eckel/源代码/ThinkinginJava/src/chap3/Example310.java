package chap3;

import java.util.*;

public class Example310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = -1;
//		System.out.println(Integer.toBinaryString(i));
//		i >>>= 10;
//		System.out.println(Integer.toBinaryString(i));
//		long l = -1;
//		System.out.println(Long.toBinaryString(l));
//		l >>>= 10;
//		System.out.println(Long.toBinaryString(l));
//		short s = -1;
//		System.out.println(Integer.toBinaryString(s));
//		s >>>= 10;
//		System.out.println(Integer.toBinaryString(s));
		Random rand = new Random(47);
		int i = rand.nextInt();
		int j = rand.nextInt();
		System.out.println("-1:" + Integer.toBinaryString(-1));
		System.out.println("+1:" + Integer.toBinaryString(1));
		int maxpos = 2147483647; // int型数上限，带符号位
		System.out.println("maxpos:" + Integer.toBinaryString(maxpos));
		int maxneg = -2147483648;// int型数下线，带符号位
		System.out.println("maxneg:" + Integer.toBinaryString(maxneg));
		System.out.println("i:" + i);
		System.out.println("i:" + Integer.toBinaryString(i));
		System.out.println("~i:" + Integer.toBinaryString(~i));
		System.out.println("-i:" + Integer.toBinaryString(-i));
		System.out.println("j:" + j);
		System.out.println("j:" + Integer.toBinaryString(j));
		System.out.println("i & j:" + Integer.toBinaryString(i & j));
		System.out.println("i | j:" + Integer.toBinaryString(i | j));
		System.out.println("i ^ j:" + Integer.toBinaryString(i ^ j));
		System.out.println("i << 5:" + Integer.toBinaryString(i << 5));
		System.out.println("i >> 5:" + Integer.toBinaryString(i >> 5));
		System.out.println("(~i) >> 5:" + Integer.toBinaryString((~i) >> 5));
		System.out.println("i >>> 5:" + Integer.toBinaryString(i >>> 5));
		System.out.println("(~i) >>> 5:" + Integer.toBinaryString((~i) >>> 5));
	}
}/*
	 * Output1: 
	 * 11111111111111111111111111111111 
	 * 1111111111111111111111
	 * 1111111111111111111111111111111111111111111111111111111111111111
	 * 111111111111111111111111111111111111111111111111111111
	 * 11111111111111111111111111111111 
	 * 11111111111111111111111111111111
	 */
/*
 * Output2: 
 * -1:11111111111111111111111111111111 
 * +1:1
 * maxpos:1111111111111111111111111111111
 * maxneg:10000000000000000000000000000000 
 * i:-1172028779
 * i:10111010001001000100001010010101
 * ~i:1000101110110111011110101101010 
 * -i:1000101110110111011110101101011
 * j:1717241110
 * j:1100110010110110000010100010110 
 * i & j:100010000000000000000000010100 
 * i | j:11111110011111110100011110010111 
 * i ^ j:11011100011111110100011110000011 
 * i << 5:1000100100010000101001010100000 
 * i >> 5:11111101110100010010001000010100
 * (~i) >> 5:10001011101101110111101011 
 * i >>> 5:101110100010010001000010100 
 * (~i) >>> 5:10001011101101110111101011
 */
