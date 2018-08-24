def transicao(estado, letra):
    #j = 0
    for j in tabela:
        line = j.split(";")
        #print(line[0])
        #print(j)
        if line[0] == estado:
            for k in line[1]:
                if k == letra:
                    print('Proximo estado: {}'.format(line[2]))
                    return line[2].rstrip()
    return "error"


def erro():
    print("{:-^60}".format("PALAVRA NAO COMPATIVEL"))


automato = input('Nome do arquivo da tabela:').upper()
estado_inicial = input('Infome o estado inicial:')
estado_final = list(str(input('Informe o(s) estado(s) final(is):')).split(' '))
palavra = list(str(input('Digite a palavra:')).lower())
print("\n{:-^40}\n".format("INICIO"))
nl = len(palavra)

estado_atual = estado_inicial

#print('Automato: {}\nEstado inicial: {} \nEstado final: {} \nPalavra: {} \nNumero de caracteres da palavra: {}'.format(
 #   automato, estado_inicial, estado_final, palavra, nl))

with open(automato + '.txt', 'r') as file:
    tabela = file.readlines()
    #nt = len(tabela)
    #print(tabela)

for i in palavra:
    print("Estado atual: {}".format(estado_atual))
    print("Letra: {}".format(i))
    estado_atual = transicao(estado_atual, i)

    if estado_atual == "error":
        erro()
        break

if estado_atual in estado_final:
    print("\nPalavra {} é valida".format(''.join(palavra)))
    print("\n{:-^40}\n".format("FIM"))
else:
    erro()