// Agent mae in project Questao2.mas2j

comida(5).

estomago(0).


!pergunta_ao_filho.
!comer.
!beber.


+!pergunta_ao_filho <-
	.print("Filho você está com fome?");
	.send(filho,askOne,pergunta(Reply)).
	
	+pergunta(sim)<-.print("Meu filho está com fome").
	
+!comer: fome & comida(F) & estomago(S) & S <5 <-
	.print("Filho comendo a comida ... ");
	-+comida(F-1);
	-+estomago(S+1);
	!comer.
	
+!beber: sede <-
	.print("Filho bebendo ... ").

+!comer: estomago(S) & S >= 5 <-
	.print("Eu estou satisfeito mãe");
	-fome;
	-beber.
