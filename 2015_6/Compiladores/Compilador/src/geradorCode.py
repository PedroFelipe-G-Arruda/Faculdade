from logic import newlogic
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
           # print(infixToPostfix(expressao(tokens, i)))
            rpn=[f'{infixToPostfix(expressao(tokens, i))}']
            rpn.append(infixToPostfix(expressao(tokens, i)))
            simplifica(rpn, tokens[i-1].split("|")[0], preCodigo)

        elif 'loop' in tokens[i].split("|")[0]: #loop var sinal numero sem (valor, incrmendo (com sinal +/-))
            preCodigo.append(f'_L{l+1}: if {tokens[i+1].split("|")[0]} {newlogic(tokens[i+2].split("|")[0])} {tokens[i+3].split("|")[0]}' + f' goto _L{l+2}')
            i,sd = intermediaro(tokens, i+5,l+2, preCodigo, nome)
            preCodigo.append(f'goto _L{l+1}')
            preCodigo.append(f'_L{l+2}:')
            l+=2

        elif 'condicao_se' in tokens[i].split("|")[1]:
            preCodigo.append(f'if {tokens[i + 2].split("|")[0]} {newlogic(tokens[i + 3].split("|")[0])} {tokens[i + 4].split("|")[0]} goto _L{l + 1}')
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
    with open(nome, 'w') as file:
        file.write('\n'.join(codigo))
    return codigo



def simplifica(exp,var,preCodigo):
    t = 1
    exp = exp[0].split()
    values = []
    operador = ['+', '-', '*', '/']
    for i in range(len(exp)):
        if exp[i] in operador:
            var1 = values.pop()
            var2 = values.pop()
            if i == len(exp) - 1:
                preCodigo.append(f'{var} := {var2} {var1} {exp[i]}')
            else:
                preCodigo.append(f't{t} := {var2} {var1} {exp[i]}')
                values.append(f't{t}')
                t += 1
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


def gerador (preCode):
    i = 1
    v = []
    data = ['section .data','\tformatin: db "%d",0','\tformatout: db "%d",10,0']
    text = ['section .text','\tglobal _main','\textern _printf','\textern _scanf']
    main = ['\t','_main:']

    for linha in preCode:
        #print(linha)
        if 'INTEIRO' in linha:
            data.append(f'\t{linha.split("INTEIRO")[1].strip()}: dd 0')
            v.append(linha.split("INTEIRO")[1].strip())
        elif ':=' in linha:
            main.append('')
            if not linha.split()[0].strip() in v:
                data.append(f'\t{linha.split()[0].strip()}: dd 0')
                v.append(linha.split()[0].strip())

            if '+' in linha:
               # print(f'\n+\n')
                main.append(f'mov eax, {"dword["+linha.split()[-3].strip()+"]" if not linha.split()[-3].strip().isdecimal() else linha.split()[-3].strip()}')
                main.append(f'mov ecx, {"dword["+linha.split()[-2].strip()+"]" if not linha.split()[-2].strip().isdecimal() else linha.split()[-2].strip()}')
                main.append(f'add eax, ecx')
                main.append(f'mov dword[{linha.split()[0].strip()}], eax')

            elif '-' in linha:
              #  print(f'\n-\n')
                main.append(f'mov eax, {"dword[" + linha.split()[-3].strip() + "]" if not linha.split()[-3].strip().isdecimal() else linha.split()[-3].strip()}')
                main.append(f'mov ecx, {"dword[" + linha.split()[-2].strip() + "]" if not linha.split()[-2].strip().isdecimal() else linha.split()[-2].strip()}')
                main.append(f'sub eax, ecx')
                main.append(f'mov dword[{linha.split()[0].strip()}], eax')

            elif '*' in linha:
               # print(f'\n*\n')
                main.append(f'mov eax, {"dword[" + linha.split()[-3].strip() + "]" if not linha.split()[-3].strip().isdecimal() else linha.split()[-3].strip()}')
                main.append(f'mov ecx, {"dword[" + linha.split()[-2].strip() + "]" if not linha.split()[-2].strip().isdecimal() else linha.split()[-2].strip()}')
                main.append(f'mul ecx')
                main.append(f'mov dword[{linha.split()[0].strip()}], eax')

            elif '/' in linha:
              #  print(f'\n/\n')
                main.append(f'mov eax, {"dword[" + linha.split()[-3].strip() + "]" if not linha.split()[-3].strip().isdecimal() else linha.split()[-3].strip()}')
                main.append(f'mov ecx, {"dword[" + linha.split()[-2].strip() + "]" if not linha.split()[-2].strip().isdecimal() else linha.split()[-2].strip()}')
                main.append(f'mov edx, 0')
                main.append(f'div ecx')
                main.append(f'mov dword[{linha.split()[0].strip()}], eax')
            else:
                main.append(f'mov dword[{linha.split(":= ")[0].strip()}], {linha.split(":= ")[1].strip()}')

        elif 'ESCREVER' in linha.split()[0]:
            #print(f'linha:{linha}')
            if '"' in linha.split("ESCREVER")[1]:
                data.append(f'\tmgs{i}: db {linha.split("ESCREVER")[1].strip()},10,0')
                main.append('')
                main.append(f'push mgs{i}')
                main.append('call _printf')
                main.append('add esp,4')
                i += 1
            else:
                main.append('')
                main.append(f'mov ebx, dword[{linha.split("ESCREVER")[1].strip()}]')
                main.append('push ebx')
                main.append('push formatout')
                main.append('call _printf')
                main.append('add esp, 8')

        elif 'LER' in linha.split()[0]:
            #print(f'linha:{linha}')
            main.append('')
            main.append(f'push {linha.split("LER")[1].strip()}')
            main.append('push formatin')
            main.append('call _scanf')
            main.append('add esp,8')

        elif 'if' in linha.split()[0]:
            #print(f'linha:{linha}')
            main.append('')
            main.append(f'mov eax, {"dword[" + linha.split()[1].strip() + "]" if not linha.split()[1].strip().isdecimal() else linha.split()[1].strip()}')
            main.append(f'cmp eax, {"dword[" + linha.split()[3].strip() + "]" if not linha.split()[3].strip().isdecimal() else linha.split()[3].strip()}')
            if '<=' in linha:
                main.append(f'jle {linha.split()[5].strip()}') # arrumar
            elif '>=' in linha:
                main.append(f'jge {linha.split()[5].strip()}')
            elif '<' in linha:
                main.append(f'jl {linha.split()[5].strip()}')
            elif '>' in linha:
                main.append(f'jg {linha.split()[5].strip()}')
            elif '==' in linha:
                main.append(f'je {linha.split()[5].strip()}')
            elif '!=' in linha:
                main.append(f'jne {linha.split()[5].strip()}')

        elif 'goto' in linha.split()[0]:
            #print(f'linha:{linha}')
            main.append('')
            main.append(f'jmp {linha.split()[1].strip()}')

        elif '_L' in linha.split()[0]:
           # print(f'linha:{linha}')
            if 'if' in linha:
                main.append('')
                main.append(f'{linha.split()[0]}')
                main.append(f'mov eax, {"dword[" + linha.split()[2].strip() + "]" if not linha.split()[2].strip().isdecimal() else linha.split()[2].strip()}')
                main.append(f'cmp eax, {"dword[" + linha.split()[4].strip() + "]" if not linha.split()[4].strip().isdecimal() else linha.split()[4].strip()}')
                if '<=' in linha:
                    main.append(f'jle {linha.split()[6].strip()}')  # arrumar
                elif '>=' in linha:
                    main.append(f'jge {linha.split()[6].strip()}')
                elif '<' in linha:
                    main.append(f'jl {linha.split()[6].strip()}')
                elif '>' in linha:
                    main.append(f'jg {linha.split()[6].strip()}')
                elif '==' in linha:
                    main.append(f'je {linha.split()[6].strip()}')
                elif '!=' in linha:
                    main.append(f'jne {linha.split()[6].strip()}')

            else:
                main.append('')
                main.append(f'{linha.strip()}')

    codigo = data + text + main
    codigo.append('ret')
    #print(codigo)
    return codigo
