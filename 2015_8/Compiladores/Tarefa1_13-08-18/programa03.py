arquivo = input('Digite o nome do arquivo:')
file = open(arquivo, 'r')

linha = 0
contador = 0
car_total = 0

for i in file:
	linha = linha + 1
	palavra = i.split(" ")
	print(palavra)
	contador = contador + len(palavra)
	car_total = car_total + len(i)

palavra = contador 
letras = car_total - (palavra - 1) - (linha - 1)
print('O arquivo {} tem: {} linha(s), {} palavra(s), {} letras e {} caracteres total'.format(arquivo, linha, palavra, letras, car_total))

ashfbas = input(".")

file.close