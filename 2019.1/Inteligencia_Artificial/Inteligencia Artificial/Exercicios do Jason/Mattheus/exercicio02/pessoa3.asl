// Agent pessoa3 in project exercicio02.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	.print("Quero um refrigerante.");
	.send(geladeira, achieve, pedirrefri).
