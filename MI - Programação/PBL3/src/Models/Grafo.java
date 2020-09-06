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
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Samuel da Costa Araujo Nunes
 */
public class Grafo implements Cloneable {

    private HashMap<String, Vertice> hmDeNos;// HashMap que irá guardar os vertices, usando seu nome de terminal como atributo chave.
    private ArrayList<Aresta> listAresta;// ArrayList que irá guardar todas as arestas que compoe o grafo.

    /**
     * Este é o construtor da classe Grafo
     */
    public Grafo() {
        this.hmDeNos = new HashMap();// Cria um HashMap que guardará os vertices.
    }

    /**
     * @return O hashMap de vertices
     */
    public HashMap getGrafo() {
        return hmDeNos; // Retorna o hasMap
    }

    /**
     * Retorna a lista de Arestas
     * @return Lista de todas as arestas do grafo.
     */
    public ArrayList<Aresta> getListAresta() {
        return listAresta; // Retorna uma lista de arestas
    }

    /**
     * Atualiza a lista de arestas do grafo
     * @param listAresta Lista de arestas do grafo
     */
    public void setListAresta(ArrayList<Aresta> listAresta) {
        this.listAresta = listAresta; // Atualiza a lista de arestas.
    }

    //------------------------------CRUD----------------------------------------

    /**
     * Adiciona o vertice no grafo
     * @param no O vertice a ser adicionado
     */
    public void add(Vertice no) {
        hmDeNos.put(no.getNomeTerminal(), no);// Adiciona um vertice ao hashMap.
    }

    /**
     * Remove um vertice do grafo
     * @param no Vertice a ser removido
     * @return O vertice que foi removido
     */
    public Vertice remove(Vertice no) {
        Vertice noRemovido = hmDeNos.remove(no.getNomeTerminal());// Encontra o vertice a ser removido.
        noRemovido.deletarTodasArestas();// Remove todas as arestas guardadas neste vertice
        ArrayList<Aresta> novaList = new ArrayList();// Cria uma arrayList que irá conter todas as aretas atuais do grafo
        for (Vertice v : hmDeNos.values()) { // Percorre por todos os vertices
            for (Aresta a : v.getVizinhos()) { // Percorre todas as arestas do vertice atual
                if (!a.contains(noRemovido)) {// Se esta aresta não conter o vertice removido, ela será adicionada na nova lista de arestas.
                    novaList.add(a);
                }
            }
        }
        listAresta = novaList; // A lista de arestas do grafo é atualizada.
        return noRemovido; // E é retornada
    }

    /**
     * Recebe dois vertices e exclui a aresta que os dois compartilham
     * @param v1 O vertice 1
     * @param v2 O vertice 2
     * @return A aresta removida
     */
    public Aresta removeAresta(Vertice v1, Vertice v2) {
        ArrayList<Aresta> arestasV1 = v1.getVizinhos();// Cria uma arrayList contendo todas as arestas do vertice 1
        for (Aresta a : arestasV1) {// Percorre todas as arestas fo vertice 1.
            if (a.getNoVizinho(v1) == v2) {// Caso exitas algum aresta contenha o vertice 1 e o vertice 2
                v1.getVizinhos().remove(a); //Remove a aresta da lista de vertices do vertce1
                v2.getVizinhos().remove(a); //Remove a aresta da lista de vertices do vertce2
                listAresta.remove(a);// Remove a aresta da lista de arestas do grafo.
                return a;// Retorna esta aresta
            }
        }
        return null;// Caso esta aresta não exista, ele retorna null.
    }

    /**
     * Acha uma aresta a partir dos dois vertices passados por parametro
     * @param atual Vertice inicial
     * @param vizinho Vertice Final
     * @return
     */
    public Aresta acharAresta(Vertice atual, Vertice vizinho) {
        ArrayList<Aresta> listVizinhos = atual.getVizinhos();// Cria uma lista com todas arestas do vertice
        for (Aresta aresta : listVizinhos) {// Percorre por cada aresta da lista
            if (aresta.getNoVizinho(atual) == vizinho) { // Caso a aresta atual, contenha os dois vertices.
                return aresta;// Caso exista, ela o retorna
            }
        }
        return null;
    }

    /**
     * Retorna um vertice a partir do seu nome
     * @param nomeDoNo Nome do vertice
     * @return O vertice procurado
     */
    public Vertice get(String nomeDoNo) {
        return hmDeNos.get(nomeDoNo); //Retorna o vertice, caso exista
    }

    //--------------------------------------------------------------------------
    @Override
    public Grafo clone() throws CloneNotSupportedException {
        return (Grafo) super.clone(); // Retorna um grafo clone, ou seja, gera outro grafo com atributos exatamente iguais
    }

    /**
     * Retorna um ArrayList contendo todos os vertices do grafo
     * @return Um ArrayList contendo todos os vertices do grafo
     */
    public ArrayList<Vertice> getVertices() {
        ArrayList<Vertice> array = new ArrayList<Vertice>(hmDeNos.values());// Cria uma lista contendo todos os vertices do HashMap.
        return array;
    }

    /**
     * Calcula a distancia euclideana a partir das coordenadas dos dois vertices
     * @param v1 O primeiro vertice
     * @param v2 O segundo vertice
     * @return O resultado da distancia euclidiana
     */
    public double distanciaEuclidiana(Vertice v1, Vertice v2) {
        double distancia = Math.sqrt(Math.pow((v1.getX() - v2.getX()), 2) + Math.pow((v1.getY() - v2.getY()), 2));// Esta função recebe as coordenadas dos dois vertices, e gera a distancia euclidiana resultante.
        return distancia; // E retorna esta distancia.
    }

    //------------------------------DIJKSTRA------------------------------------

    /**
     * A partir dos nomes de dois vertices, é possivel gerar o caminho menos custos, baseado no algoritomo de Djikstra
     * @param sv1 O nome do primeiro vertice
     * @param sv2 O nome do segundo vertice
     * @return Uma arrayList contendo o menor caminho Djisktra
     */
    public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(String sv1, String sv2) {

        Vertice v1 = hmDeNos.get(sv1);// cria o vertice de inicio.
        Vertice v2 = hmDeNos.get(sv2);// cria o vertice final.
        
        ArrayList<Vertice> menorCaminho = new ArrayList<Vertice>();//Instancia a lista que guardará os vertices, do menor caminho.
        Vertice vCaminho;// Variavel que recebe os vertices pertencentes ao menor caminho
        Vertice vAtual;// Variavel que guarda o vertice que esta sendo visitado
        Vertice vVizinho;// Variavel que marca o vizinho do vertice atualmente visitado
        Aresta aLigacao;// Aresta que liga o atual ao seu vizinho;
        ArrayList<Vertice> naoVisitados = new ArrayList(); // Lista dos vertices que ainda nao foram visitados
        
        menorCaminho.add(v1); // Adiciona o vertice de origem na lista do menor caminho

        // Colocando a distancias iniciais 
        for (int i = 0; i < this.getVertices().size(); i++) {// Percorre por todos os vertices do grafo
            if (this.getVertices().get(i).getNomeTerminal().equals(v1.getNomeTerminal())) {
                this.getVertices().get(i).setDistancia(0);// O vertice atual tem distancia 0
            } else {
                this.getVertices().get(i).setDistancia(9999);// Enquanto todos os outro tendem ao infinito, (ou um valor muito muito alto )
            }
            naoVisitados.add(this.getVertices().get(i));// Insere o vertice na lista de vertices nao visitados
        }

        Collections.sort(naoVisitados);//Organiza a lista, usando a distancia como atributo comparador.

        while (!naoVisitados.isEmpty()) {// O algoritmo continua ate que todos os vertices sejam visitados

            vAtual = naoVisitados.get(0);//Como a lista está organizada da menor para a maior distancia, ele pega o primeiro vertice, ou seja o com a menor distancia. 
            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */
            for (int i = 0; i < vAtual.getVizinhos().size(); i++) {

                vVizinho = vAtual.getVizinhos().get(i).getNoVizinho(vAtual);

                if (!vVizinho.isVisitado()) {
                    aLigacao = this.acharAresta(vAtual, vVizinho);// Comparando a distância do vizinho com a possível distância
                    if (vVizinho.getDistancia() > (vAtual.getDistancia() + aLigacao.getPesoDaAresta())) {
                        vVizinho.setDistancia(vAtual.getDistancia() + aLigacao.getPesoDaAresta());
                        vVizinho.setPai(vAtual);

                        /*
                         * Se o vizinho eh o vertice procurado, e foi feita uma
                         * mudanca na distancia, a lista com o menor caminho
                         * anterior eh apagada, pois existe um caminho menor
                         * vertices pais, ateh o vertice origem.
                         */
                        if (vVizinho == v2) {
                            menorCaminho.clear();
                            vCaminho = vVizinho;
                            menorCaminho.add(vVizinho);
                            while (vCaminho.getPai() != null) {
                                menorCaminho.add(vCaminho.getPai());
                                vCaminho = vCaminho.getPai();

                            }
                            Collections.sort(menorCaminho);// Ordena a lista do menor caminho, para que ele seja exibido da origem ao destino.

                        }
                    }
                }

            }
           
            vAtual.setVisitado(true); // Marca o vertice atual como visitado e o retira da lista de nao visitados
            naoVisitados.remove(vAtual);

            Collections.sort(naoVisitados);// Reordena a lista

        }
        limparVerticesPai(); //Limpa todos os booleanos Pais.
        desvisitarTodos();// Desvisita todos os vertices
        limparVerticesDjikstra();// Despinta todos os vertices do grafo 
        pintarVerticesDjikstra(menorCaminho);// E pinta apenas aqueles que formam o menor caminho Djikstra
        return menorCaminho;// E retorna a lista de vertices djkistra
    }

    /**
     * Limpa os vertices pais de todos os vertices
     */
    public void limparVerticesPai() {// Esta função, limpa as variaveis pai de cada vertice
        for (int i = 0; i < this.getVertices().size(); i++) {
            this.getVertices().get(i).setPai(null);
        }
    }

    /**
     * Gera o peso do menor caminho Djikstra
     * @param v1 O nome do vertice inicial
     * @param v2 O nome do vertice final
     * @return O peso total da soma das arestas
     */
    public int pesoDoMenorCaminhoDijkstra(String v1, String v2) {// A partir dos dois vertices informados, esta função retorna o peso total do menor caminho.
        int contador = 0;
        Vertice anterior = null;
        ArrayList<Vertice> menorCaminho = encontrarMenorCaminhoDijkstra(v1, v2);
        for (Vertice v : menorCaminho) {// Percorre todos os vertices
            if (anterior != null) {
                contador += anterior.distanciaParaOProximo(v); // Soma os pesos das arestas entre os vertices vizinho, até o vertice final
            }
            anterior = v;
        }
        return contador;// Retorna o contador
    }

    /**
     * Marca todos os vertices da lista, como vertices djkistra
     * @param lista Lista dos vertices a serem pintados
     */
    public void pintarVerticesDjikstra(ArrayList<Vertice> lista) {// Receb um arraylist, e torna verdadeira a variavel color Djiskstra
        for (Vertice v : lista) {
            v.setColoDjkstra(true);
        }
    }

    /**
     * Zera todos os vertices do grafo, para que nenhum esteja pintado
     */
    public void limparVerticesDjikstra() {// Torna todas as variaveis colorDjikstra falsas.
        for (Vertice v : this.getVertices()) {
            v.setColoDjkstra(false);
        }
    }

    /**
     * Desvisita todos os vertices do grafo
     */
    public void desvisitarTodos() {// Desvisita todos os vertices pais.
        for (Vertice v : this.getVertices()) {
            v.setVisitado(false);
        }
    }
}
