package p02;

// Ŭ������ ����� 1���� ����
class A {}
class B extends A {}
class C extends B {}
// �������̽��� ����� ������ ����
interface IA{}
interface IB{}
class E implements IA, IB {}

public class TEST049 {
	public static void main(String[] args) {
		A ac = new C();
	}
}
