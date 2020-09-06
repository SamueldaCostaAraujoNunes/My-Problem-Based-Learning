
import Util.ListaEncadeada;
import Util.No;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class TestListaEncadeada {

    ListaEncadeada lista;

    /**
     * Antes de iniciar os testes, ele instancia os objetos dentro do before.
     */
    @Before
    public void beforeListaEncadeada() {
        lista = new ListaEncadeada();
    }

    /**
     * O testAdd testa o metodo "add". No inicio, ela adicionada na lista 3
     * objetos, verificando se os pacientes estão sendo alocados de forma
     * correta, considerando a sua ordem de inserção.
     */
    @Test
    public void testAdd() {
        lista.add("Objeto1");
        lista.add("Objeto2");
        lista.add("Objeto3");

        assertEquals("Ver se o objeto1 foi adicionado corretamente", "Objeto1", lista.getPrimeiro().getObj());
        assertEquals("Ver se o objeto2 foi adicionado corretamente", "Objeto2", lista.getPrimeiro().getProx().getObj());
        assertEquals("Ver se o objeto3 foi adicionado corretamente", "Objeto3", lista.getPrimeiro().getProx().getProx().getObj());
    }

    /**
     * O testFind testa o metodo "find". No inicio, ele verifica, que se for
     * solicitado um objeto em uma posição qualquer, de uma lista vazia, o
     * metodo irá retornar null. Depois, são testadas as posições menores que
     * zero, e as posições maiores que o tamanho da lista. Por ultimo, ele
     * retorna os nós solicitados e verifica se o objeto contido é igual ao
     * esperado.
     */
    @Test
    public void testFind() {
        lista = new ListaEncadeada();

        assertNull("Testar com a lista vazia", lista.find(0));

        lista.add("Objeto1");
        lista.add("Objeto2");
        lista.add("Objeto3");

        assertNull("Passar como parametro posições que não existem", lista.find(-1));
        assertNull("Passar como parametro posições que não existem", lista.find(lista.tamanho()));//O tamanho da lista, considera o nó de indice 0.

        assertEquals("Passar como parametro posições que existem", "Objeto1", lista.find(0).getObj());
        assertEquals("Passar como parametro posições que existem", "Objeto2", lista.find(1).getObj());
        assertEquals("Passar como parametro posições que existem", "Objeto3", lista.find(2).getObj());
    }

    /**
     * O testInserir testa o metodo "inserir". O metodo inserir, recebe um
     * objeto e uma posição. Gera um nó, e o insere na posição indicada no
     * parametro(Se a posição existir). Inicialmente, o programa gera varios
     * testes para forçar o erro do metodo, tentando inserir o objeto na
     * primeira posição, na ultima, ou fora da lista. Após, ele insere um objeto
     * em uma posição valida. E verifica se o nó foi inserido entre o nó da
     * posição anterior e o proximo nó.
     */
    @Test
    public void testInserir() {

        assertFalse("Tenta inserir o objeto1 numa lista vazia", lista.inserir("Objeto1", 1));

        lista.add("Objeto1");
        lista.add("Objeto2");
        lista.add("Objeto3");

        assertFalse("Tenta inserir o objeto5 na primeira posição", lista.inserir("Objeto5", 0));
        assertFalse("Tenta inserir o objeto5 na ultima posição", lista.inserir("Objeto5", lista.tamanho()));
        assertFalse("Tenta inserir o objeto5 numa posição maior que o tamanho da lista", lista.inserir("Objeto5", 5));
        assertFalse("Tenta inserir o objeto5 numa posição menor que zero", lista.inserir("Objeto5", -1));

        assertEquals("Observa a posição 0, antes de inserir o objeto4 entre o primeiro e o segundo nó", "Objeto1", lista.find(0).getObj());
        assertEquals("Observa a posição 1, antes de inserir o objeto4 entre o primeiro e o segundo nó", "Objeto2", lista.find(1).getObj());

        assertTrue("Inserir o objeto5 entre o primeiro e o segundo nó da lista", lista.inserir("Objeto4", 1));

        assertEquals("Verificar se a posição 0, possui o mesmo objeto de antes", "Objeto1", lista.find(0).getObj());
        assertEquals("Verificar se foi inserido um nó na posição 1", "Objeto4", lista.find(1).getObj());
        assertEquals("Verificar se o objeto2 está alocado logo apos o objeto4", "Objeto2", lista.find(2).getObj());

    }

    /**
     * O testDel testa o metodo "del". O metodo del, deleta um nó, recebendo uma
     * posição como parametro. Assim, ele tenta forçar o erro, tentando deletar
     * um nó em uma lista vazia, ou em uma posição maior que o proprio tamanho
     * da lista, ou menor que zero. Depois, ele confere a posição dos objetos da
     * lista, antes de chamar o metodo del. Depois de chamar o metodo, ele
     * verifica se o nó foi realmente deletado.
     */
    @Test
    public void testDel() {

        assertNull("Tenta deletar um nó de uma lista vazia", lista.del(1));

        lista.add("Objeto1");
        lista.add("Objeto2");
        lista.add("Objeto3");

        assertNull("Tenta deletar um nó, numa posição maior que o tamanho da lista", lista.del(lista.tamanho() + 1));
        assertNull("Tenta deletar um nó, numa posição maior que zero", lista.del(-1));

        assertEquals("Observa a posição 0, antes de deletar o objeto2 entre o primeiro e o terceiro nó", "Objeto1", lista.find(0).getObj());
        assertEquals("Observa a posição 1, antes de deletar o objeto2 entre o primeiro e o terceiro nó", "Objeto2", lista.find(1).getObj());
        assertEquals("Observa a posição 2, antes de deletar o objeto2 entre o primeiro e o terceiro nó", "Objeto3", lista.find(2).getObj());

        assertEquals("Verificar se a função retorna o nó deletado", "Objeto2", lista.del(1));

        assertEquals("Verificar se a posição 0, possui o mesmo objeto de antes", "Objeto1", lista.find(0).getObj());
        assertEquals("Verificar se a posição 1, corresponde ao objeto3 ", "Objeto3", lista.find(1).getObj());

    }

    /**
     * O testTamanho testa o metodo "tamanho". O metodo "tamanho", retorna um
     * valor inteiro, correspondente a quantidade de nós, dentro da lista
     * encadeada, ele verifica se o tamanho de uma lista vazia é 0, se após
     * adicionar um nó, a lista passa a ter tamanho 1, e se repetindo o
     * precesso, o metodo ira incremtentar ao invez de sobreescrever o valor do
     * atributo. Por fim, ele verifica se após deletar um nó da lista, o seu
     * valor decrementa.
     */
    @Test
    public void testTamanho() {

        assertEquals("Tamanho da lista vazia", 0, lista.tamanho());

        lista.add("Objeto1");

        assertEquals("Tamanho da lista com 1 item", 1, lista.tamanho());

        lista.add("Objeto2");

        assertEquals("Tamanho da lista com 2 item", 2, lista.tamanho());
        lista.del(0);

        assertEquals("Tamanho da lista após deletar 1 item", 1, lista.tamanho());

    }

    /**
     * O testIsEmpty testa o metodo "isEmpty". O metodo "isEmpty", verifica se a
     * lista está vazia ou não. Assim, o programa verifica se uma lista recem
     * criada é realmente vazia, adiciona um item a lista e chama o metodo,
     * esperando um resultado falso. Para indicar que a lista não esta vazia. E
     * por fim, ele deleta o unico item da lista e verifica se a lista retornou
     * ao seu estado vazio.
     */
    @Test
    public void testIsEmpty() {

        assertTrue("Testar se a lista está inicialmente vazia", lista.isEmpty());

        lista.add("Objeto1");

        assertFalse("Testar se a lista está vazia", lista.isEmpty());

        lista.del(0);

        assertTrue("Testar se a lista está novamente vazia", lista.isEmpty());

    }
}
