class Fruit {
	int data;
	void print() {
		System.out.println("Fruit Print : " + this.data);
	}
}
class Apple extends Fruit {
	void print() {
		System.out.println("Overriding");
	}
	void print2() {
		System.out.println("Apple Print : ");
	}
}

public class TEST035 {
	public static void main(String[] args) {
		Fruit f1 = new Fruit();
		Apple a1 = new Apple();
		Fruit f2 = new Apple();
		a1.print();
		f2.print();
	} 
}