// 오브젝트
class Test extends Object{
	int data;
	Test(int input) {
		data = input;
	}
	public boolean equals(Object obj) {
		if ( obj instanceof Test ) {
			return ((Test)obj).data == this.data;
		}
		return false;
	}
}

public class TEST044 {
	public static void main(String[] args){		
		Test a = new Test(100);
		System.out.println(a.toString());
		
		Test b = new Test(100);
		System.out.println(b.toString());
		
		System.out.println( a == b );
		System.out.println( a.equals(b) );
		System.out.println( a.data == b.data );
	}
}