// Agent agentecompras in project exercicio02.mas2j

/* Initial beliefs and rules */

/* Initial goals */

+!agua(cheia) <-
.send(geladeira, achieve, pediragua);
.print("Agua colocada").

+!suco(cheia) <-
.send(geladeira, achieve, pedirsuco);
.print("Suco colocado").

+!refri(cheia) <-
.send(geladeira, achieve, pedirrefri);
.print("Refrigerante colocado").
