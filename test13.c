int main(void) {
	int i;
	int j;
	int k;
	
	i = 0;
	j = 2;
	k = 7;
	while (i < 10) {
		int l;
		int m;
		int n;
		l = m = n = 5;
		if (j + i < l) {
			putchar(65);
		}
		else if(k - i/2 < l) {
			putchar(75);
		}
		else {
			putchar(85);
		}
		i = i + 1;
	}
	
	if (i != k) {
		i = 0;
	}
	return i;
}