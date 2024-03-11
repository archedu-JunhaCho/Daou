class Fruit {
	String typ;
	
	Fruit() {
		this.typ = "None";
	}
	
	void print() {
		System.out.println("Fruit type : " + typ);
	};
}
class Apple extends Fruit {
	String name;
	
	Apple() {
		this.name = "apple";
	}
	
	void print2() {
		System.out.println("Apple name : " + name);
	};
}
class Banana {
	String name;
}

public class TEST033 {
	public static void main(String[] args) {
		Fruit f1 = new Fruit();
		f1.print();
		
		Apple a1 = new Apple();
		a1.print();
		a1.print2();
		
		Fruit f2 = new Apple();
		f2.print();
	} 
}