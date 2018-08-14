arquivo = input('Digite o nome do arquivo:')
file = open(arquivo, 'r')

linha = 0
caracteres = 0

for i in file:
	linha = linha + 1


	
print('O arquivo {} tem: {} linhas'.format(arquivo, linha))
file.close