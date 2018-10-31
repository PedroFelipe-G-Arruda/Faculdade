def step (chave):

    # Dicionario com os nao teminais

    step = {
        '0': 'inicio|<CODIGO>|fim',
        '1': '<COMANDO>|<CODIGO>',
        '2': 'î',
        '3': 'escrever|abre_parenteses|<ARGUMENTO>|fecha_parenteses|final_linha',
        '4': 'ler|abre_parenteses|variavel|fecha_parenteses|final_linha',
        '5': 'condicao_se|<EXPRESSAO>|ponto_interrogacao|<CODIGO>|<SENAO>',
        '6': 'condicao_repeticao|<LOGICA>|<LOOP>',
        '7': '<DECLARACAO>|final_linha',
        '8': '<ATRIBUICAO>|final_linha',
        '9': 'senao|<CODIGO>|ponto_interrogacao|final_linha',
        '10': 'ponto_interrogacao|final_linha',
        '11': 'abre_parenteses|<ARGUMENTO_NUMERICO>|virgula|<OP_MATEMATICA>|<ARGUMENTO_NUMERICO>|fecha_parenteses|dois_pontos|<CODIGO>|fim_repeticao|final_linha',
        '12': 'dois_pontos|<CODIGO>|fim_repeticao|final_linha',
        '13': 'abre_parenteses|<LOGICA>|fecha_parenteses',
        '14': '<ARGUMENTO_NUMERICO>|<OP_LOGICA>|<ARGUMENTO_NUMERICO>',
        '15': '<ARGUMENTO_NUMERICO>|<EXPRESSAO_MATEMATICA>',
        '16': 'abre_parenteses|<CALCULO>|fecha_parenteses|<EXPRESSAO_MATEMATICA>',
        '17': '<OP_MATEMATICA>|<CALCULO>',
        '18': 'î',
        '19': 'tipo|<ATRIBUICAO>',
        '20': 'variavel|<ATRIBUIR_VALOR>',
        '21': 'atribuicao|<CALCULO>',
        '22': 'î',
        '23': '<ARGUMENTO_TEXTO>',
        '24': '<ARGUMENTO_NUMERICO>',
        '25': 'î',
        '26': 'texto|<ARGUMENTO>',
        '27': 'numero',
        '28': 'variavel|<ARGUMENTO>',
        '29': 'logica_maior_que',
        '30': 'logica_menor_que',
        '31': 'logica_igual',
        '32': 'logica_maior',
        '33': 'logica_menor',
        '34': 'logica_diferente',
        '35': 'matematica_soma',
        '36': 'matematica_subtracao',
        '37': 'matematica_multiplicacao',
        '38': 'matematica_divisao',
        '39': 'matematica_igual'
    }

    return step[chave]