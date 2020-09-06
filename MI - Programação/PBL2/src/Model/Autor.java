/** Autor: Samuel da Costa Araujo Nunes
 *Componente Curricular: MI-Programação
 *Concluido em: 22/01/2020
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package Model;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class Autor{
    private String nome;
    private int quantLivros;

    /**
     * Contrutor da classe Autor.
     * @param nome Nome do autor.
     * @param quantLivros Quantidade de livros escritos por ele.
     */
    public Autor(String nome, int quantLivros) {
        this.nome = nome;
        this.quantLivros = quantLivros;
    }

    /**
     * Retorna o nome do Autor.
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a quantidade de livros escritos pelo Autor.
     * @return
     */
    public int getQuantLivros() {
        return quantLivros;
    }

    /**
     * Altera ou atualiza o nome do Autor.
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera ou atualiza a quantidade de livros de Autor.
     * @param quantLivros
     */
    public void setQuantLivros(int quantLivros) {
        this.quantLivros = quantLivros;
    }
    
    /**
     * Imprime na para o usuario as informações do autor.
     */
    public void displayAutor(){
        String descricao
                = "\n|-----------------------------------------|"
                + "\n Autor: " + nome
                + "\n Quantidade de livros: " + quantLivros
                + "\n|-----------------------------------------|\n";
        System.out.print(descricao);
    }

}
