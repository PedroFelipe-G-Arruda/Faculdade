// Agent print in project Exercicio2.mas2j

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */

+!mundo(a)<-
	.print("                          ","|  |   ","|  |   ","|  |"  );
	.print("                          ","|A|   ","|  |   ","|  |");
	.print("                          ","|B|   ","|C|   ","|  |");
	.print("                  --------------------------------------").
	
	
	
+!mundo(b)<-
	.print("                          ","|  |   ","|  |   ","|  |"  );
	.print("                          ","|  |   ","|  |   ","|  |");
	.print("                          ","|B|   ","|C|   ","|A|");
	.print("                  --------------------------------------").

+!mundo(c)<-
	.print("                          ","|  |   ","|  |   ","|  |"  );
	.print("                          ","|  |   ","|  |   ","|B|");
	.print("                          ","|  |   ","|C|   ","|A|");
	.print("                  --------------------------------------").
	
+!mundo(d)<-
	.print("                          ","|  |   ","|  |   ","|C|"  );
	.print("                          ","|  |   ","|  |   ","|B|");
	.print("                          ","|  |   ","|  |   ","|A|");
	.print("                  --------------------------------------").
	
	
+!mundo(e)<-
	.print("                          ","|C|   ","|  |   ","|  |"  );
	.print("                          ","|B|   ","|  |   ","|  |");
	.print("                          ","|A|   ","|  |   ","|  |");
	.print("                  --------------------------------------").
