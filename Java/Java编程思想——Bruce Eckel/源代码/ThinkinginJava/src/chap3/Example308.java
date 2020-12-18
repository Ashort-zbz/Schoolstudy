package chap3;

public class Example308 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i1 = 0x2f;// Hexadecimal(lowercase)
		System.out.println("i1:" + i1);
		System.out.println("i1:" + Integer.toBinaryString(i1));// toBinaryString 返回无符号二进制整数
		int i2 = 0X2F;// Hexadecimal(uppercase)
		System.out.println("i2:" + Integer.toBinaryString(i2));
		int i3 = 0177;// Octal (leading zero)
		System.out.println("i3:" + i3);
		System.out.println("i3:" + Integer.toBinaryString(i3));
		char c = 0xffff; // max char hex value
		System.out.println("c:" + c);
		System.out.println("c:" + Integer.toBinaryString(c));
	}
}/*
	 * Output: 
	 * i1:47 
	 * i1:101111 
	 * i2:101111 
	 * i3:127 
	 * i3:1111111 
	 * c:￿ 
	 * c:1111111111111111
	 */
