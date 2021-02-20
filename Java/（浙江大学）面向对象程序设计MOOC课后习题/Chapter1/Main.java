import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(), in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5, 6)).print();
		a.print();
		b.print();
		in.close();
	}
}

class Fraction {
	int Mole = 0;// 分子
	int Deno = 0;// 分母
	// 构造函数

	Fraction(int a, int b) {
		int red = reduce(a, b);
		if (red == 0) {
			Mole = a;
			Deno = b;
		} else {
			a /= red;
			b /= red;
			Mole = a;
			Deno = b;
		}
	}

	// 将分数转换为double
	public double toDouble() {
		double res = 0;
		/*
		 * 如果直接处会得到 0，因为是两个 int 型变量相除，JVM会自动进行取整操作 将分子或分母中一个数转化成double型数即可
		 */
		res = Double.valueOf(this.Mole) / this.Deno;
		return res;
	}

	// 将自己的分数和r的分数相加，产生一个新的Fraction的对象。
	public Fraction plus(Fraction r) {
		int coDeno = this.Deno * r.Deno;
		int coMole = (this.Mole * r.Deno) + (r.Mole * this.Deno);
		Fraction res = new Fraction(coMole, coDeno);
		return res;
	}

	// 将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
	public Fraction multiply(Fraction r) {
		int coDeno = this.Deno * r.Deno;
		int coMole = this.Mole * r.Mole;
		Fraction res = new Fraction(coMole, coDeno);
		return res;
	}

	// 将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。
	// 如果分数是1/1，应该输出1。
	// 当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
	public void print() {
		if (this.Mole == this.Deno) {
			System.out.println(this.Mole + "/" + this.Deno + "=1");
		} else {
			System.out.println(this.Mole + "/" + this.Deno);
		}
	}

	// 求出最大公倍数，以化简初始分数
	public int reduce(int a, int b) {
		int c = 0;
		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}