package chap3;

public class Example314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double above = 0.7, below = 0.4;
		float fabove = 0.7f, fbelow = 0.4f;
		System.out.println("(int)above:" + (int) above);
		System.out.println("(int)below:" + (int) below);
		System.out.println("(int)fabove:" + (int) fabove);
		System.out.println("(int)fbelow:" + (int) fbelow);
		System.out.println("Math.round(above):" + Math.round(above));
		System.out.println("Math.round(below):" + Math.round(below));
		System.out.println("Math.round(fabove):" + Math.round(fabove));
		System.out.println("Math.round(fbelow):" + Math.round(fbelow));
	}
}/*
	 * Output: 
	 * (int)above:0 
	 * (int)below:0 
	 * (int)fabove:0 
	 * (int)fbelow:0
	 * Math.round(above):1 
	 * Math.round(below):0 
	 * Math.round(fabove):1
	 * Math.round(fbelow):0
	 */
