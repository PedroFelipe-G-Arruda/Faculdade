// Agent pessoa2 in project exercicio03.mas2j

/* Initial beliefs and rules */

/* Initial goals */

+!cafe(ok) <-
.print("Desculpe, nao posso pegar agora. ");
.wait(2000);
.print("Joey, pegue uma cafe para Chandler, por gentileza?"); 
.wait(2000);
.send(pessoa3, achieve, cafe1(ok)).
