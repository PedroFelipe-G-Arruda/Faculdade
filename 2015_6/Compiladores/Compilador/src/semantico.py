import sys
def analisador(listaTokens):
    def valor(linha):
        lista = ""
        while listaTokens[linha].split("|")[1] != "final_linha":
            if listaTokens[linha].split("|")[0] == "/" and (listaTokens[linha + 1].split("|")[0] == "0" or (listaTokens[linha + 1].split("|")[0] in dicVariavel.keys() and  dicVariavel[listaTokens[linha + 1].split("|")[0]] == "0")):  # Verifica se i e variavel
                print("\ndivisao por zero")
                sys.exit()
            if listaTokens[linha].split("|")[1] == "variavel" and dicVariavel[listaTokens[linha].split("|")[0]]:
                lista = lista + dicVariavel[listaTokens[linha].split("|")[0]] + " "
            else:
                lista = lista + listaTokens[linha].split("|")[0] + " "
            linha += 1
        for i in lista.rstrip():
            if i.isalpha():
                return lista.rstrip()
        return int(eval(lista.rstrip()))

    dicVariavel = {}  # Dicionario com as variaveis e seus valores
    lista_LOG = []
    listadic = []
    # Verificação de declaração de variaveis
    cont = 0  # contador
    for i in listaTokens:  # i percorre a lista de tokens
        if i.split("|")[1] == "variavel":  # Verifica se i e variavel
            if listaTokens[cont - 1].split('|')[0] == "int":
                if not i.split('|')[0] in dicVariavel.keys():  # Verifica de a variavel esta sendo declarada
                    if listaTokens[cont + 1].split("|")[1] == "atribuicao":
                        dicVariavel.update({i.split('|')[0]: f'{valor(cont + 2)}'})  # Adiciona a variavel no dicionario
                    else:
                        dicVariavel.update({i.split('|')[0]: None})  # Adiciona a variavel no dicionario
                    lista_LOG.append(f"Variavel: {i.split('|')[0]} declarada")
                else:
                    print(f"Variavel: [{i.split('|')[0]}] ja declarada")  # Adiciona o erro na lista de erro
                    sys.exit()

            elif i.split('|')[0] in dicVariavel.keys():  # Verifica se a variavel ja esta no dicionario
                if listaTokens[cont + 1].split("|")[1] == "atribuicao":
                    dicVariavel.update({i.split('|')[0]: f'{valor(cont + 2)}'})  # Adiciona a variavel no dicionario
                    lista_LOG.append(f"Variavel: {i.split('|')[0]} teve o seu valor altera para ({dicVariavel[i.split('|')[0]]})")

            else:  # Caso a variavel nao estaja no dicionario, e nao esteja sendo declarada
                print(f"Variavel: {i.split('|')[0]} nao declarada")   # Adiciona o erro na lista de erro
                sys.exit()
        cont += 1
    print("\nAnalize Semantica Concluida!")
    listadic = sorted(dicVariavel.items(), key=lambda k: k[0])
    lista = [listaTokens,lista_LOG, listadic]
    return lista