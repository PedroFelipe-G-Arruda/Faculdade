// Agent garrafa in project exercicio04.mas2j


/* Initial beliefs and rules */

acabou.
liquido(0).

/* Initial goals */

!encher.

/* Plans */

+!encher: acabou & liquido(A) & A<=950 <-   //950ml
	.print("Colocando agua ...", (A),"ml");
	-+liquido(A+50);
	.wait(100);
	!encher.

+!encher: liquido(A) & + A>50 <-
	.print("Esta cheio.");
	-acabou.
