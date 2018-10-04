import sys


def transicao(estado, letra):
    for line in tabela:
        if estado + '|' + letra in line:
            print(line)
            return line.split('|')[2].rstrip()
    return "error"


# sao passados dois argumentos no maximo

# pega os argumentos e coloca na lista parametros (param)
param = sys.argv[1:]

# verifica se a lista (param) esta vazia
if not param:
    print("\n{:-^40}\n".format("ERRO"))
    print("Programa sem ARGUMENTO\n")
    print("-> Passar argumentos juntos do programa <-\n")
    sys.exit()

nparam = len(param)
if nparam == 2:
    if param[0] == "-lt":
        print("lista de tokens")
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
    #print(tabela)

with open(codigoFonte, 'r') as file:
    codigo = file.readlines()
    #print(codigo)

estado_finais = {
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
    'q50':'logica_menor_que'
    'q52':'logica_diferente'


}

nlinha = 0

for linha in codigo:
    estado_atual = estado_anterior = "q0"
    nlinha +=1
    ncoluna = 0
    for i in linha:
       # print("Estado atual: {}".format(estado_atual))
        print("Letra: {}".format(i))
        print("Estado atenrior: {}".format(estado_anterior))
        estado_anterior = estado_atual
        estado_atual = transicao(estado_atual, i)
        ncoluna += 1
        print("Estado atual: {}".format(estado_atual))

        if estado_atual + '\n' in estados_finais:
            print(linha)
        '''
        for l in estados_finais:
            #print(l)
            if estado_atual in l:
                print(l)
        '''
    '''
    print("\n\n")
    print(estado_anterior)
    print(estado_atual)
    if  estado_atual == "error":
        print(linha)
    else:
        print(estado_anterior)
        print("Erro")
        sys.exit()
'''