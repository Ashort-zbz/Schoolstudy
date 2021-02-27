//Ensuring proper cleanup
//确保适当的清理
package chap7;

/*
 * 有时类可能要在其生命周期内执行一些必须的清理活动
 * 如果你想要某个类清理一些东西，就必须显式地编写一个特殊方法来做这些事
 * 并且要确保客户端程序员知晓他们必须要调用这一方法
 * 
 * 这个程序要用 debug 一步一步看具体的进行过程，可以深刻理解继承的运作
 * */

class Shape{
    Shape(int i){
        System.out.println("Shape constructor ");
    }

    void dispose(){
        System.out.println("Shape dispose. ");
    }
}

class Circle extends Shape {
    Circle(int i){
        super(i);
        System.out.println("Circle constructor ");
    }

    void dispose(){
        System.out.println("Erasing Circle. ");     //擦除圆
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i){
        super(i);
        System.out.println("Drawing Triangle ");
    }

    void dispose(){
        System.out.println("Erasing Triangle ");
        super.dispose();
    }
}

class Line extends Shape{
    private int start, end;
    Line(int start, int end){
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line: " + start + ". " + end);
    }

    void dispose(){
        System.out.println("Erasing Line: " + start + ". " + end);
        super.dispose();
    }
}

public class Example708 extends Shape{

	private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public Example708(int i){
        super(i + 1);
        for(int j = 0; j < lines.length; j++){
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("Combined constructor ");
    }

    public void dispose(){
        System.out.println("Example707.dispose ");
        //The order of cleanup is reverse
        //of the order of initialization:
        //清除顺序与初始化顺序相反:
        t.dispose();
        c.dispose();
        for(int i = lines.length - 1; i >= 0; i--){
            lines[i].dispose();
        }
        super.dispose();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example708 x = new Example708(47);
		try {
			//Code and exception handling...
		}finally {		//这里 finally 子句表示“无论发生什么事，一定要为 x 调用 dispose()
			x.dispose();
		}
	}
}
/*Output:
 * Shape constructor
 * Shape constructor 
 * Drawing Line: 0. 0
 * Shape constructor 
 * Drawing Line: 1. 1
 * Shape constructor 
 * Drawing Line: 2. 4
 * Shape constructor 
 * Circle constructor 
 * Shape constructor 
 * Drawing Triangle 
 * Combined constructor 
 * Example707.dispose 
 * Erasing Triangle 
 * Shape dispose. 
 * Erasing Circle. 
 * Shape dispose. 
 * Erasing Line: 2. 4
 * Shape dispose. 
 * Erasing Line: 1. 1
 * Shape dispose. 
 * Erasing Line: 0. 0
 * Shape dispose. 
 * Shape dispose. 
 * */

/*
 * 在 main() 中可以看到 try 和 finally 之前没有出现过的关键字。
 * 关键字 try 表示下面的块是所谓的保护区（guarded region），这意味着它要被特殊处理。
 * 其中一项特殊处理就是无论 try 怎样退出，保护区后 finally 子句中的代码总是要被执行。
 * 
 * 最好的方法是除内存外，不能依赖垃圾回收器做任何事情。
 * 如果需要清理，最好是编写自己的清理方法，但不要使用 finalize()
 * */
