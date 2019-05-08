// Agent kate in project AgentBigBrother.mas2j



/* Initial beliefs and rules */



/* Initial goals */
!irParaPraia.
/* Plans */

+!irParaPraia <-
	!falePara.
	

+!falePara <-
	.print("Qual a previsão do tempo?");
	.send(bob, askAll, tempo(Nome));
	.wait(2000);
	!analise.	

+!analise: not tempo(limpo) <-
	.print("Hoje vou ficar em casa!").

+!analise: tempo(limpo) <-
	.print("Hoje eu vou para a praia!").
