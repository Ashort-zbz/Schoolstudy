package chap7;
//Composition for code reuse

//组合用法的代码复用

class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}

	public String toString() {
		return s;
	}
}

public class Example701 {

	private String value1, value2, value3, value4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;

	public String toString() {
		return "value1 = " + value1 + " " + "value2 = " + value2 + "  " + "value3 = " + value3 + " " + "value4 = "
				+ value4 + "\n" + "i = " + i + " " + "f = " + f + " " + "source = " + source;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Example701 sprinklers = new Example701();
        System.out.println(sprinklers);
	}

}

/*
 * Output: WaterSource() value1 = null value2 = null value3 = null value4 = null
 * i = 0 f = 0.0 source = Constructed
 */
/*
 * 这里的两个类有一个特殊的方法： toString()
 * 当编译器需要一个 String 而你只有一个对象时，该方法 toString() 会自动调用
 * 将对象根据 toString() 中的具体操作装换成 String 类型
 * */