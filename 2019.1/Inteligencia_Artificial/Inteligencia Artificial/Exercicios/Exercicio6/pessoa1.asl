// Agent pessoa1 in project exercicio03.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!falarpara.
/* Plans */
+!falarpara : true <- 
.print("Por Favor Ross, pode pegar me pegar uma cafe?");
.wait(2000);
.send(pessoa2, achieve, cafe(ok)).


+!acabar(ok) <- 
.print("Obrigado, Joey!!!").
