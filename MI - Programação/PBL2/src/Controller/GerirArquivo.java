/** Autor: Samuel da Costa Araujo Nunes
 *Componente Curricular: MI-Programação
 *Concluido em: 22/01/2020
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package Controller;

import static Controller.PBL2.arquivoDeEntrada;
import Model.Livro;
import Util.ArvoreBinariaBusca;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A classe <b>GerirArquivo</b>, é responsavel por abrir, editar, criar e
 * recuperar informações de arquivos.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since dec 2019.
 * @version 1.0
 */
public class GerirArquivo {

    String nomeDoArquivo;

    /**
     *
     * @param arquivoDeEntrada
     */
    public GerirArquivo(String arquivoDeEntrada) {
        nomeDoArquivo = arquivoDeEntrada;
    }

    /**
     * O método <b>gerarListaObjetos</b>, recebe uma String contendo o nome do
     * arquivo a ser aberto e retorna ao programa principal uma Arvore contendo
     * Objetos do tipo <b>Livro</b>, ordenados pelo Numero de Ebook.
     *
     * @return Uma ArvoreBinaria contendo todos os livros, estruturada usando o
     * IdDeEbook como parametro.
     */
    public ArvoreBinariaBusca gerarListaObjetos() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();//Inicializa um objeto do tipo Arvore Binaria.
        try {//Tenta abri o arquivo solicitado.
            FileReader arq = new FileReader(nomeDoArquivo);// Gera um objeto contendo o arquivo.
            BufferedReader lerArq = new BufferedReader(arq);// Ler o conteudo do arquivo.

            String linha;
            linha = lerArq.readLine();//Ler a primeira linha do arquivo, que está por default em branco.
            linha = lerArq.readLine();//Ler o cabeçalho do arquivo.

            while (linha != null) {
                String[] array = linha.split(";");//Quebra a linha, dividindo as informações dentro de um Array
                try {
                    int idEbook = Integer.parseInt(array[0]);//Se o id, for realmente um numero, ele converte para um valor inteiro
                    int anoEbook = Integer.parseInt(array[4]);
                    Livro livro = new Livro(idEbook, array[1], array[2], array[3], anoEbook, array[5]);// Um objeto livro é gerado, contendo as informações splitadas.
                    arvore.inserir(livro);//O livro é guardado em uma estrutura de dados do tipo, Arvore. Usando como atributo chave o numero do Ebook.
                } catch (NumberFormatException e) {
                }//Caso, não exista numero de Ebook valido, ele não cadastra o livro.
                linha = lerArq.readLine();//A proxima linha é guardada.
            }
            arq.close();// E por fim, o arquivo é fechado.
        } catch (IOException e) {//Caso, não consiga abrir o arquivo desejado.
            System.err.printf("Erro na abertura do arquivo: %s.\n ", e.getMessage());
        }
        return arvore;
    }

    /**
     O método <b>gravarArquivo</b>, recebe uma ArrayListe contendo todos os livros 
     * guardados na estrutura de dados arvore e retorna ao programa principal um
     * boolean representando se o método conseguiu gravar o arquivo com sucesso.
     *
     * @param listaLivros Uma lista contendo todos os livros a serem gravados.
     * @return O resultado do sucesso do método.
     */
    public boolean gravarArquivo(ArrayList<Livro> listaLivros) {
        try {
            FileWriter arq = new FileWriter(nomeDoArquivo);
            PrintWriter gravarArq = new PrintWriter(arq);
            int escolha = 0;
            gravarArq.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");
            while (listaLivros.size() > escolha) {
                String livroStg = listaLivros.get(escolha).displayLivroForTxt();
                gravarArq.println(livroStg);
                escolha++;
            }
            arq.close();
            System.out.print("Arquivo atualizado com sucesso!!");
            return true;
        } catch (IOException ex) {
            System.out.print("Não foi possivel gravar o arquivo!!");
            return false;
        }
    }
    
}
