// Agent crianca in project exercicio05.mas2j
/* Initial beliefs and rules */

/* Initial goals */

!fome.
!sede.
!sono.

/* Plans */

+!fome : true <- .print("Estou com fome !!!");
	!foome;
	.print("Estou satisfeito").
+!foome <- .print("comendo...").

+!sede : true <- .print("Estou com sede !!!");
	!seede;
	.print("Bebi o suficiente").
+!seede <- .print("Bebendo...").

+!sono : true <- .print("Estou com sono !!!");
	!soono;
	.print("Dormi").
+!soono <- .print("To quase dormindo...").

