import sys

def transicao(estado, letra):   # Verifica se a tem um proximo estado
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
param = sys.argv[1:]

if not param:   # verifica se a lista (param) esta vazia
    erro("ERRO","Programa sem ARGUMENTO",True)  # Chama a funcao erro e passa o erro

nparam = len(param) # Verifica o numero de argumentos
lt = False
if nparam == 2: # se dois o primeiro tem que se -lt e o segundo o codigo fonte
    if param[0] == "-lt":   # Verica se realmente o primeto argumento e -kt
        lt = True   # Se for o segundo é o codigo fonte
        codigoFonte = param[1]  # O codigo fonte recebe o segundo argumento
    else:   # Se o primero nao for -lt esta errado
        erro("ERRO DE ARGUMENTO","Argumento {} nao reconhecido\n".format(param[0]),True) # chama funcao erro
else:   # Se nao tiver pois argumento entao o usuario so passou o codigo fonte
    codigoFonte = param[0]  # Codigo fonte recebe o primeir e unico argumento

# carrega da tabela de tokens para a memoria
with open('tabelaTokens.txt', 'r') as file:
    tabela = file.readlines()
#carrega o codigo fonte para a memoria
with open(codigoFonte, 'r') as file:
    codigo = file.readlines()



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
if sys.version <= "3.6.6":
    erro("ERRO","A versao do python nao é compativel com o programa, usar a versao 3.6.6 ou posterior ")
texto = False   # Verifica se e string
lista_erros = ['Caractere|Linha|Coluna'] # Lista de erros
lista_tokens = ['Lexema|Token|Linha|Coluna']   #Lista armazenas os Lexemas e os seus tokens
nlinha = 0  # Inicializa nlinha(bumero de linhas) com 0
# Verifica linha por linha do codigo fonte para verificar os tokens
for linha in codigo:    # Verifica todas as linhas do codigo fonte
    estado_atual = "q0"  # Inicializa os estados atual e anterior com q0 que é o estado inicial
    buffer = ""     # Beffur para os tokens em teste
    nlinha +=1  # Guada o numero da linha que esta
    ncoluna = 0 # Zera a coluna sempre que começa uma nova linha
    if linha[len(linha) - 1] == "\n":
        linha = linha.rstrip()

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
                if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                    if ncoluna < len(linha):    # Verifica se a linha ja esta no fim
                        if transicao(estado_atual, linha[ncoluna]) == "error":    # Se der erro a palavra nao continua
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"     # E estado atual recebe q0
                            buffer = ""     #Limpa o buffer
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

                if estado_atual == "error": # verifica se o esado atual e error
                    lista_tokens.append(i + "|" + "|" + str(nlinha) + "|" + str(coluna))

            else:   # Se nao for texto
                if i != " ":  # Verifica se nao e quebra de linha ou espaco
                    estado_atual = transicao(estado_atual,i)  # estado atual chama a transicao e recebe o proximo estado
                    buffer = buffer + i  # buffer que guarda os tokens em teste
                    if ncoluna < len(linha) and ncoluna == 1:
                        if transicao(estado_atual, linha[ncoluna]) == "error":
                            erro("1", "{} Caracter não esperado linha: {} e coluna: {}".format(i, nlinha, ncoluna),False)
                            estado_atual = "q0"
                            buffer = buffer.replace(i, "")



                    if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                        if ncoluna < len(linha):
                            if transicao(estado_atual, linha[ncoluna]) == "error":
                                lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                estado_atual = "q0"
                                buffer = ""
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

                    if estado_atual == "error":
                        if testeVariavel(buffer) == False:
                            if transicao(estado_atual, linha[ncoluna]) == "error":
                                erro("1","{} Caracter não esperado linha: {} e coluna: {}".format(i,nlinha,ncoluna),False)
                                estado_atual = estado_anterior
                                buffer = buffer.replace(i,"")
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais['q46'] + "|" + str(nlinha) + "|" + str(coluna))  # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

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
    print("Codigo Verificado com sucesso")

if lt == True:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista_tokens:  # Anda toda a lista de tokens
        print(f'{i.split("|")[0]:^30}\t\t\t\t{i.split("|")[1]:^30}\t\t\t\t{i.split("|")[2]:^8}\t\t{i.split("|")[3]:^8}')    # Imprime a lista de tokens
        print("-"*120)  #   Faz risco
sys.exit()