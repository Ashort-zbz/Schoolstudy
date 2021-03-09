package chap7;
//7.6 protected 关键字
//The protected keyword
/*
 * 在理想世界中，仅靠 private 就已经足够。
 * 但在实际项目中，经常会想要将某些事物尽可能对这个世界隐藏起来，但仍然允许导出类的成员访问他们。 
 * 关键字 protected 就是这个作用。它指明：  
 * 就类用户而言，这是 private的，但是对于任何继承于此类的导出类或其他任何位于同一个包内的类来说，它是可以访问的。（protected 提供了包内访问权限）
 * 尽管可以创建 protected 域，但是最好的方法还是将域保持为 private。
 * 应当一直保留“更改底层实现”的权利。然后通过 protected 方法来控制类的继承者的访问权限
 * */

class Villain{
	private String name;
	protected void set(String nm) {
		name = nm;
	}
	
	public Villain(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "I'm a Villain and my name is " + name;
	}
}
public class Example711 extends Villain{
	
	private int orcNumber;
	public Example711(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	
	public void change(String name, int orcNumber) {
		set(name);
		this.orcNumber = orcNumber;
	}
	
	public String toString() {
		return "Orc " + orcNumber + ":" + super.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example711 orc = new Example711("Lin", 12);
		System.out.println(orc);
		orc.change("Bob", 19);
		System.out.println(orc);
	}
}
/*Output:
 * Orc 12:I'm a Villain and my name is Lin
 * Orc 19:I'm a Villain and my name is Bob
 * */
/*
 * 可以发现，change() 可以访问 set()，因为它是 protected 的。
 * 还应该注意 Example711 的 toString()方法的定义方式，它是依据 toSting 的基类版本定义的
 * */
