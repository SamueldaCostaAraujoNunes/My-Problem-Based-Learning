
import Util.Fila;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class TestFila{

    Fila fila;
    Object objeto1;
    Object objeto2;
    Object objeto3;
    Object objeto4;

    /**
     * Inicialmente, são instaciadas os objetos que farão parte dos testes.
     */
    @Before
    public void Instance() {
        fila = new Fila();
        objeto1 = "Samuel";
        objeto2 = "Matheus";
        objeto3 = "Ludmilla";

    }

    /**
     * O testEntrar, testa o metodo "entrar". No inicio, o programa testa se a
     * fila começa vazia por default. Depois, ela insere na lista 3 objetos,
     * verificando se entre as entradas, o tamanho e o conteudo da fila, são
     * alterados conforme o esperado.
     */
    @Test
    public void testEntrar() {
        assertTrue("Verifica se a lista esta vazia", fila.isEmpty());

        fila.entrar(objeto1);
        assertEquals("Verifica o primeiro objeto da fila", objeto1, fila.getPrimeiro().getObj());
        assertEquals("Verifica o tamanho da lista", 1, fila.getTamanho());

        fila.entrar(objeto2);
        assertEquals("Verifica o primeiro objeto da fila", objeto2, fila.getPrimeiro().getObj());
        assertEquals("Verifica o tamanho da lista", 2, fila.getTamanho());

        fila.entrar(objeto3);
        assertEquals("Verifica o primeiro objeto da fila", objeto3, fila.getPrimeiro().getObj());
        assertEquals("Verifica o tamanho da lista", 3, fila.getTamanho());
    }

    /**
     * O testSair, testa o metodo "sair". Inicialmente, o programa possui na
     * fila, 3 objetos. Ele verifica, pelo tamanho, se fexistem os 3 objetos, e
     * vai retirando o primeiro objeto da fila, sempre verificando se o objeto
     * esperado é igual ao adquirido. Depois, ele verifica se realmente foram
     * retirado os 3 objetos.Pelo tamanho.
     */
    @Test
    public void testSair() {
        fila.entrar(objeto1);
        fila.entrar(objeto2);
        fila.entrar(objeto3);

        assertEquals("Verifica o tamanho", 3, fila.getTamanho());
        assertEquals("Verifica se o metodo retorna o primeiro objeto", objeto1, fila.sair());
        assertEquals("Verifica se o metodo retorna o primeiro objeto", objeto2, fila.sair());
        assertEquals("Verifica se o metodo retorna o primeiro objeto", objeto3, fila.sair());

        assertEquals("Verifica se o tamanho é igual a 0", 0, fila.getTamanho());

    }

}
