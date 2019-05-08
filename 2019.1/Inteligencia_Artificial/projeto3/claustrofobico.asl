// Agent claustrofobico in project projeto3.mas2j



/* Initial beliefs and rules */



/* Initial goals */



/*
~aberta(porta).




+~aberta(porta):true <- .print("Porta Fechada. Vou abrir!!");
-~aberta(porta);
+aberta(porta);
.print("Porta Aberta").*/

aberta(~porta).




+aberta(~porta):true <- .print("Porta Fechada. Vou abrir!!");
+aberta(porta);
.print("Porta Aberta").

