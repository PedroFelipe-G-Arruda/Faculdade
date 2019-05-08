// Agent kate in project Exercicio1.mas2j
pergunta_kate(sim). //O Agente Kate responde dizendo que não está no quarto
pergunta_kate_luz(nao). //O Agente Kate responde dizendo que a luz do quarto está apagada
pergunta_horario_kate(7). //O Agente Kate responde dizendo o horário que ela acorda

!resposta_da_Kate_para_o_horario.

+!resposta_da_Kate_para_o_horario <- 
	.print("Meu horário de despertar é as ",7).



