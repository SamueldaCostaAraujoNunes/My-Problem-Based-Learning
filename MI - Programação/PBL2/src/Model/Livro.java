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
 * Classe de Modelo, representando um Livro.
 * @author Samuel da Costa Araujo Nunes
 */
public class Livro {

    private int numEbook;
    private String titulo;
    private String autor;
    private String mes;
    private int ano;
    private String link;

    /**
     *
     * @param numEbook Numero do Id do Ebook
     * @param titulo Tirulo do livro
     * @param autor Nome do Autor do Livro
     * @param mes Mês de publicação
     * @param ano Ano de publicação
     * @param link Link para acesso as informações do livro
     */
    public Livro(int numEbook, String titulo, String autor, String mes, int ano, String link) {
        this.numEbook = numEbook;
        this.titulo = titulo;
        this.autor = autor;
        this.mes = mes;
        this.ano = ano;
        this.link = link;
    }

    /**
     * Este metodo é responsavel por criar uma UserInterface.
     */
    public void displayLivroUI() {
        String descricao
                = "\n|-----------------------------------------|"
                + "\n Nº Ebook: " + numEbook
                + "\n Titulo: " + titulo
                + "\n Autor: " + autor
                + "\n Mês: " + mes
                + "\n Ano: " + ano
                + "\n Link: " + link
                + "\n|-----------------------------------------|\n";
        System.out.print(descricao);
    }

    /**
     *  Este metodo gera uma String, que ordena os dados correspondente ao modelo CSV.
     * @return Os dados do Livro em CSV.
     */
    public String displayLivroForTxt() {
        String descricao
                = numEbook + ";"
                + titulo + ";"
                + autor + ";"
                + mes + ";"
                + ano + ";"
                + link;
        return descricao;
    }

    /**
     * Este metodo é responsavel por retornar o id do Ebook.
     * @return O id de Ebook do livro.
     */
    public int getNumEbook() {
        return numEbook;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo numbook.
     * @param numEbook O id do Eboook
     */
    public void setNumEbook(int numEbook) {
        this.numEbook = numEbook;
    }

    /**
     * Este metodo é responsavel por retornar o tirulo do Ebook.
     * @return O tirulo do livro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *  Este metodo é responsavel por atualizar, o atributo titulo.
     * @param titulo O tirulo do Livro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Este metodo é responsavel por retornar o autor do Ebook.
     * @return O autor do livro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo Autor.
     * @param autor O autor do Livro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Este metodo é responsavel por retornar o mês de publicação do Ebook.
     * @return O mês de publicação do livro.
     */
    public String getMes() {
        return mes;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo Mês.
     * @param mes O mês de publicação do livro.
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Este metodo é responsavel por retornar o ano de publicação do Ebook.
     * @return O ano de publicação do livro.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo Ano.
     * @param ano O ano de publicação do Livro.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Este metodo é responsavel por retornar o link do Ebook.
     * @return O link de acessoa as informações do livro.
     */
    public String getLink() {
        return link;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo Link.
     * @param link O link de acesso para mais informações sobre o Livro.
     */
    public void setLink(String link) {
        this.link = link;
    }
}
