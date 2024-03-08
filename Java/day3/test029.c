#include <stdio.h>

typedef struct apple{
	int a;
	int (*add)(int a, int b);
} Apple;

int add_apple(int a, int b){
	return a+b;
}

int main(){
	Apple t;
	Apple *ptr;
	// ptr = (Apple*)malloc(sizeof(Apple));
	
	ptr->a = 123;
	ptr->add = add_apple;
	
	printf("a : %d, add : %d\n", ptr->a, ptr->add(1,2));
	
	// free(ptr);
	
	return 0;
}

