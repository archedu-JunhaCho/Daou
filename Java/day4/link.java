import java.util.Scanner;
import java.io.IOException;

class Node {
	// declare
	int data;
	Node next, before;
	// init
	Node(){
		this.data = 0;
		this.next = null;
		this.before = null;
	}
}

class LinkedList {
	// declare
	int len; 
	String name;
	Node head, tail, tmp;

	// init
	LinkedList(String str) {
		name = str;
		System.out.println("\n================================");
		System.out.println("\n  < Linked List Create >\n");
		System.out.println("  Name : " + name);
		System.out.println("\n================================");
		this.len = 0;
		this.head = null;
		this.tail = null;
		this.tmp = new Node();
	}
	
	// add one node
	void add_node(int value) {
		System.out.println("\n==============================");
		System.out.println("\n  < Success : Add node >");
		System.out.println("\n==============================");
		Node nd = new Node();
		nd.data = value;
		// head tail setting
		if (head != null) {
			nd.before = tail;
			tail.next = nd;
			tail = nd;
		}
		else {
			head = nd;
			tail = nd;
		}
		this.len++;
	}
	
	// del one node
	void del_node(int idx) {
		// error
		if (len < 1) {
			System.out.println("  Fail : 0 node");
			return;
		}
		if (idx >= len || idx < 0) {
			System.out.println("  Fail : out of range ");
			return;
		}
		// delete
		link.console_clear();
		System.out.println("\n===============================");
		System.out.println("\n  < Success : Del node >");
		System.out.println("\n===============================");
		// head tail setting
		if (idx == 0) {
			//// 1. first
			if(len == 1) {
				// if all clear
				head = null;
				tail = null;
			}
			else {
				head.next.before = null;
				head = head.next;
			}
		}
		else if (idx == len-1) {
			//// 2. last
			tmp = tail;
			tail.before.next = null;
			tail = tail.before;
		}
		else {
			//// 3. between
			tmp = head;
			for (int i = 0; i < idx; i++){
				tmp = tmp.next;
			}
			tmp.before.next = tmp.next;
			tmp.next.before = tmp.before;
		}
		this.len--;
	}
	
	// print all node
	void print_node() {
		// error
		if (head == null) {
			System.out.println("  Fail : 0 node");
			return;
		}
		// print
		boolean run = true;
		System.out.println("\n  >> Name : " + len);
		System.out.println("  >> Length : " + len);
		tmp = head;
		for (int i = 1; run; i++) {
			System.out.printf("  |%2d) ", i);
			System.out.printf("data: %-4d", tmp.data);
			System.out.printf(" / now: %-24s", tmp);
			System.out.printf(" / B: %-24s", tmp.before);
			System.out.printf(" / N: %-24s\n", tmp.next);
        if (tmp.next == null) {
				run = false;
			}
			tmp = tmp.next;
		}
	}
	
	// print all node for Desc
	void print_node_desc() {
		// error
		if (tail == null) {
			System.out.println("  Fail : 0 node");
			return;
		}
		// print
		boolean run = true;
		System.out.println("\n  >> Name : " + len);
		System.out.println("  >> Length : " + len);
		tmp = tail;
		for (int i = 0; run; i++) {
			System.out.printf("  |%2d) ", len - i);
			System.out.printf("data: %-4d", tmp.data);
			System.out.printf(" / now: %-24s", tmp);
			System.out.printf(" / B: %-24s", tmp.before);
			System.out.printf(" / N: %-24s\n", tmp.next);
        if (tmp.before == null) {
				run = false;
			}
			tmp = tmp.before;
		}
	}
}

public class link {
	public static void main(String[] args) {
		// I/O setting
		Scanner scanner = new Scanner(System.in);
		// declare
		int select = 0, tmp_data;
		boolean run = true;
		String tmp_name;
		LinkedList ll = null;
		
		// program start
		console_clear();
		do {
			System.out.println("\n  <��ũ�� ����Ʈ ����>  \n");
			System.out.println("  1. ����Ʈ ����");
			System.out.println("  2. ��� �߰�");
			System.out.println("  3. ��� ����");
			System.out.println("  4. ����Ʈ ��� (asc)");
			System.out.println("  5. ����Ʈ ��� (desc)");
			System.out.print("\n  �۾��� �����ϼ���: ");
			while (!scanner.hasNextInt()) {
				String input = scanner.nextLine();
				if (input.trim().isEmpty()) {
					System.out.println("  �����̳� �� ���� ������ �ʽ��ϴ�. ������ �Է��ϼ���.");
					System.out.print("\n  �۾��� �����ϼ���: ");
				} else {
					System.out.println("  ������ �Է��ϼ���.");
					System.out.print("\n  �۾��� �����ϼ���: ");
				}
			}
			select = scanner.nextInt();
			
			switch (select) {
				case 1:
					console_clear();
					System.out.println("\n  ����Ʈ ����");
					System.out.print("\n  ������ ����Ʈ �̸��� �Է��ϼ��� : ");
					scanner.nextLine();
					tmp_name = scanner.nextLine();
					console_clear();
					ll = new LinkedList(tmp_name);
					break;
				case 2:
					console_clear();
					System.out.println("\n  ��� �߰�");
					if (check_init(ll) != 0) {
						System.out.print("\n  �߰��� ����� ���� �Է��ϼ��� : ");
						scanner.nextLine();
						tmp_data = scanner.nextInt();
						console_clear();
						ll.add_node(tmp_data);
					}
					break;
				case 3:
					console_clear();
					System.out.println("\n  ��� ����");
					if (check_init(ll) != 0) {
						System.out.print("\n  ������ ����� �ε����� �Է��ϼ��� : ");
						scanner.nextLine();
						tmp_data = scanner.nextInt();
						ll.del_node(tmp_data);
					}
					break;
				case 4:
					console_clear();
					System.out.println("\n  ����Ʈ ��� (asc)");
					if (check_init(ll) != 0) {
						ll.print_node();
					}
					break;
				case 5:
					console_clear();
					System.out.println("\n  ����Ʈ ��� (desc)");
					if(check_init(ll) != 0) {
						ll.print_node_desc();
					}
					break;
				default:
					console_clear();
					System.out.println("\n  �ý��� ����");
					run = false;
					break;
			}
		} while(run);
	}
	
	static void console_clear() {
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	static int check_init(LinkedList ll) {
		if (ll == null) {
			System.out.println("  Fail : please init first");
			return 0;
		}
		else {
			return 1;
		}
	}
}