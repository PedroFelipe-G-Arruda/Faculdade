// Agent robo in project Atividades.mas2j



/* Initial beliefs and rules */

bat(100).

/* Initial goals */

!bateria.

/* Plans */

+!bateria: bat(I) & I>0 & I>15 <-
	.print("Andando... ", I,"% da bateria.");
	-+bat(I-1);
	.wait(100);
	!bateria.
	
+!bateria : bat(I) & I<=15 & I>0 <-
	.print(I,"% da bateria.       Bateria esta descarregando");
	-+bat(I-1);
	.wait(100);
	!bateria.
	
+!bateria: bat(I) & I=0 <-
	.print("Bateria zerada... Carregando bateria...");
	-+bat(I+100);
	.wait(3000);
	.print("---------------Bateria Carregada---------------");
	.wait(3000).

