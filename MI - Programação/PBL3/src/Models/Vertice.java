/** Autor: Samuel da Costa Araujo Nunes
 *Componente Curricular: MI-Programação
 *Concluido em: Data
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class Vertice implements Comparable {

    private String nomeTerminal; // Nome do terminal
    private boolean terminal; // Verifica se é um terminal ou um roteador
    private boolean coloDjkstra; // Verifica se o vertice compõe atualmente um caminho djikistra
    private ArrayList<Aresta> listaDasArestas; // Uma lista contendo todas as arestas que se ligam ao vertice
    private int distancia = 0; // Variavel usada para calcular o peso total no algoritmo de djkistra
    private boolean visitado = false; // Variavel usada para verificar se já foi visitada ou não, pelo algoritmo djikstra
    private Vertice pai; // Vertice pertencente ao menor caminho, anterior a este vertice
    private int x, y;// As coordenadas do vertice no plano cartesiano

    /**
     *Contrutor da classe Vertice
     * @param nomeTerminal Nome do terminal/roteador
     * @param terminal Booleano indicando se é ou não, um terminal
     * @param x Posição no eixo X, no plano cartesiano
     * @param y Posição no eixo Y, no plano cartesiano
     */
    public Vertice(String nomeTerminal, boolean terminal, int x, int y) {
        this.nomeTerminal = nomeTerminal;
        this.terminal = terminal;
        this.x = x;
        this.y = y;
        this.coloDjkstra = false;// Inicia como falso
        listaDasArestas = new ArrayList();// Instancia a ArrayList
    }

    /**
     * Ao passar um vertice por parametro, ele verifica se existe uma aresta ligando os dois, se existir, ele retona o peso da aresta
     * @param v Vertice a ser avaliado
     * @return O peso da aresta entre o vertice atual e o passado pelo parametro.
     */
    public int distanciaParaOProximo(Vertice v) {// Recebe um Vertic como parametro
        for (Aresta aresta : listaDasArestas) {// Percorre por todas as arestas do vertice
            if (aresta.getNoVizinho(this) == v) {// Se a aresta atual, fizer ligação entre o nó atual, e o nó passado por parametro
                return aresta.getPesoDaAresta();// Ele retorna o peso do vertice
            }
        }
        return 0;// Caso, os vetices não compartilhem uma aresta, ele retorna 0
    }

    /**
     * Gera uma string, que serve de molde para gerar outro Vertice
     * @return gera uma linha contendo todas as informações necessarias para a criação de outro vertice
     */
    public String displayForTxt() {
        String linha = this.nomeTerminal + "," + this.terminal + "," + this.x + "," + this.y;// Gera uma string contendo todas as informações cruciais para a contrução de um vertice
        return linha; // retorna esta string
    }

    /**
     *Deleta todas as arestas que contem este vertice, tanto detro dele quanto nos vertices vizinhos
     */
    public void deletarTodasArestas() {
        for (Aresta a : listaDasArestas) {// Percorre por todas as aresta que fazem ligação com o vertice
            Vertice vizinho = a.getNoVizinho(this);// Receve o vertice vizinho, que fica do outro lado da aresta
            vizinho.getVizinhos().remove(a);// E remove o objeto aresta, do vertice vizinho
        }
        listaDasArestas.clear();// Por sim, ele limpa todas as arestas do vertice atual
    }

    /**
     * Deleta a aresta entre este vertice e o passado por parametro
     * @param v Vertice que será analisado
     */
    public void deletarAresta(Vertice v) {
        for (Aresta aresta : listaDasArestas) {// Percorre por toda lista de arestas
            Vertice noVizinho = aresta.getNoVizinho(this);//Retorna o nó vizinho 
            if (noVizinho.equals(v)) {// Se o nó vizinho, for igual ao no passado por parametro
                listaDasArestas.remove(aresta);// Ele remove esta aresta
            }
        }
    }

    @Override
    public int compareTo(Object vizinho) { //Metódo da interface Comparable, que define qual atributo será usado como comparador, afim de organizar da lista pela distancia. 
        Vertice v = (Vertice) vizinho;//Recebe o vertice a ser comparado
        if (this.distancia < v.distancia) {// Se o vertice atual for menor que o passado pelo paramentro, retorna -1
            return -1;
        }
        if (this.distancia > v.distancia) {// Se for maior, retorna +1
            return 1;
        }
        return 0;//Se for igual, retorna 0
    }

    /**
     *
     * @return
     */
    public boolean isColoDjkstra() {
        return coloDjkstra;
    }

    /**
     *
     * @param coloDjkstra
     */
    public void setColoDjkstra(boolean coloDjkstra) {
        this.coloDjkstra = coloDjkstra;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public Vertice getPai() {
        return pai;
    }

    /**
     *
     * @param pai
     */
    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    /**
     *
     * @param v
     * @return
     */
    public Aresta getAresta(Vertice v) {
        for (Aresta aresta : listaDasArestas) {// Percorre todas asrestas
            if (aresta.getNoVizinho(this) == v) {// Se achar a aresta desejada
                return aresta;// Ele a retorna
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     *
     * @param distancia
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     *
     * @return
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     *
     * @param visitado
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     *
     */
    public Vertice() {
    }

    /**
     *
     * @return
     */
    public String getNomeTerminal() {
        return nomeTerminal;
    }

    /**
     *
     * @param nomeTerminal
     */
    public void setNomeTerminal(String nomeTerminal) {
        this.nomeTerminal = nomeTerminal;
    }

    /**
     *
     * @return
     */
    public boolean isTerminal() {
        return terminal;
    }

    /**
     *
     * @param terminal
     */
    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    /**
     *
     * @return
     */
    public ArrayList<Aresta> getVizinhos() {
        return listaDasArestas;
    }

    /**
     *
     * @param listaDasArestas
     */
    public void setListaDasArestas(ArrayList<Aresta> listaDasArestas) {
        this.listaDasArestas = listaDasArestas;
    }

}
