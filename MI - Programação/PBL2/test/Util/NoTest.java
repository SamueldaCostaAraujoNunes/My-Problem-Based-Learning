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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class NoTest {
    static Livro livro1;
    static Livro livro2;
    static Livro livro3;
    
    
    static No noDireita;
    static No noEsquerda;
    
    public NoTest() {}
    
    @BeforeClass
    public static void setUpClass() {
        livro1 = new Livro(74634, "Killed At Resaca", "Ambrose Bierce", "Sep", 2006, "http://gutenberg.net.au/ebooks06/0607201.txt");
        livro2 = new Livro(79008, "Australian Discovery", "Ernest Scott", "Nov", 2002, "http://gutenberg.net.au/ebooks02/0201001h.zip");
        livro3 = new Livro(84090, "Stories of the Foreign Legion", "P. C. Wren", "Mar", 2007, "http://gutenberg.net.au/ebooks07/0700341h.html");
        
        No noEsquerda = new No(livro2);
        No noDireita = new No(livro3);
                
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getLivro method, of class No.
     */
    @Test
    public void testGetLivro() {
        System.out.println("getLivro");
        No no = new No(livro1);
        Livro result = no.getLivro();
        assertSame(livro1, result);
    }

    /**
     * Test of setLivro method, of class No.
     */
    @Test
    public void testSetLivro() {
        System.out.println("setLivro");
        No no = new No();
        no.setLivro(livro1);
        assertSame(no.getLivro(),livro1);
    }

    /**
     * Test of getDireita method, of class No.
     */
    @Test
    public void testGetDireita() {
        System.out.println("getDireita");
        No no = new No();
        no.setDireita(noDireita);
        No expResult = noDireita;
        No result = no.getDireita();
        assertSame(expResult, result);
    }

    /**
     * Test of setDireita method, of class No.
     */
    @Test
    public void testSetDireita() {
        System.out.println("setDireita");
        No no = new No();
        no.setDireita(noDireita);
        No expResult = no.getDireita();
        assertSame(expResult, noDireita);
    }

    /**
     * Test of getEsquerda method, of class No.
     */
    @Test
    public void testGetEsquerda() {
        System.out.println("getEsquerda");
        No no = new No();
        no.setEsquerda(noEsquerda);
        No expResult = noEsquerda;
        No result = no.getEsquerda();
        assertSame(expResult, result);
    }

    /**
     * Test of setEsquerda method, of class No.
     */
    @Test
    public void testSetEsquerda() {
        System.out.println("setEsquerda");
        No no = new No();
        no.setEsquerda(noEsquerda);
        No expResult = no.getEsquerda();
        assertSame(expResult, noEsquerda);
    }
    
}
