
'''Autor: Samuel da Costa Araujo Nunes
Componente Curricular: MI - Algoritmos
Concluido em: 30/03/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.'''


ConsumoSetor = []

ConsAR = []#consumo ar
ar = []#quantidade de ar condicionado
arP = []#potencia dos ar condicionados
arQHD = []#quantidade de horas ar condicionado
arQDM = []#quantidade de dias ar condicionado

ConsPC = []#consumo pc
pc = []#quantidade de pc
pcP = []#potencia dos pcs
pcQHD = []#quantidade de horas pc
pcQDM = []#quantidade de dias PC

ConsGELA = []#consumo geladeira
gela = []#quantidade de geladeiras
gelaP = []#potencia das geladeiras
gelaQHD = []#quantidade de horas de geladeira
gelaQDM = []#quantidade de dias geladeira

ConsLAM = []#consumo lampada
lam = []#quantidade de lampadas
lamP = []#potencia lampadas
lamQHD = []#quantidade de horas lampadas
lamQDM = []#quantidade de dias lampadas

ConsTV = []#consumo tv
tv = []#quantidade de tvs
tvP = []#potencia tvs
tvQHD = []#horas tvs
tvQDM = []#dias tvs

i=0
j=0
tarifa = float(input('Insira o valor da Tarifa Residencial de Baixa Tensão:'))
setores = int(input('Insira quantidade de setores:'))

while(i<setores):
    print('\nSobre o setor', i + 1, 'responda as perguntas:')
    ar.append(float(input('\tExistem quantos aparelhos de Ar Condicionado?')))
    arP.append(float(input('\tQual a Potencia destes(Watts)?')))
    arQHD.append(float(input('\tEles funcionam quantas horas por dia?')))
    arQDM.append(float(input('\tEles funcionam por quantos dias durante o mês?')))
    pc.append(float(input('\tExistem quantos Computadores?')))
    pcP.append(float(input('\tQual a Potencia destes(Watts)?')))
    pcQHD.append(float(input('\tEles funcionam quantas horas por dia?')))
    pcQDM.append(float(input('\tEles funcionam por quantos dias durante o mês?')))
    gela.append(float(input('\tExistem quantas Geladeiras?')))
    gelaP.append(float(input('\tQual a Potencia destes(Watts)?')))
    gelaQHD.append(float(input('\tEles funcionam quantas horas por dia?')))
    gelaQDM.append(float(input('\tEles funcionam por quantos dias durante o mês?')))
    lam.append(float(input('\tExistem quantoas Lampadas?')))
    lamP.append(float(input('\tQual a Potencia destes(Watts)?')))
    lamQHD.append(float(input('\tEles funcionam quantas horas por dia?')))
    lamQDM.append(float(input('\tEles funcionam por quantos dias durante o mês?')))
    tv.append(float(input('\tExistem quantas Televisões?')))
    tvP.append(float(input('\tQual a Potencia destes(Watts)?')))
    tvQHD.append(float(input('\tEles funcionam quantas horas por dia?')))
    tvQDM.append(float(input('\tEles funcionam por quantos dias durante o mês?')))
    ConsAR.append(arQHD[i] * arQDM[i] * arP[i] * ar[i])
    ConsPC.append(pcQHD[i] * pcQDM[i] * pcP[i] * pc[i])
    ConsGELA.append(gelaQHD[i] * gelaQDM[i] * gelaP[i] * gela[i])
    ConsLAM.append(lamQHD[i] * lamQDM[i] * lamP[i] * lam[i])
    ConsTV.append(tvQHD[i] * tvQDM[i] * tvP[i] * tv[i])
    i += 1

    if(setores != i):
        condicional = input('\n\tDeseja continuar? (s/n)')
        if (condicional == 'n'):
            setores = i



while(j < setores):
    print('\nO setor', j + 1, ':\n')
    ConsumoSetor.append((ConsAR[j] + ConsPC[j] + ConsGELA[j] + ConsLAM[j] + ConsTV[j]))
    print('\tConsumiu: ', ConsumoSetor[j]/1000, ' kWh')#conversão de Wh para kWh
    print('\tGastou: R$', ConsumoSetor[j] * tarifa)
    print('\tOs Ar Condicionados gastaram ', ConsAR[j]/1000, ' kWh, que custou',ConsAR[j] * tarifa,'R$')
    print('\tOs Computadores gastaram ', ConsPC[j]/1000, ' kWh, que custou',ConsPC[j] * tarifa,'R$')
    print('\tAs Geladeiras gastaram ', ConsGELA[j]/1000, ' kWh, que custou',ConsGELA[j] * tarifa,'R$')
    print('\tAs Lampadas gastaram ', ConsLAM[j]/1000, ' kWh, que custou',ConsLAM[j] * tarifa,'R$')
    print('\tAs Televisões gastaram ', ConsTV[j]/1000, ' kWh, que custou',ConsTV[j] * tarifa,'R$\n')
    j+=1

CONSTOTAL = sum(ConsumoSetor)
print('\tO consumo total da UEFS foi de ', CONSTOTAL/1000, ' kWh')
VALORTOTAL = (CONSTOTAL * tarifa)
print('\tValor total: R$', VALORTOTAL)
VALORTOTAL = VALORTOTAL * 1.3891966755
print('\tValor total com impostos: R$', VALORTOTAL)

