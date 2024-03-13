package p01;

class Banana <T> {
	T temp = null;
}

public class TEST054 {
	public static void main(String[] args) {
		Banana<String> b = new Banana<String>();
		b.temp = "Hello World";
		System.out.println(b.temp);
	}
}
