int a;

int main(void) {
	int i;
	i = 0;
	a = 0;
	while (i < 5) {
		int j;
		j = 0;
		while (j < 2) {
			a = a + 1;
			j = j + 1;
		}
		i = i + 1;
	}
}