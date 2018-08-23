def r(head):
    return head + 1


def l(head):
    return head - 1


def q0(head):
    if fita[head] == 'a':
        fita[head] = 'A'
        q1(r(head))

    elif fita[head] == 'B':
        q3(r(head))

    elif fita[head] == ' ':
        q4()

    else:
        qr()


def q1(head):
    if fita[head] == 'a':
        q1(r(head))

    elif fita[head] == 'b':
        fita[head] = 'B'
        q2(l(head))

    elif fita[head] == 'B':
        q1(r(head))

    else:
        qr()


def q2(head):
    if fita[head] == 'a':
        q2(l(head))

    elif fita[head] == 'A':
        q0(r(head))

    elif fita[head] == 'B':
        q2(l(head))

    else:
        qr()


def q3(head):
    if fita[head] == 'B':
        q3(r(head))

    elif fita[head] == ' ':
        q4()

    else:
        qr()


def q4():
    print(fita)


def qr():
    print(f'{"Erro":-^40}')


fita = ['a','a','b', 'b', ' ']

q0(0)
