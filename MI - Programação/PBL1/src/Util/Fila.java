package Util;

/**
 * A classe <b>Fila</b>, é uma estrutura de dados abstrada, que é baseada na
 * FIFO -> "first in, first out", assim, o primeiro item a ser adicionado em uma
 * fila, por consequencia será o primeiro a sair.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class Fila {

    protected No primeiro;
    protected No proximo;
    protected int tamanho;

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public int getTamanho() {
        return tamanho;
    }
    /**Contrutor que inicializa os atributos, como em uma fila vazia, sem items, de tamanho igual a 0;
     * 
     */
    public Fila() {
        this.primeiro = null;
        this.proximo = null;
        this.tamanho = 0;
    }
    /**
     * Recebe um objeto qualquer e o adiciona ao fim da fila.
     * @param obj 
     */
    public void entrar(Object obj) {
        No node = new No(obj);
        if (isEmpty()) {
            primeiro = node;
            proximo = node;
            tamanho++;
        } else {
            No aux = primeiro;
            primeiro = node;
            node.setProx(aux);
            tamanho++;
        }
    }
    /**
     * Esse metodo, retira o objeto que está no inicio da fila e o retorna para o programa principal.
     * @return 
     */
    public Object sair() {
        if (isEmpty()) {
            return null;
        }
        No corrente = primeiro;
        No aux = primeiro;
        while (corrente.getProx() != null) {
            aux = corrente;
            corrente = corrente.getProx();
        }
        aux.setProx(null);
        tamanho--;
        return corrente.getObj();
    }

    public boolean isEmpty() {
        return (tamanho == 0);
    }
}
