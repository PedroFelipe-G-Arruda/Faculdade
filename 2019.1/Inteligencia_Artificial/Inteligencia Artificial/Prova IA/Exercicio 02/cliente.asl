pizza(calabresa).
pizza(queijo).
pizza(frango).

+!cliente(pedido) <-
	.wait(1000);
	.print("Ol�, boa noite! Quero uma pizza de queijo");
	.send(pizzaiolo, tell, pizza(queijo)).

