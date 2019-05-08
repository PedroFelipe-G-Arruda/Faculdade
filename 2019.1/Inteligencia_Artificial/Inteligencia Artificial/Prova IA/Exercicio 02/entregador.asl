pizza(entregue).

+entregar(pizza) <-
	.wait(1000);
	.print("Ok, já to saindo para entregar");
	.wait(10000);
	.print("A pizza foi entregue no tempo");
	.send(pizzaiolo, tell, pizza(entregue)).
