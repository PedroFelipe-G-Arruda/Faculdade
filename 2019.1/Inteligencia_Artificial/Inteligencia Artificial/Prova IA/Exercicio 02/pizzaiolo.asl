entregar(pizza).

!atender.

+!atender : true <- 
	.print("Pizzaria, boa noite! Qual é o seu pedido?");
	.send(cliente, achieve, cliente(pedido)).
	
+pizza(queijo) <-
	.wait(1000);
	.print("Seu pedido foi anotado, em 30mim sua pizza estara na sua casa");
	.wait(5000);
	.print("A pizza está pronta, levar para o cliente");
	.send(entregador, tell, entregar(pizza)).
	
+pizza(entregue) <-
	.wait(2000);
	.print("Ok, daqui a pouco sai outra pizza para entrega.").
	
	
