import random
import pickle
from Classes import Baralho
from Classes import Deck
from Classes import Jogadores
#------------------------------------------------Funções----------------------------------------------------------------
def opcoes():
    print('\033[34m1. \033[0;0mValor')
    print('\033[34m2. \033[0;0mForça')
    print('\033[34m3. \033[0;0mEnergia')
    print('\033[34m4. \033[0;0mJokempô (Pedra, Papel e Tesoura)')


def escolher():
    while True:
        try:
            escolha = int(input("Escolha uma opção de disputa:"))
            if (escolha in [1, 2, 3, 4]):
                return escolha
            else: raise#Induz um erro, quando escolha não é uma opção de disputa
        except:
            print("Escolha uma opção valida!")

def tipo_jogo():
    print("\n\033[34m1.\033[0;0mAleatorio\n\033[34m2.\033[0;0mManual\n")
    tipo = int(input("Escolha o tipo de jogo:"))
    if(tipo == 1):
        return "A"
    elif(tipo == 2):
        return "M"
    else:
        print("Selecione uma opção valida!")
        tipo_jogo()
def cadastro(chave, numero_jogador):  # Realiza o cadastro dos jogadores
    try:
        with open("Cadastro.dat", "r+b") as cadastro:
            jogadores = pickle.load(cadastro)
            jogador = Jogadores()
            jogador.nickname = chave
            if chave in jogadores:
                print("Partidas Jogadas: ",jogadores[chave].partidas,"\nPartidas Ganhas: ",jogadores[chave].vencidas,"\nPorcentagem de vitorias: ",jogadores[chave].vencidas/jogadores[chave].partidas*100,"%")
                jogadores[chave].partidas += 1
                jogadores["jogador"+str(numero_jogador)] = chave
                with open("Cadastro.dat", "wb") as cadastro:
                    pickle.dump(jogadores,cadastro)
            else:
                jogadores.update({jogador.nickname: jogador, "jogador" + str(numero_jogador): chave})
                with open("Cadastro.dat", "wb") as cadastro:
                    pickle.dump(jogadores, cadastro)
                print("Novo Jogador Cadastrado")
    except EOFError:
        with open("Cadastro.dat", "wb") as cadastro:
            jogador = Jogadores()
            jogador.nickname = chave
            pickle.dump({jogador.nickname: jogador,"jogador1": jogador.nickname,"jogador2":"ainda_não_cadastrado"}, cadastro)
            print("Novo Jogador Cadastrado")

#----------------------------------------------------------------Main---------------------------------------------------
cadastro(input("Insira o nickname do \033[34mJogador 1: \033[0;0m"), 1)
cadastro(input("Insira o nickname do \033[34mJogador 2: \033[0;0m"), 2)
partida = True
while(partida == True):

    jogadores = pickle.load(open("Cadastro.dat", "r+b"))
    baralho = Baralho("Cartas.txt")  # Define o obj baralho print(jogo_aberto.baralho.cartas)
    baralho.misturar()  # Mistura a lista de cartas e gera uma pilha
    deck1 = Deck(baralho.gerar_deck())
    deck2 = Deck(baralho.gerar_deck())
    rodada = 1
    vitorias_jogador_1 = 0
    vitorias_jogador_2 = 0
    tipo = tipo_jogo()
    print("\n"+"\033[34m"+"-"*50+"Jogo Iniciado"+"-"*50+"\033[0;0m")
    while (rodada < 11 and deck1.tamanho > 1 and deck2.tamanho > 1):
        print('\033[34m' + "\nRodada Nº", rodada,"[" + jogadores["jogador1"] + "-" + str(vitorias_jogador_1) + "X" + str(vitorias_jogador_2) + "-" + jogadores["jogador2"] + "]" + '\033[0;0m')
        opcoes()
        if (rodada % 2 != 0):#Se o resto da divisão for 0, é a vez do jogador 2
            print("Vez do jogador " + jogadores["jogador1"])
            escolha = escolher()
            if (escolha == 4):
                print("Cartas do Jogador: " + jogadores["jogador1"] + "\n")
                deck1.mostrar_deck()
                print("Cartas do Jogador: " + jogadores["jogador2"] + "\n")
                deck2.mostrar_deck()
            else:
                deck1.ordenador(escolha,tipo)
                deck2.ordenador(escolha,tipo)
                print("Cartas do Jogador: " + jogadores["jogador1"] + "\n")
                deck1.mostrar_deck()
                print("Cartas do Jogador: " + jogadores["jogador2"] + "\n")
                deck2.mostrar_deck()
        elif (rodada % 2 == 0):
            print("Vez do jogador " + jogadores["jogador2"])
            escolha = escolher()
            if (escolha == 4):
                print("Cartas do Jogador: " + jogadores["jogador2"] + "\n")
                deck2.mostrar_deck()
                print("Cartas do Jogador: " + jogadores["jogador1"] + "\n")
                deck1.mostrar_deck()
            else:
                deck1.ordenador(escolha, tipo)
                deck2.ordenador(escolha, tipo)
                print("Cartas do Jogador: " + jogadores["jogador2"] + "\n")
                deck2.mostrar_deck()
                print("Cartas do Jogador: " + jogadores["jogador1"] + "\n")
                deck1.mostrar_deck()
        if(tipo == "A"):
            while True:
                ENTER = input('\n' + jogadores["jogador1"] + ' pressione \033[34m"ENTER"\033[0;0m para sortear uma carta')
                if not ENTER:  # Se retornar uma string vazia
                    carta_sorteada_jogador1 = random.randint(0, deck1.tamanho - 1)  # sortear a carta
                    print("A carta sorteada é a de Nº" + str(carta_sorteada_jogador1 + 1))
                    break

            while True:
                ENTER = input('\n' + jogadores["jogador2"] + ' pressione \033[34m"ENTER"\033[0;0m para sortear uma carta')
                if not ENTER:  # Se retornar uma string vazia
                    carta_sorteada_jogador2 = random.randint(0, deck2.tamanho - 1)  # sortear a carta dentro da lista
                    print("A carta sorteada é a de Nº" + str(carta_sorteada_jogador2 + 1))
                    break
        elif (tipo == "M"):
            while True:
                try:
                    carta_sorteada_jogador1 = int(input('\n' + jogadores["jogador1"] + ' escolha sua carta: '))-1
                    if(carta_sorteada_jogador1 >= 0 and carta_sorteada_jogador1<=deck1.tamanho-1):
                        break
                    print("Escolha uma carta do deck!")
                except:
                    print("Escolha uma carta do deck!")
            while True:
                try:
                    carta_sorteada_jogador2 = int(input('\n' + jogadores["jogador2"] + ' escolha sua carta: '))-1
                    if(carta_sorteada_jogador2 >= 0 and carta_sorteada_jogador1<=deck2.tamanho-1):
                        break
                    print("Escolha uma carta do deck!")
                except:
                    print("Escolha uma carta do deck!")
        if (escolha in [1, 2, 3]):
            if(escolha == 1):
                if (deck1.deck[carta_sorteada_jogador1].valor > deck2.deck[carta_sorteada_jogador2].valor):
                    print('\n' + jogadores["jogador1"] + " venceu")
                    vitorias_jogador_1 += 1
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)
                elif (deck1.deck[carta_sorteada_jogador1].valor < deck2.deck[carta_sorteada_jogador2].valor):
                    print(jogadores["jogador2"] + " venceu")
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)
                else:
                    print("\nEMPATE")
                    vitorias_jogador_1 += 1
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

            elif (escolha == 2):
                if (deck1.deck[carta_sorteada_jogador1].forca > deck2.deck[carta_sorteada_jogador2].forca):
                    print('\n' + jogadores["jogador1"] + " venceu")
                    vitorias_jogador_1 += 1
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

                elif (deck1.deck[carta_sorteada_jogador1].forca < deck2.deck[carta_sorteada_jogador2].forca):
                    print(jogadores["jogador2"] + " venceu")
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

                else:
                    print("\nEMPATE")
                    vitorias_jogador_1 += 1
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

            elif (escolha == 3):
                if (deck1.deck[carta_sorteada_jogador1].energia > deck2.deck[carta_sorteada_jogador2].energia):
                    print('\n' + jogadores["jogador1"] + " venceu")
                    vitorias_jogador_1 += 1
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

                elif (deck1.deck[carta_sorteada_jogador1].energia < deck2.deck[carta_sorteada_jogador2].energia):
                    print(jogadores["jogador2"] + " venceu")
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

                else:
                    print("\nEMPATE")
                    vitorias_jogador_1 += 1
                    vitorias_jogador_2 += 1
                    deck1.por_carta_deck(baralho.tirar_carta_baralho())
                    deck2.por_carta_deck(baralho.tirar_carta_baralho())
                    deck1.tirar_carta_deck(carta_sorteada_jogador1)
                    deck2.tirar_carta_deck(carta_sorteada_jogador2)

        elif (escolha == 4):
            if ((deck1.deck[carta_sorteada_jogador1].jokempo == "Pedra" and deck2.deck[carta_sorteada_jogador2].jokempo == "Tesoura") or (deck1.deck[carta_sorteada_jogador1].jokempo == "Tesoura" and deck2.deck[carta_sorteada_jogador2].jokempo == "Papel") or (deck1.deck[carta_sorteada_jogador1].jokempo == "Papel" and deck2.deck[carta_sorteada_jogador2].jokempo == "Pedra")):
                print('\n' + jogadores["jogador1"] + " venceu")
                vitorias_jogador_1 += 1
                deck2.por_carta_deck(baralho.tirar_carta_baralho())
                deck1.tirar_carta_deck(carta_sorteada_jogador1)
                deck2.tirar_carta_deck(carta_sorteada_jogador2)

            elif (deck1.deck[carta_sorteada_jogador1].jokempo == deck2.deck[carta_sorteada_jogador2].jokempo):
                print("\nEMPATE")
                vitorias_jogador_1 += 1
                vitorias_jogador_2 += 1
                deck1.por_carta_deck(baralho.tirar_carta_baralho())
                deck2.por_carta_deck(baralho.tirar_carta_baralho())
                deck1.tirar_carta_deck(carta_sorteada_jogador1)
                deck2.tirar_carta_deck(carta_sorteada_jogador2)

            else:
                print('\n' + jogadores["jogador2"] + " venceu")
                vitorias_jogador_2 += 1
                deck1.por_carta_deck(baralho.tirar_carta_baralho())
                deck1.tirar_carta_deck(carta_sorteada_jogador1)
                deck2.tirar_carta_deck(carta_sorteada_jogador2)

        rodada += 1

        if (rodada == 11 and deck1.tamanho > 1 and deck2.tamanho > 1):
            valortotaljogador1 = int
            valortotaljogador2 = int
            for carta in deck1.deck:
                valortotaljogador1 += carta[1]
            for carta in deck2.deck:
                valortotaljogador2 += carta[1]
            if (valortotaljogador1 == valortotaljogador2):
                forcatotaljogador1 = float
                forcatotaljogador2 = float
                for carta in deck1.deck:
                    forcatotaljogador1 += carta[2]
                for carta in deck2.deck:
                    forcatotaljogador2 += carta[2]
                if (forcatotaljogador1 == forcatotaljogador2):
                    energiatotaljogador1 = float
                    energiatotaljogador2 = float
                    for carta in deck1.deck:
                        energiatotaljogador1 += carta[3]
                    for carta in deck2.deck:
                        energiatotaljogador2 += carta[3]
                    if (energiatotaljogador1 == energiatotaljogador2):
                        print("Não houve vencedores!")
                    elif (energiatotaljogador1 < energiatotaljogador2):
                        print("\n"*5,"\033[34m",jogadores["jogador1"]," ganhou a partida!!!\033[0;0m","\n" * 5)
                        jogadores[jogadores["jogador1"]].vencidas +=1
                    else:
                        print("\n"*5,"\033[34m",jogadores["jogador2"]," ganhou a partida!!!\033[0;0m","\n" * 5)
                        jogadores[jogadores["jogador2"]].vencidas += 1
                elif (forcatotaljogador1 < forcatotaljogador2):
                    print("\n"*5,"\033[34m",jogadores["jogador1"]," ganhou a partida!!!\033[0;0m","\n" * 5)
                    jogadores[jogadores["jogador1"]].vencidas += 1
                else:
                    print("\n" * 5, "\033[34m", jogadores["jogador2"], " ganhou a partida!!!\033[0;0m","\n" * 5)
                    jogadores[jogadores["jogador2"]].vencidas += 1
            elif (valortotaljogador1 < valortotaljogador2):
                print("\n"*5,"\033[34m",jogadores["jogador1"]," ganhou a partida!!!\033[0;0m","\n" * 5)
                jogadores[jogadores["jogador1"]].vencidas += 1
            else:
                print("\n"*5,"\033[34m",jogadores["jogador2"]," ganhou a partida!!!\033[0;0m","\n" * 5)
                jogadores[jogadores["jogador2"]].vencidas += 1
    if(deck1.tamanho<deck2.tamanho):
        print("\n"*5,"\033[34m",jogadores["jogador1"],"ganhou a partida!!!\033[0;0m","\n" * 5)
        jogadores[jogadores["jogador1"]].vencidas += 1
    else:
        print("\n" * 5, "\033[34m", jogadores["jogador2"],"ganhou a partida!!!\033[0;0m","\n" * 5)
        jogadores[jogadores["jogador2"]].vencidas += 1
    pickle.dump(jogadores, open("Cadastro.dat", "wb"))
    while True:
        pergunta = input("Deseja jogar novamente?(\033[34ms/n\033[0;0m)").upper()
        if (pergunta == "S" or pergunta == "N"):  # Se retornar uma string vazia
            if (pergunta == "S"):
                partida = True
            else:
                partida = False
            break
        print("\033[34mEscolha uma opção valida!\033[0;0m")