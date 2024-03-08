class Apple{
	int data = 1;
	
	// 매개변수를 받는 생성자 함수
    Apple(int i) {
		data = i;
    }
	
	// 멤버 함수
	void print(){
		System.out.println( this.data );
	}
}

public class TEST032{
	public static void main(String[] args){
		Apple a = new Apple(1);
		Apple b = new Apple(2);
		Apple c = new Apple(3);
		a.print();
		b.print();
		c.print();
	}
}