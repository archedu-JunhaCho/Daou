#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// 목표 링크드 리스트를 만드는 것을 C에서 객체 지향으로 해보자!
	// 1. 기본형태 구현
	// 2.0 인스턴스 생성 구현
	// 2. 각 구조체 구현
	// 3. 생성자 구현
	// 4. 함수 구현

// 노드
typedef struct node {
	int data;
	struct node *before;
	struct node *next;
} Node;
void node_Construct(Node *node) {
	printf("	Setting Node init\n");
	return;
}
Node *new_node() {
	Node *node;
	node = (Node*)malloc(sizeof(Node));
	
	node_Construct(node);
	
	return node;
};

// 링크드 리스트
typedef struct linked_lst {
	Node *head;
	Node *tail;
	Node *tmp;
	void (*add)(struct linked_lst *this, int data);
	void (*print)(struct linked_lst *this);
} Link;
void linked_lst_Construct(Link *this) {
	printf("Setting Linked List init\n");
	this -> head = NULL;
	this -> tail = NULL;
	this -> tmp = NULL;
}
void add_node(Link *this, int data) {
	Node *now;
	printf("Try add node\n");
	now = new_node();
	if (this -> head == NULL) {
		this -> head = now;
		this -> tail = now;
	} 
	else {
		this -> tail -> next = now;
		now -> before = this -> tail;
		this -> tail = now;
	}
	now -> data = data;
};
void print_node(Link *this) {
	printf("Try print node\n");
}
Link *new_ll() {
	Link *link;
	link = (Link*)malloc(sizeof(Link));
	
	linked_lst_Construct(link);
	link -> add = add_node;
	link -> print = print_node;
	return link;
};

// 메인
int main() {
	int run = 1, select = 0, enter;
	Link *lst = new_ll();
	
	system("cls");
	do {
		printf("\n< Linked List > \n\n");
		printf("  Select Number\n\n");
		printf("  1. init node\n");
		printf("  2. add node\n");
		printf("  3. del node\n");
		printf("  4. print node asc\n");
		printf("  5. print node desc\n");
		printf("\n  your select : ");
		scanf("%d%*c", &select);
		switch (select) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				run = 0;
				break;
		}
	} while (run);
	
	lst -> add(lst, 1);
	lst -> print(lst);
	
	return 0;
}
