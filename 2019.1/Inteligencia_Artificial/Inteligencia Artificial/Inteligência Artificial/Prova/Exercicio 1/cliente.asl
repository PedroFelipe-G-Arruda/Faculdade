poltrona.
livre(5).
ocupada(0).

!vender.
!interfaceSistema.
+!interfaceSistema : true <-
	.print("Ol�, seja bem vindo ao cinema, Qual � a sua poltrona?");
	.send(poltronas,askOne,poltrona(Livre)).
+!vender: livre(K) & ocupada(S) & S <=Livre & K >0 <-
	.print("A poltrona de n�mero ja foi vendida -> ",K);
	-+livre(K-1);
	-+ocupada(S+1);
	.wait(500);
	!vender.
+!vender: ocupada(T) & T >=5 <-
	.print("Todas as poltronas ocupada!");
	.print("As vendas foram encerradas!");
	-poltrona.
