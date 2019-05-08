// Agent compras in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+!agua(cheia) <-
	.send(geladeiras, achieve, pediragua);
	.print("Agua comprado!!").


+!suco(cheia) <-
	.send(geladeiras, achieve, pedirsuco);
	.print("Suco comprado!!").

+!refri(cheia) <-
	.send(geladeiras, achieve, pedirrefri);
	.print("Refrigerante comprado!!").
