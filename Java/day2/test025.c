#include <stdio.h>
#include <string.h>

int add(int x, int y){
	return x + y;
}

int main(){
	int r;
	
	r = add(10, 20);
	printf("add : %d\n", r);
	
	return 0;
}

