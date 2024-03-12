package linkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// setting
		boolean run = true;
		int select = 0;
		// Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);	
        Linked lst = new Linked();
		
		do {
			System.out.println(">> 작업을 선택하세요");
			System.out.println("  1. 추가");
			System.out.println("  2. 삭제");
			System.out.println("  3. 출력");
			System.out.print("  선택 : ");
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
