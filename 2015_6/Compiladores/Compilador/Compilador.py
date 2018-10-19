import sys
from lexico import analizador

if sys.version <= "3.6.6":
    print("ERRO", "A versao do python nao é compativel com o programa, usar a versao 3.6.6 ou posterior ")

param = sys.argv[1:]
if not param:   # verifica se a lista (param) esta vazia
    print("ERRO","Programa sem ARGUMENTO")  # Chama a funcao erro e passa o erro
    sys.exit()
tudo = lt = ars = ls = False

if "-tudo"in param:
    tudo = True
if "-lt" in param:
    lt = True
if "-as" in param:
    ars = True
if "-ls" in param:
    ls = True
if '.m' in param[len(param)-1]:
    codigoFonte = param[len(param)-1]


lista_tokens = analizador(codigoFonte)

if lt == True:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista_tokens:  # Anda toda a lista de tokens
        print(f'{i.split("|")[0]:^30}\t\t\t\t{i.split("|")[1]:^30}\t\t\t\t{i.split("|")[2]:^8}\t\t{i.split("|")[3]:^8}')  # Imprime a lista de tokens
        print("-" * 120)  # Faz risco
