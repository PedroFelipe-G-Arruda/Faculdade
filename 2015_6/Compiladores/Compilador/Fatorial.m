begin
    egin;
    int fat <- 1;
    int n;
    output("Insira o numero para saber o seu fatorial:");
    input(n);
    loop n > 1:
        fat <- fat * n;
        n <- n - 1;
    lend;
    output("O fatorial e:" fat);
    output(fat);
end