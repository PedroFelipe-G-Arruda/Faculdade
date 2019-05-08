semcomida.
fome.
comida(39).
estomago(0).

!comer.
+!comer: fome & comida(F) & estomago(S) & S <= 50 & F > 0 <-.print("Comendo...");
-+comida(F-1);
-+estomago(S+1);
.print(F);
!comer.

+!comer: fome & semcomida & comida(F) & F == 0 <-.print("Colocando comida...");
-+comida(F+2);
.print(F);
!comer.

+!comer: estomago(S) & S > 50 <-.print("Eu estou satisfeito");
-fome.

+!comer: comida(F) & F == 0 & estomago(S) & S<50 <-.print("Sem comida");
+fome;
+semcomida.
