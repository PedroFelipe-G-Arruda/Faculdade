file = open('arquivo1.txt','r')
manipulador = file.readlines()
file.close
manipulador.sort()

file = open('arquivo2.txt','w')
file.writelines(manipulador)
file.close