// Agent kate1 in project AgentBigBrother.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!falapara.

/* Plans */

+!falapara: true <-
.print("Por favor, ligue a luz!");
.send(bob1, achieve, ligar(ok)).


+luz(ligada)<- 
.send(bob1,unachieve, ligar(ok)).
      
