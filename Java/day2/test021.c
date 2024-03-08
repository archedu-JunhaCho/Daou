#include <stdio.h>

typedef struct abcd{
	int x;
	int y;
} APPLE;

int main(){
	// 선언문
	struct abcd s_1;
	struct abcd* ptr;
	APPLE s_2;
	APPLE *ptr2;
	APPLE s_3;
	APPLE *ptr3;
	
	// 포인터가 가리킬 기억공간 대입
	ptr = &s_1;
	ptr2 = &s_2;
	ptr3 = (APPLE *)malloc(sizeof(APPLE)*2);
	ptr3[0].x = 10;
	ptr3[0].y = 11;
	
	// 구조체별 값 할당후 확인
	s_1.x = 2;
	s_1.y = 3;	
	printf("%d %d\n", s_1.x, s_1.y);
	printf("%d %d\n", ptr->x, ptr->y);
	
	s_2.x = 4;
	s_2.y = 5;
	printf("%d %d\n", s_2.x, s_2.y);
	printf("%d %d\n", ptr2->x, ptr2->y);
	
	s_3.x = 6;
	s_3.y = 7;
	printf("%d %d\n", s_3.x, s_3.y);
	printf("%d %d\n", ptr3[0].x, ptr3[0].y);
	
	
	return 0;
}