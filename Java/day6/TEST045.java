// 
class A {
	
}
class C {
	
}
class B extends A{
	public void print(){
		System.out.println("Hi");
	}
}

public class TEST045 {
	public static void main(String[] args){		
		A ab = new B();
		// ab.print();
		
		B b = (B)ab;
		b.print();
		
		Object c = new C();
	}
}