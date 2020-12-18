package chap5;

class Window {
	Window(int marker) {
		System.out.println("Window(" + marker + ")");
	}
}

class House {
	Window w1 = new Window(1); // Before constructor

	House() {
		// show that we're in the constructor
		System.out.println("House()");
		w3 = new Window(33);
	}

	Window w2 = new Window(2);

	void f() {
		System.out.println("f()");
	}

	Window w3 = new Window(3);
}

public class Example507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House h = new House();
		h.f();
	}

}/*
	 * Output: 
	 * Window(1) 
	 * Window(2) 
	 * Window(3) 
	 * House() 
	 * Window(33) 
	 * f()
	 */
