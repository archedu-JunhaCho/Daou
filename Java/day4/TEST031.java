class Apple{
	int data = 1;
	
	// 매개변수를 받는 생성자 함수
    Apple() {
		System.out.println( "인스턴스 생성. 주소 : " + this );
    }
	
	// 멤버 함수
	void print(){
		System.out.println( this.data );
	}
}

public class TEST031{
	public static void main(String[] args){
		Apple a = new Apple();
		Apple b = new Apple();
		Apple c = new Apple();
		a.print();
		b.print();
		c.print();
		c.print_print();
	}
}