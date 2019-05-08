// Agent pensando in project AgentBigBrother.mas2j



/* Initial beliefs and rules */

cont (0).

!iniciar.
!pensando.

+!iniciar : true <-.print("Iniciei").

+!pensando: cont(I) & I<=10 <-
	.print("Pensando",I*5);
	-+cont(I+1);
	!pensando.
	
+!pensando <-
.print("Sem eventos para executar, terminei!").
