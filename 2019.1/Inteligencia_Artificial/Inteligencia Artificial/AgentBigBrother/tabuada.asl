
!iniciar.
!multi.
cont(0)

+!iniciar : true <-.print("Tabuada").
!imprime_multi(3).
+!imprime_multi(N)

+!multi: cont(I) & I<=10 
	<-
	.print(N);
-+cont(I+1);
!multi.

/*	

+!multi: cont(I) & I<=10 <-

!multi(N,M,0) : M == 0.

+!multi (N,M,F) : M > 0
<-!multi(N,M+1,F);
 	F = N * M.
-+cont(I+1);
!multi.*/
