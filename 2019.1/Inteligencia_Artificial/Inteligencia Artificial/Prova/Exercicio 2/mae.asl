// Agent mae in project Questao2.mas2j

comida(5).
estomago(0).


!pergunta_ao_filho.
!comer.

+!pergunta_ao_filho <-
	.print("Filho você está com fome?");
	.send(filho,askOne,pergunta(Reply)).
	
	+pergunta(sim)<-.print("Meu filho está com fome").
	
+!comer: fome & comida(F) & estomago(S) & S <5 <-
	.print("Filho comendo a comida ... ");
	.print("Filho bebendo a bebida ... ");
	.print("Filho cochilando ... ");
	-+comida(F-1);
	-+estomago(S+1);
	!comer.

+!comer: estomago(S) & S >= 5 <-
	.print("Eu estou satisfeito mãe");
	-fome;
	-sede;
	-sono.
