abstract class Note {
	public abstract void print();
}

class Paper extends Note {
	public void print() {
		System.out.println("Hi");
	}
}


public class TEST039 {
	public static void main(String[] args) {
		Paper p = new Paper();
		p.print();
		
		Note p2 = new Paper();
		p2.print();
	} 
}