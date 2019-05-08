// Agent cliente in project Exercicio3.mas2j

/* Initial beliefs and rules */

produto(pao).
produto(presunto).
produto(mussarela).
produto(cafe).

/* Initial goals */

!perguntar.

/* Plans */

+!perguntar:true <-
	.wait(3000);
	.print("Bom dia, eu gostaria de comprar 500g de pão.");
	.send(vendedor,tell,produto(pao)).






