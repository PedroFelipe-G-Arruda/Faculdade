// Agent agente in project Exercicio1.mas2j

/*
Crie um SMA que simule um quarto inteligente. O 
quarto ser� controlado por um agente que come�ar� 
com as seguintes cren�as sobre o quarto:
? � dia
? A luz do quarto est� apagada
? Kate est� no quarto
? Bob n�o est� no quarto
? A temperatura atual do quarto
*/


!dia. 
!luz_quarto(apagado). 
!kate_esta_no_quarto.
!bob_nao_esta_no_quarto.
!temperatura_atual.



+!dia <-
	.print("� dia"); //Exibi uma mensagem na tela dizendo ("� dia")
	+dia(sim). //Adiciona a cren�a dia

/*	
//Possibilidade 1
+!luz_quarto(apagado) <-
	.print("A luz do quarto est� apagada");
	+luz_quarto(apagado).
*/

//Possibilidade 2 
+!luz_quarto(apagado) <- 
	.print("Kate a luz do quarto est� apagada?");
	.send(kate, askOne,pergunta_kate_luz(Reply)).
	//Pergunta ao Agente Kate se a luz do quarto est� apagada e com base na resposta de Kate o Agente adiciona a cren�a
	+pergunta_kate_luz(sim) <- .print("A luz do quarto est� acessa");
	+luz_quarto(ligado).
	+pergunta_kate_luz(nao) <- .print("A luz do quarto est� apagada");
	+luz_quarto(apagada).
	
+!kate_esta_no_quarto <-
	.print("Kate voc� est� no quarto?");
	.send(kate,askOne,pergunta_kate(Reply)).
	//Adiciona a cren�a com base na resposta do Agente Kate
	+pergunta_kate(sim) <- .print("Kate est� no quarto");
	+kate_esta_no_quarto.
	+pergunta_kate(nao) <- .print("Kate n�o est� no quarto");
	+kate_nao_esta_no_quarto.
			
+!bob_nao_esta_no_quarto <-
	.print("Bob voc� est� no quarto?");
	.send(bob,askOne,pergunta(Reply)).
	//Para adicionar uma cren�a baseada na resposta do Agente Bob	
	+pergunta(sim)<-.print("Bob est� no quarto");
	+bob_esta_no_quarto.
	+pergunta(nao)<-.print("Bob n�o est� no quarto");
	+bob_nao_esta_no_quarto.
+!temperatura_atual <-	
	.print("A temperatura atual do quarto � 30 graus celsius");
	+temperatura_atual(30).	

	


