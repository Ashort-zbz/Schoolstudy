package chap7;
/*
 * 编程语言都有某种方法，向编译器告知这块数据时恒定不变的。
 * Java中，这类常量必须是基本数据类型，并且是以关键字 final 表示。
 * 在对常量定义的时候，必须对其进行赋值。
 * 一个既是 static 有时 final 的域只占据一段不能改变的存储空间
 * 当对象引用运用 final 时，引用恒定不变。
 * 一旦引用被初始化指向一个对象，就无法再把它改为指向另一个对象。但是，对象自身却是可以被修改的。
 * */
//The effect of final on fields

import java.util.*;

class Value{
	int i; //Package access
	public Value(int i) {
		this.i = i;
	}
}

public class Example713 {
	private static Random rand = new Random(47);
	private String id;
	public Example713(String id) {
		this.id = id;
	}
	
	//Can be compile-time constants:
	
	private final int valueOne = 9;
	private static final int VALUE_THREE = 39;
	
	//Cannot be compile-time constants
	
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	//Arrays:
	private final int[] a = {1,2,3,4,5,6};
	
	public String toString() {
		return id + ":" + "i4 =" + i4 + ", INT_5 =" + INT_5;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example713 fd1 = new Example713("fd1");
		//! fd1.valueOne++;  //Error:can't change value
		fd1.v2.i++;  //Object isn't constant!
		fd1.v1 = new Value(9); //OK, not final
		for(int i = 0; i<fd1.a.length; i++) {
			fd1.a[i]++;  //Object isn't constant!
		}
		//! fd1.v2 = new Value(0); //Error: Can't
		//! fd1.VAL_3 = new Value(1); //change reference
		//! fd1.a = new int[3];
		
		System.out.println(fd1);
		System.out.println("Creating new Example713");
		Example713 fd2 = new Example713("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}
/*Output:
 * fd1:i4 =15, INT_5 =18
 * Creating new Example713
 * fd1:i4 =15, INT_5 =18
 * fd2:i4 =13, INT_5 =18
 * */
/*
 * 注意，在 fd1 和 fd2 中，i4的值是唯一的，但INT_5的值是不可以通过创建第二个 Example713 对象而加以改变的，因为它是 static 的。
 * 不能因为某个数据时 final 的就认为在编译时可以知道它的值。在运行时使用随机生成的数值来初始化 i4 和 INT_5 就说明这一点。
 * 在 fd1 和 fd2 中， i4 的值是唯一的， 但 INT_5 的值是不可以通过创建第二个 Example713 对象而加以改变的。因为它是 static 的，在装载时已被初始化
 * 看起来， 使引用成为 final 没有使基本类型成为 final 用处大
 * */