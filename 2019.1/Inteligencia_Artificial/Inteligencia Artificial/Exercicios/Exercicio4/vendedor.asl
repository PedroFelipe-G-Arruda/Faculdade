// Agent vendedor in project Exercicio4.mas2j

/* Initial beliefs and rules */

cadeira.
vazia(100).
ocupada(20).

/* Initial goals */

!vender.
!falarpara.

/* Plans */

+!falarpara : true <-
	.print("Qual sua cadeira!!!");
	.send(ncadeira, askOne, cadeira(Cadeira), Reply);
	.send(ncadeira, tell, vendedor(Cadeira));
	+Reply.
		 
+!vender: vazia(V) & ocupada(O) & O<=Cadeira & V>0 <-
	.wait(100);
	.print("vendida");
	-+vazia(V-1);
	-+ocupada(O+1);
	.print(V);
	.wait(500);
	!vender.	
	
+!vender: ocupada(O) & O >120 <-
	.print("Cadeiras ocupada");
	-cadeira.
