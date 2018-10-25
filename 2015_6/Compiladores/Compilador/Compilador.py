import sys
import argparse
sys.path.insert(0, 'C:\\Users\\pedro\\OneDrive\\Faculdade\\Faculdade\\2015_6\\Compiladores\\Compilador\\src')
from lexico import analizador
from sintatico import analizador as sintatico



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

if  not '.m' in args.codigo:
    erro("ERRO","Extensão de arquivo errado")
    sys.exit()
lista_tokens = analizador(args.codigo)

if args.lt:  # Verifica se o usuraio quer que imprima a lista de tokens
    print("\n")
    for i in lista_tokens:  # Anda toda a lista de tokens
        print(f'{i.split("|")[0]:^15.15}\t\t\t\t{i.split("|")[1]:^16.16}\t\t\t\t{i.split("|")[2]:^5}\t\t{i.split("|")[3]:^5}')  # Imprime a lista de tokens
        print("-" * 105)  # Faz risco

sintatico(lista_tokens)