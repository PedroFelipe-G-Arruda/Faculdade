!pedir.
+!pedir: true <-
	.print("Quero água.");
	.send(geladeira,achieve,pedirAgua);
	.wait(2500);
	.send(geladeira,achieve,pedirIorgute).



