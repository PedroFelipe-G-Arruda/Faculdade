acabou.
liquido(0).
!encher.
/* Plans */
+!encher: acabou & liquido(S) & S<=950 <-   //950ml
	.print("Colocando café ...");
	-+liquido(S+1);
	.print(S);
	.wait(25);
	!encher.

+!encher: liquido(S) & S>950 <-
	.print("Esta cheio.");
	-acabou.

