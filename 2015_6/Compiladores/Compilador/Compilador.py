import sys
import argparse
sys.path.insert(0, 'src')
from lexico import analisador as lexico
from sintatico import analisador as sintatico
from semantico import analisador as semantico

def imprime(msg):
    print(msg)
    print("-" * 80)  # Faz risco

def erro(cabecalho, texto):  # Funcao de erro recebe o cabecalho e o texto para ser impresso
    print("\n{:-^40}".format(cabecalho))  # Imprime o cabecalho
    print(texto)  # Imprime o texto

if sys.version <= "3.6.6":
    erro("ERRO", "A versao do python nao é compativel com o programa, usar a versao 3.6.6 ou posterior ")

param = argparse.ArgumentParser()
param.add_argument("-tudo",help="Exibe todas as listagens do compilador",action="store_true")
param.add_argument("-lt",help="Exibe  a listagem dos Tokens",action="store_true")
param.add_argument("-ls",help="Exibe o LOG do analisador sintático",action="store_true")
param.add_argument("codigo",type=str,help="Codigo fonte")
args = param.parse_args()
if not args:   # verifica se a lista (param) esta vazia
    print("ERRO","Programa sem ARGUMENTO")  # Chama a funcao erro e passa o erro
    sys.exit()

if not '.m' in args.codigo:
    erro("ERRO","Extensão de arquivo errado")
    sys.exit()
lista = lexico(args.codigo)
if lista[1]:
    print('\n')
    for i in lista[1]:
        print(i)

if args.lt or args.tudo:  # Verifica se o usuraio quer que imprima a lista de tokens
    print('\n')
    for tokens in lista[0]:  # Anda toda a lista de tokens
        imprime(f'{tokens.split("|")[0]:^15.15}\t\t\t\t{tokens.split("|")[1]:^16.16}\t\t\t\t{tokens.split("|")[2]:^5}\t\t{tokens.split("|")[3]:^5}')  # Imprime a lista de tokens

lista[1] = sintatico(lista[0])
if args.ls or args.tudo:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista[1]:  # Anda toda a lista de tokens
        imprime(i)  # Imprime a lista de tokens

semantico(lista[0])