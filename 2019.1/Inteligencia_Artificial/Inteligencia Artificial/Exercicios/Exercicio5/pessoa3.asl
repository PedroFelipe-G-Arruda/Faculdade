// Agent pessoa3 in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <-
	.print("Quero um suco.");
	.send(geladeiras, achieve, pedirsuco).
