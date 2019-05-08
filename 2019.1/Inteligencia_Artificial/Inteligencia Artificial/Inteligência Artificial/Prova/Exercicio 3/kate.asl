!pedir.
+!pedir: true <-
	.print("Quero Refrigerante!!! Agora");
	.send(geladeira,achieve,pedirRefrigerante);
	.wait(5000);
	.print("Haaaa, eu tambem quero uma maçã ");
	.send(geladeira,achieve,pedirFrutas).
