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
package Control;

import Views.GerirArquivo;
import Models.Grafo;
import Models.Vertice;
import Views.AddAresta;
import Views.AddVertice;
import Views.CalcularDistanciaEuclideana;
import Views.MainForm;
import Views.RemoveAresta;
import Views.RemoveVertice;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class Controll {

    /**
     * Este é o metódo que inicia o sistema
     *
     * @param args Args
     */
    public static void main(String[] args) {
        MainForm main = new MainForm();// Ela cria um Jrame, que contem a tela principal do programa.
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);// Maximiza esta tela.
        main.setVisible(true);// E a torna visivel.
    }

    /**
     * Este metodo instancia um objeto GerirArquivo,e gera um grafo
     *
     * @return O grafo contendo todas informações da pasta Grafo do diretorio do
     * projeto
     */
    public static Grafo gerarGrafo() {
        GerirArquivo gerir = new GerirArquivo();// Cria um objeto, que será responsavel por importar e exportar o grafo, em forma de SVG.
        return gerir.gerarGrafo();// Retorna o grafo criado.
    }

    /**
     * Este metodo é responsavel por selecionar um arquivo, que será usado pra
     * gerar um novo grafo.
     *
     * @return Um grafo atualizado
     */
    public static Grafo buscarArquivos() {
        GerirArquivo gerir = new GerirArquivo();// Cria um objeto, que será responsavel por importar e exportar o grafo, em forma de SVG.
        if (gerir.buscarArquivo()) {// Caso, o JFileChooser, tenha encontrado um arquivo compativel para confecção do grafo
            return gerir.gerarGrafo();// Ele gera o novo grafo e o retorna
        }
        return null;// Se não foi selecionado, nenhum arquivo valido, a função retorna null
    }

    /**
     * Este metodo é responsavel por salvar um grafo, no disco do computador
     *
     * @param grafo O grafo que o usuario deseja salvar
     * @return A confirmação do processo
     */
    public static boolean salvarArquivos(Grafo grafo) {
        GerirArquivo gerir = new GerirArquivo();// Cria um objeto, que será responsavel por importar e exportar o grafo, em forma de SVG.
        return gerir.salvarArquivos(grafo);// Com o grafo rececbido por parametro, o objeto processa todos os vertices e arestas, os organizam em dois arquivos txt,
        //e os exportam para uma pasta, a efetividade da função é validada por um boolean
    }

    /**
     * Abre um Jframe responsavel por adicionar um vertice ao grafo
     *
     * @param view A view principal do programa
     */
    public static void addVertice(MainForm view) {
        AddVertice janela = new AddVertice(view);// Cria um jFrame que será responsavel por adicionar um vertice no grafo
        janela.setLocationRelativeTo(null);// Deixa o jFrame no centro da tela
        janela.setResizable(false);// Não permite o redimensionamento da janela
        janela.setVisible(true);// A torna visivel
    }

    /**
     * Abre um Jframe responsavel por remover um vertice ao grafo
     *
     * @param view A view principal do programa
     */
    public static void removeVertice(MainForm view) {
        RemoveVertice janela = new RemoveVertice(view);// Cria um jFrame que será responsavel por remover um vertice no grafo
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
    }

    /**
     * Abre um Jframe responsavel por adicionar uma aresta ao grafo
     *
     * @param view A view principal do programa
     */
    public static void addAresta(MainForm view) {
        AddAresta janela = new AddAresta(view);// Cria um jFrame que será responsavel por adicionar uma aresta no grafo
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
    }

    /**
     * Abre um Jframe responsavel por remover uma aresta do grafo
     *
     * @param view A view principal do programa
     */
    public static void removeAresta(MainForm view) {
        RemoveAresta janela = new RemoveAresta(view);// Cria um jFrame que será responsavel por remover uma aresta no grafo
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
    }

    /**
     * Abre um Jframe responsavel por gerar a distancia euclideana entre dois
     * vertices
     *
     * @param view A view principal do programa
     */
    public static void gerarDistanciaEuclideana(MainForm view) {
        CalcularDistanciaEuclideana janela = new CalcularDistanciaEuclideana(view);// Cria um jFrame que será responsavel por calcular a distancia euclideana no grafo.
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setVisible(true);
    }

    /**
     * Este metodo é responsavel por criar uma lista com todos os percusos
     * djkistra a partir de um vertice, e as imprimir em um jLabel
     *
     * @param main A view principal do programa
     * @param selecionado Vertice inicial para todos os percusos Djisktra
     */
    public static void gerarDistanciaDjikstraTodos(MainForm main, Vertice selecionado) {
        Grafo grafo = main.getGrafo();// Receb o grafo
        String text = "<html>";// Cria um texto em html, que será usado em um jLabel
        for (Vertice v : grafo.getVertices()) {// Percorre por todos os vertices do grafo
            if (v.isTerminal()) {//Considera os caminhos apenas de terminal para terminal
                ArrayList<Vertice> resultado = grafo.encontrarMenorCaminhoDijkstra(selecionado.getNomeTerminal(), v.getNomeTerminal());// Cria uma lista contendo o menor caminho entre o vertice passado por parametro e o vertice atual.
                grafo.limparVerticesDjikstra();// Passa por todos os vertice novamente, setando false para os nos pertencentes ao caminho djikstra passado
                String lista = "";// String que ira receber o percusso do menor caminho
                if (resultado.size() == 1) {// Caso, só exista um unico vertice na lista, ou ele faz um percusso para ele mesmo, ou ele está desconectado aos vertices do grafo.
                    lista += "Não existe ligação entre o vertice " + selecionado.getNomeTerminal() + " e o vertice " + v.getNomeTerminal();// Informa, que não a ligação entre os dois vertices
                } else {
                    for (Vertice vertice : resultado) {
                        lista += vertice.getNomeTerminal() + "->"; // Percorre por todos os vertices que compoe o menor caminho djikstra, e incrementa a String lista, montando assim o percusso do vertice inicial até o final
                    }
                }
                text += (lista + "<br>");// Por fim, ele gera uma quebra de linha, pelo padrão html.}
            }
        }
        text += "</html>";// Após passar por todos os vertices,  ele acrescenta o marcador fimal Html.

        main.jLabelEuclidiana.setText(text);// E envia esta String para o jLAbel responsavel por indicar o menor caminho djkistra
    }

    /**
     * Este metodo gera uma ArrayList contendo todos os vertices que compoe o
     * menor caminho, partindo do vertice 1 até o vertice 2
     *
     * @param main A view principal do programa
     * @param nomeTerminal1 Nome do vertice de origem
     * @param nomeTerminal2 Noem do vertice de destino
     * @return Uma arrayList contendo todos os vertices que compoe o percusop
     * djikstra
     */
    public static ArrayList<Vertice> gerarDistanciaDjikstra(MainForm main, String nomeTerminal1, String nomeTerminal2) {
        Grafo grafo = main.getGrafo();// Recebe o grafo
        main.jLabelEuclidiana.setText("");// Limpa o jLabel que indica o menor caminho
        return grafo.encontrarMenorCaminhoDijkstra(nomeTerminal1, nomeTerminal2);// Retorna uma lista contendo os vertices que compoe o menor caminho djkistra
    }

}
