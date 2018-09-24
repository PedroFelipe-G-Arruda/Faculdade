def transicao(estado, letra):
  for line in tabela:
    if estado + ';' + letra in line:
      print(line)
      return line.split(';')[2].rstrip()
  return "error"

def erro():
    print("{:-^60}".format("PALAVRA NAO COMPATIVEL"))

automato = input('Nome do arquivo da tabela:').upper()
estado_inicial = input('Infome o estado inicial:')
estado_final = list(str(input('Informe o(s) estado(s) final(is):')).split(' '))
palavra = list(str(input('Digite a palavra:')).lower())
print("\n{:-^40}\n".format("INICIO"))

estado_atual = estado_inicial

with open(automato + '.txt', 'r') as file:
    tabela = file.readlines()

for i in palavra:
    print("Estado atual: {}".format(estado_atual))
    print("Letra: {}".format(i))
    estado_atual = transicao(estado_atual, i)

    if estado_atual == "error":
        erro()
        break

if estado_atual in estado_final:
    print("\nPalavra: {}".format(''.join(palavra)))
    print("\n{:-^40}\n".format("FIM"))
else:
    erro()