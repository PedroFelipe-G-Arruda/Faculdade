// Agent multi in project AgentBigBrother.mas2j

/* Initial beliefs and rules */
cont(0).
/* Initial goals */

!start.

!calcu(8).
+!start : true <- .print("//=========//TABUADA//=========//").
//!i(5).

//+!imprime_tabu(N)
+!calcu(N) : cont(I) & I<=10 <-

	.print("                       ",N," x ",I," = ", I*N);
	-+cont(I+1);
	!calcu(N).

	+!calcu(N) <-
.print("//=========//=========//=========//").
