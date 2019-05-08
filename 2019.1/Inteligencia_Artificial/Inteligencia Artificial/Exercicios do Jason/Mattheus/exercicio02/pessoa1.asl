// Agent pessoa1 in project exercicio02.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	.print("Quero uma agua.");
	.send(geladeira, achieve, pediragua).

