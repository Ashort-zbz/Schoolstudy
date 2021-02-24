package chap7;

class Cleanser{
	private String s = "Cleanser";
	public void append(String a) {
		s += a;
	}
	
	public void dilute() {
		append(" dilute()");
	}
	
	public void apply() {
		append(" apply()");
	}
	
	public void scrub() {
		append(" scrub");
	}
	
	public String toString() {
		return s;
	}
	
	//每个类都有一个 main 方法，便于测试程序
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x);
	}
}

public class Example703 extends Cleanser {

	//
	//Change a method:
	public void scrub() {
		append("Example703.scrub()");
		//super 关键字表示超类的意思，当前类就是从超类继承来的。
		super.scrub();		//调用基类版本
	}
	
	//在继承的过程中，并非一定使用基类的方法，也可以在导出类中添加新的方法
	public void foam() {
		append("foam()");
	}
	
	//测试这个新类
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("测试这个新类");
		Example703 x = new Example703();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("测试基类");
		Cleanser.main(args);
	}

}
/*OUtput:
 * 测试这个新类
 * Cleanser dilute() apply()Example703.scrub() scrubfoam()
 * 测试基类
 * Cleanser dilute() apply() scrub
 * */
