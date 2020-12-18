package chap5;

class Person{
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler{
	static Apple peel(Apple apple) {
		//...
		return apple;
	}
}

class Apple{
	Apple getPeeled() {
		return Peeler.peel(this);
	}
}
public class Example503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Person().eat(new Apple());
	}
}
