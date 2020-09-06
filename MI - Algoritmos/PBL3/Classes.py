import random
from prettytable import PrettyTable
class Baralho:

    def __init__(self, arquivo):
        self.arquivo = arquivo
        cartas = list()
        with open(self.arquivo, "r") as pesquisa:
            pesquisa.readline()  # pula a primeira linha
            for linha in pesquisa:
                texto = linha.strip()  # Retira qualquer formatação a direita e a esquerda da linha
                dividido = texto.split(";")
                carta_obj = Cartas(dividido)
                cartas.append(carta_obj)
            self.cartas = cartas

    def misturar(self):  # A função pega os valores das extremidades da lista e trocam com um item aleatorio dentro da propria lista, e com o decorrer do for as trocas vão se aproximando do meio.
        for indice in range(len(self.cartas)):
            x = random.randint(indice, len(self.cartas) - 1)
            y = random.randint(0, len(self.cartas) - indice - 1)
            self.cartas[x], self.cartas[y] = self.cartas[y], self.cartas[x]
        return self.cartas

    def tirar_carta_baralho(self):
        carta = self.cartas.pop()
        return carta

    def gerar_deck(self):
        deck = list()
        for cartainicial in range(5):
            deck.append(self.cartas.pop())
        return deck
class Cartas:

    def __init__(self,carta):
        self.nome = carta[0]
        self.valor = int(carta[1])
        self.forca = float(carta[2])
        self.energia = float(carta[3])
        self.jokempo = carta[4]

class Deck:

    def __init__(self, deck):
        self.deck = deck
        self.tamanho = len(self.deck)

    def tirar_carta_deck(self,carta):
        self.deck.pop(carta)
    def por_carta_deck(self,carta):
        self.deck.append(carta)

    def mostrar_deck(self):
        self.tamanho = len(self.deck)#Atualiza o tamanho do deck do jogador
        cartas = ["X"]
        personagens = ["Personagens"]
        valor = ["Valor"]
        força = ["Força"]
        energia = ["Energia"]
        jokempo = ["Jokempo"]

        for carta in range(self.tamanho):
            cartas.append("Carta Nº" + str(carta + 1))
            personagens.append(self.deck[carta].nome)
            valor.append(self.deck[carta].valor)
            força.append(self.deck[carta].forca)
            energia.append(self.deck[carta].energia)
            jokempo.append(self.deck[carta].jokempo)

        tabela = PrettyTable(cartas)

        tabela.padding_width = 1

        tabela.add_row(personagens)#Adiciona Os personagens por coluna
        tabela.add_row(valor)
        tabela.add_row(força)
        tabela.add_row(energia)
        tabela.add_row(jokempo)

        print(tabela)

    def ordenador(self, escolha, tipo):
        self.tamanho = len(self.deck)
        valores = list()
        comparador = list()
        lista_ordenada = list()
        decknovo = list()
        if(tipo == "M"):
            for x in range(self.tamanho):
                valores.append(self.deck[x].nome)
                comparador.append(self.deck[x].nome)
        elif(tipo == "A"):
            if(escolha == 1):
                for x in range(self.tamanho):
                    valores.append(self.deck[x].valor)
                    comparador.append(self.deck[x].valor)
            elif (escolha == 2):
                for x in range(self.tamanho):
                    valores.append(self.deck[x].forca)
                    comparador.append(self.deck[x].forca)
            else:
                for x in range(self.tamanho):
                    valores.append(self.deck[x].energia)
                    comparador.append(self.deck[x].energia)
        for k in range(len(valores)):
            menor = valores[0]
            for i in valores:
                if i < menor:
                    menor = i
            lista_ordenada.append(valores.pop(valores.index(menor)))#Acha o menor valor da lista, pega o indice correspondente da um pop na propria lista usando o indice e adiciona o elemento em outra lista, repetindo o processo pela quantidade de itens na lista.
        for j in lista_ordenada:
            for carta in comparador:
                if(j == carta):
                    decknovo.append(self.deck[comparador.index(carta)])
        self.deck = decknovo

class Jogadores:

    def __init__(self):
        self.nickname = str
        self.partidas = 1
        self.vencidas = 0