package chap7;

class Soap {
	private String s;

	Soap() {
		System.out.println("Soap()");
		s = "Constructed";
	}

	public String toString() {
		return s;
	}
}

public class Example702 {

	private String s1 = "Happy", s2 = "Happy", s3, s4;		//定义处初始化
	private Soap castille;
	private int i;
	private float toy;

	public Example702() {
		System.out.println("Inside Bath()");
		s3 = "joy";
		toy = 3.14f;
		castille = new Soap();
	}
	
	//实例初始化
	{
		i = 47;
	}

	public String toString() {
		if (s4 == null) {		//惰性初始化
			s4 = "joy";
		}
		return "s1 = " + s1 + "\n" + "s2 = " + s2 + "\n" + "s3 = " + s3 + "\n" + "s4 = " + s4 + "\n" + "i = " + i + "\n"
				+ "toy = " + toy + "\n" + "castille = " + castille + "\n";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example702 b = new Example702();
        System.out.println(b);
	}

}
/*
 * Output: 
 * Inside Bath() 
 * Soap() 
 * s1 = Happy 
 * s2 = Happy 
 * s3 = joy 
 * s4 = joy 
 * i = 47
 * toy = 3.14 
 * castille = Constructed
 * 
 */
/*
 * 编译器不是简单地为每一个引用都创建默认的对象，这样会避免增加不必要的负担
 * 如果要初始化这些引用，可以在下列位置进行：
 * 1.在定义对象的地方。这意味着它们总是能在构造器被调用之前被初始化。
 * 2.在构造器中
 * 3.在正要使用这些对象之前，这种方式成为惰性初始化。在生成对象不值得及不必每次都生成对象的情况下，这种方式可以 减少额外的负担
 * 4.使用实例初始化。
 * */
 