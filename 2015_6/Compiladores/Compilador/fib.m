begin
	int n;
	output("Digite um numero para saber o fatorial dele");
	input(n);
	int f <- 1;
	loop n >= 1:
		f <- f * n;
		n <- n - 1;
	lend;
	output("O fatorial e" f);
	output(f);
end

