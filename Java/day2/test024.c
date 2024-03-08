#include <stdio.h>
#include <string.h>

int strlen2(char *lst);

int main(){
	int i, len = 0;
	char lst[6] = "Apple";
	char *ptr;
	
	for (ptr = lst; *ptr; ptr++){
		printf("%c", *ptr);
		len++;
	}
	printf("\n");
	printf("str len : %d\n", len);
	printf("str len : %d\n", strlen(lst));
	printf("str len : %d\n", strlen2(lst));
	
	return 0;
}

int strlen2(char *lst){
	int len = 0;
	
	for (; *lst; lst++){
		len++;
	}
	
	return len;
}