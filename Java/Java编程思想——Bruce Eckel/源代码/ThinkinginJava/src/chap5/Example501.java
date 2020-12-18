package chap5;

public class Example501 {
	Example501(int i) {// This is the constructor
		System.out.println("Rock" + i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			new Example501(i);
		}
	}
}/*
	 * Output: Rock0 Rock1 Rock2 Rock3 Rock4 Rock5 Rock6 Rock7 Rock8 Rock9
	 * 
	 */
