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
        '15': 'matematica_subtracao|<CALCULO>',
        '16': '<ARGUMENTO_NUMERICO>|<EXPRESSAO_MATEMATICA>',
        '17': 'abre_parenteses|<CALCULO>|fecha_parenteses|<EXPRESSAO_MATEMATICA>',
        '18': '<OP_MATEMATICA>|<CALCULO>',
        '19': 'î',
        '20': 'tipo|<ATRIBUICAO>',
        '21': 'variavel|<ATRIBUIR_VALOR>',
        '22': 'atribuicao|<CALCULO>',
        '23': 'î',
        '24': '<ARGUMENTO_TEXTO>',
        '25': '<ARGUMENTO_NUMERICO>',
        '26': 'î',
        '27': 'texto|<ARGUMENTO>',
        '28': 'numero',
        '29': 'variavel|<ARGUMENTO>',
        '30': 'logica_maior_que',
        '31': 'logica_menor_que',
        '32': 'logica_igual',
        '33': 'logica_maior',
        '34': 'logica_menor',
        '35': 'logica_diferente',
        '36': 'matematica_soma',
        '37': 'matematica_subtracao',
        '38': 'matematica_multiplicacao',
        '39': 'matematica_divisao',
        '40': 'matematica_igual'
    }
    return step[chave]