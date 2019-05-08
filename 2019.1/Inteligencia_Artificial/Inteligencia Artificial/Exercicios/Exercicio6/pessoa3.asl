// Agent pessoa3 in project exercicio03.mas2j

/* Initial beliefs and rules */

/* Initial goals */

+!cafe1(ok) <-
.print("OK Ross, eu pego uma cafe para Chandler!");
.wait(2000);
.send(pessoa1, achieve, acabar(ok)).

