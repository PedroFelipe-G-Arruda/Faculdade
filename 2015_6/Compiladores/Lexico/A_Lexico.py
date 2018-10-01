import sys
# sao passados dois argumentos no maximo


# pega os argumentos e coloca na lista parametros (param)
param = sys.argv[1:]

# verifica se a lista (param) esta vazia
if not param:
    print("\n{:-^40}\n".format("ERRO"))
    print("Programa sem ARGUMENTO\n")
    print("-> Passar argumentos juntos do programa <-\n")
    sys.exit()

nparam = len(param)
if param[nparam - 2] == "-lt":
    print("lista de tokens")


print(param[nparam - 1])
print(nparam)


#with open()