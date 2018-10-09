import sys
lt = False  #lista de tokens
texto = False   # Verifica se e string

def transicao(estado, letra):   # Verifica se a tem um proximo estado
    for line in tabela:     # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:    # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro

def erro(cabecalho,texto):  # Funcao de erro recebe o cabecalho e o texto para ser impresso
    print("\n{:-^40}\n".format(cabecalho))  # Imprime o cabecalho
    print(texto)    # Imprime o texto
    sys.exit()  # Fecha o programa

# sao passados dois argumentos no maximo
# pega os argumentos e coloca na lista parametros (param)
param = sys.argv[1:]

if not param:   # verifica se a lista (param) esta vazia
    erro("ERRO","Programa sem ARGUMENTO")  # Chama a funcao erro e passa o erro

nparam = len(param) # Verifica o numero de argumentos
if nparam == 2: # se dois o primeiro tem que se -lt e o segundo o codigo fonte
    if param[0] == "-lt":   # Verica se realmente o primeto argumento e -kt
        lt = True   # Se for o segundo é o codigo fonte
        codigoFonte = param[1]  # O codigo fonte recebe o segundo argumento
    else:   # Se o primero nao for -lt esta errado
        erro("ERRO DE ARGUMENTO","Argumento {} nao reconhecido\n".format(param[0])) # chama funcao erro
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
    'q52':'logica_diferente'
}
lista_tokens = ['Lexema|Token|Linha|Coluna']   #Lista armazenas os Lexemas e os seus tokens
nlinha = 0  # Inicializa nlinha(bumero de linhas) com 0
# Verifica linha por linha do codigo fonte para verificar os tokens
for linha in codigo:    # Verifica todas as linhas do codigo fonte
    estado_atual  = estado_anterior = "q0"  # Inicializa os estados atual e anterior com q0 que é o estado inicial
    buffer = ""     # Beffur para os tokens em teste
    nlinha +=1  # Guada o numero da linha que esta
    ncoluna = 0 # Zera a coluna sempre que começa uma nova linha
    for i in linha: # Anda caractere a caractere da linha
        ncoluna += 1  # Guarda o numero da coluna
        if i != "\t":
            # Verifica se o texto  esta entre aspas
            if i == '"' and texto == False: # Se inicio de string
                texto = True    # E string
            else:
                if i == '"' and texto == True:  # Se final de string
                    texto = False   # Nao e string

            if estado_atual == "q0":    # Vefica se o estado autal e q0 se for é inicio de palavra
                coluna = ncoluna    # coluna recebe o numero da culana que esta porque e a coluna de inicio de uma nova palavra

            if texto == True:   # Se for texto
                estado_atual = transicao(estado_atual, i)   # estado atual chama a transicao e recebe o proximo estado
                buffer = buffer + i  # buffer que guarda os tokens em teste
                if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                    if ncoluna < len(linha):    # Verifica se a linha ja esta no fim
                        teste = transicao(estado_atual, linha[ncoluna])     # teste para saber se a palavra continua
                        if teste == "error":    # Se der erro a palavra nao continua
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"     # E estado atual recebe q0
                            buffer = ""     #Limpa o buffer

                if estado_atual == "error": # verifica se o esado atual e error
                    erro("ERRO LEXICO", "Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))  # Cham a funcao erro passando o erro
            else:   # Se nao for texto
                if i != "\n" and i != " ":  # Verifica se nao e quebra de linha ou espaco
                    estado_atual = transicao(estado_atual, i)
                    buffer = buffer + i  # buffer que guarda os tokens em teste
                    if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                        if ncoluna < len(linha):
                            teste = transicao(estado_atual, linha[ncoluna])
                            if teste == "error":
                                lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                                estado_atual = "q0"
                                buffer = ""
                        else:
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual] + "|" + str(nlinha) + "|" + str(coluna))    # Guarda na lista de tokens o lexima com o seu token sua linha e coluna
                            estado_atual = "q0"
                            buffer = ""

                    if estado_atual == "error":
                        erro("ERRO LEXICO", "Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))

    if buffer and ncoluna == len(linha):
        erro("ERRO LEXICO", "Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))

if estado_atual == "error":
    erro("ERRO LEXICO", "Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))
else:
    print("Codigo Verificado com sucesso")
if lt == True:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista_tokens:  # Anda toda a lista de tokens
        print(f'{i.split("|")[0]:^30}\t\t\t\t{i.split("|")[1]:^30}\t\t\t\t{i.split("|")[2]:^8}\t\t{i.split("|")[3]:^8}')    # Imprime a lista de tokens
        print("-"*120)  #   Faz risco
sys.exit()