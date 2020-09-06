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

import Model.Livro;
import Util.ArvoreBinariaBusca;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class PBL2 {

    /**
     * @param args the command line arguments
     */
    static String arquivoDeEntrada = "Arquivo de entrada do catálogo.txt";
    static ArvoreBinariaBusca arvore;
    static Scanner scanner;
    static GerirArquivo gerir;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        gerir = new GerirArquivo(arquivoDeEntrada);
        System.out.print("Antes de executar as opções do menu, carrege a base de dados na opção 2!!\n\n\n");
        while (true) {
            menu();
            voltarMenuOuSair();
        }

    }

    public static void menu() throws IOException {

        Scanner menuSc = new Scanner(System.in);

        System.out.print("\n|------------------Menu-------------------|\n\n");
        System.out.print("|-----------------------------------------|\n");
        System.out.print("| Opção 1 - Cadastrar - Livro             |\n");
        System.out.print("| Opção 2 - Carregar base de dados        |\n");
        System.out.print("| Opção 3 - Gravar arquivo                |\n");
        System.out.print("| Opção 4 - Listar - Autores/Quantidade   |\n");
        System.out.print("| Opção 5 - Listar - Autor/Livros         |\n");
        System.out.print("| Opção 6 - Listar - Livros               |\n");
        System.out.print("| Opção 7 - Buscar Livro                  |\n");
        System.out.print("| Opção 8 - Buscar Livro/Ano              |\n");
        System.out.print("| Opção 9 - Excluir Livro                 |\n");
        System.out.print("| Opção 10 - Sair                         |\n");
        System.out.print("|-----------------------------------------|\n\n");
        System.out.print("Digite uma opção: ");

        int opcao = menuSc.nextInt();
        int ano;

        switch (opcao) {
            case 1:
                System.out.print("\n| Opção 1 - Cadastrar - Livro             |\n");

                System.out.print("Insira o numero de Ebook do livro: \n");
                int numEbook = scanner.nextInt();

                System.out.print("Insira o titulo do livro: \n");
                scanner.nextLine();
                String titulo = scanner.nextLine();

                System.out.print("Insira o nome do autor do livro: \n");
                String autor = scanner.nextLine();

                System.out.print("Insira o mês de publicação do livro: \n");
                String mes = scanner.nextLine();

                System.out.print("Insira o ano de publicação do livro: \n");
                ano = scanner.nextInt();

                System.out.print("Insira o link de acesso do livro: \n");
                String link = scanner.nextLine();

                Livro livroASerCadastrado = new Livro(numEbook, titulo, autor, mes, ano, link);
                cadastrarLivro(livroASerCadastrado);
                break;

            case 2:
                System.out.print("\n| Opção 2 - Carregar base de dados        |\n");
                if (carregarDados()) {
                    System.out.print("\nArquivo carregado com sucesso!!\n");
                } else {
                    System.out.print("\nFalha ao carregar o arquivo!!\n");
                }
                break;

            case 3:
                System.out.print("\n| Opção 3 - Gravar arquivo                |\n");
                ArrayList<Livro> listaLivros = gerarArquivo();
                gerir.gravarArquivo(listaLivros);
                break;

            case 4:
                System.out.print("\n| Opção 4 - Listar - Autores/Quantidade   |\n");
                listarAutorPorQuantidade();
                break;

            case 5:
                System.out.print("\n| Opção 5 - Listar - Autor/Livros          |\n");
                System.out.print("Insira o nome de um autor: \n");
                autor = scanner.nextLine();
                System.out.print(autor);
                acharLivrosDeUmAutor(autor);
                break;

            case 6:
                System.out.print("\n| Opção 6 - Listar - Livros               |\n");
                arvore.displayOrdem();
                break;

            case 7:
                System.out.print("\n| Opção 7 - Buscar Livro                  |\n");
                System.out.print("Insira o numero de Ebook do livro: \n");
                int idEbook = scanner.nextInt();

                Livro livroBuscado = buscarLivro(idEbook);

                if (livroBuscado != null && arvore != null) {
                    String nomeDoArquivo = "ArquivosTxt\\ArquivosDeBusca\\BuscaPorId\\" + livroBuscado.getNumEbook() + ".txt";

                    FileWriter arquivo = new FileWriter(nomeDoArquivo);
                    PrintWriter gravarArq = new PrintWriter(arquivo);
                    livroBuscado.displayLivroUI();
                    gravarArq.println(livroBuscado.displayLivroForTxt());
                    arquivo.close();
                } else {
                    System.out.print("Livro não encontrado!!");
                }
                break;

            case 8:
                System.out.print("\n| Opção 8 - Buscar Livro/Ano              |\n");
                System.out.print("\nQual o ano desejado?\n");
                ano = scanner.nextInt();
                System.out.print("\n");
                ArrayList<Livro> lista = arvore.findAno(ano);
                if(arvore != null && !lista.isEmpty()){
                    String nomeDoArquivo = "ArquivosTxt\\ArquivosDeBusca\\BuscaPorAno\\" + ano + ".txt";

                    FileWriter arquivo = new FileWriter(nomeDoArquivo);
                    PrintWriter gravarArq = new PrintWriter(arquivo);
                    
                    String texto = "";
                    
                    for(Livro livro : lista){
                        texto += livro.displayLivroForTxt() + "\n";
                    }
                    gravarArq.print(texto);
                    arquivo.close();
                    int cont = 0;
                    while (cont < lista.size()) {
                        lista.get(cont).displayLivroUI();
                        cont++;
                    }
                }else{
                    System.out.println("Não foi possivel achar livros deste ano!!");
                }
                
                break;

            case 9:
                System.out.print("\n| Opção 9 - Excluir Livro                 |\n");
                System.out.print("Insira o numero de Ebook do livro que pretende deletar: \n");
                idEbook = scanner.nextInt();
                deletarLivro(idEbook);
                
                break;

            case 10:
                System.out.println("\nAté logo!");
                System.exit(0);
                break;

            default:
                System.out.print("\nOpção Inválida!");
                menu();
                break;

        }
    }

    public static void voltarMenuOuSair() throws IOException {
        Scanner voltarSc = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("|-----------------------------------------|\n");
        System.out.print("| Opção 1 - Voltar ao menu                |\n");
        System.out.print("| Opção 2 - Sair                          |\n");
        System.out.print("|-----------------------------------------|\n\n");

        System.out.print("Digite uma opção: ");

        int opcao = voltarSc.nextInt();

        switch (opcao) {

            case 1:
                break;

            case 2:
                System.exit(0);
                break;

            default:
                System.out.print("\nOpção Inválida!");
                voltarMenuOuSair();
                break;
        }
    }
//--------------------------------------------Funções/Requisitos----------------------------------------------------------    

    /**
     * Requisito N1
     * Chama o metodo inserir da arvore binaria.
     * @return Se a função for realizada com sucesso, retorna true.
     */
    public static boolean cadastrarLivro(Livro livro) {
        arvore.inserir(livro);
        return true;
    }

    /**
     * Requisito N2
     * Carrega os livros do arquivo txt 
     * @param nomeDoArquivo Nome do arquivo com os dados dos livros.
     * @return Retorna um valor logico representando a efetivação da função.
     */
    public static boolean carregarDados() {
        try {
            arvore = gerir.gerarListaObjetos();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
    *Requisito N3
    */
    public static ArrayList gerarArquivo() {
        ArrayList listLivros = arvore.gerarListaEmPreOrdem();
        return listLivros;
    }

    /**
     * Requisito N7
     *
     * @param idEbook O id de Ebook do livro a ser buscado.
     * @return O livro correspondente ao id informado.
     */
    public static Livro buscarLivro(int idEbook) {
        try {
            Livro livro = arvore.find(idEbook);
            return livro;
        } catch (Exception e) {
            return null;
        }

    }
    /**
     * Requisito N4
     */
    public static void listarAutorPorQuantidade(){
        arvore.listarAutorPorQuantidade();
    }
    /**
     * Requisito N5
     * @param nomeDoAutor Nome do autor a ser pesquisado.
     */
    public static void acharLivrosDeUmAutor(String nomeDoAutor){
        arvore.listLivrosDoAutor(nomeDoAutor);
    }
    /**
     * Requisito N9
     * @param idEbook O id de Ebook do livro a ser deletado.
     * @return O livro deletado da arvore.
     */
    public static Livro deletarLivro(int idEbook){
        return arvore.remover(idEbook);
    }
}
