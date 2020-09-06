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
public class Aresta {

    private Vertice noAdjacente1;// Primeiro vertice da aresta
    private Vertice noAdjacente2;// Segundo vertice da aresta
    private int pesoDaAresta;// Peso da aresta

    /**
     * Contrutor da classe Aresta
     * @param noAdjacente1 Primeiro Vertice
     * @param noAdjacente2 Segundo Vertice
     * @param pesoDaAresta Peso da Aresta
     */
    public Aresta(Vertice noAdjacente1, Vertice noAdjacente2, int pesoDaAresta) {

        this.noAdjacente1 = noAdjacente1;
        this.noAdjacente2 = noAdjacente2;
        this.pesoDaAresta = pesoDaAresta;

        noAdjacente1.getVizinhos().add(this);// Adciona esta aresta na lista de arestas de cada vertice
        noAdjacente2.getVizinhos().add(this);
    }
   
    /**
     * Ao informar um vertice, se a aresta conter este, ela irá retornar o outro vertice
     * @param v Vertice escolhido
     * @return Vertice vizinho, quem compartilhar esta aresta
     */
    public Vertice getNoVizinho(Vertice v) {
        if (v == noAdjacente1) {// Ao informar um verticec, o outro é retornado
            return noAdjacente2;
        } else if (v == noAdjacente2) {
            return noAdjacente1;
        }
        return null;
    }
    
    /**
     * Retorna um array contendo os dois vertices da aresta
     * @return Um array contendo dosi vertices
     */
    public ArrayList<Vertice> getNos(){
        ArrayList<Vertice> array = new ArrayList();
        array.add(noAdjacente1);
        array.add(noAdjacente2);
        return array;// Retorna um array, com os dois vertices da aresta
    }

    /**
     * Retorna o peso da aresta
     * @return O peso da aresta
     */
    public int getPesoDaAresta() {
        return pesoDaAresta;
    }
    
    /**
     * Verifica se a aresta contem o vertice passado por parametro
     * @param v Vertice que pode esta contido ou não
     * @return Informa se a aresta contem ou não um determinado vertice
     */
    public boolean contains(Vertice v){
        return this.noAdjacente1 == v || this.noAdjacente2 == v;// retorna um boolean, informando se a aresta contem ou não um determinado vertice
    }

    /**
     * Atualiza o valor da aresta
     * @param pesoDaAresta Novo peso da aresta
     */
    public void setPesoDaAresta(int pesoDaAresta) {
        this.pesoDaAresta = pesoDaAresta;// Recebe um peso
    }

    /**
     * Gera uma string, que serve de molde para gerar outra Aresta
     * @return gera uma linha contendo todas as informações da aresta
     */
    public String displayForTxt(){
        return this.noAdjacente1.getNomeTerminal() + "," + this.noAdjacente2.getNomeTerminal() + "," + this.pesoDaAresta;// Gera uma string contendo todas as informações cruciais para a contrução de uma aresta
    }
}
