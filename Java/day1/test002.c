// test002.c
#include <stdio.h>

int main(){
	int xy; // 변수 선언 : 자료형 1개의 심볼 -> 기억공간 확보
	printf("%d\n", xy);
	
	xy = 12;
	printf("%d\n", xy);
	printf("%f\n", xy);
	// printf("%s\n", xy);
	printf("%p\n", xy);
	return 0;
}

