package chap5;

public class Example504 {
	int petalCount = 0;
	String s = "initial value";

	Example504(int petals) {
		petalCount = petals;
		System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
	}

	Example504(String ss) {
		System.out.println("Constructor w/ String arg only, s = " + ss);
		s = ss;
	}

	Example504(String s, int petals) {
		this(petals);
		// ! this(s); //Can't call two!
		this.s = s; // Another use of "this"
		System.out.println("String & int args");
	}

	Example504() {
		this("hi", 47);
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}

	void printPetalCount() {
		// ! this(11); //not inside non-constructor!
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example504 x = new Example504();
		x.printPetalCount();
	}
}/*
	 * Output: 
	 * Constructor w/ int arg only, petalCount= 47 
	 * String & int args
	 * petalCount = 47 s = hi 
	 * petalCount = 47 s = hi
	 * 
	 */
