package linkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// setting
		boolean run = true;
		int select = 0;
		// Scanner ��ü ����
        Scanner scanner = new Scanner(System.in);	
        Linked lst = new Linked();
		
		do {
			System.out.println(">> �۾��� �����ϼ���");
			System.out.println("  1. �߰�");
			System.out.println("  2. ����");
			System.out.println("  3. ���");
			System.out.print("  ���� : ");
	        select = scanner.nextInt();
			switch(select) {
			case 1:
				lst.add();
				break;
			case 2:
				lst.del();
				break;
			case 3:
				lst.print();
				break;
			default:
				run = false;
				break;
			}
		} while(run);
	}
}
