import sys
import argparse
sys.path.insert(0, 'src')
from lexico import analisador as lexico
from sintatico import analisador as sintatico
from semantico import analisador as semantico
from geradorCode import intermediaro

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
param.add_argument("-ts",help="Exibe tabela de simbolos",action="store_true")
param.add_argument("-ls",help="Exibe o LOG do analisador sintático",action="store_true")
param.add_argument("-lse",help="Exibe o LOG do analisador semantico",action="store_true")
param.add_argument("-lgc",help="exibe o LOG da geração de código",action="store_true")
param.add_argument("codigo",type=str,help="Codigo fonte")
param.add_argument("saida",type=str,help="Arquivo de saida")
args = param.parse_args()
ss = []
if not args:   # verifica se a lista (param) esta vazia
    print("ERRO","Programa sem ARGUMENTO")  # Chama a funcao erro e passa o erro
    sys.exit()

if not '.m' in args.codigo:
    erro("ERRO","Extensão de arquivo errado")
    sys.exit()

print('Analise Lexica Iniciada')
lista = lexico(args.codigo)

if lista[1]:
    print('\n')
    for i in lista[1]:
        print(i)
        sys.exit()
print("Analise Lexica Concluida!")
if args.lt or args.tudo:  # Verifica se o usuraio quer que imprima a lista de tokens
    print('\nLista de Tokens\n')
    for tokens in lista[0]:  # Anda toda a lista de tokens
        imprime(f'{tokens.split("|")[0]:^15.15}\t\t\t\t{tokens.split("|")[1]:^16.16}\t\t\t\t{tokens.split("|")[2]:^5}\t\t{tokens.split("|")[3]:^5}')  # Imprime a lista de tokens

print('Analise Sintatica Iniciada')
lista[1] = sintatico(lista[0])
if args.ls or args.tudo:  # Verifica se o usuraio quer que imprima o LOG do analisador sintatico
    print("\nLOG do analisador sintatico\n")
    for linha in lista[1]:  # Anda toda a lista
        imprime(linha)  # Imprime a lista

print('Analise Semantica Iniciada')
lista = semantico(lista[0])
if args.lse or args.tudo:  # Verifica se o usuraio quer que imprima o LOG do analisador semantico
    print("\nLOG do analisador semantico\n")
    for linha in lista[1]:  # Anda toda a lista
        imprime(linha)  # Imprime a lista

print('Geração de Código Iniciada')
lista[1] = intermediaro(lista[0], 0, 0, ss,args.saida)
print('Geração de Código Finalizada!')
if args.lgc or args.tudo:  # Verifica se o usuraio quer que imprima o LOG do analisador semantico
    print("\nLOG da geração de código\n")
    for linha in lista[1]:  # Anda toda a lista
        imprime(linha)  # Imprime a lista

if args.ts or args.tudo:  # Verifica se o usuraio quer que imprima a tabela de simbolos
    print("\nTabela de simbolos\n")
    for linha in lista[2]:  # Anda toda a lista
        imprime(f"{linha[0]} : {linha[1]}")  # Imprime a lista
