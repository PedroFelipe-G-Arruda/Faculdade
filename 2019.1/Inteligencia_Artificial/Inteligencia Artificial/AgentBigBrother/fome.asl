// Agent fome in project AgentBigBrother.mas2j

/* Initial beliefs and rules */
fome.
comida(100).
estomago(0).
/* Initial goals */

!comer.
/* Plans */

+!comer: fome & comida(F) & estomago(S) & S<=50 <-
	.print("Comendo...");
	-+comida(F-1);
	-+estomago(S+1);
	.print("Quantidade de comida: ", F);
	!comer.
+!comer: estomago(S) & S>50 <-
	.print("Eu estou satisfeito");
	-fome.
