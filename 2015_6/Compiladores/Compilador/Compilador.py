import sys
from lexico import analizador

if sys.version <= "3.6.6":
    print("ERRO", "A versao do python nao é compativel com o programa, usar a versao 3.6.6 ou posterior ")

param = sys.argv[1:]
if not param:   # verifica se a lista (param) esta vazia
    print("ERRO","Programa sem ARGUMENTO")  # Chama a funcao erro e passa o erro

nparam = len(param) # Verifica o numero de argumentos
lt = False
if nparam == 2: # se dois o primeiro tem que se -lt e o segundo o codigo fonte
    if param[0] == "-lt":   # Verica se realmente o primeto argumento e -kt
        lt = True   # Se for o segundo é o codigo fonte
        codigoFonte = param[1]  # O codigo fonte recebe o segundo argumento
    else:   # Se o primero nao for -lt esta errado
        print("ERRO DE ARGUMENTO","Argumento {} nao reconhecido\n".format(param[0]),) # chama funcao erro
else:   # Se nao tiver pois argumento entao o usuario so passou o codigo fonte
    codigoFonte = param[0]  # Codigo fonte recebe o primeir e unico argumento

lista_tokens = analizador(codigoFonte)

if lt == True:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista_tokens:  # Anda toda a lista de tokens
        print(f'{i.split("|")[0]:^30}\t\t\t\t{i.split("|")[1]:^30}\t\t\t\t{i.split("|")[2]:^8}\t\t{i.split("|")[3]:^8}')  # Imprime a lista de tokens
        print("-" * 120)  # Faz risco
