// Agent geladeiras in project Exercicio3.mas2j

/* Initial beliefs and rules */

acabou.

agua(10).
suco(10).
refri(10).
cerveja(10).

/* Initial goals */


/* Plans */

+!pediragua: agua(A) & A = 0 <-
	.print("OPrecisa comprar mais agua!!!");
	.send(compras, achieve, agua(cheia));
	-+agua(10).
		
+!pediragua: agua(A) & A > 0  <-
	.print("Quantidade de água: ", A);
	-+agua(A-1);
	.wait(500);
	!pediragua.

+!pedirsuco: suco(S) & S = 0 <-
	.print("Precisa comprar mais suco!!!");
	.send(compras, achieve, suco(cheia));
	-+suco(10).
		
+!pedirsuco: suco(S) & S > 0  <-
	.print("Quantidade de Suco: ", S);
	-+suco(S-1);
	.wait(500);
	!pedirsuco.

+!pedirrefri: refri(R) & R = 0 <-
	.print("Precisa comprar mais refrigerante!");
	.send(compras, achieve, refri(cheia));
	-+refri(10).
	
	
+!pedirrefri: refri(R) & R > 0  <-
	.print("Quantidade de Refrigerante: ", R);
	-+refri(R-1);
	.wait(500);
	!pedirrefri.

