// Agent vendedor in project exercicio01.mas2j

/* Initial beliefs and rules */

/* Initial goals */

cadeira.
vazia(100).
ocupada(20).

!vender.
!falarpara.
+!falarpara : true <-
	.print("Qual sua cadeira!!!");
	.send(cliente, askOne, cadeira(Cadeira));
	.send(cliente, tell, vendedor(Cadeira)).
		 
+!vender: vazia(V) & ocupada(O) & O<=Cadeira & V>0 <-
	.print("vendida");
	-+vazia(V-1);
	-+ocupada(O+1);
	.print(V);
	.wait(500);
	!vender.	
+!vender: ocupada(O) & O >120 <-
	.print("Cadeiras ocupada");
	-cadeira.
