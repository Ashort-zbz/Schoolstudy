// initialization/TankTest.java
// TIJ4 Chapter Initialization, Exercise 12, page 177
/* Create a class called Tank that can be filled and emptied, and has a
* termination condition that it must be empty when the object is cleaned up.
* Write a finalize() that verifies this termination condition. In main(), test
* the possible scenarios that can occur whtn your Tank is used.
*/
//未被注释掉的是标准答案
package chap5;

//class Tank{
//    boolean state = false;//状态值， true为满，false为空
//    Tank(boolean s){
//        state = s;
//    }
//    void action(){
//        state = true;
//    }
//    protected void finalize(){
//        if(!state){
//            System.out.println("Error: not empty!");
//        }
//    }
//}

class Tank {
	int howFull = 0;

	Tank() {
		this(0);
	}

	Tank(int fullness) {
		howFull = fullness;
	}

	void sayHowFull() {
		if (howFull == 0) {
			System.out.println("Tank is empty");
		} else {
			System.out.println("Tank filling status = " + howFull);
		}
	}

	void empty() {
		howFull = 0;
	}

	protected void finalize() {
		if (howFull != 0) {
			System.out.println("Error: Tank not empty");
			// Normally, you'll also do this:
			// super.finalize(); //Call the base-class version
		}
	}
}

public class Practice512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Tank t1 = new Tank(false);
//        t1.action();
//        new Tank(false);
//        System.gc();
		Tank t1 = new Tank();
		Tank t2 = new Tank(3);
		Tank t3 = new Tank(5);
		t2.empty();
		new Tank(6);
		System.out.println("Check tanks:");
		System.out.println("t1:");
		t1.sayHowFull();
		System.out.println("t2:");
		t2.sayHowFull();
		System.out.println("t3:");
		t3.sayHowFull();
		System.out.println("first forced gc(): ");
		System.gc();
		System.out.println("try deprecated runFinalizerOnExit(true): ");
		System.runFinalization();
		/*
		 * 答案中的runFinalizersOnExit() 方法已被废弃 runFinalization()
		 * 运行任何未完成的对象的终结方法。调用此方法表明，Java虚拟机将花更多的精力来运行finalize已发现被丢弃但其finalize
		 * 方法尚未运行的对象的方法。
		 */
		System.out.println("last forced gc(): ");
		System.gc();
	}

}/*
	 * Output: 
	 * Check tanks: 
	 * t1: 
	 * Tank is empty 
	 * t2: 
	 * Tank is empty 
	 * t3: 
	 * Tank filling status = 5 
	 * first forced gc(): 
	 * try deprecated runFinalizerOnExit(true): 
	 * Error: Tank not empty 
	 * last forced gc():
	 */
