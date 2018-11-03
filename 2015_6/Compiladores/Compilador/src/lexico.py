from estadosFinais import tokem

def transicao(estado, letra):  # Verifica se a tem um proximo estado
    # carrega da tabela de tokens para a memoria
    with open('tabelas/tabelaTokens.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:  # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:  # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro


def testeVariavel(buffer):
    for i in buffer:
        if transicao("q46", i) == "error":
            return False
        else:
            return True


def analisador(codigoFonte):
    # carrega o codigo fonte para a memoria
    with open(codigoFonte, 'r') as file:
        codigo = file.readlines()

    lista_erros = []  # Lista de erros
    lista_tokens = ['Lexema|Token|Linha|Coluna']  # Lista armazenas os Lexemas e os seus tokens
    nlinha = 0  # Inicializa nlinha(bumero de linhas) com 0
    # Verifica linha por linha do codigo fonte para verificar os tokens
    for linha in codigo:  # Verifica todas as linhas do codigo fonte
        estado_atual = "q0"  # Inicializa os estados atual e anterior com q0 que é o estado inicial
        buffer = ""  # Beffur para os tokens em teste
        nlinha += 1  # Guada o numero da linha que esta
        ncoluna = 0  # Zera a coluna sempre que começa uma nova linha
        texto = False  # Verifica se e string

        if linha[len(linha) - 1] == "\n":
            linha = linha.rstrip()

        while (ncoluna < len(linha)):
            i = linha[ncoluna]
            estado_anterior = estado_atual
            ncoluna += 1  # Guarda o numero da coluna
            if i != "\t":

                # Verifica se o texto  esta entre aspas
                if i == '"' and texto == False:  # Se inicio de string
                    texto = True  # E string
                elif i == '"' and texto == True:  # Se final de string
                    texto = False  # Nao e string
                    if estado_atual == "q42":
                        estado_atual = "q43"

                if estado_atual == "q0":  # Vefica se o estado autal e q0 se for é inicio de palavra
                    coluna = ncoluna  # coluna recebe o numero da culana que esta porque e a coluna de inicio de uma nova palavra
                if texto == True:  # Se for texto
                    estado_atual = transicao(estado_atual,
                                             i)  # estado atual chama a transicao e recebe o proximo estado
                    buffer = buffer + i  # buffer que guarda os tokens em teste
                    if estado_atual == "error":
                        colunaErro = + 1
                        lista_erros.append(i + "|" + nlinha + "|" + ncoluna)
                        estado_atual = estado_anterior
                        buffer = buffer.replace(i, "")

                    if buffer and ncoluna == len(linha):
                        if testeVariavel(buffer) == False:
                            lista_erros.append(buffer +"|" + nlinha + "|" + (ncoluna - colunaErro - 1))
                        else:
                            lista_tokens.append(buffer + "|" + tokem('q46') + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

                else:  # Se nao for texto
                    if i != " ":  # Verifica se nao e quebra de linha ou espaco
                        estado_atual = transicao(estado_atual,i)  # estado atual chama a transicao e recebe o proximo estado
                        buffer = buffer + i  # buffer que guarda os tokens em teste
                        if ncoluna < len(linha):
                            if transicao(estado_atual, linha[ncoluna]) == "error":
                                if tokem(estado_atual):  # Verifica se o estado atual é um estado final
                                    lista_tokens.append(buffer + "|" + tokem(estado_atual) + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                    estado_atual = "q0"
                                    buffer = ""
                                elif testeVariavel(buffer) == True:
                                    estado_atual = "q46"
                                    buffer = ""
                                    ncoluna = coluna - 1
                                else:
                                    lista_erros.append("ERRO {} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, coluna))
                                    estado_atual = "q0"
                                    buffer = ""
                        else:
                            if tokem(estado_atual):  # Verifica se o estado atual é um estado final
                                lista_tokens.append(buffer + "|" + tokem(estado_atual) + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                estado_atual = "q0"
                                buffer = ""

                            if estado_atual == "error" and testeVariavel(buffer) == False:
                                lista_erros.append("ERRO {} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, coluna))

                    if buffer and ncoluna == len(linha):
                        if testeVariavel(buffer) == False:
                            lista_erros.append("ERRO {} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, coluna))
                        else:
                            lista_tokens.append(buffer + "|" + tokem('q46') + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

    if estado_atual == "error":
        lista_erros.append("ERRO {} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, coluna))

    lista = [lista_tokens,lista_erros]
    print("\nAnalize lexica finalizada")
    return lista