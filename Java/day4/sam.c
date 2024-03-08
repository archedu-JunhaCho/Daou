#include <stdio.h>

typedef struct node {
	int data;	
	struct node* next;
} Node;

Node* new_Node( int a ) {
	Node* t;
	t = (Node*)malloc(sizeof(Node));
	t->data = a;
	t->next = NULL;
	return t;
}

Node* add( int i , Node* t ) {
	t->next = new_Node( i );
	return t->next;
}

void print( Node* head2 ) {
	Node* t;
	for( t = head2->next ; t != NULL ; t = t->next ) {
		printf("%d\n", t->data );
	}
}

void erase( Node* head2 ) {
	Node *pre, *post;

	pre = head2;
	post = head2->next;

	while( post != NULL ) {
		pre = post;
		post = post->next;

		free( pre );
	}
	head2->next = NULL;
}

int main() {
	Node *head, *tail;

	head = new_Node( 0 );
	tail = head;

	tail = add( 100, tail );
	tail = add( 200, tail );
	tail = add( 300, tail );

	print( head );
	
	erase( head );

	print( head );

	free( head );
	return 0;
}

//	test035.c