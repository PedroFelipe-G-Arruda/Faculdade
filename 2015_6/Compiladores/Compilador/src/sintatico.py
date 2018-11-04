import pilha
from passos import step


def transicao(estado, letra):  # Verifica se a tem um proximo estado
    with open('tabelas/tabela_sintatica.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:  # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:  # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro


def analisador(listaTokens):
    fila = []
    for i in listaTokens:
        fila.append(i.split("|")[1])

    del fila[0]
    del listaTokens[0]
    fila.append("$")
    pilha1 = pilha.Stack("<INICIO_FIM>")
    cont = 0
    lista_LOG = []

    while fila:
        if pilha1.top().isupper():
            processo = transicao(pilha1.top(), fila[0])
            if processo == "error":
                print(f"\nERRO: {listaTokens[cont].split('|')[0]} linha:{listaTokens[cont].split('|')[2]} coluna:{listaTokens[cont].split('|')[3]}")
                break

            pilha1.pop()
            i = len(step(processo).split("|")) - 1
            while i >= 0:
                if step(processo).split("|")[i] != "î":
                    pilha1.push(step(processo).split("|")[i])
                i -= 1
            lista_LOG.append(processo + ":" + step(processo))
        elif pilha1.top() == fila[0]:
            del fila[0]
            cont += 1
            pilha1.pop()

    print("\nAnalize Sintatica Concluida!") if not fila and pilha1.isEmpty() else print("\nErro pilha ou fila nao estao vazias")
    return (lista_LOG)