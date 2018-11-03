def analisador(listaTokens):

    def valor(linha):
        lista = []
        while listaTokens[linha].split("|")[1] != "final_linha":
            lista.append(listaTokens[linha].split("|")[0])
            linha +=1
        return lista

    dicVariavel = {} # Dicionario com as variaveis e seus valores
    listaErros = [] # Listade erros
    # Verificação de declaração de variaveis
    cont = 0 # contador
    for i in listaTokens:   # i percorre a lista de tokens
        if i.split("|")[1] == "variavel":   # Verifica se i e variavel
            print(f"Variavel: [{i.split('|')[0]}]")
            if i.split("|")[0] in dicVariavel.keys():   # Verifica se a variavel ja esta no dicionario
                print("ok")

            elif listaTokens[cont - 1].split("|")[0] == "int":  # Verifica de a variavel esta sendo declarada
                dicVariavel.update({i.split('|')[0]: None}) # Adiciona a variavel no dicionario
                print("variavel add no dicionario")

            else:   # Caso a variavel nao estaja no dicionario, e nao esteja sendo declarada
                listaErros.append(f"Variavel: [{i.split('|')[0]}] nao declarada")   # Adiciona o erro na lista de erro
                print("nao declarado")

        cont += 1
    print(listaErros)
    print(dicVariavel)
    return ()