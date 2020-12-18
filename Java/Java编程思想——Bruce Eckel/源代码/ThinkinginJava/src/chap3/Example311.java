package chap3;

public class Example311 {
	static int ternary(int i) {
		return i < 10 ? i * 100 : i * 10;
	}

	// 如果编写方法，建议使用三元操作符，根据代码规范，函数有两个出口是不合格的！！！
	static int standardIfElse(int i) {
		if (i < 10)
			return i * 100;
		else
			return i * 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ternary(9));
		System.out.println(ternary(10));
		System.out.println(standardIfElse(9));
		System.out.println(standardIfElse(10));
	}
}/*
	 * Output: 
	 * 900 
	 * 100 
	 * 900 
	 * 100
	 */
