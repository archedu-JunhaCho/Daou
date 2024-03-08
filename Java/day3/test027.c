#include <stdio.h>
#include <string.h>

int add(int a, int b) {
	return a+b;
}

int sub(int a, int b) {
	return a-b;
}

int mul(int a, int b) {
	return a*b;
}

int div(int a, int b) {
	return a/b;
}

int main(){
	int r, idx;
	int (*fp)(int, int);
	fp = **add;
	
	r = fp(10, 20);
	printf("add : %d\n", r);
	printf("add : %d\n", (*add)(1,2));
	
	return 0;
}

