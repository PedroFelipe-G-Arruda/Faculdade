// Agent geladeira in project exercicio02.mas2j

/* 2) Crie uma geladeira inteligente que controle o estoque de alguns itens 
(4 itens a sua escolha), onde existam 3 pessoas que iram consumir esses itens. 
Esse agente enviará a um agente compras o pedido dos itens que devam estar 
abaixo de um limite criado por você. 
 */
acabou.
agua(0).
suco(0).
refri(0).
cerveja(0).

/* Plans */

+!pediragua: agua(A) & A<=5 <-
	.print("Colocar agua !!!");
	.send(agentecompras, achieve, agua(cheia));
	-+agua(10);
	.print(agua(A)).
	
+!pediragua: agua(A) & A > 5  <-
	.print("Entrou ");
	-+agua(A-1);
	.print(A);
	.wait(500);
	!pediragua.

+!pedirsuco: suco(S) & S<=5 <-
	.print("Colocar suco !!!");
	.send(agentecompras, achieve, suco(cheia));
	-+suco(10);
	.print(suco(S)).
	
+!pedirsuco: suco(S) & S > 5  <-
	.print("Entrou ");
	-+suco(S-1);
	.print(S);
	.wait(500);
	!pedirsuco.

+!pedirrefri: refri(R) & R<=5 <-
	.print("Colocar Refrigerante !!!");
	.send(agentecompras, achieve, refri(cheia));
	-+refri(10);
	.print(refri(R)).
	
+!pedirrefri: refri(R) & R > 5  <-
	.print("Entrou ");
	-+refri(R-1);
	.print(R);
	.wait(500);
	!pedirrefri.	
