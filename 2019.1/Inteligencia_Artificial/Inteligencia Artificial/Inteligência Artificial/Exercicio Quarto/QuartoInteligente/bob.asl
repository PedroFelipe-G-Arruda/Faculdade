acordada(nao).

!acordar.

+!acordar : true <-
.broadcast(tell,acordada(nao)).


+!acorde(sim) <-
	.print("Estou Acordado!");
	-acordada(nao);
	+acordada(sim);
	.send(despertador,untell,acordada(nao)).
