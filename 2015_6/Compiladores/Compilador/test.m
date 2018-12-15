begin
	int n;
	int f <- 1;
	int x <- 1;
	int soma;
	int test;
	output("Digite um numero para saber o fatorial dele");
	input(n);
	loop n >= 1:
		f <- f * n;
		n <- n - 1;
		soma <- 4/x;
		output("LOOP");
		

		loop n >= 1:
			f <- f * n;
			n <- n - 1;
			soma <- 4/x;
		output("LOOP");
		
		lend;
		if(x > 0)?
			output("Maior");
		@
			output("Menor");
			loop n >= 1:
				x <- x + 1;
				n <- n - 1;
				
			lend;
		?;
		
	lend;
	
	output("O fatorial e" f);
end
