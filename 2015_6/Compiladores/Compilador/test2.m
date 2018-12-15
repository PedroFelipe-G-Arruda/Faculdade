begin
	int n;
	int f <- 1;
	int x <- 2;

	if(x > 0)?
		output("Maior");
	@
		output("Menor");
		if(x > 1)?
			output("Maior");
			@
		    output("Menor");

		?;
	?;
end