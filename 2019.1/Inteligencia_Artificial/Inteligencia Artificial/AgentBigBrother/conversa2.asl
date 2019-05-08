// Agent conversa2 in project AgentBigBrother.mas2j

/* Initial beliefs and rules */

/* Initial goals */

//Paranoico

/* Plans */

+!porta(aberta)<-
	.print("Feche a porta!!");
	.send(conversa1, achieve, porta(fechada)).

+!porta1(aberta)<-
	.print("Não, feche a porta!!");
	.send(conversa1, unachieve, falapara(aberta)).
