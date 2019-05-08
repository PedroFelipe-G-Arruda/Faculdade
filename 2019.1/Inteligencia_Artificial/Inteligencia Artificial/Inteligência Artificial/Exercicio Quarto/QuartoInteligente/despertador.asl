despertar_bob(18).
depertar_kate(12).
hora(10).

!despertar.


+!incrementarHora : hora(H) & H<24 <-
	.print("Hora > ",H);
	-+hora(H + 1);
	.wait(500);
	!despertar.
+!incrementarHora : hora(H) & H >= 24 <-
	-+hora(0);
	.wait(500);
	!despertar.
	
+!despertar : hora(H) & H == 12 <-
	.print("Hora > ",H," Hora de Despertar KATE.");
	.print("RING RING RING");
	.send(kate,achieve,acorde(sim));
	!incrementarHora.
	
+!despertar : hora(H) & H == 18 & acordada(nao)[source(bob)] <-
	.print("Hora > ",H," Hora de Despertar BOB.");
	.print("RING RING RING");
	.send(bob,achieve,acorde(sim));
	!incrementarHora.
	
+!despertar : hora(H) & H < 12 | H > 12 <-
	!incrementarHora.



	
	
