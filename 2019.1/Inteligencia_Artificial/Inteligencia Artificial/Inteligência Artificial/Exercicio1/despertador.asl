// Agent despertador in project Exercicio1.mas2j



!horario_kate.
!horario_bob.

+!horario_kate <- 
	.print("Kate qual é seu horário de despertar?");
	.send(kate,askOne,pergunta_horario_kate(Reply)).
	+pergunta_horario_kate(Reply) <-
		.print("O horário de despertar de Kate é as ",Reply).
		
+!horario_bob <- 
	.print("Bob qual é seu horário de despertar?");
	.send(bob,askOne,pergunta_horario_bob(Reply)).
	+pergunta_horario_bob(Reply) <-
		.print("O horário de despertar de Bob é as ",Reply).
