interface Fruit {
	public void print();
}

class Apple implements Fruit {
	public void print() {
		System.out.println("|Interface Over");
	}
}

public class TEST041 {
	public static void main(String[] args){
		Apple a = new Apple();
		a.print();
	}
}