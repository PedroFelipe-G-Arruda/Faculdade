// Agent fatorial in project AgentBigBrother.mas2j



/* Initial beliefs and rules */


cont(10).
!imprime_fatorial (10).

+!imprime_fatorial(N): cont(X) & X>0
	<-	//cont(X);
	.print("Fatorial de ", cont(X-1), " é ", X*5 );
	!imprime_fatorial(N).

