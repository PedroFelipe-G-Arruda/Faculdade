// Agent kate in project askOne.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!falarpara.

/* Plans */

+!falarpara : true <- .print("Qual seu nome ?");
.send(bob, askOne, nome(Nome), Replay);
+Replay.

