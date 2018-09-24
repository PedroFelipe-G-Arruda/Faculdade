
with open("site.html","r") as file:
    escreve = 1
    w = 0
    linha = ''
    for line in file:
        nline = line.strip()
        for i in nline:
            if (i == '<'):
                escreve = 0
            if (escreve == 1):
                linha +=i
            if (i == '>'):
                escreve = 1
        linha += '\n'
with open("site.txt","w") as file:
    file.writelines(linha)