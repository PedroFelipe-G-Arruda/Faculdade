// Agent bob in project Exercicio1.mas2j
pergunta(nao). //O Agente Bob responde dizendo que n�o est� no quarto

pergunta_horario_bob(10). //O Agente Kate responde dizendo o hor�rio que ela acorda
!resposta_do_Bob_para_o_quarto.
!resposta_do_Bob_para_o_horario.

+!resposta_do_Bob_para_o_quarto <-
	.print("Eu n�o estou no quarto").

+!resposta_do_Bob_para_o_horario <- 
	.print("Meu hor�rio de despertar � as ",10).

