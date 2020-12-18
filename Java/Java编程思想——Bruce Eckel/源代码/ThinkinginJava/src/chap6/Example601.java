package chap6;

class Sundae{
	private Sundae()  {
		
	}
	static Sundae makeASundae() {
		return new Sundae();
	}
}
public class Example601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//! Sundae x = new Sundae();
		Sundae x = Sundae.makeASundae();
	}

}
