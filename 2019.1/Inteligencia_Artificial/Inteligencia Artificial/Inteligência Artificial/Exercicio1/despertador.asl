// Agent despertador in project Exercicio1.mas2j



!horario_kate.
!horario_bob.

+!horario_kate <- 
	.print("Kate qual � seu hor�rio de despertar?");
	.send(kate,askOne,pergunta_horario_kate(Reply)).
	+pergunta_horario_kate(Reply) <-
		.print("O hor�rio de despertar de Kate � as ",Reply).
		
+!horario_bob <- 
	.print("Bob qual � seu hor�rio de despertar?");
	.send(bob,askOne,pergunta_horario_bob(Reply)).
	+pergunta_horario_bob(Reply) <-
		.print("O hor�rio de despertar de Bob � as ",Reply).
