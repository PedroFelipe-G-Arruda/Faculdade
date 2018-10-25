import pilha
from passos import step


def transicao(estado, letra):  # Verifica se a tem um proximo estado
    with open('tabelas\\tabela_sintatica.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:  # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:  # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro


def analizador(listaTokens):
    fila = []
    for i in listaTokens:
        fila.append(i.split("|")[1])

    del fila[0]
    fila.append("$")

    pilha1 = pilha.Stack("<INICIO_FIM>")

    cont = 0
    print("INICIO\n\n")

    while fila:
        top = pilha1.pop()
        if top.isupper() == True:
            processo = transicao(top, fila[0])
            if processo == "error":
                print("ERRO")
                print(f"linha:{listaTokens[cont].split('|')[2]} coluna:{listaTokens[cont].split('|')[3]}")
                break

            i = len(step(processo).split("|")) - 1
            while i >= 1:
                if step(processo).split("|")[i] != "î":
                    pilha1.push(step(processo).split("|")[i])
                i -= 1
        elif top == fila[0]:
            print(f"#{top} = {fila[0]}#")
            del fila[0]
            cont += 1

    if not fila and pilha1.isEmpty():
        return print("Sem erros Sintaticos")
    else:
        return print("Erro pilha ou fila nao estao vazias")
