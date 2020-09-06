/** Autor: Samuel da Costa Araujo Nunes
 *Componente Curricular: MI-Programação
 *Concluido em: 22/01/2020
 *Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 *trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 *apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 *de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 *do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package Util;

import Model.Livro;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class No {
    private Livro livro;
    private No direita;
    private No esquerda;

    /**
     *  Este metodo é responsavel por retornar o Livro guardado ao programa principal. 
     * @return O livro guardado no nó.
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Este metodo é responsavel por atualizar, o atributo Livro.
     * @param livro O livro guardado no nó.
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * Este metodo é responsavel por retornar o nó filho da sua direita, ao programa principal. 
     * @return O nó filho da direta.
     */
    public No getDireita() {
        return direita;
    }

    /**
     * Este metodo é responsavel por atualizar, o nó filho da direita.
     * @param direita No filho da direita.
     */
    public void setDireita(No direita) {
        this.direita = direita;
    }

    /**
     * Este metodo é responsavel por retornar o nó filho da sua esquerda, ao programa principal. 
     * @return O nó filho da esquerda.
     */
    public No getEsquerda() {
        return esquerda;
    }

    /**
     * Este metodo é responsavel por atualizar, o nó filho da esquerda.
     * @param esquerda No filho da esquerda.
     */
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    /**
     * Construtor responsavel por inicializar o objeto.
     */
    public No(){}
    
    /**
     * Construtor responsavel por inicializar o objeto, contendo o livro a ser guardado.
     * @param livro O livro a ser guardado no nó.
     */
    public No(Livro livro){
        this.livro = livro;
    }
}
