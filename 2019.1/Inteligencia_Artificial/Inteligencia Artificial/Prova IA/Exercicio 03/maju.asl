tempo(sol).
tempo(nublado).
tempo(chovendo).

!informacao.

+!informacao : true <-
	.print("Bom dia, a previs�o do tempo para hoje � nublado, o que pretende fazer?");
	.send(pessoas, tell, tempo(nublado)).
