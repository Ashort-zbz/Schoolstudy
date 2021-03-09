package chap7;
//Composition with public objects.
/*
 * 组合和继承都允许在新的类中放置子对象，两者的区别在哪，又该在二者之间如何选择？
 * 组合技术通常用于想在新类中使用现有类的功能而非它的接口。即，在新类中嵌入某个对象，让其实现所需要的功能，
 * 但新类的用户看到的只是为新类所定义的接口，而非所嵌入对象的接口。为取得此效果，要在新类中嵌入一个现有类的 private 对象
 * 但是也有特殊情况，将成员对象声明为 public
 * */

class Engine{
	public void start() {};
	public void rev() {};
	public void stop() {};
}

class Wheel{
	public void inflate(int psi) {};
}

class Window{
	public void rollup() {};
	public void rolldown() {};
}

class Door{
	public Window window = new Window();
	public void open() {};
	public void close() {};
}


public class Example710 {
	
	public Engine engine = new Engine();
	public Wheel[] wheel = new Wheel[4];
	public Door
		left = new Door(),
		right = new Door();
	
	public Example710() {
		for(int i = 0; i<4; i++) {
			wheel[i] = new Wheel();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example710 car = new Example710();
		car.left.window.rollup();
		car.wheel[0].inflate(72);
	}

}
/*
 *由于这个例子中 car 的组合也是问题分析的一部分，所以让成员对象成为 public 将有助于客户端程序员了解怎样去使用类 
 * 但是务必要记得这仅仅是一个特例，一般情况下应使域成为 private
 * */

/*
 *在继承时，使用某个现有的类，并开发它的特殊版本。
 *通常这意味着你在使用一个通用类，并为了某种特殊需要而将其特殊化。 
 *例如，用一个“交通工具”对象来构成一部“车子”是毫无意义的，
 *因为“车子”并不包含“交通工具”，它仅是一种交通工具（is-a 关系）。
 * “is-a”（是一个）的关系是用继承来表达的，而“has-a”（有一个）的关系使用组合来表达的。
 * */
