// Agent mundodosblocos in project Exercicio2.mas2j

/* Initial beliefs and rules */
sobremesa1(b).
sobre(a,b).
sobremesa2(c).

/* Initial goals */

!move.

/* Plans */

+!move: true <-
	.print("MUNDO DOS BLOCOS");
	.wait(1000);
	.print("--------ESTADO INICIAL--------");
	.wait(1000);
	.send(print,achieve,mundo(a));
	.wait(1000);
	
	.print("Movimentar o A p/ mesa");
	+sobremesa3(a);-sobre(a,b);
	.wait(1000);
	.send(print,achieve,mundo(b));	
	.wait(1000);
	
	.print("Movimentar o B p/ o A");
	+sobre(b,a);-sobremesa1(b);
	.wait(1000);
	.send(print,achieve,mundo(c));	
	.wait(1000);	
	
	.print("Movimentar o C p/ o B");
	+sobre(c,b);-sobremesa2(c);
	.wait(1000);
	.send(print,achieve,mundo(d));
	.wait(1000);
	
	.print("Movimentar o Pino 3 p/ Pino 1");
	.wait(1000);
	+sobremesa1(a);+sobre(b,a);+sobre(c,b);-sobre(c,b);-sobremesa3(a);
	.print("--------ESTADO FINAL--------");
	.wait(1000);
	.send(print,achieve,mundo(e)).
	
