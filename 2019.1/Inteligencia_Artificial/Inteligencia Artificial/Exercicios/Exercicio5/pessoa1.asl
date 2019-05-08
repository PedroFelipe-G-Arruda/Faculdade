// Agent pessoa1 in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
	.print("Quero um refrigerante.");
	.send(geladeiras, achieve, pedirrefri).
