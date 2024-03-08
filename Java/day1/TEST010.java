// TEST010.java

public class TEST010{
	public static void main(String[] args){
		byte a = 127; // -128 ~ 127
		short b = -1; // -32,768 ~ 32,767
		int c = -1; // -2,147,483,648 ~ 2,147,483,647
		long d = -1; // ??
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		float e = 0.1F;
		double f = 0.2;
		System.out.println(e);
		System.out.println(f);
		
	}
}