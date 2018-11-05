import pilha
from passos import step


def transicao(estado, letra):  # Verifica se a tem um proximo estado
    with open('tabelas/tabela_sintatica.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:  # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:  # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro


def analisador(listaTokens):    #Funcao principal
    fila = []   # Cria a fila para os tokens
    for i in listaTokens:
        fila.append(i.split("|")[1])    # Adiciona os tokens a fila

    del fila[0]     # Deleta o primeiro item da fila
    del listaTokens[0]  # Deleta o primeiro item da fila
    fila.append("$")    # Adiciona $ no final da fila
    pilha1 = pilha.Stack("<INICIO_FIM>")    # Cria a pilha e coloca o nao terminal
    cont = 0    # Inicializa o contador igual a 0
    lista_LOG = []  # Inicializa lista de LOG

    while fila and not pilha1.isEmpty(): #
        if pilha1.top().isupper():  #Verifica se e nao terminal, pois eles sao em letras maiusculas
            processo = transicao(pilha1.top(), fila[0])     # Processo recebe o numero do processo
            if processo == "error": # Verifica se e erro o processo
                print(f"\nERRO: {listaTokens[cont].split('|')[0]} linha:{listaTokens[cont].split('|')[2]} coluna:{listaTokens[cont].split('|')[3]}")
                break   # Para o programa
            pilha1.pop()
            i = len(step(processo).split("|")) - 1 # I recebe o numero de estados do processo
            while i >= 0:
                if step(processo).split("|")[i] != "î":     # Se o estado nao for vazio (î)
                    pilha1.push(step(processo).split("|")[i])   # Addiciona da pilha
                i -= 1  # Decrementa i
            lista_LOG.append(processo + ":" + step(processo))   # Adiciona o processo no LOG
        elif pilha1.top() == fila[0]:   # Se o topo da pilha for igual a primeira coisa de fila
            del fila[0]     # Deleta o primeiro item da fila
            cont += 1   # Contador + 1
            pilha1.pop()    # Tira o topo da pilha

    print("\nAnalize Sintatica Concluida!") if not fila and pilha1.isEmpty() else print("\nErro pilha ou fila nao estao vazias")
    return (lista_LOG)