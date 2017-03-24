int x;
int y;
int z[5];

int add(int a[], int b, int c) {
	int sum[5];
	int e;
	while (e<5){
		sum[e]=a[e]+b+c;
		e=e+1;
	}
}

void main(void) {
	x=1;
	y=3;
	int w = 2;
	add(z[5], (x-y)*w, x);
}