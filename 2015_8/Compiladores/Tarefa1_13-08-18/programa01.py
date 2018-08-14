file = open('arquivo1.txt','w')
numero = int(input('Digite o numero de nomes:'))

for i in range(numero):
	nome = input('Digite o nome:')
	file.write(nome + "\n")
file.close