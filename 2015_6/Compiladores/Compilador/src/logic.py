def newlogic (chave):

    # Dicionario com as mudanças de logica

    logica = {
        '>=': '<',
        '<=': '>',
        '>': '<=',
        '<': '>=',
        '==': '!=',
        '!=': '=='

    }
    return logica[chave]