package chap5;

class Mug {
	Mug(int marker) {
		System.out.println("Mug(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

public class Example510 {
	Mug m1;
	Mug m2;
	{
		m1 = new Mug(1);
		m2 = new Mug(2);
		System.out.println("m1 & m2 initialized");
	}

	Example510() {
		System.out.println("Mugs");
	}

	Example510(int i) {
		System.out.println("Mugs(int)");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main()");
		new Example510();
		System.out.println("new Mugs() completed");
		new Example510(1);
		System.out.println("new Mugs(1) completed");
	}

}/*
	 * Output: 
	 * Inside main() 
	 * Mug(1) 
	 * Mug(2) 
	 * m1 & m2 initialized 
	 * Mugs 
	 * new Mugs() completed 
	 * Mug(1) 
	 * Mug(2) 
	 * m1 & m2 initialized 
	 * Mugs(int) 
	 * new Mugs(1) completed
	 */
