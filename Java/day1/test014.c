// test014.c
#include <stdio.h>

int main(){
	int i, year = 100;
	double money = 100, rate = 0.066;
	for (i = 0; i < year; i++){
		money *= ( 1 + rate );
	}
	printf("result : %f\n", money);
	
	return 0;
}