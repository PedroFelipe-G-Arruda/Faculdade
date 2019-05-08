// Agent paranoico in project projeto3.mas2j



/* Initial beliefs and rules */



/* Initial goals */



aberta(porta).

/* Plans */

+aberta(porta):true <- .print("Porta Aberta. Vou fechar!!");
+aberta(~porta);
.print("Porta Fechada...").

