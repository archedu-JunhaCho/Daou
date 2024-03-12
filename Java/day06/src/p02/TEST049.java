package p02;

// 클래스는 상속이 1개만 가능
class A {}
class B extends A {}
class C extends B {}
// 인터페이스는 상속이 여러개 가능
interface IA{}
interface IB{}
class E implements IA, IB {}

public class TEST049 {
	public static void main(String[] args) {
		A ac = new C();
	}
}
