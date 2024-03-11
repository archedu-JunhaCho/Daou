class parent {
	private int a = 10;
	protected int b = 20;
	public int c = 30;
	
	private int data = 100;
	int getData() {
		return data;
	}
}

class child extends parent {
	// int a_copy = a;
	int b_copy;
	int c_copy;
	child() {
		b_copy = b;
		c_copy = c;
	}
	
	private int data = 200;
	int getData() {
		return data;
	}
	
}

public class TEST037 {
	public static void main(String[] args) {
		parent sample = new parent();
		child sample2 = new child();
		
		parent sample3 = new child();
		System.out.println(sample3.getData());
	} 
}