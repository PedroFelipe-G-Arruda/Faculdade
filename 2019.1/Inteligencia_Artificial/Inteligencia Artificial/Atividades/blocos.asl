// Agent blocos in project Atividades.mas2j

/* Initial beliefs and rules */

/* Initial goals */
bloa(1).
blob(1).
bloc(1).

!mesa.
!move.
!s1(X).
!s2(Y).
!s3(Z).


/* Plans */

+!mesa: true <-
	.print("              ");
	.print("-A-       ");
	.print("-B-    -C-").

+!move: true <-
	move(a,X).
	move(
