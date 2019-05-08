// Agent bigbrother in project AgentBigBrother.mas2j

/* Initial beliefs and rules */


/* Initial goals */
/*
!latir.*/
!snif.
/*ADIÇÃO - OBJETIVO A SER ALCANÇADO*/
/*
+!latir : cachorro(desconhecido)
	 <- .print ("Au Au Au").*/
	 
/*DELAÇÃO*/
/*
-!latir <-
	.print("Snif snif snif");
	!snif.

+!snif <- 
	.print("Bob?");
	?cachorro(X);
	.print(X);
	!latir.
                        
+?cachorro(X) <-
	X = desconhecido;
	+cachorro(X).*/

	//Tipos de Plano
	
+!snif <-
	.print("Bob");
	+dog(bob).
	
+dog(bob) <- .print("sniff sniff");
!snif.
