agua(0).
refrigerante(0).
iorgute(0).
frutas(0).
//agua
+!pedirAgua: agua(T) & T<2 <-
	.print("Precisa colocar agua na geladeira!");
	.wait(1000);
	.send(agenteCompra,achieve,agua(encher));
	-+agua(T+10);
	.wait(2000).
+!pedirAgua: agua(T) & T >=2<-
	.print("Retirou água");
	-+agua(T-1);
	.wait(1000);
	.print(T);
	!pedirAgua.
	
// refrigerante
+!pedirRefrigerante: refrigerante(T) & T<2 <-
	.print("Precisa colocar refrigerante na geladeira!");
	.wait(1000);
	.send(agenteCompra,achieve,refrigerante(encher));
	-+refrigerante(10);
	.wait(2000).
+!pedirRefrigerante: refrigerante(S) & S >=2<-
	.print("Retirou refrigerante");
	-+agua(S-1);
	.wait(1000);
	.print(S);
	!pedirRefrigerante.


// iorgute
+!pedirIorgute: iorgute(T) & T<2 <-
	.print("Precisa colocar iorgute na geladeira!");
	.wait(1000);
	.send(agenteCompra,achieve,iorgute(encher));
	-+iorgute(10);
	.wait(2000).
+!pedirIorgute: iorgute(S) & S >=2<-
	.print("Retirou iorgute");
	-+iorgute(S-1);
	.wait(1000);
	.print(S);
	!pedirIorgute.
	
//frutas

+!pedirFrutas: frutas(T) & T<2 <-
	.print("Precisa colocar frutas na geladeira!");
	.wait(1000);
	.send(agenteCompra,achieve,frutas(encher));
	-+frutas(10);
	.wait(2000).
+!pedirFrutas: frutas(S) & S >=2<-
	.print("Retirou frutas");
	-+frutas(S-1);
	.wait(1000);
	.print(S);
	!pedirFrutas.

