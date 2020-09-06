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
package Views;

import Models.Aresta;
import Models.Aresta;
import Models.Grafo;
import Models.Grafo;
import Models.Vertice;
import Models.Vertice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class GerirArquivo {

    
    private String path = "Grafo";
    private String vertices = "Vertices.txt";
    private String arestas = "Arestas.txt";

    /**
     * Retorna o nome do arquivo que guarda os vertices
     * @return O nome do arquivo que guarda os vertices
     */
    public String getVertices() {
        return vertices;
    }

    /**
     * Altera o nome do arquivo que guarda os vertices
     * @param vertices
     */
    public void setVertices(String vertices) {
        this.vertices = vertices;
    }

    /**
     * Retorna o nome do arquivo que guarda as arestas
     * @return O nome do arquivo que guarda as arestas
     */
    public String getArestas() {
        return arestas;
    }

    /**
     * Altera o nome do arquivo que guarda as arestas
     * @param arestas
     */
    public void setArestas(String arestas) {
        this.arestas = arestas;
    }

    /**
     * Altera o path da pasta que guarda os dois arquivos de texto(Vertices.txt e Arestas.txt)
     * @return O resultado da operação
     */
    public boolean buscarArquivo() {
        
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());// Cria um escolhedor de arquivos
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {// Se o usuario a pedir para abrir um arquivo
            File selectedFile = jfc.getSelectedFile();// Recebe o arquivo selecionado
            path = selectedFile.getAbsolutePath();// Altera o path, que a classe irá procurar o arquivo
            return true;
        }
        else if (returnValue == JFileChooser.CANCEL_OPTION){
            return false;
        }
        return false;
    }

    /**
     * Este metodo gera um grafo, a partir de uma pasta, que contem um arquivo txt pra vertice e um para arestas.
     * @return Retorna um grafo.
     */
    public Grafo gerarGrafo() {
        Grafo grafo = new Grafo();
        try {//Tenta abri o arquivo solicitado.
            FileReader arq = new FileReader(path + "\\" + vertices);// A partir do path, ele busca o arquivo vertice
            BufferedReader lerArq = new BufferedReader(arq);// Abre o arquivo

            String linha;
            linha = lerArq.readLine();//Ler a primeira linha do arquivo, que está por default em branco.
            linha = lerArq.readLine();//Ler o cabeçalho do arquivo.

            while (linha != null) {
                String[] array = linha.split(",");//Quebra a linha, dividindo as informações dentro de um Array
                try {
                    String nome = array[0];// Recebe o nome do terminal
                    boolean terminal = Boolean.parseBoolean(array[1]);// Verifica se o vertice é um terminal ou não
                    int x = Integer.parseInt(array[2]);// Recebe a coordenada X no plano cartesiano
                    int y = Integer.parseInt(array[3]);// Recebe a coordenada Y no plano cartesiano

                    Vertice vertice = new Vertice(nome, terminal, x, y);// Gera o vertice
                    grafo.add(vertice);// Adiciona ao grafo
                } catch (NumberFormatException e) {}
                linha = lerArq.readLine();//A proxima linha é guardada.
            }
            arq.close();// E por fim, o arquivo é fechado.
        } catch (IOException e) {//Caso, não consiga abrir o arquivo desejado.
            System.err.printf("Erro na abertura do arquivo: %s.\n ", e.getMessage());
        }

        gerarArestasGrafo(grafo);// Depois de criar os vertice, ele chama o metodo que cria as ligações

        return grafo;// E por fim retorna o grafo
    }

    private void gerarArestasGrafo(Grafo grafo) {
        ArrayList<Aresta> listaAresta = new ArrayList();
        try {//Tenta abri o arquivo solicitado.
            FileReader arq = new FileReader(path + "\\" + arestas);// Ler o artquivo aresta
            BufferedReader lerArq = new BufferedReader(arq);// Abre o arquivo

            String linha;// Cria a String linha
            linha = lerArq.readLine();//Ler a primeira linha do arquivo, que está por default em branco.
            linha = lerArq.readLine();//Ler o cabeçalho do arquivo.

            while (linha != null) {
                String[] array = linha.split(",");//Quebra a linha, dividindo as informações dentro de um Array
                try {
                    Vertice vInicial = grafo.get(array[0]);// Recebe um vertice do grafo, com o nome do vertice da linha
                    Vertice vFinal = grafo.get(array[1]);// Recebe um vertice do grafo, com o nome do segundo vertice da linha
                    int peso = Integer.parseInt(array[2]);// Por fim, recebe o peso da aresta

                    Aresta aresta = new Aresta(vInicial, vFinal, peso);// Cria a aresta
                    listaAresta.add(aresta);//Adiciona a aresta a lista de arestas
                } catch (NumberFormatException e) {}
                linha = lerArq.readLine();//A proxima linha é guardada.
            }
            arq.close();// E por fim, o arquivo é fechado.
        } catch (IOException e) {//Caso, não consiga abrir o arquivo desejado.
            System.err.printf("Erro na abertura do arquivo: %s.\n ", e.getMessage());
        }
        grafo.setListAresta(listaAresta);// Atualiza a lista de arestas do grafo
    }
    
    /**
     * Expora o grafo para uma pasta fora do diretorio 
     * @param grafo O grafo que deseja salvar
     * @return A validação do processo de slavamento
     */
    public boolean salvarArquivos(Grafo grafo) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());//Instancia o fileChosse
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {// Se ele selecionou corretamente uma pasta
                File file = jfc.getSelectedFile();// Recebe o arquivo/pasta que será salvo 
                return gerarArquivoTxtVertice(grafo, file) && gerarArquivoTxtAresta(grafo, file);// E passa para os dois metodos responsaveis por salvar os dois arquivos de texto, vertice e arestas
            }
        }
        return false;// Caso a operação falhe
    }
    
    /**
     * Esse metodo cria o arquivo txt que irá guardar os vertices
     * @param grafo O grafo que deseja salvar
     * @param file A pasta que deverá ser salvo
     * @return O resultado da operação
     */
    public boolean gerarArquivoTxtVertice(Grafo grafo, File file){
       try {
            FileWriter arq = new FileWriter(file.getPath() + "\\" + vertices);// Cria um arquivo vertice na pasta indicada
            PrintWriter gravarArq = new PrintWriter(arq);// Abre o arquivo e espera para gravar algo
            gravarArq.println("Nome,Terminal,x,y");// Insere o cabeçalho
            for(Vertice v : grafo.getVertices()) {// Percorre por todos os vertices do grafo
                String linha = v.displayForTxt();// gera o display txt, ou seja o molde para txt
                gravarArq.println(linha);//E grava esta string na linha
            }
            arq.close();// Por fim, fecha o arquivo
            return true;
        } catch (IOException ex) {
            return false;// Caso dê algum erro, retorna false
        }
    }
    
    /**
     *
     * @param grafo
     * @param file
     * @return
     */
    public boolean gerarArquivoTxtAresta(Grafo grafo, File file){
       try {
            FileWriter arq = new FileWriter(file.getPath() + "\\" + arestas);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println("Noinicial,NoFinal,Peso");
            for(Aresta a : grafo.getListAresta()) {
                String linha = a.displayForTxt();
                gravarArq.println(linha);
            }
            arq.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    
    
}
