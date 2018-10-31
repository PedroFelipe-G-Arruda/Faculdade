def tokem (chave):

    # Dicionario com os estados finais e os tokens
    estados_finais = {
        'q5': 'inicio',
        'q8': 'fim',
        'q14': 'escrever',
        'q16': 'condicao_se',
        'q18': 'tipo',
        'q21': 'ler',
        'q25': 'condicao_repeticao',
        'q28': 'fim_repeticao',
        'q29': 'virgula',
        'q30': 'fecha_parenteses',
        'q31': 'abre_parenteses',
        'q32': 'dois_pontos',
        'q33': 'final_linha',
        'q34': 'matematica_divisao',
        'q35': 'matematica_multiplicacao',
        'q36': 'matematica_subtracao',
        'q37': 'matematica_soma',
        'q38': 'matematica_igual',
        'q39': 'logica_igual',
        'q40': 'senao',
        'q41': 'ponto interrogacao',
        'q44': 'texto',
        'q45': 'numero',
        'q46': 'variavel',
        'q47': 'logica_maior',
        'q48': 'logica_maior_que',
        'q49': 'lociga_menor',
        'q50': 'logica_menor_que',
        'q52': 'logica_diferente',
        'q54': 'atribuicao'
    }

    if chave in estados_finais:
        return estados_finais[chave]
    else:
        return False