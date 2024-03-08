#include <stdio.h>
#include <stdlib.h>

int main(){
	int i, r = 3, cnt = 1000000000, cnt_true = 0, cnt_false = 0;
	double x, y, rate = 0, max = 32767, result;
	
	srand(time(NULL));
	for (i = 0; i < cnt; i++){
		x = rand()/max * r;
		y = rand()/max * r;
		if (x*x + y*y <= r*r){
			cnt_true++;
		}
		else{
			cnt_false++;
		}
	}
	result = (double)cnt_true / (cnt_true + cnt_false) * 4;
	printf("true : %d, false : %d\n", cnt_true, cnt_false);
	printf("pi : %f", result);
	
	return 0;
}