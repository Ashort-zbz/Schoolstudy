package chap5;

class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		System.out.println("Cups()");
	}
}

public class Example509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main()");
		Cups.cup1.f(99);
	}

}/*
	 * Output: 
	 * Inside main() 
	 * Cup(1) 
	 * Cup(2) 
	 * f(99)
	 */
