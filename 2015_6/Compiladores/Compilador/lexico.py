import sys

def transicao(estado, letra):   # Verifica se a tem um proximo estado
    # carrega da tabela de tokens para a memoria
    with open('tabelaTokens.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:     # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:    # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro

def testeVariavel(buffer):
    for i in buffer:
        if transicao("q46",i) == "error":
            return False
    else:
        return True
def erro(cabecalho,texto,sair):  # Funcao de erro recebe o cabecalho e o texto para ser impresso
    print("\n{:-^40}".format(cabecalho))  # Imprime o cabecalho
    print(texto)    # Imprime o texto
    if sair == True:
        sys.exit()  # Fecha o programa

# sao passados dois argumentos no maximo
# pega os argumentos e coloca na lista parametros (param)

def analizador(codigoFonte):


    # carrega o codigo fonte para a memoria
    with open(codigoFonte, 'r') as file:
        codigo = file.readlines()

    lista_erros = ['Caractere|Linha|Coluna'] # Lista de erros
    lista_tokens = ['Lexema|Token|Linha|Coluna']   #Lista armazenas os Lexemas e os seus tokens
    nlinha = 0  # Inicializa nlinha(bumero de linhas) com 0
    # Verifica linha por linha do codigo fonte para verificar os tokens
    for linha in codigo:    # Verifica todas as linhas do codigo fonte
        estado_atual = "q0"  # Inicializa os estados atual e anterior com q0 que é o estado inicial
        buffer = ""     # Beffur para os tokens em teste
        nlinha +=1  # Guada o numero da linha que esta
        ncoluna = 0 # Zera a coluna sempre que começa uma nova linha
        texto = False  # Verifica se e string
        if linha[len(linha) - 1] == "\n":
            linha = linha.rstrip()
            # Dicionario com os estados finais e os tokens
            estados_finais = {
                'q5':'inicio',
                'q8':'fim',
                'q14':'escrever',
                'q16':'condicao_se',
                'q18':'tipo',
                'q21':'ler',
                'q25':'condicao_repeticao',
                'q28':'fim_repeticao',
                'q29':'virgula',
                'q30':'fecha_parenteses',
                'q31':'abre_parenteses',
                'q32':'dois_pontos',
                'q33':'final_linha',
                'q34':'matematica_divisao',
                'q35':'matematica_multiplicacao',
                'q36':'matematica_subtracao',
                'q37':'matematica_soma',
                'q38':'matematica_igual',
                'q39':'logica_igual',
                'q40':'senao',
                'q41':'ponto interrogacao',
                'q44':'texto',
                'q45':'numero',
                'q46':'variavel',
                'q47':'logica_maior',
                'q48':'logica_maior_que',
                'q49':'lociga_menor',
                'q50':'logica_menor_que',
                'q52':'logica_diferente',
                'q54':'atribuicao'
            }

        while(ncoluna < len(linha)):
            i = linha[ncoluna]
            estado_anterior = estado_atual
            ncoluna += 1  # Guarda o numero da coluna
            if i != "\t":

                # Verifica se o texto  esta entre aspas
                if i == '"' and texto == False: # Se inicio de string
                    texto = True    # E string
                else:
                    if i == '"' and texto == True:  # Se final de string
                        texto = False   # Nao e string
                        if estado_atual == "q42":
                            estado_atual = "q43"

                if estado_atual == "q0":    # Vefica se o estado autal e q0 se for é inicio de palavra
                    coluna = ncoluna    # coluna recebe o numero da culana que esta porque e a coluna de inicio de uma nova palavra
                if texto == True:   # Se for texto
                    estado_atual = transicao(estado_atual, i)  # estado atual chama a transicao e recebe o proximo estado
                    buffer = buffer + i  # buffer que guarda os tokens em teste
                    if estado_atual == "error":
                        colunaErro =+ 1
                        erro("TEXTO", "{} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, ncoluna), False)
                        estado_atual = estado_anterior
                        buffer = buffer.replace(i, "")

                    print(buffer)
                    if buffer and ncoluna == len(linha):
                        if testeVariavel(buffer) == False:
                            erro("2", "{} Caracter não esperado linha: {} e coluna: {}".format(buffer, nlinha, ncoluna - colunaErro -1), False)
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais['q46'] + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""


                else:   # Se nao for texto
                    if i != " ":  # Verifica se nao e quebra de linha ou espaco
                        estado_atual = transicao(estado_atual,i)  # estado atual chama a transicao e recebe o proximo estado
                        buffer = buffer + i  # buffer que guarda os tokens em teste
                        if ncoluna < len(linha):
                            if transicao(estado_atual, linha[ncoluna]) == "error":
                                if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                                    lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                    estado_atual = "q0"
                                    buffer = ""
                                elif testeVariavel(buffer) == True:
                                    estado_atual = "q46"
                                    buffer = ""
                                    ncoluna = coluna - 1
                                else:
                                    erro("1", "{} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, ncoluna),False)
                                    estado_atual = "q0"
                                    buffer = ""
                        else:
                            if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                                lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                estado_atual = "q0"
                                buffer = ""

                            if estado_atual == "error":
                                if testeVariavel(buffer) == False:
                                    erro("1","{} Caracter não esperado linha: {} e coluna: {}".format(i,nlinha,ncoluna),False)


                    if buffer and ncoluna == len(linha):
                        if testeVariavel(buffer) == False:
                            erro("2", "{} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, coluna), False)
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais['q46'] + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

    if estado_atual == "error":
        erro("3","{} Caracter não esperado linha: {} e coluna: {}".format(i,nlinha,coluna),False)

    else:
        return lista_tokens
        print("Codigo Verificado com sucesso")


    sys.exit()