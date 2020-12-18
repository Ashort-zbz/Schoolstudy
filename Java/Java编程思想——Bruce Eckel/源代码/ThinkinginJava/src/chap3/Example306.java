package chap3;

class Value{
	int i;
}
public class Example306 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 9;
		int n2 = 9;
		System.out.println(n1 == n2);
		System.out.println(n1 != n2);
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s1 != s2);
		System.out.println(s1.equalsIgnoreCase(s2));
		
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i=v2.i=10;
		System.out.println(v1.equals(v2));
	}
}/*Output:
*true
*false
*false
*true
*true
*false
*/
