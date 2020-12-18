package chap4;

public class Example403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char c = 0; c < 128; c++){
            int i = (int)c;
            if(Character.isLowerCase(c));{
                System.out.println("value:" + i + "character:" + c);
            }
        }
	}

}
