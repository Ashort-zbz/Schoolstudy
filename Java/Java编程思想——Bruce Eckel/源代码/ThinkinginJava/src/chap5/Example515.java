package chap5;

enum S {
	NOT, MILD, MEDIUM, HOT, FLAMING
}

public class Example515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S howHot = S.MEDIUM;
		System.out.println(howHot);

		for (S j : S.values()) {
			System.out.println(j + ", ordinal " + j.ordinal());
		}

		System.out.println("This burrito is ");
		S s = S.HOT;
		switch (s) {
		case NOT:
			System.out.println("not spicy at all.");
			break;
		case MILD:
		case MEDIUM:
			System.out.println("a little hot.");
			break;
		case HOT:
		case FLAMING:
		default:
			System.out.println("maybe too hot.");

		}
	}

}/*
	 * Output: 
	 * MEDIUM 
	 * NOT, ordinal 0 
	 * MILD, ordinal 1 
	 * MEDIUM, ordinal 2 
	 * HOT, ordinal 3 
	 * FLAMING, ordinal 4 
	 * This burrito is 
	 * maybe too hot.
	 */
