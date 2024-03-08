#include <stdio.h>

int main(){
	int a[5];
	// int b[]; //틀린문법
	// int[] c; //틀린문법
	// int[5] d; //틀린문법
	int e[3] = {10,20,30};
	int e_2[3];
	int *e_ptr;
	int f[] = {1,2,3};
	int g[] = {};
	int h[] = {0};
	int i[3] = {0};
	
	// e_2 = 2 // 틀린문법
	e_ptr = e;
	
	printf("a : %d\n", sizeof(a));
	printf("e : %d\n", sizeof(e));
	printf("e_ptr val : %d, size : %d\n", *(e_ptr+1), sizeof(*e_ptr));
	printf("f : %d\n", sizeof(f));
	printf("g : %d\n", sizeof(g));
	printf("h : %d\n", sizeof(h));
	printf("i : %d\n", sizeof(i));
	
	return 0;
}