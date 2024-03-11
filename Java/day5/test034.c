#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Fruit Class
typedef struct fruit {
	char typ[20];
	void (*print)(void *vp);
} Fruit;
void print(void *vp) {
	Fruit *fp = (Fruit*)vp;
	printf("Hello Its Fruit | address : %p\n", fp);
	printf("%s \n", fp -> typ);
}
Fruit *new_fruit() {
	Fruit *fp;
	fp = (Fruit*)malloc(sizeof(Fruit));
	
	strcpy(fp->typ, "NOT");
	fp->print = print;
	return fp;
}
void *new_fruit_void() {
	void *vp;
	Fruit *fp;
	fp = (Fruit*)malloc(sizeof(Fruit));
	
	strcpy(fp->typ, "NOT");
	fp->print = print;
	
	vp = (void*)fp;
	
	return vp;
}
// Apple Class
typedef struct apple {
	char typ[20];
	char name[20];
	void (*print)(void *vp);
	void (*print2)(void *vp);
} Apple;
void print2(void *vp) {
	Apple *ap = (Apple*)vp;
	printf("Hello Its Apple | address : %p\n", ap);
	printf("%s \n", ap -> name);
}
Apple *new_apple() {
	Apple *ap;
	ap = (Apple*)malloc(sizeof(Apple));
	
	strcpy(ap->typ, "NOT");
	ap->print = print;
	strcpy(ap->name, "NONE");
	ap->print2 = print2;
	
	return ap;
}
void *new_apple_void() {
	void *vp;
	Apple *ap;
	ap = (Apple*)malloc(sizeof(Apple));
	
	strcpy(ap->typ, "NOT");
	ap->print = print;
	printf("A ! P ! : %p\n", ap->print);
	strcpy(ap->name, "NONE");
	ap->print2 = print2;
	
	vp = (void*)ap;
	
	return vp;
}

int main() {
	/******** Declare ********/
	void *fp_void;
	void *ap_void;
	Fruit *fp;
	Apple *ap;
	/******** Inheritance_Cross ********/
	ap_void = new_apple_void();
	fp = (Fruit*)ap_void;
	ap = (Apple*)ap_void;
	printf("%p\n", ap->print);
	printf("%p\n", ap->print2);
	printf("%s\n", fp->typ);
	printf("%p\n", fp->print);
	fp->print(fp);
	
	return 0;
}