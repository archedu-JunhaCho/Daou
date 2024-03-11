class A {
	int data = 100;
	void print() {
		System.out.println("Fruit Print : " + this.data);
	}
}
class B extends A {
	int data = 200;
}

public class TEST036 {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.data);
		A ab = new B();
		System.out.println(ab.data);
	} 
}