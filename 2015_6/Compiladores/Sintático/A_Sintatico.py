import pilha

def transicao(estado, letra):  # Verifica se a tem um proximo estado
    with open('tabela_sintatica.txt', 'r') as file:
        tabela = file.readlines()

    for line in tabela:  # Le linha por linha da tabela de tokens
        if estado + '|' + letra in line:  # Verifica se tem estado e letra na linha
            return line.split('|')[2].rstrip()  # Retorna o proximo estado
    return "error"  # Se verificou toda a tabela e nao acho nada retorna erro


step = {
    '0': '<INICIO_FIM>|inicio|<CODIGO>|fim',
    '1': '<CODIGO>|<COMANDO>|<CODIGO>',
    '2': '<CODIGO>|î',
    '3': '<COMANDO>|escrever|abre_parenteses|<ARGUMENTO>|fecha_parenteses|final_linha',
    '4': '<COMANDO>|ler|abre_parenteses|variavel|fecha_parenteses|final_linha',
    '5': '<COMANDO>|condicao_se|<EXPRESSAO>|ponto_interrogacao|<CODIGO>|<SENAO>',
    '6': '<COMANDO>|condicao_repeticao|<LOGICA>|<LOOP>',
    '7': '<COMANDO>|<DECLARACAO>|final_linha',
    '8': '<COMANDO>|<ATRIBUICAO>|final_linha',
    '9': '<SENAO>|senao|<CODIGO>|ponto_interrogacao|final_linha',
    '10': '<SENAO>|ponto_interrogacao|final_linha',
    '11': '<LOOP>|abre_parenteses|<ARGUMENTO_NUMERICO>|virgula|<OP_MATEMATICA>|<ARGUMENTO_NUMERICO>|fecha_parenteses|dois_pontos|<CODIGO>|fim_repeticao|final_linha',
    '12': '<LOOP>|dois_pontos|<CODIGO>|fim_repeticao|final_linha',
    '13': '<EXPRESSAO>|abre_parenteses|<LOGICA>|fecha_parenteses',
    '14': '<LOGICA>|<ARGUMENTO_NUMERICO>|<OP_LOGICA>|<ARGUMENTO_NUMERICO>',
    '15': '<CALCULO>|<ARGUMENTO_NUMERICO>|<EXPRESSAO_MATEMATICA>',
    '16': '<CALCULO>|abre_parenteses|<CALCULO>|fecha_parenteses|<EXPRESSAO_MATEMATICA>',
    '17': '<EXPRESSAO_MATEMATICA>|<OP_MATEMATICA>|<CALCULO>',
    '18': '<EXPRESSAO_MATEMATICA>|î',
    '19': '<DECLARACAO>|tipo|<ATRIBUICAO>',
    '20': '<ATRIBUICAO>|variavel|<ATRIBUIR_VALOR>',
    '21': '<ATRIBUIR_VALOR>|atribuicao|<CALCULO>',
    '22': '<ATRIBUIR_VALOR>|î',
    '23': '<ARGUMENTO>|<ARGUMENTO_TEXTO>',
    '24': '<ARGUMENTO>|<ARGUMENTO_NUMERICO>',
    '25': '<ARGUMENTO>|î',
    '26': '<ARGUMENTO_TEXTO>|texto|<ARGUMENTO>',
    '27': '<ARGUMENTO_NUMERICO>|numero',
    '28': '<ARGUMENTO_NUMERICO>|variavel|<ARGUMENTO>',
    '29': '<OP_LOGICA>|logica_maior_que',
    '30': '<OP_LOGICA>|logica_menor_que',
    '31': '<OP_LOGICA>|logica_igual',
    '32': '<OP_LOGICA>|logica_maior',
    '33': '<OP_LOGICA>|logica_menor',
    '34': '<OP_LOGICA>|logica_diferente',
    '35': '<OP_MATEMATICA>|matematica_soma',
    '36': '<OP_MATEMATICA>|matematica_subtracao',
    '37': '<OP_MATEMATICA>|matematica_multiplicacao',
    '38': '<OP_MATEMATICA>|matematica_divisao',
    '39': '<OP_MATEMATICA>|matematica_igual'
}
fila = []
with open("lista de tokens.txt","r")as file:
    for i in file:
        fila.append(i.split("|")[1])

    file.seek(1)
    tabelaGeral = file.readlines()

del fila[0]
fila.append("$")

pilha = pilha.Stack()
pilha.push("$")
pilha.push("<INICIO_FIM>")



#INICIO DO PROGRAMA PRINCIPAL
cont = 0
print("INICIO\n\n")

while fila:
    top = pilha.pop()
    if top.isupper() == True:
        processo = transicao(top,fila[0])
        if processo == "error":
            print("ERRO")
            print(f"linha:{tabelaGeral[cont].split('|')[2]} coluna:{tabelaGeral[cont].split('|')[3]}")
            break

        i = len(step[processo].split("|")) - 1
        while i >= 1:
            if step[processo].split("|")[i] != "î":
                pilha.push(step[processo].split("|")[i])
            i -= 1
    elif top == fila[0]:
        print(f"#{top} = {fila[0]}#")
        del fila[0]
        cont +=1

if not fila:
    print("Sem erros Sintaticos")