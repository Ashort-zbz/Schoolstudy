package chap7;

/*继承并不只是复制基类的接口，当创建了一个导出类的对象时，该对象包含了一个基类的子对象
 * 这个子对象和用基类直接创建的对象是一样的。
 * 二者的区别在，后者来自外部，基类的子对象被包装在导出类对象内部。
 * 对基类子对象的正确初始化显得很重要
 * 只有一种办法来保证这一点：在构造器中调用基类构造器来执行初始化
 * Java会自动在导出类的构造器中插入对基类构造器的调用
 * */

//Constructor calls during inheritance
//继承期间的构造方法调用

class Art{
	Art(){
		System.out.println("Art constructor.");
	}
}

class Drawing extends Art {
	Drawing(){
		System.out.println("Drawing constructor.");
	}
}
public class Example704 extends Drawing {

	public Example704() {
		System.out.println("Example704 constructor.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example704 x = new Example704();
	}

}
/*
 * Output:
 * Art constructor.
 * Drawing constructor.
 * Example704 constructor.
 * */
/*
 * 可以发现，构建过程是从基类“向外”扩散的，所以基类在导出类构造器可以访问它之前，就已经完成了初始化
 * 即使你不为 Example704() 创建构造器，编译器也会为你合成一个默认的构造器，该构造器将调用基类中的构造器。
 * */