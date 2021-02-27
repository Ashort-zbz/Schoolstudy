package chap7;

//同时使用组合和继承是很常见的

class Plate{
    Plate(int i){
        System.out.println("Plate constructor ");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i){
        super(i);
        System.out.println("DinnerPlate constructor ");
    }
}

class Utensil {
    Utensil(int i){
        System.out.println("Utensil constructor ");
    }
}

class Spoon extends Utensil {
    Spoon(int i){
        super(i);
        System.out.println("Spoon constructor ");
    }
}

class Fork extends Utensil {
    Fork(int i){
        super(i);
        System.out.println("Fork constructor ");
    }
}

class Knife extends Utensil {
    Knife(int i){
        super(i);
        System.out.println("Knife constructor ");
    }
}

//A cultural way of doing something
//一种做事的文化方式
class Custom{
    Custom(int i){
        System.out.println("Custom constructor ");
    }
}

public class Example707 extends Custom{

	private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public Example707(int i){
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i +3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        System.out.println("Example707 constructor ");
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example707 x = new Example707(9);
	}
}
/*Output:
 * Custom constructor 
 * Utensil constructor 
 * Spoon constructor 
 * Utensil constructor 
 * Fork constructor 
 * Utensil constructor 
 * Knife constructor 
 * Plate constructor 
 * DinnerPlate constructor 
 * Example707 constructor 
 * */
