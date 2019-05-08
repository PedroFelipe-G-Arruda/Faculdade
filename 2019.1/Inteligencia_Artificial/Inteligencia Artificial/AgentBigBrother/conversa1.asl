// Agent conversa1 in project AgentBigBrother.mas2j

/* Initial beliefs and rules */

/* Initial goals */

//Claustrofobico

!falapara(aberta).


/* Plans */

+!falapara(aberta) <-
	.print("Abre a porta!!");
	.send(conversa2, achieve, porta(aberta)).
	
+!porta(fechada)<-
	.print("Não, abre a porta!!");
	.send(conversa2, achieve, porta1(aberta)).
