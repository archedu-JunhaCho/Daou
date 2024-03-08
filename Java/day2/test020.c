#include <stdio.h>

int main(){
	int i;
	int *ptr;
	int *ptr2;
	i = 10101;
	ptr = &i;
	ptr2 = ptr;
	
	printf("%d\n", i);
	printf("%d\n", *ptr);
	printf("%d\n", *ptr2);
	
	return 0;
}