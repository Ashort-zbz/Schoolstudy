package chap3;

public class Example312 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0, y = 1, z = 2;
		String s = "x, y, z ";
		System.out.println(s + x + y + z);
		System.out.println(x + "" + s);
		s += "summed = ";
		System.out.println("" + x);
	}
}/*
	 * Output: x, y, z 012 
	 * 0x, y, z 
	 * 0
	 */