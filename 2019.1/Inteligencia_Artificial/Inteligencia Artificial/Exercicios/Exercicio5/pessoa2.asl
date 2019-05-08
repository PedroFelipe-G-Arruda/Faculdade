// Agent pessoa2 in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <-
	.print("Quero uma água.");
	.send(geladeiras, achieve, pediragua).

