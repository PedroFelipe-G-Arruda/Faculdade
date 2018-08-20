def R(head):
    return head + 1


def L(head):
    return head - 1


def q0(head):
    if fita[head] == 'a':
        fita[head] = 'A'
        R(head)
        q1(head)

    if cell == 'B':
        fita[head] = 'B'
        R(head)
        q3(cell, head)

    if cell == ' ':
        fita[head] = ' '
        R(head)
        q4()


def q1(cell, head):
    if cell == 'a':
        fita[head] = 'a'
        R(head)
        q1(cell, head)

    if cell == 'b':
        fita[head] = 'B'
        L(head)
        q2(cell, head)

    if cell == 'B':
        fita[head] = 'B'
        R(head)
        q1(cell, head)


def q2(cell, head):
    if cell == 'a':
        fita[head] = 'a'
        R(head)
        q2(cell, head)

    if cell == 'A':
        fita[head] = 'A'
        R(head)
        q0(cell, head)

    if cell == 'B':
        fita[head] = 'B'
        L(head)
        q2(cell, head)


def q3(cell, head):
    if cell == 'B':
        fita[head] = 'B'
        R(head)
        q3(cell, head)

    if cell == ' ':
        fita[head] = ' '
        L(head)
        q4()


def q4():
    print(fita)


fita = 'aabb'


q0(0)
