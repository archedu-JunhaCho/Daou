class Apple{
	int a = 100;
	int add(int a, int b){
		return a+b;
	}
}

public class TEST028{
	public static void main(String[] args){
		// Apple.a = 12;
		Apple p = new Apple();
		Apple2 p2 = new TEST028().new Apple2();
		int r = p.add(10, 20);
		
		// p.a = 11;
		System.out.println(r);
		System.out.println(p.a);
		// System.out.println();
	}
	
	class Apple2{
	int a = 100;
	int add(int a, int b){
		return a+b;
	}
}
}