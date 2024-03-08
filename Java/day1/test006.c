// test006.c
#include <stdio.h>

int main(){
	int i, year = 100;
	float seed = 1000000, ci = 0.066;
	
	for (i = 0; i < year; i++){
		seed *= (1 + ci);
	}
	
	printf("%.2f\n", seed);
	
	return 0;
}

