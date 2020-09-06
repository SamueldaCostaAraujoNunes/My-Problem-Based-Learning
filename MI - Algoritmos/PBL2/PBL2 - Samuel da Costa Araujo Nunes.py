'''Autor: Samuel da Costa Araujo Nunes
Componente Curricular: MI - Algoritmos
Concluido em: 10/08/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.'''

import sys

def linhas(nlinhas):
    contador = sum(1 for linha in nlinhas)
    nlinhas.seek(0)
    return contador

def separador(pesquisa):
    texto = pesquisa.readline()  # Ler uma unica linha do arquivo
    texto = texto.strip()# Retira qualquer formatação a direita e a esquerda da linha
    dividido = texto.split(";")  # Divide os dados em uma lista
    return dividido

def contador_linhas(arquivo):
    with open(arquivo, 'r', encoding='utf-8-sig') as pesquisa:
        return linhas(pesquisa)

def verificador_pesquisa(dicionario,referencia):#Verifica os possiveis erros comparando o arquivo de pesquisa com o arquivo de entrada
    with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquisa:
        for linha in range(linhas(pesquisa)):
            coluna_pesquisa = separador(pesquisa)[referencia]
            if (coluna_pesquisa not in dicionario and coluna_pesquisa != "Técnico" and coluna_pesquisa != "1.01"):
                print("Referência não encontrada:", coluna_pesquisa)
                sys.exit()

def verificador_interno (nome_arquivo, tipo, categoria, matricula_tecnico):#Verifica os possiveis erros dentro do proprio arquivo
    with open(nome_arquivo, 'r', encoding='utf-8-sig') as tecnico:
        tecnico_dict = dict()
        for linha in range(linhas(tecnico)):
            dados_tecnicos = separador(tecnico)  # Gera uma lista com os dados da pesquisa com a matricula do tecnico
            numero_tecnico = dados_tecnicos.pop(matricula_tecnico) # Deleta a matricula do tecnico da lista da pesquisa
            if (numero_tecnico in tecnico_dict):  # Verifica se a matricula do tecnico é uma chave de dicionario
                if (dados_tecnicos == tecnico_dict[numero_tecnico]):  # Ele verifica os dados dos tecnicos, quando se tem mais de dois  cadastros iguais.
                    print("A",tipo, numero_tecnico, "foi cadastrada mais de uma vez")
                    sys.exit()
                else:
                    print("A" ,tipo, numero_tecnico, categoria)
                    sys.exit()
            else:
                tecnico_dict.update({numero_tecnico: dados_tecnicos})  # Gera um dicionario com a chave sendo a matricula do tecnico.
        return tecnico_dict
def domicilios():
    with open('exemploPesquisa.txt', 'r', encoding='utf8') as pesquisa:
        ja_pago = 0
        ainda_pagando = 0
        alugado = 0
        for linha in range(linhas(pesquisa)):
            coluna_pesquisa = separador(pesquisa)[5]
            if(coluna_pesquisa != '2.01'):
                if(coluna_pesquisa == '1'):
                    ja_pago += 1
                elif(coluna_pesquisa == '2'):
                    ainda_pagando += 1
                elif (coluna_pesquisa == '3'):
                    alugado += 1
        return (ja_pago,ainda_pagando,alugado)
def banheiros(): #Retorna as informações dos banheiros em uma tupla que contem dois dicionarios, um que possui todas as casas que não tem banheiro, dentro de uma cidade e na outra os que possuem.
    with open('regioes.txt', 'r', encoding='utf-8-sig') as regioes:
        with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquisa:
            cidade_dict = dict()
            sem_banheiro_dict = dict()
            com_banheiro_dict = dict()
            for linha in range(linhas(regioes)):
                dados_regioes = separador(regioes)
                if (dados_regioes[1] != 'Município' and dados_regioes[2] != 'Código do IBGE'):
                    codigosIBGE = int(dados_regioes[2])  # Adquire a quantida de banheiros por casa
                    cidades = dados_regioes[1]  # Adquire o codigo da cidade
                    estado = dados_regioes[3]
                    cidade_dict.update({codigosIBGE: cidades + "-" + estado})
            for linha in range(linhas(pesquisa)):
                dados_pesquisa = separador(pesquisa)
                if(dados_pesquisa[1] != '1.01' and dados_pesquisa[6] != '2.02'):
                    banheiro = int(dados_pesquisa[6]) #Adquire a quantida de banheiros por casa
                    codigoIBGE = int(dados_pesquisa[1]) #Adquire o codigo da cidade
                    if(banheiro == 0): #Verifica se existe banheiro na casa
                        if(cidade_dict[codigoIBGE] not in sem_banheiro_dict):
                            sem_banheiro_dict.update({cidade_dict[codigoIBGE]: 1})
                        else:
                            contador = sem_banheiro_dict[cidade_dict[codigoIBGE]]
                            sem_banheiro_dict.update({cidade_dict[codigoIBGE]: contador+1})
                    elif(banheiro > 0):
                        if (cidade_dict[codigoIBGE] not in com_banheiro_dict):
                            com_banheiro_dict.update({cidade_dict[codigoIBGE]: 1})
                        else:
                            contador = com_banheiro_dict[cidade_dict[codigoIBGE]]
                            com_banheiro_dict.update({cidade_dict[codigoIBGE]: contador + 1})
    return (sem_banheiro_dict,com_banheiro_dict)

def contador_banheiros():#Organiza as informações coletadas em banheiro() para o usuario.
    with open('regioes.txt', 'r', encoding='utf-8-sig') as regioes:
        for linha in range(linhas(regioes)):
            dados_regioes = separador(regioes)
            cidades = dados_regioes[1]  # Adquire o codigo da cidade
            estado = dados_regioes[3]
            comparador = cidades + "-" + estado
            if (dados_regioes[1] != 'Município' and (comparador in banheiros()[0] or comparador in banheiros()[1])):
                print("\nO Município", comparador, "possui:")
                if(comparador in banheiros()[0]):
                    print(banheiros()[0][comparador],"casas sem banheiro.")
                    if (dados_regioes[1] in banheiros()[1]):
                        print(banheiros()[1][comparador], "casas com banheiro.")
                    else:
                        print(0, "casas com banheiro.")
                elif(comparador in banheiros()[1]):
                    print(0, "casas sem banheiro.")
                    print(banheiros()[1][comparador],"casas com banheiro.")
def abastecimento_agua():#Gera uma lista por cidade, que coleta os dados do abastecimento relacionando as 10 possiveis alternativas e o indice da lista.
                         #Após, ele depura a alternativa mais assinalada, em uma sequencia de if e elif, e printa pro usuario a forma de abastecimento mais comum por cidade.
    with open('regioes.txt', 'r', encoding='utf-8-sig') as regioes:
        with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquisa:
            cidade_dict = dict()
            abastecimento_dict = dict()
            for linha in range(linhas(regioes)):
                dados_regioes = separador(regioes)
                if (dados_regioes[1] != 'Município' and dados_regioes[2] != 'Código do IBGE'):
                    codigosIBGE = int(dados_regioes[2])  # Adquire a quantida de banheiros por casa
                    cidades = dados_regioes[1]  # Adquire o codigo da cidade
                    estado = dados_regioes[3]
                    cidade_dict.update({codigosIBGE: cidades + "-" + estado})
            for linha in range(linhas(pesquisa)):
                dados_pesquisa = separador(pesquisa)
                if(dados_pesquisa[1] != '1.01' and dados_pesquisa[9] != '2.05'):
                    abastecimento = int(dados_pesquisa[9]) #Adquire o abastecimento da casa
                    codigoIBGE = int(dados_pesquisa[1]) #Adquire o codigo da cidade
                    if(cidade_dict[codigoIBGE] not in abastecimento_dict):
                        abastecimento_dict.update({cidade_dict[codigoIBGE]: [0,0,0,0,0,0,0,0,0,0]})
                        for abast in range(10): #Verifica as 10 possibilidades de resposta
                            if (abastecimento == abast):
                                abastecimento_atual = abastecimento_dict[cidade_dict[codigoIBGE]][abast - 1]
                                abastecimento_atual += 1
                                abastecimento_dict[cidade_dict[codigoIBGE]][abast - 1] = abastecimento_atual
                    else:
                        for abast in range(10):
                            if (abastecimento == abast):
                                abastecimento_atual = abastecimento_dict[cidade_dict[codigoIBGE]][abast]
                                abastecimento_atual += 1
                                abastecimento_dict[cidade_dict[codigoIBGE]][abast] = abastecimento_atual
        with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquis:
            for linha in range(linhas(pesquis)):
                dados_pesquis = separador(pesquis)
                if (dados_pesquis[1] != '1.01'):
                    codigo = int(dados_pesquis[1])
                    resposta = abastecimento_dict[cidade_dict[codigo]].index(max(abastecimento_dict[cidade_dict[codigo]]))#Ele acha o maior valor da lista e retorna a posição dentro dela.
                    if(resposta == 0):
                        print("A forma de abastecimento mais comum na cidade",cidade_dict[codigo],"é a rede geral de distribuição.")
                    elif(resposta == 1):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"são os poços ou nascentes na propriedade.")
                    elif(resposta == 2):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"são os poços ou nascentes fora da propriedade.")
                    elif(resposta == 3):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"são os carros-pipas.")
                    elif(resposta == 4):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"é a coleta da agua da chuva armazenada em cisternas.")
                    elif(resposta == 5):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo], "é a coleta da agua da chuva armazenada de outras formas.")
                    elif(resposta == 6):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"são os rios, lagos, açudes e igarapés.")
                    elif(resposta == 7):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"outra.")
                    elif(resposta == 8):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"poço ou nascente na aldeia.")
                    elif(resposta == 9):
                        print("A forma de abastecimento mais comum na cidade", cidade_dict[codigo],"poço ou nascente fora da aldeia.")

def casas_com_energia():
    with open('regioes.txt', 'r', encoding='utf-8-sig') as regioes:
        with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquisa:
            cidade_dict = dict()
            energia_dict = dict()
            for linha in range(linhas(regioes)):
                dados_regioes = separador(regioes)
                if (dados_regioes[1] != 'Município' and dados_regioes[2] != 'Código do IBGE'):
                    codigosIBGE = int(dados_regioes[2])  # Adquire a quantida de banheiros por casa
                    cidades = dados_regioes[1]  # Adquire o codigo da cidade
                    estado = dados_regioes[3]
                    cidade_dict.update({codigosIBGE: cidades + "-" + estado})
            for linha in range(linhas(pesquisa)):
                dados_pesquisa = separador(pesquisa)
                if(dados_pesquisa[1] != '1.01' and dados_pesquisa[11] != '2.07'):
                    status_energia = int(dados_pesquisa[11]) #Adquire o abastecimento da casa
                    codigoIBGE = int(dados_pesquisa[1]) #Adquire o codigo da cidade
                    if(cidade_dict[codigoIBGE] not in energia_dict):
                        energia_dict.update({cidade_dict[codigoIBGE]: [0,0]})
                        if (status_energia == 1 or status_energia == 2):
                            cidades_com_energia = energia_dict[cidade_dict[codigoIBGE]][0]
                            cidades_com_energia += 1
                            energia_dict[cidade_dict[codigoIBGE]][0] = cidades_com_energia
                        elif(status_energia == 3):
                            cidades_sem_energia = energia_dict[cidade_dict[codigoIBGE]][1]
                            cidades_sem_energia += 1
                            energia_dict[cidade_dict[codigoIBGE]][1] = cidades_sem_energia
                    else:
                        if (status_energia == 1 or status_energia == 2):
                            cidades_com_energia = energia_dict[cidade_dict[codigoIBGE]][0]
                            cidades_com_energia += 1
                            energia_dict[cidade_dict[codigoIBGE]][0] = cidades_com_energia
                        elif(status_energia == 3):
                            cidades_sem_energia = energia_dict[cidade_dict[codigoIBGE]][1]
                            cidades_sem_energia += 1
                            energia_dict[cidade_dict[codigoIBGE]][1] = cidades_sem_energia
            for x in energia_dict:
                percentual = (energia_dict[x][1]/sum(energia_dict[x]))*100
                print("O percentual de domicilios da cidade",x,"que não possuem acesso a energia eletrica é de",percentual,"%")
    return energia_dict

def estatisticas_cor():
    with open('exemploPesquisa.txt', 'r', encoding='utf8') as pesquisa:
        BRANCA = 0
        PRETA = 0
        AMARELA = 0
        PARDA = 0
        INDIGENA = 0
        for linha in range(linhas(pesquisa)):
            coluna_pesquisa = separador(pesquisa)[18]
            if(coluna_pesquisa != '4.03'):
                if(coluna_pesquisa == '1'):
                    BRANCA += 1
                elif(coluna_pesquisa == '2'):
                    PRETA += 1
                elif (coluna_pesquisa == '3'):
                    AMARELA += 1
                elif (coluna_pesquisa == '4'):
                    PARDA += 1
                elif (coluna_pesquisa == '5'):
                    INDIGENA += 1
        cores = (BRANCA,PRETA,AMARELA,PARDA,INDIGENA)
        estatisticas_branca = (BRANCA /sum(cores))*100
        estatisticas_preta = (PRETA / sum(cores)) * 100
        estatisticas_amarela = (AMARELA / sum(cores)) * 100
        estatisticas_parda = (PARDA / sum(cores)) * 100
        estatisticas_indigenas = (INDIGENA / sum(cores)) * 100

        return (estatisticas_branca,estatisticas_preta,estatisticas_amarela,estatisticas_parda,estatisticas_indigenas)

def região_mais_pesquisada():
    Norte = ('AM','RR','AP','PA','TO','RO','AC')
    Nordeste = ('MA','PI','CE','RN','PE','PB','SE','AL','BA')
    Centro_oeste = ('MT','MS','GO')
    Sudeste = ('SP','RJ','ES','MG')
    Sul = ('PR','RS','SC')

    estatisticas_norte = 0
    estatisticas_nordeste = 0
    estatisticas_centro_oeste = 0
    estatisticas_sudeste = 0
    estatisticas_sul = 0
    with open('regioes.txt', 'r', encoding='utf-8-sig') as regioes:
        cidade_dict = dict()
        for linha in range(linhas(regioes)):
            dados_regioes = separador(regioes)
            if (dados_regioes[1] != 'Município' and dados_regioes[2] != 'Código do IBGE'):
                codigosIBGE = dados_regioes[2]  # Adquire a quantida de banheiros por casa
                estado = dados_regioes[3]
                cidade_dict.update({codigosIBGE: estado})
        with open('exemploPesquisa.txt', 'r', encoding='utf-8-sig') as pesquisa:
            for linha in range(linhas(pesquisa)):
                codigoIBGE = separador(pesquisa)[1]
                if (codigoIBGE != '1.01'):
                    if(cidade_dict[codigoIBGE] in Norte):
                        estatisticas_norte += 1
                    if (cidade_dict[codigoIBGE] in Nordeste):
                        estatisticas_nordeste += 1
                    if (cidade_dict[codigoIBGE] in Centro_oeste):
                        estatisticas_centro_oeste += 1
                    if (cidade_dict[codigoIBGE] in Sudeste):
                        estatisticas_sudeste += 1
                    if (cidade_dict[codigoIBGE] in Sul):
                        estatisticas_sul += 1
    estatisticas = (estatisticas_norte,estatisticas_nordeste,estatisticas_centro_oeste,estatisticas_sudeste,estatisticas_sul)
    print(estatisticas)
    regiao_com_mais_pesquisas = estatisticas.index(max(estatisticas))

    if(regiao_com_mais_pesquisas == 0):
        return "Norte"
    if (regiao_com_mais_pesquisas == 1):
        return "Nordeste"
    if (regiao_com_mais_pesquisas == 2):
        return "Centro-Oeste"
    if (regiao_com_mais_pesquisas == 3):
        return "Sudeste"
    if (regiao_com_mais_pesquisas == 4):
        return "Sul"

def voltar_menu():
    resposta = input("Voltar ao menu? (s/n):")
    if (resposta == "s"):
        menu()
    elif (resposta == "n"):
        sys.exit()



verificador_pesquisa(verificador_interno('tecnicosIBGE.txt','Matricula','possui mais de um tecnico cadastrado',0),0)
verificador_pesquisa(verificador_interno('regioes.txt','Posição','possui mais de um municipio cadastrado',2),1)


def menu():
    print(" ")
    print("================================================")
    print("     Sistema para o Censo Demografico de 2020    ")
    print("================================================")
    print("[1] - Nº de domicílios utilizados para a coleta")
    print("[2] - Nº de domicílios particulares que já estão pagos, pagando e alugados")
    print("[3] - Quantos domicílios por cidade possuem banheiro e quantos não possuem")
    print("[4] - A forma mais comum de abastecimento de agua por cidade")
    print("[5] - O percentual de domiclios por cidade que ainda não possuem energia elétrica")
    print("[6] - O percentual de moradores que participaram da entrevista por cor ou raça")
    print("[7] - A região com maior número de municípios pesquisados")
    print("[8] - Apresentar todos os dados anteriores")
    print(" ")
    res = int(input("Opcao: "))
    print("================================================")
    print(" ")

    if (res == 1):
        print("Número de domicílios utilizados para a coleta:", contador_linhas('exemploPesquisa.txt') - 1)
        voltar_menu()
    elif (res == 2):
        print("Domicilio Já Pago:", domicilios()[0], "\nDomicilio Ainda Pagando:", domicilios()[1],"\nDomicilio Alugado:", domicilios()[2])
        voltar_menu()
    elif (res == 3):
        contador_banheiros()
        voltar_menu()
    elif (res == 4):
        abastecimento_agua()
        voltar_menu()
    elif (res == 5):
        casas_com_energia()
        voltar_menu()
    elif (res == 6):
        print("Percentual de moradores que participaram da entrevista por cor ou raça:\n", "Branca:",estatisticas_cor()[0], "%\n", "Preta:", estatisticas_cor()[1], "%\n", "Amarela:", estatisticas_cor()[2],"%\n", "Parda:", estatisticas_cor()[3], "%\n", "Indigena:", estatisticas_cor()[4], "%")
        voltar_menu()
    elif (res == 7):
        print("A região com maior número de municipios pesquisados é:", região_mais_pesquisada())
        voltar_menu()
    elif (res == 8):
        print("Número de domicílios utilizados para a coleta:", contador_linhas('exemploPesquisa.txt') - 1)
        print("Domicilio Já Pago:", domicilios()[0], "\nDomicilio Ainda Pagando:", domicilios()[1],"\nDomicilio Alugado:", domicilios()[2])
        contador_banheiros()
        abastecimento_agua()
        casas_com_energia()
        print("Percentual de moradores que participaram da entrevista por cor ou raça:\n", "Branca:",estatisticas_cor()[0], "%\n", "Preta:", estatisticas_cor()[1], "%\n", "Amarela:", estatisticas_cor()[2],"%\n", "Parda:", estatisticas_cor()[3], "%\n", "Indigena:", estatisticas_cor()[4], "%")
        print("A região com maior número de municipios pesquisados é:", região_mais_pesquisada())
        voltar_menu()

menu()#Chamo o menu