file = open('arquivo1.txt','r')
manipulador = file.readlines()
file.close
manipulador.sort()
x =len(manipulador)

file = open('arquivo2.txt','w')
for i in range(0,x):
	file.write(manipulador[i])
file.close