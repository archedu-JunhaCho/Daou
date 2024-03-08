#include <stdio.h>

int main(){
	int i;
	i = ( 10 > 5 );
	i = ( 10 < 5 );
	
	if ( 0.00 ){
		printf("True\n");
	}
	else{
		printf("False\n");
	}
	
	printf("%d\n", i);
	
	return 0;
}