// Agent filho in project Questao2.mas2j

!responder.

+!responder <- 
	.print("Eu estou com fome,sede e sono");
	+pergunta(sim);
	.send(mae,tell,fome);
	.wait(500);
	.send(mae,tell,sede);
	.wait(500);
	.send(mae,tell,sono).
