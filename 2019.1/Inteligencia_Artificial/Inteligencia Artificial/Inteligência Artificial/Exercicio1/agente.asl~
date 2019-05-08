// Agent agente in project Exercicio1.mas2j

/*
Crie um SMA que simule um quarto inteligente. O 
quarto será controlado por um agente que começará 
com as seguintes crenças sobre o quarto:
? É dia
? A luz do quarto está apagada
? Kate está no quarto
? Bob não está no quarto
? A temperatura atual do quarto
*/


!dia. 
!luz_quarto(apagado). 
!kate_esta_no_quarto.
!bob_nao_esta_no_quarto.
!temperatura_atual.



+!dia <-
	.print("É dia"); //Exibi uma mensagem na tela dizendo ("É dia")
	+dia(sim). //Adiciona a crença dia

/*	
//Possibilidade 1
+!luz_quarto(apagado) <-
	.print("A luz do quarto está apagada");
	+luz_quarto(apagado).
*/

//Possibilidade 2 
+!luz_quarto(apagado) <- 
	.print("Kate a luz do quarto está apagada?");
	.send(kate, askOne,pergunta_kate_luz(Reply)).
	//Pergunta ao Agente Kate se a luz do quarto está apagada e com base na resposta de Kate o Agente adiciona a crença
	+pergunta_kate_luz(sim) <- .print("A luz do quarto está acessa");
	+luz_quarto(ligado).
	+pergunta_kate_luz(nao) <- .print("A luz do quarto está apagada");
	+luz_quarto(apagada).
	
+!kate_esta_no_quarto <-
	.print("Kate você está no quarto?");
	.send(kate,askOne,pergunta_kate(Reply)).
	//Adiciona a crença com base na resposta do Agente Kate
	+pergunta_kate(sim) <- .print("Kate está no quarto");
	+kate_esta_no_quarto.
	+pergunta_kate(nao) <- .print("Kate não está no quarto");
	+kate_nao_esta_no_quarto.
			
+!bob_nao_esta_no_quarto <-
	.print("Bob você está no quarto?");
	.send(bob,askOne,pergunta(Reply)).
	//Para adicionar uma crença baseada na resposta do Agente Bob	
	+pergunta(sim)<-.print("Bob está no quarto");
	+bob_esta_no_quarto.
	+pergunta(nao)<-.print("Bob não está no quarto");
	+bob_nao_esta_no_quarto.
+!temperatura_atual <-	
	.print("A temperatura atual do quarto é 30 graus celsius");
	+temperatura_atual(30).	

	


