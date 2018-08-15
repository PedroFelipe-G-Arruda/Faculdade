file = open("voo.txt","r")

origem = input("Digite a sua cidade de origem:")
destino = input("Digiteo a cidade destino:") 

flag = 0

#tem que fazer a formatação

for i in file:
		voo = i.split(",")
		if (origem == voo[2]) and (destino == voo[3]):
			print(i)
			flag = 1


if (flag == 0):
	print("“NÃO EXISTEM VOOS")

i = input('.') 