#include <stdio.h>
#include <string.h>

int add(int x, int y){
	return x + y;
}

int indexOf(char *x, char *y){
	int i, idx = 0, check = 0;
	
	for (; *x && !check; x++){
		// 첫글자가 일치할시
		if(*x == *y){
			i = 0;
			// 나머지 글자를 검증
			for (; *(y+i); i++){
				// 다음이 일치할시 문자열 끝 검증
				if(*(x+i) == *(y+i)){
					if(*(y+i+1) == '\0'){
						check = 1;
						break;
					}
				}
				// 일치 안할시 다음으로
				else{
					break;
				}
			}
		}
		idx++;
	}
	
	return check ? idx:-1;
}


int main(){
	int r, idx;
	
	r = add(10, 20);
	printf("add : %d\n", r);
	
	idx = indexOf("Hello World", "ello");
	printf("indexOf : %d\n", idx);
	
	return 0;
}

