!irParaPraia.

+!irParaPraia <- 
	!falaPara;
	!analise.
	
+!falaPara: true <-
	.print("Qual a previs�o do tempo");
	.send(bob, askAll, tempo(Nome)).
	
+!analise: tempo(limpo) & tempo(ensolarado) <-
	.print("Vou a praia").
/*	
+!analise: tempo(limpo) & ~tempo(ensolarado) <-
	.print("Vou a praia").
	
+!analise: ~tempo(limpo) & ~tempo(ensolarado) <-
	.print("N�o vou a praia"). */
