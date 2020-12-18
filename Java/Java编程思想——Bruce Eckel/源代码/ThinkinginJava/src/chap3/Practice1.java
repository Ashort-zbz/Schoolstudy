package chap3;
/*
 * Page:45
 * Question:Dog
 * */

class Dog {
	String name;
	String says;

	void setName(String n) {
		name = n;
	}

	void setSays(String n) {
		says = n;
	}

	void showName() {
		System.out.println(this.name);
	}

	void showSays() {
		System.out.println(this.says);
	}
}

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog spot = new Dog();
		Dog scruffy = new Dog();
		spot.setName("spot");
		spot.setSays("Ruff!");
		scruffy.setName("scruffy");
		scruffy.setSays("Wurf!");
		spot.showName();
		spot.showSays();
		scruffy.showName();
		scruffy.showSays();
		Dog butch = new Dog();
		butch.setName("Butch");
		butch.setSays("Wooo!");
		butch.showName();
		butch.showSays();
		System.out.println("Comparison:");
		System.out.println("spot == butch：" + (spot == butch));
		System.out.println("spot.equals(butch)：" + spot.equals(butch));
		System.out.println();
		System.out.println("Now assign: butch = spot");
		System.out.println();
        butch = spot;
        System.out.println("Comparison again:");
        System.out.println("spot == butch：" + (spot == butch));
        System.out.println("spot.equals(butch)：" + spot.equals(butch));
        spot.showName();
        spot.showSays();
        butch.showName();
        butch.showSays();
	}

}
