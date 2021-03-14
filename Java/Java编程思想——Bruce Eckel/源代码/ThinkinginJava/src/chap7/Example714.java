package chap7;
/*
 * Java 允许生成 “空白 final”，即被声明为 final 但不初始化。
 * 但是要确保 “空白 final” 在使用前必须被初始化
 * “空白 final” 为使用 final 关键字上提供了更大的灵活性
 * 为此，一个类中的 final 域就可以做到根据对象而有所不同，却有保持恒定不变的特性。
 * */

class Poppet{
	private int i;
	public Poppet(int ii) {
		// TODO Auto-generated constructor stub
		this.i = ii;
	}
}

public class Example714 {
	
	private final int i = 0;      //Initialized final
	private final int j;      //Blank final
	private final Poppet p;      //Blank final reference
	//Blank finals MUST be initialized in the constructor:
	
	public Example714() {
		j = 1;
		p = new Poppet(1);
	}
	
	public Example714(int x) {
		j = x;
		p = new Poppet(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Example714();
		new Example714(2);
	}
}
/*
 * 必须在 final 域的定义处或者每个构造器中对其进行初始化。
 * */
 