def r(head):
    return head + 1


def l(head):
    return head - 1


def q0(head):
    print(fita)
    print(head)
    print('q0')
    if fita[head] == '0':
        fita[head] = ' '
        q1(r(head))

    elif fita[head] == '1':
        fita[head] = ' '
        q2(r(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q1(head):
    print(fita)
    print(head)
    print('q1')
    if fita[head] == '0':
        q1(r(head))

    elif fita[head] == '1':
        q1(r(head))

    elif fita[head] == ' ':
        q3(l(head))

    else:
        qr()


def q2(head):
    print(fita)
    print(head)
    print('q2')
    if fita[head] == '0':
        q2(r(head))

    elif fita[head] == '1':
        q2(r(head))

    elif fita[head] == ' ':
        q4(l(head))

    else:
        qr()


def q3(head):
    print(fita)
    print(head)
    print('q3')
    if fita[head] == '0':
        fita[head] = ' '
        q5(l(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q4(head):
    print(fita)
    print(head)
    print('q4')
    if fita[head] == '1':
        fita[head] = ' '
        q5(l(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q5(head):
    print(fita)
    print(head)
    print('q5')
    if fita[head] == '0':
        fita[head] = ' '
        q6(l(head))

    elif fita[head] == '1':
        fita[head] = ' '
        q7(l(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q6(head):
    print(fita)
    print(head)
    print('q6')
    if fita[head] == '0':
        q6(l(head))

    elif fita[head] == '1':
        q6(l(head))

    elif fita[head] == ' ':
        q8(r(head))

    else:
        qr()


def q7(head):
    print(fita)
    print(head)
    print('q7')
    if fita[head] == '0':
        q7(l(head))

    elif fita[head] == '1':
        q7(l(head))

    elif fita[head] == ' ':
        q9(r(head))

    else:
        qr()


def q8(head):
    print(fita)
    print(head)
    print('q8')
    if fita[head] == '0':
        fita[head] = ' '
        q0(r(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q9(head):
    print(fita)
    print(head)
    print('q9')
    if fita[head] == '1':
        fita[head] = ' '
        q0(r(head))

    elif fita[head] == ' ':
        q10()

    else:
        qr()


def q10():
    print("O numero binario é palindromo".format(''.join(fita)))


def qr():
    print(f'{"Erro":-^40}')


fita = list(str(input('Digite o numero binario:')))
fita.append(' ')
q0(0)

