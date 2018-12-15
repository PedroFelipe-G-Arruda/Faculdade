'''
Codigo retirado do github de Nicolas T. Cuerbas
pelo link: https://github.com/limonheiro/Compilador/blob/master/infixtoposfix.py
'''

def infixToPostfix(infixexpr):
    prec = {}
    prec["*"] = 3
    prec["/"] = 3
    prec["+"] = 2
    prec["-"] = 2
    prec[">"] = 2
    prec["<"] = 2
    prec["("] = 1
    opStack = []
    postfixList = []
    tokenList = infixexpr.split()

    for token in tokenList:
        if token.isidentifier() or token.isdigit():
            postfixList.append(token)
        elif token == '(':
            opStack.extend(token)
        elif token == ')':
            topToken = opStack.pop()
            while topToken != '(':
                postfixList.append(topToken)
                topToken = opStack.pop()
        else:
            while (not len(opStack)==0) and (prec[opStack[-1]] >= prec[token]):
                  postfixList.append(opStack.pop())
            opStack.extend(token)

    while not (len(opStack)==0):
        postfixList.append(opStack.pop())
    return " ".join(postfixList)