// 
class A {
	// A() {
		// System.out.println("Start A");
	// }
	A(int a) {
		System.out.println("Start A and " + a);
	}
}
class B extends A {
	B() {
		super(100);
		System.out.println("Start B");
	}
}


public class TEST046 {
	public static void main(String[] args){		
		A a = new A(10);
		System.out.println("------------------------");
		B b = new B();
	}
}