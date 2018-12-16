from builtins import print

from infixtoposfix import infixToPostfix


def intermediaro(tokens, inicio, loop, preCodigo, nome): # código intermediario
    i = inicio
    l = loop
    while i < len(tokens): # verifica toda a lista de tokens

        if 'ler' in tokens[i].split("|")[1]:
            preCodigo.append('LER ' + tokens[i+2].split("|")[0])

        elif 'escrever' in tokens[i].split("|")[1]:
            preCodigo.append('ESCREVER ' + tokens[i+2].split("|")[0])

        elif 'tipo' in tokens[i].split("|")[1]:
            preCodigo.append('INTEIRO ' + tokens[i+1].split("|")[0])

        elif 'atribuicao' in tokens[i].split("|")[1]:
            print(infixToPostfix(expressao(tokens, i)))
            end3=[]
            end3.append(infixToPostfix(expressao(tokens, i)))


        elif 'loop' in tokens[i].split("|")[0]: #loop var sinal numero sem (valor, incrmendo (com sinal +/-))
            preCodigo.append('LOOP')
            preCodigo.append(f'_L{l+1}: if {tokens[i+1].split("|")[0]} '+ ('< ' if '>' or '>=' in tokens[i+2].split("|")[0] else '>' ) + f'{tokens[i+3].split("|")[0]}' + f' goto _L{l+2}')
            i,sd = intermediaro(tokens, i+5,l+2, preCodigo, nome)
            preCodigo.append(f'goto _L{l+1}')
            preCodigo.append(f'_L{l+2}:')
            l+=2

        elif 'condicao_se' in tokens[i].split("|")[1]:
            preCodigo.append('SE')
            preCodigo.append(f'if {tokens[i + 2].split("|")[0]} '+ ('< ' if '>' or '>=' in tokens[i+2].split("|")[0] else '>' ) + f'{tokens[i + 4].split("|")[0]} goto _L{l + 1}')
            lista = []
            i,sd = intermediaro(tokens, i + 5, l, preCodigo,nome)
            if sd:
                preCodigo.append(f'_L{sd}:')
                l = sd
            preCodigo = preCodigo + lista
            l += 1

        elif 'senao' in tokens[i].split("|")[1]:
            preCodigo.append(f'goto _L{l + 2}')
            preCodigo.append(f'_L{l + 1}:')
            i, sd = intermediaro(tokens, i + 1, l + 2, preCodigo,nome)
            return i, l+2

        elif 'fim_repeticao' in tokens[i].split("|")[1] or ('ponto_interrogacao' in tokens[i].split("|")[1] and 'final_linha' in tokens[i+1].split("|")[1]):

            return i+1,None
        i += 1
    codigo = gerador(preCodigo)
    with open(nome.split('.')[0]+'.asm', 'w') as file:
        file.write('\n'.join(codigo))
    return codigo

def expressao(token, i):
    l = i + 1
    var = []
    while not ('final_linha' in token[l]):
        var.append(token[l].split("|")[0])
        l += 1
    return ' '.join(var)


def gerador (preCode):
    i = 1
    data = ['section .data','\tformatin: db "%d",0','\tformatout: db "%d",10,0']
    text = ['section .text','\tglobal _main','\textern _printf','extern _scanf']
    main = ['_main:']
    codigo = []

    for linha in preCode:
        print(linha)
        if 'ESCREVER' in linha:
            data.append(f'\tmgs{i}: db {linha.split("ESCREVER")[1]},10,0')
            print(data)
            main.append(f'push mgs{i}')
            main.append('call _printf')
            main.append('add esp,4')
            i+=1

    main = data + text + main
    main.append('ret')
    print(main)
    return main
