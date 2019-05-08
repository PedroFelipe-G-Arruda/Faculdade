// Agent parimpar in project AgentBigBrother.mas2j

/* Initial beliefs and rules */

/* Initial goals */


!print_par(9).
+!print_par(N)
	<- !par (N,F);
		.print(N," é ", F).
		
		+!par(N,F) : ((N mod 3)== 0 &(N mod 6)== 0 ) <- F=par.
		+!par(N,F) : ((N mod 3)>= 0 &(N mod 6)> 0) <- F=impar.
		
