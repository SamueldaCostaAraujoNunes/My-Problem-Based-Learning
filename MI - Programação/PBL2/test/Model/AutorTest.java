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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class AutorTest {
    
    Autor autor;
    @Before
    public void setUp() {
        autor = new Autor("Samuel Nunes",5);
    }
    

    /**
     * Test of getNome method, of class Autor.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Samuel Nunes";
        String result = autor.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantLivros method, of class Autor.
     */
    @Test
    public void testGetQuantLivros() {
        System.out.println("getQuantLivros");
        int expResult = 5;
        int result = autor.getQuantLivros();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Autor.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nomeEsperado = "Samuel da Costa";
        autor.setNome(nomeEsperado);
        String nome = autor.getNome();
        assertEquals(nome,nomeEsperado);
    }

    /**
     * Test of setQuantLivros method, of class Autor.
     */
    @Test
    public void testSetQuantLivros() {
        System.out.println("setQuantLivros");
        int quantLivrosEsperado = 3;
        autor.setQuantLivros(quantLivrosEsperado);
        int quantLivros = autor.getQuantLivros();
        assertEquals(quantLivros, quantLivrosEsperado);
    }

    /**
     * Test of displayAutor method, of class Autor.
     */
    @Test
    public void testDisplayAutor() {
        System.out.println("displayAutor");
        //Impossivel de ser testado.
    }
    
}
