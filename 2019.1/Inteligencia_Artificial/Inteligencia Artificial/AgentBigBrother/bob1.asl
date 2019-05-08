// Agent bob1 in project AgentBigBrother.mas2j

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */

+!ligar(ok)<-
	.print("Luz ligada");
	.send(kate1, tell, luz(ligada));
!ligar(ok).         
