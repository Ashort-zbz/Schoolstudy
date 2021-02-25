package chap7;

/*
 * 第三种复用称为代理，Java并没有提供对它的直接支持。这是继承与组合之间的中庸之道
 * 因为我们将一个成员对象置于所要构造的类中（组合），但是于此同时我们在新类中暴露了该成员对象的所有方法（继承）。
 * 例如太空船需要一个控制模块：
 * */

class SpaceShipControls{
	void up(int velocity) {	}
	
	void down(int velocity) { }
	
	void left(int velocity) { }
	
	void right(int velocity) { }
	
	void forward(int velocity) { }
	
	void back(int velocity) { }
	
	void turboBoost() { }
}

//构造太空船的一种方式是使用继承
class SpaceShip extends SpaceShipControls{
	private String name;
	
	public SpaceShip(String name) {this.name = name;}
	
	public String toString() {return name;}
	
}

/*
 * 然而 SpaceShip 并非真正的 SpaceShipControls 类型。
 * 更准确地讲， SpaceShip 包含 SpaceShipControls， 
 * 与此同时， SpaceShipControls 的所有方法都在 SpaceShip 中暴露出来
 * 代理可以解决这样的问题：
 * */
public class Example706 {
	
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
	
	public Example706(String name) {
		this.name = name;
	}
	
	//Example706 methods:
	public void up(int velocity) {
		controls.up(velocity);
	}
	
	public void back(int velocity) {
		controls.back(velocity);
	}
	
	public void down(int velocity) {
		controls.down(velocity);
	}
	
	public void forward(int velocity) {
		controls.forward(velocity);
	}
	
	public void left(int velocity) {
		controls.left(velocity);
	}
	
	public void right(int velocity) {
		controls.right(velocity);
	}
	
	public void turboBoost() {
		controls.turboBoost();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example706 Ship = new Example706("CNSA"); 
	}
}
/*
 * 可以看到，上面的方法是传递给了底层的 controls 对象，而其接口由此也就与使用继承得到的接口相同了
 * 但是，我们使用代理是可以拥有更多的控制力，因为我们可以选择只提供在成员对象中的方法的某个子集
 * 尽管 Java 不直接支持代理，但是很多开发工具都是支持的。如： JetBrains Idea IDE 就可以自动生成上面的例子。
 * */