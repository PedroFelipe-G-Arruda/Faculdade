begin

	int n;
	int f = 1;

	output("Digite um numero para saber o fatorial dele");
	input(n);

	loop n >= 1:
		f = f * n;
		n = n - 1;
	lend;

	output("O fatorial e" f);
	

end