!teach(kate).

+!teach(kate)<-.print("Isto � como fazemos...");
	.send(kate, tellHow, "+!luz(lgada <- .print(\"Luz ligada.\").");
	.wait(3000);
	.send(kate, achieve, luz(ligada)).
	
+!luz(ligada)<-.print("Luz ligada").
