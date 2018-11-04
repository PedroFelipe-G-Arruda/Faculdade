def analisador(listaTokens):
    def valor(linha):
        lista = ""
        while listaTokens[linha].split("|")[1] != "final_linha":
            lista = lista + listaTokens[linha].split("|")[0] + " "
            linha += 1
        return lista.rstrip()

    dicVariavel = {}  # Dicionario com as variaveis e seus valores
    listaErros = []  # Listade erros
    # Verificação de declaração de variaveis
    cont = 0  # contador
    for i in listaTokens:  # i percorre a lista de tokens
        if i.split("|")[1] == "variavel":  # Verifica se i e variavel
            if listaTokens[cont - 1].split('|')[0] == "int":
                if not i.split('|')[0] in dicVariavel.keys():  # Verifica de a variavel esta sendo declarada
                    dicVariavel.update({i.split('|')[0]: None})  # Adiciona a variavel no dicionario
                else:
                    print(f"Variavel: [{i.split('|')[0]}] ja declarada")  # Adiciona o erro na lista de erro
                    break

            elif i.split('|')[0] in dicVariavel.keys() and not i.split('|')[0] in listaErros:  # Verifica se a variavel ja esta no dicionario
                if listaTokens[cont + 1].split("|")[1] == "atribuicao":
                    dicVariavel.update({i.split('|')[0]: valor(cont + 2)})  # Adiciona a variavel no dicionario

            else:  # Caso a variavel nao estaja no dicionario, e nao esteja sendo declarada
                print(f"Variavel: {i.split('|')[0]} nao declarada")   # Adiciona o erro na lista de erro
                break
        cont += 1
    for i in listaTokens:  # i percorre a lista de tokens
        if i.split("|")[0] == "/" and listaTokens[cont - 1].split('|')[0]:  # Verifica se i e variavel
            print("divisao por zero")
    print("\nAnalize Semantica Concluida!")
    return "ok"