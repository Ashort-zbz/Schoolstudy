//名称屏蔽
package chap7;
//如果 Java 的基类拥有某个已被多次重载的方法名称，那么在导出类中重新定义该方法名称并不会屏蔽其在基类中的任何版本
//因此，无论是在该层或者是它的基类中对方法进行定义，重载机制都可以正常工作

class Homer{
    char doh(char c){
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f){
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer {
    void doh(Milhouse m){
        System.out.println("doh(Milhouse)");
    }
}

public class Example709 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
	}
}
/*Output:
 * doh(float)
 * doh(char)
 * doh(float)
 * doh(Milhouse)
 * */

/*
 * 可以看到在 Bart 中 Homer 的所有重载方法都是可用的
 * @Override 租借，可以当作关键字使用。
 * 当你想要覆写某个方法时，可以选择添加这个注解，在你不留心重载而并非覆写了该方法是，编译器就会报错
 * @Override 注解可以防止你在不想重载时而意外地进行了重载：
 * */

//class Lisa extends Homer {
//	@Override void doh(Milhouse m) {
//		System.out.println("doh(Milhouse)");
//	}
//}

//此时编译器就会报错
//The method doh(Milhouse) of type Lisa must override or implement a supertype method