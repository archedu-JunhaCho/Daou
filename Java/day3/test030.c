#include <stdio.h>
#include <stdlib.h>

typedef struct node{
	int data;
	struct node *next;
	struct node *before;
} Node;

int init_node(Node **head, Node **tail, int value){
	// create init node
	Node *tmp;
	tmp = (Node*)malloc(sizeof(Node));
	tmp -> before = tmp -> next = NULL;
	// head tail setting
	(*head) = tmp;
	(*tail) = tmp;
	// insert value in node
	tmp -> data = value;
	return 0;
}
int add_node(Node **head, Node **tail, int value){
	// create add node
	Node *tmp;
	tmp = (Node*)malloc(sizeof(Node));
	tmp -> before = tmp -> next = NULL;
	// head tail setting
	tmp -> before = *tail;
	(*tail) -> next = tmp;
	*tail = tmp;
	// insert value in node
	tmp -> data = value;
	return 0;
}
int del_node(Node **head, Node **tail, int idx){
	// search del node
	int i = 0;
	Node *find, *check;
	find = *head;
	check = *head;
	for (; check -> next; i++){
		if(idx > i){
			find = find -> next;
		}
		check = check -> next;
	}
	printf("\n=============================================================\n");
	printf("del node : %p %d\n", find, find->data);
	printf("idx : %d, i : %d \n", idx, i);
	// error
	if(idx > i){
		printf("Invalid IDX\n");
		return 0;
	}
	
	// change node next before
	if (idx == 0){
		//// 1. head
		find -> next -> before = NULL;
		*head = find -> next;
	} 
	else if(idx == i){
		//// 3. tail
		find -> before -> next = NULL;
		*tail = find -> before;
	} 
	else{
		//// 2. between
		find -> before -> next = find -> next;
		find -> next -> before = find -> before;
	}
	
	// memorey free
	free(find);
	
	return 0;
}
int print_node_asc(Node *head){
	int i = 0;
	Node *result;
	result = head;
	
	printf("\n=============================================================\n");
	printf("Print Asc\n\n");
	for (i = 0; result -> next; i++){
		printf("%d ) %3d : %p : before - %p : next - %p \n", i+1, result -> data, result, result -> before, result -> next);
		result = result -> next;
	}
	printf("%d ) %3d : %p : before - %p : next - %p \n", i+1, result -> data, result, result -> before, result -> next);
	
	return 0;
}
int print_node_desc(Node *tail){
	int i = 0;
	Node *result;
	result = tail;
	
	printf("\n=============================================================\n");
	printf("Print Desc\n\n");
	for (i = 0; result -> before; i++){
		printf("%d ) %3d : %p : before - %p : next - %p \n", i+1, result -> data, result, result -> before, result -> next);
		result = result -> before;
	}
	printf("%d ) %3d : %p : before - %p : next - %p \n", i+1, result -> data, result, result -> before, result -> next);
	
	
	return 0;
}

int main(){
	Node *head, *tail;
	int select = -1, run = 1, enter, cnt = 0;
	
	system("cls");
	do{
		printf("\nSelect Number\n\n");
		printf("  1. init node\n");
		printf("  2. add node\n");
		printf("  3. del node\n");
		printf("  4. print node asc\n");
		printf("  5. print node desc\n");
		printf("\n  your select : ");
		scanf("%d%*c", &select);
		switch (select){
			case 1:
				if(cnt){
					printf("Already init\n");
					break;
				}
				printf("Enter data (num) : ");
				scanf("%d%*c", &enter);
				init_node(&head, &tail, enter);
				cnt++;
				break;
			case 2:
				if(!cnt){
					printf("You need init\n");
					break;
				}
				printf("Enter data (num) : ");
				scanf("%d%*c", &enter);
				add_node(&head, &tail, enter);
				cnt++;
				break;
			case 3:
				if(!cnt){
					printf("You need init\n");
					break;
				}
				printf("Enter index (num) : ");
				scanf("%d%*c", &enter);
				del_node(&head, &tail, enter);
				cnt--;
				break;
			case 4:
				print_node_asc(head);
				break;
			case 5:
				print_node_desc(tail);
				break;
			default:
				run = 0;
				break;
		}
		system("cls");
	}while(run);
	
	// init_node(&head, &tail, 0);
	
	// add_node(&head, &tail, 10);
	// add_node(&head, &tail, 112);
	// add_node(&head, &tail, 123);
	// add_node(&head, &tail, 135);
	// add_node(&head, &tail, 147);
	
	// print_node_asc(head);
	// print_node_desc(tail);
	
	// del_node(&head, &tail, 5);
	// print_node_asc(head);
	
	return 0;
}