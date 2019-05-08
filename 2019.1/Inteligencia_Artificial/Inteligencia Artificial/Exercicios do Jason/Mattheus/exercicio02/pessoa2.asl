// Agent pessoa2 in project exercicio02.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	.print("Quero um suco.");
	.send(geladeira, achieve, pedirsuco).

