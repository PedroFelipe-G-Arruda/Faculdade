// Agent kate in project Exercicio1.mas2j
pergunta_kate(sim). //O Agente Kate responde dizendo que n�o est� no quarto
pergunta_kate_luz(nao). //O Agente Kate responde dizendo que a luz do quarto est� apagada
pergunta_horario_kate(7). //O Agente Kate responde dizendo o hor�rio que ela acorda

!resposta_da_Kate_para_o_horario.

+!resposta_da_Kate_para_o_horario <- 
	.print("Meu hor�rio de despertar � as ",7).



