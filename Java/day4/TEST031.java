class Apple{
	int data = 1;
	
	// �Ű������� �޴� ������ �Լ�
    Apple() {
		System.out.println( "�ν��Ͻ� ����. �ּ� : " + this );
    }
	
	// ��� �Լ�
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