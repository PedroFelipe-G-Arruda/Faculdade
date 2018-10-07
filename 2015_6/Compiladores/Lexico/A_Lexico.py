import sys
lt = False  #lista de tokens
texto = False   # Verifica se e string

def transicao(estado, letra):   # Verifica se a tem um proximo estado
    for line in tabela:     # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:    # Verifica se tem estado e letra na linha
           # print(line)
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro

# sao passados dois argumentos no maximo

# pega os argumentos e coloca na lista parametros (param)
param = sys.argv[1:]


if not param:   # verifica se a lista (param) esta vazia
    print("\n{:-^40}\n".format("ERRO"))
    print("Programa sem ARGUMENTO\n")
    print("-> Passar argumentos juntos do programa <-\n")
    sys.exit()  # fecha o programa

nparam = len(param)
if nparam == 2:
    if param[0] == "-lt":
        lt = True
        codigoFonte = param[1]
    else:
        print("\n{:-^40}\n".format("ERRO"))
        print("Argumento {} nao reconhecido\n".format(param[0]))
        print("-> Passar argumento corretamente <-\n")
        sys.exit()
else:
    codigoFonte = param[0]


# carrega da tabela de tokens
with open('tabelaTokens.txt', 'r') as file:
    tabela = file.readlines()

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
k = 0
lista_tokens = []
nlinha = 0  # Inicializa nlinha(bumero de linhas) com 0
# Verifica linha por linha do codigo fonte para verificar os tokens
for linha in codigo:    # Verifica todas as linhas do codigo fonte
    estado_atual  = estado_anterior = "q0"  # Inicializa os estados atual e anterior com q0 que é o estado inicial
    buffer = ""     # Beffur para os tokens em teste
    nlinha +=1  # Guada o numero da linha que esta
    ncoluna = 0 # Zera a coluna sempre que começa uma nova linha
    for i in linha: # Anda caractere a caractere da linha
        ncoluna += 1    # Guarda o numero da coluna
        # Verifica se o texto  esta entre aspas
        if i == '"' and texto == False: # Se inicio de string
            texto = True    # E string
        else:
            if i == '"' and texto == True:  # Se final de string
                texto = False   # Nao e string

        if texto == True:   # Se for texto
            estado_anterior = estado_atual
            estado_atual = transicao(estado_atual, i)
            buffer = buffer + i  # buffer que guarda os tokens em teste
            if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                if ncoluna < len(linha):
                    teste = transicao(estado_atual, linha[ncoluna])
                    if teste == "error":
                        lista_tokens.append(buffer + "|" + estados_finais[estado_atual])
                        estado_atual = "q0"
                        buffer = ""

            if estado_atual == "error":
                print("\n{:-^40}\n".format("ERRO LEXICO"))
                print("Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))
                sys.exit()
        else:   # Se nao for texto
            if i != "\n" and i != " ":  # Verifica se nao e quebra de linha ou espaco
                print("Letra: {}".format(i))
                estado_anterior = estado_atual
                print("Estado atenrior: {}".format(estado_anterior))
                estado_atual = transicao(estado_atual, i)
                print(estado_atual)
                buffer = buffer + i  # buffer que guarda os tokens em teste
                if estado_atual in estados_finais:  # Verifica se o estado atual é um estado final
                    if ncoluna < len(linha):
                        teste = transicao(estado_atual, linha[ncoluna])
                        if teste == "error":
                            lista_tokens.append(buffer + "|" + estados_finais[estado_atual])
                            estado_atual = "q0"
                            buffer = ""
                    else:
                        lista_tokens.append(buffer + "|" + estados_finais[estado_atual])
                        buffer = ""

                if estado_atual == "error":
                    print("\n{:-^40}\n".format("ERRO LEXICO"))
                    print("Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))
                    sys.exit()

    if buffer and ncoluna == len(linha):
        print("\n{:-^40}\n".format("ERRO LEXICO"))
        print("Erro lexico na linha [{}] e coluna [{}]".format(nlinha, ncoluna))
        sys.exit()

if estado_atual == "error":
    print("\n{:-^40}\n".format("ERRO LEXICO"))
    print("Erro lexico na linha [{}] e coluna [{}] -> [{}] <-".format(nlinha,ncoluna,i))
    sys.exit()

else:
    print("Codigo Verificado com sucesso")

if lt == True:
    print("\n")
    print("{}\t\t\t{}\n".format("Lexema", "Token"))
    print("-"*40)
    for i in lista_tokens:
        print("{}\t\t\t{}".format(i.split("|")[0],i.split("|")[1]))
        print("-"*40)