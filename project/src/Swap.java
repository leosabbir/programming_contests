

public class Swap {
	public static void main(String[] args) {
		int x = 5, y = 10;
		
		x = x ^ y ^ (y=x);
		System.out.println(x + " " + y);
		
		char a = 'b', b = 'm';
		//a = a ^ b ^ (b=a);
	}
}
