package Util;

/**
 * * A classe <b>ListaEncadeada</b>, é uma estrutura de dados, composta por
 * varios objetos do tipo Nó, que guardam um dado e a referencia do proximo.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class ListaEncadeada {

    protected No primeiro;
    protected No proximo;
    protected int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.proximo = null;
        this.tamanho = 0;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No first) {
        this.primeiro = first;
    }

    /**
     * O metodo add, adiciona um nó no inicio da lista encadeada.
     *
     * @param obj
     */
    public void add(Object obj) {
        No node = new No(obj);
        if (isEmpty()) {
            primeiro = node;
            proximo = node;
            tamanho++;
        } else {
            node.setProx(proximo.getProx());
            proximo.setProx(node);
            proximo = node;
            tamanho++;
        }
    }

    /**
     * O metodo find, recebe um valor inteiro e retorna o nó de indice igual ao
     * valor recebido por parametro.
     *
     * @param pos
     * @return
     */
    public No find(int pos) {
        if (isEmpty() || pos > tamanho - 1 || pos < 0) {
            return null;
        }
        No current = primeiro;
        int contador = 0;
        while (pos > contador) {
            current = current.getProx();
            contador++;
        }
        return current;
    }

    /**
     * O metodo inserir, recebe por parametro um objeto generico e a posição a
     * qual ele deve ser inserido.
     *
     * @param object
     * @param pos
     * @return
     */
    public boolean inserir(Object object, int pos) {
        if (isEmpty() || pos >= tamanho || pos <= 0) {
            return false;
        }
        No current = primeiro;
        int contador = 0;
        while (pos - 1 > contador) {
            current = current.getProx();
            contador++;
        }

        No aux = current.getProx();
        No novoNo = new No(object);
        current.setProx(novoNo);
        novoNo.setProx(aux);
        tamanho++;
        return true;
    }

    /**
     * O metodo del, recebe por parametro um valor inteiro que corresponderá ao
     * indice de um nó na lista encadeada, esse nó por sua vez, será guardado. O
     * nó anterior guardará a referencia do proximo nó após o que deverá ser
     * deletado e o nó deletado será retornado para o programa principal.
     */
    public Object del(int pos) {
        if (isEmpty() || pos > tamanho || pos < 0) {
            return null;
        }
        No current = primeiro;
        No previous = primeiro;
        int v = 0;
        if (pos == 0) {
            primeiro = primeiro.getProx();
            current.setProx(null);
            tamanho--;
            return current.getObj();
        }
        while (v < pos) {
            previous = current;
            current = current.getProx();
            v++;
        }
        previous.setProx(current.getProx());
        current.setProx(null);
        Object obj = current.getObj();
        tamanho--;
        return (obj);
    }
    /**
     * Este metodo printa a lista para o usuario.
     */
    public void displayList() {
        No current = primeiro;
        if (current != null) {
            System.out.print("List: ");
        }
        while (current != null) {
            current.displayNo();
            current = current.getProx();
        }
        System.out.println("null.");

    }
    /**
     * Esse metodo retorna o ultimo nó da lista.
     * @return Ultimo nó da lista.
     */
    public No getUltimo() {
        if (isEmpty()) {
            return null;
        }
        return find(tamanho - 1);
    }
    /**
     * Retorna o tamanho da lista.
     * @return tamanho da lista.
     */
    public int tamanho() {
        return tamanho;
    }
    /** Indica por meio de uma Booleano se a lista esta vazia ou não.
     * @return Se a lista está vazia ou não.
     */
    public boolean isEmpty() {
        return (tamanho == 0);
    }

}
