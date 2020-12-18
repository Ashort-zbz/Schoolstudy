package chap5;

public class Example502 {
	int height;

	Example502() {
		System.out.println("Planting a seeding");
		height = 0;
	}

	Example502(int i) {
		height = i;
		System.out.println("Creating new Tree that is " + height + "feet tall");
	}

	void info() {
		System.out.println("Tree is " + height + "feet tall");
	}

	void info(String s) {
		System.out.println(s + ": Tree is " + height + " feet tall");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			Example502 t = new Example502(i);
			t.info();
			t.info("overloaded method");
		}
		System.out.println();
		new Example502();
	}
}/*
	 * Output:
	 * Creating new Tree that is 0feet tall 
	 * Tree is 0feet tall 
	 * overloaded method: Tree is 0 feet tall 
	 * Creating new Tree that is 1feet tall 
	 * Tree is 1feet tall 
	 * overloaded method: Tree is 1 feet tall 
	 * Creating new Tree that is 2feet tall 
	 * Tree is 2feet tall 
	 * overloaded method: Tree is 2 feet tall 
	 * Creating new Tree that is 3feet tall 
	 * Tree is 3feet tall 
	 * overloaded method: Tree is 3 feet tall 
	 * Creating new Tree that is 4feet tall 
	 * Tree is 4feet tall 
	 * overloaded method: Tree is 4 feet tall
	 * 
	 * Planting a seeding
	 */
