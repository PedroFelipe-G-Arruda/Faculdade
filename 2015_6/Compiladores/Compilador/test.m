begin
	int n;
	int f <- 1;
	int n;
	output("Digite um numero para saber o fatorial dele");
	input(n);
	int b;
	loop n >= 1:
		f <- f * n;
		n <- n - 1;
	lend;
	output("O fatorial e" f);
end
