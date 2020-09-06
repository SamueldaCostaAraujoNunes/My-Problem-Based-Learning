/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Control.Controll;
import Models.Aresta;
import Models.Grafo;
import Models.Vertice;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.green;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JTextField;

/**
 *
 * @author samue
 */
public class DesenhaGrafos extends javax.swing.JPanel {

    private Grafo grafo;// Grafo que será desenhado na tela
    private MainForm main;// Referencia a mainView
    private Vertice[] filaDeNos = {null, null};// Ere irá guardar o historico de nós clicados, assim quando dois dois seguidos forem clicados ele mostra o percusso em djkistra
    ArrayList<Vertice> listaDosVertices;// Lisca com os vertices, do menor caminho.

    int altura;// Altura do jPanel
    int largura;// Largura do jPanel
    int xMax = 0;// Largura do plano cartesiano
    int yMax = 0;// Altura do plano cartesiano

    /**
     * Creates new form DesenhaGrafos
     */
    public DesenhaGrafos(MainForm main) {
        this.main = main;// Indica a referencia da mainVIew
        this.grafo = main.getGrafo();// Indica a referencia do grafo
        listaDosVertices = new ArrayList();
        redimensionarGrafo();

        initComponents();// Inicia os componentes padrão do jPanel

        addMouseListener(new MouseAdapter() {// Adiciona um MouseListener, que será responsavel por avaliar os cliques do mouse, sobre os vertices do grafo
            public void mousePressed(MouseEvent e) {

                float x = e.getX();//Recebe a posição no eixo X, na qual o mouse clicou.
                float y = (altura - e.getY());//Recebe a posição no eixo Y, na qual o mouse clicou.(Ajustando a orientação do eixo).

                x = x / largura;// Acha uma porcentagem, da parte para o todo, assim é possivel normatizar a escala do grafo, independente do tamanho do layout do painel.
                y = y / altura;

                x = x * xMax;// Realiza uma proporção entre o espaço disponivel, e sua representação de unidade no plano cartesiano
                y = y * yMax;

                ArrayList<Vertice> vertices = grafo.getVertices();// Recebe uma lista contendo todos os vertices do grafo.
                boolean verificador = true;// O Verificador, irá validar se o mouse clicou em algum vertice ou não.

                for (Vertice v : vertices) {// Percorre por todos os vertices do grafo para verificar se o clicque do mouse, foi sobre um vertice ou não

                    if ((x >= v.getX() - 10 * xMax / largura && x <= v.getX() + 10 * xMax / largura) && (y >= v.getY() - 10 * yMax / altura && y <= v.getY() + 10 * yMax / altura)) {// Se a posição do mouse for igual a posição de algum vertice no plano cartesiano.
                        verificador = false;
                        guardarNoClicado(v);// Guarda o vertice clicado em uma fila de duas posições.
                    }
                }
                if (verificador) {
                    guardarNoClicado(null);// Caso, nenhum vertice tenha sido clicado, é guardado na fila um valor null.
                    main.jLabelEuclidiana.setText("");// Limpa as informações do menor caminho
                }

                grafo.limparVerticesDjikstra();// Toda vez que há um clique no plano, o caminho de djikstra é limpo
                if (filaDeNos[0] == null && filaDeNos[1] == null) {// Caso, a fila de vertices clicados esteja vazia
                    if (listaDosVertices != null) {
                        listaDosVertices.clear();// Limpa a arrayList que contem os vertices do menor caminho djkistra
                    }
                } else if (filaDeNos[0] != null && filaDeNos[1] == null) {//Caso, apenas um vertice tenha sido clidado

                    if (filaDeNos[0].isTerminal()) {// Se, o vertice clicado for um terminal
                        if (listaDosVertices != null) {
                            listaDosVertices.clear();// Limpa a arrayList que contem os vertices do menor caminho djkistra
                        }
                        Vertice selecionado = filaDeNos[0];// Recebe o vertice selecionado
                        Controll.gerarDistanciaDjikstraTodos(main, selecionado);// Informa ao controller o vertice selecionado, e pede pra ele gerar uma lista contendo os menores caminhos deste vertice par todos os outros
                        filaDeNos[0].setColoDjkstra(true);// Pinta o vertice selecionado
                    }else{
                        listaDosVertices.clear();// Limpa a arrayList que contem os vertices do menor caminho djkistra
                    }
                } else if (filaDeNos[0] != null && filaDeNos[0].isTerminal() && filaDeNos[1] != null && filaDeNos[1].isTerminal()) {//Caso tenha, dois vertices selecionados e os dois forem terminais

                    String nomeTerminal1 = filaDeNos[0].getNomeTerminal();// Recebe o nome do v1
                    String nomeTerminal2 = filaDeNos[1].getNomeTerminal();// Recebe o nome do v2

                    listaDosVertices = Controll.gerarDistanciaDjikstra(main, nomeTerminal1, nomeTerminal2);// Recebe uma lista contendo os vertices que compoe o menor caminho djkstra
                    zerarFila();// Zera a fila de vertices clicados
                }
                att();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void redimensionarGrafo() {
        ArrayList<Vertice> listVertice = grafo.getVertices();// Recebe a lista atualizada de verticecs do grafo

        int xInicial = xMax;// Recebe o xMax
        int yInicial = yMax;// Recebe o yMax

        xMax = 0;//Zera a variavel
        yMax = 0;

        for (Vertice v : listVertice) {//Percorre por todos os vertices achando as maiores coordenadas no plano cartesiano
            if (v.getX() >= xMax) {
                xMax = v.getX();
            }
            if (v.getY() >= yMax) {
                yMax = v.getY();
            }
        }

        xMax += 50;// Incremente uma folga no grafo de 50
        yMax += 50;

        if (xInicial != xMax || yInicial != yMax) {
            att();// Se as maiores coordenadas antigas forem diferentes das atuais, ele atualiza a GUI.
        }
    }

    public void att() {
        this.grafo = main.getGrafo();// Gera um novo grafo
        initComponents();// Atualiza a GUI.
    }

    public void guardarNoClicado(Vertice v) {
        Vertice prox = filaDeNos[0];// Guarda o vertice da primeira posição em uma variavel auxiliar
        filaDeNos[0] = v;// O vertice passado por parametro vai pro fim da fila 
        filaDeNos[1] = prox;// E o vertice proximo, vai para o inicio da fila
        if (prox == null || !prox.isTerminal()) {
            filaDeNos[1] = null;// Se o prox for nulo ou não for um terminal, ele nunca vai para a primeira posição da fila
        }
    }

    public void zerarFila() {
        filaDeNos[0] = null;//Zera a fila
        filaDeNos[1] = null;
    }

    private void pintarVertice(Vertice v, Graphics g, int largura, int altura) {
        int x = v.getX() * largura / xMax; //Recebe a coordenada x, já redimensionada para o painel
        int y = altura - (v.getY() * altura / yMax); //Recebe a coordenada y, já redimensionada para o painel

        if (v.isColoDjkstra()) {// Se o vertice me questão compor um caminho djikstra, ele será pintado de laranja
            g.setColor(orange);
        } else {
            if (v.isTerminal()) {// Se for um terminal, será pintado de verde
                g.setColor(green); 
            } else {// E se nçao for um temrinal, será pintado de vermelho
                g.setColor(red);
            }
        }
        g.fillOval(x - 10, y - 10, 20, 20);// O vertice é centralizado, e é desenhado um circulo a sua volta, com a cor escolhida
        if (!v.isColoDjkstra()) {// Se o vertice não compor o caminho djikstra, o nome de terminal será pintado de preto
            g.setColor(black);
        }
        g.drawString(v.getNomeTerminal(), x - 15, y - 15);// É Printado seu nome na tela, levemente a sua diagonal superior a esquerda.
    }

    private void pintarAresta(Aresta a, Graphics g, int largura, int altura, boolean djikstra) {
        ArrayList<Vertice> vertics = a.getNos();// Receb os nós que compoe o vertice
        Vertice v1 = vertics.get(0);// Guardas os dois vertices
        Vertice v2 = vertics.get(1);
        if (djikstra) {// Se a aresta compor um percusso djikstra, ela será pintada de laranja, se não, de preta
            g.setColor(orange);
        } else {
            g.setColor(black);
        }

        int x1 = v1.getX() * largura / xMax;// Recebe o x inicial
        int y1 = altura - (v1.getY() * altura / yMax);// Recebe o y inicial
        int x2 = v2.getX() * largura / xMax;// Recebe o x final
        int y2 = altura - (v2.getY() * altura / yMax);// Recebe o y final

        g.drawLine(x1, y1, x2, y2);// Desenha a linha, simbolizando a aresta
        g.drawString(Integer.toString(a.getPesoDaAresta()), (x2 - x1) / 2 + x1, (y2 - y1) / 2 + y1);// No ponto medio da aresta, é printado o peso da aresta.
    }

    protected void paintComponent(Graphics g) {

        this.grafo = main.getGrafo();
        altura = super.getHeight();//Recebe a altura da classe pai, para redimensionar o grafo.
        largura = super.getWidth();//Recebe a largura da classe pai, para redimensionar o grafo.
        redimensionarGrafo();// Redimensiona o espaço do plano cartesiano
        ArrayList<Aresta> arestas = grafo.getListAresta();// Gera uma lista de arestas
        ArrayList<Vertice> vertices = grafo.getVertices();//gerar umsa lista de vertices
        super.paintComponent(g);// Chama o metodo pai

        ArrayList<Aresta> listArestas = new ArrayList();// Lista que irá receber todas as arestas que fazem parte do caminho de djikstra

        Vertice anterior = null;// Cria um vertice auxiliar
        if (listaDosVertices != null) {// Caso exista uma lista de vertices djkistra
            for (Vertice v : listaDosVertices) {
                if (anterior != null) {
                    Aresta arestaAtual = anterior.getAresta(v);// Recebe a aresta que faz ligação entre o vertice atual e o anterior
                    listArestas.add(arestaAtual);// Adiciona na lista de arestas djikstra
                    anterior = v;// O anterior passa a ser o atual
                } else {
                    anterior = v;// O Anterior passa a ser o atual
                }
            }
        }

        for (Aresta a : arestas) {// Para todas as arestas
            pintarAresta(a, g, largura, altura, listArestas.contains(a));// Pinta individualmente cada aresta
        }
        g.setFont(new Font("default", Font.BOLD, 16));// Muda a fonte da letra

        for (Vertice v : vertices) {// Para todos os vertices
            pintarVertice(v, g, largura, altura);// Pinta individualmente cada vertice
        }

        g.setColor(black);// Seta a cor do grphics como preta

        g.setFont(new Font("default", Font.CENTER_BASELINE, 16));// Muda novamente a fonte
        for (int i = 50; i < xMax; i += 50) {//A cada intevalo de 50, no plano cartesiano
            g.drawString(Integer.toString(i), i * largura / xMax, altura - 10);// É printado uma legenda, no eixo x 
        }

        for (int i = 50; i < yMax; i += 50) {//A cada intevalo de 50, no plano cartesiano
            g.drawString(Integer.toString(i), 10, altura - (i * altura / yMax));// É printado uma legenda, no eixo y
        }

        g.drawString(Integer.toString(0), 10, altura - 10);// Escreve o 0, no ponto 0

        g.setColor(green);
        g.drawString("Terminal", largura - (largura / 10), altura - 50);// Imprime uma legenda pro terminal e não terminal

        g.setColor(red);
        g.drawString("Não Terminal", largura - (largura / 10), altura - 30);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
