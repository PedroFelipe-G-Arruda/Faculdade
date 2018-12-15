from builtins import print

from infixtoposfix import infixToPostfix


def intermediaro(tokens, inicio, loop, preCodigo): # código intermediario
    i = inicio
    l = loop
    print(i)
    while i < len(tokens): # verifica toda a lista de tokens

        if 'ler' in tokens[i].split("|")[1]:
            preCodigo.append('LER ' + tokens[i+2].split("|")[0])

        elif 'escrever' in tokens[i].split("|")[1]:
            preCodigo.append('ESCREVER ' + tokens[i+2].split("|")[0])

        elif 'tipo' in tokens[i].split("|")[1]:
            preCodigo.append('INTEIRO ' + tokens[i+1].split("|")[0])

        elif 'atribuicao' in tokens[i].split("|")[1]:
            expr = []
            print(infixToPostfix(expressao(tokens, i)))
            expr.append(infixToPostfix(expressao(tokens, i)))
            expTo2(expr, tokens[i - 1].split("|")[0], preCodigo) #  TERMINAR

        elif 'loop' in tokens[i].split("|")[0]: #loop var sinal numero sem (valor, incrmendo (com sinal +/-))
            preCodigo.append('LOOP')
            preCodigo.append(f'_L{l+1}: if {tokens[i+1].split("|")[0]} '+ ('< ' if '>' or '>=' in tokens[i+2].split("|")[0] else '>' ) + f'{tokens[i+3].split("|")[0]}' + f' goto _L{l+2}')
            i,sd = intermediaro(tokens, i+5,l+2, preCodigo)
            preCodigo.append(f'goto _L{l+1}')
            preCodigo.append(f'_L{l+2}:')
            l+=2

        elif 'condicao_se' in tokens[i].split("|")[1]:
            preCodigo.append('SE')
            preCodigo.append(f'if {tokens[i + 2].split("|")[0]} '+ ('< ' if '>' or '>=' in tokens[i+2].split("|")[0] else '>' ) + f'{tokens[i + 4].split("|")[0]} goto _L{l + 1}')
            lista = []
            i,sd = intermediaro(tokens, i + 5, l, preCodigo)
            if sd:
                preCodigo.append(f'_L{sd}:')
                l = sd
            preCodigo = preCodigo + lista
            l += 1

        elif 'senao' in tokens[i].split("|")[1]:
            preCodigo.append(f'goto _L{l + 2}')
            preCodigo.append(f'_L{l + 1}:')
            i, sd = intermediaro(tokens, i + 1, l + 2, preCodigo)
            return i, l+2

        elif 'fim_repeticao' in tokens[i].split("|")[1] or ('ponto_interrogacao' in tokens[i].split("|")[1] and 'final_linha' in tokens[i+1].split("|")[1]):

            return i+1,None
        i += 1

    return preCodigo



def expTo2(exp,var,preCodigo): #  TERMINAR  TERMINAR
    '''
    add dest,src    dest = dest + src
    sub dest,src    dest = dest - src

    ADD dest,src1,src2	dest = src1 + src2
    SUB dest,src1,src2	dest = src1 - src2
    ADDI dest,src1,I	dest = src1 + I
    MUL dest,src1,src2	dest = src1 × src2
    DIV[U] dest,src1,src2	dest = src1/src2
    '''
    t=1
    exp=exp[0].split()
    values=[]
    operador=['+','-','*','/']
    for i in range(len(exp)):
        if exp[i] in operador:
            a = values.pop()
            b = values.pop()
            if i == len(exp)-1:
                preCodigo.append(f'{var} := {b} {a} {exp[i]}')
            else:
                preCodigo.append(f'T{t} := {b} {a} {exp[i]}')
                values.append(f'T{t}')
                t+=1
        else:
            values.append(exp[i])
    if len(values) > 0:
        preCodigo.append(f'{var} := {values[0]}')

def expressao(token, i):
    l = i + 1
    var = []
    while not ('final_linha' in token[l]):
        var.append(token[l].split("|")[0])
        l += 1
    return ' '.join(var)
