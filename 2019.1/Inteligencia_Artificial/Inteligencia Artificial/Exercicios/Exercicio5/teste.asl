// Agent teste in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!latir.

/* Plans */

+!latir: cachorro(desconhecido) <- .print("Au Au Au").

-!latir: true <-
	.print("Snif Snif Snif");
	!latir.

