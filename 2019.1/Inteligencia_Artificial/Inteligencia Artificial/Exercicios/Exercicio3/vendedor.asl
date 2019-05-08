// Agent vendedor in project Exercicio3.mas2j

/* Initial beliefs and rules */

/* Initial goals */
!bomdia.


/* Plans */

+!bomdia:true <-
	.print("Bom dia, bem vindo a Padaria Sonhos. O que o senhor deseja?").
	
+produto(pao) <-
	.wait(200);
	.print("Aqui senhor seus paes.").
	
+produto(presunto) <-
	.wait(200);
	.print("Aqui senhor seus presunto.").	
	
+produto(mussarela) <-
	.wait(200);
	.print("Aqui senhor seus mussarela.").	
	
+produto(cafe) <-
	.wait(200);
	.print("Aqui senhor seus cafe.").	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
+!vender(pao):true <-
	.wait(4000);
	.print("Claro, aqui esta. Obrigado pela preferencia").

+!vender(presunto):true <-
	.wait(4000);
	.print("Claro, aqui esta. Obrigado pela preferencia").

+!vender(mussarela):true <-	
	.wait(4000);
	.print("Claro, aqui esta. Obrigado pela preferencia").

+!vender(cafe):true <-
	.wait(4000);
	.print("Claro, aqui esta. Obrigado pela preferencia").
	
