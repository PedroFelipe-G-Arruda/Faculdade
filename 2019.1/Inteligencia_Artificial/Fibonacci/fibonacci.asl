!print_fibonacci(30).
+!print_fibonacci(N)<-!fibonacci(N,F);
.print(N, "n�mero da s�rie de Fibonacci � ",F).
+!fibonacci(N,1):N == 1.
+!fibonacci(N,1):N == 2.
+!fibonacci(N,F):N > 2<-!fibonacci(N-1,F1);
!fibonacci(N-2,F2);
F=F1+F2.
