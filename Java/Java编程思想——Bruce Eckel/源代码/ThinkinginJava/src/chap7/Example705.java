package chap7;

//不带参数的构造器称为默认构造器，编译器可以轻松地调用它们是因为不必要考虑要传递什么样的参数
//如果没有默认的基类构造器，或者想调用一个带参数的基类构造器，就必须用关键字 super 显式地编写调用基类构造器的语句

class Game{
	Game(int i){
		System.out.println("Game constructor.");
	}
}

/*如果在 BoardGame 中不用显式地编写调用基类构造器的语句，eclipse 会报错：
 * Implicit super constructor Game() is undefined for default constructor. 
 * Must define an explicit constructor
*/
class BoardGame extends Game {
	BoardGame(int i){
		super(i);
		System.out.println("BoardGame constructor.");
	}
}
public class Example705  extends BoardGame{

	Example705(){
		super(11);
		System.out.println("Example705 constructor.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example705 x = new Example705();
	}
}
/*
 * Output:
 * Game constructor.
 * BoardGame constructor.
 * Example705 constructor.
 * */
/*
 *调用基类构造器必须是在导出类构造器中要做的第一件事。 
 * */
