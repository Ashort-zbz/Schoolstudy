package chap7;
//7.7 向上转型
/*
 * “为新的类提供方法”并不是继承技术中最重要的方面，其最重要的方面使用来表现新类和基类之间的关系。
 * 这种关系可以用“新类是现有类的一种类型”这句话加以概括。
 * */

class Instrument{
	public void play() {}
	static void tune(Instrument i) {
		//...
		i.play();
	}
}

public class Example712 extends Instrument{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example712 flute = new Example712();
		Instrument.tune(flute); //Upcasting 向上转型
	}
}
/*
 * 在这个例子当中，tune() 方法可以接受 Instrument 引用。
 * 但是在 Example712.main() 中，传递给 tune() 方法的是一个 Example712 引用。
 * 其实 Example712 对象同样也是一种 Instrument 对象，而且也不存在任何 tune() 方法是可以通过 Instrument 来调用，同时又不存在于 Example712 中。
 * 在 tune() 中，程序代码可以对 Instrument 和它所有导出类起作用，这种将 Example712 引用转换为 Instrument 引用的动作，称之为向上转型。
 * */
