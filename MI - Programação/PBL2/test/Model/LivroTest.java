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
public class LivroTest {
    
    static Livro livro1;
    static Livro livro2;
    static Livro livro3;
    static Livro livro4;
    static Livro livro5;
    static Livro livro6;
    static Livro livro7;
    
    /**
     *Metodo do Junit que prepara o ambiente antes da execução de cada metodo de teste.
     */
    @Before
    public void setUp() {
        livro1 = new Livro(74634, "Killed At Resaca", "Ambrose Bierce", "Sep", 2006, "http://gutenberg.net.au/ebooks06/0607201.txt");
        livro2 = new Livro(79008, "Australian Discovery", "Ernest Scott", "Nov", 2002, "http://gutenberg.net.au/ebooks02/0201001h.zip");
        livro3 = new Livro(84090, "Stories of the Foreign Legion", "P. C. Wren", "Mar", 2007, "http://gutenberg.net.au/ebooks07/0700341h.html");
    }

    /**
     * Test of displayLivroUI method, of class Livro.
     */
    @Test
    public void testDisplayLivroUI() {
        System.out.println("displayLivroUI");
        //Metodo impossivel de ser testado.
    }

    /**
     * Test of displayLivroForTxt method, of class Livro.
     */
    @Test
    public void testDisplayLivroForTxt() {
        System.out.println("displayLivroForTxt");
        
        String expResult = "74634;Killed At Resaca;Ambrose Bierce;Sep;2006;http://gutenberg.net.au/ebooks06/0607201.txt";//Texto formatado da forma correta.
        String result = livro1.displayLivroForTxt();// Metodo que organiza as informações do livro em CSV e retorna como uma string.
        assertEquals(expResult, result);
        
        expResult = "79008;Australian Discovery;Ernest Scott;Nov;2002;http://gutenberg.net.au/ebooks02/0201001h.zip";//Texto formatado da forma correta.
        result = livro2.displayLivroForTxt();// Metodo que organiza as informações do livro em CSV e retorna como uma string.
        assertEquals(expResult, result);
        
        expResult = "84090;Stories of the Foreign Legion;P. C. Wren;Mar;2007;http://gutenberg.net.au/ebooks07/0700341h.html";//Texto formatado da forma correta.
        result = livro3.displayLivroForTxt();// Metodo que organiza as informações do livro em CSV e retorna como uma string.
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumEbook method, of class Livro.
     */
    @Test
    public void testGetNumEbook() {
        System.out.println("getNumEbook");
        int expResult = 74634;
        int result = livro1.getNumEbook();
        assertEquals(expResult, result);
        
        expResult = 79008;
        result = livro2.getNumEbook();
        assertEquals(expResult, result);
        
        expResult = 84090;
        result = livro3.getNumEbook();
        assertEquals(expResult, result);
    }
        
    /**
     * Test of setNumEbook method, of class Livro.
     */
    @Test
    public void testSetNumEbook() {
        System.out.println("setNumEbook");
        
        int numEbook = 1;
        livro1.setNumEbook(numEbook);
        int result = livro1.getNumEbook();
        assertEquals(numEbook,result);
        
        numEbook = 2;
        livro2.setNumEbook(numEbook);
        result = livro2.getNumEbook();
        assertEquals(numEbook,result);
        
        numEbook = 3;
        livro3.setNumEbook(numEbook);
        result = livro3.getNumEbook();
        assertEquals(numEbook,result);
        
    }
    
    /**
     * Test of getTitulo method, of class Livro.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        String expResult = "Killed At Resaca";
        String result = livro1.getTitulo();
        assertEquals(expResult, result);
        
        expResult = "Australian Discovery";
        result = livro2.getTitulo();
        assertEquals(expResult, result);
        
        expResult = "Stories of the Foreign Legion";
        result = livro3.getTitulo();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setTitulo method, of class Livro.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        
        String tituloEsperado = "Livro1";
        livro1.setTitulo(tituloEsperado);
        String titulo = livro1.getTitulo();
        assertEquals(titulo, tituloEsperado);
        
        tituloEsperado = "Livro2";
        livro2.setTitulo(tituloEsperado);
        titulo = livro2.getTitulo();
        assertEquals(titulo, tituloEsperado);
        
        tituloEsperado = "Livro3";
        livro3.setTitulo(tituloEsperado);
        titulo = livro3.getTitulo();
        assertEquals(titulo, tituloEsperado);
    }
    
    /**
     * Test of getAutor method, of class Livro.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        String expResult = "Ambrose Bierce";
        String result = livro1.getAutor();
        assertEquals(expResult, result);
        
        expResult = "Ernest Scott";
        result = livro2.getAutor();
        assertEquals(expResult, result);
        
        expResult = "P. C. Wren";
        result = livro3.getAutor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAutor method, of class Livro.
     */
    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        
        String autorEsperado = "Autor1";
        livro1.setAutor(autorEsperado);
        String autor = livro1.getAutor();
        assertEquals(autor, autorEsperado);
        
        autorEsperado = "Autor2";
        livro1.setAutor(autorEsperado);
        autor = livro1.getAutor();
        assertEquals(autor, autorEsperado);
        
        autorEsperado = "Autor3";
        livro1.setAutor(autorEsperado);
        autor = livro1.getAutor();
        assertEquals(autor, autorEsperado);
    }
    

    /**
     * Test of getMes method, of class Livro.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        String expResult = "Sep";
        String result = livro1.getMes();
        assertEquals(expResult, result);
        
        expResult = "Nov";
        result = livro2.getMes();
        assertEquals(expResult, result);
        
        expResult = "Mar";
        result = livro3.getMes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMes method, of class Livro.
     */
    @Test
    public void testSetMes() {
        System.out.println("setMes");
        
        String mesEsperado = "Mes1";
        livro1.setMes(mesEsperado);
        String mes = livro1.getMes();
        assertEquals(mes, mesEsperado);
        
        mesEsperado = "Mes2";
        livro2.setMes(mesEsperado);
        mes = livro2.getMes();
        assertEquals(mes, mesEsperado);
        
        mesEsperado = "Mes3";
        livro3.setMes(mesEsperado);
        mes = livro3.getMes();
        assertEquals(mes, mesEsperado);
    }

    /**
     * Test of getAno method, of class Livro.
     */
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        int expResult = 2006;
        int result = livro1.getAno();
        assertEquals(expResult, result);
        
        expResult = 2002;
        result = livro2.getAno();
        assertEquals(expResult, result);
        
        expResult = 2007;
        result = livro3.getAno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAno method, of class Livro.
     */
    @Test
    public void testSetAno() {
        System.out.println("setAno");
        int anoEsperado = 1;
        livro1.setAno(anoEsperado);
        int ano = livro1.getAno();
        assertEquals(ano, anoEsperado);
        
        anoEsperado = 2;
        livro2.setAno(anoEsperado);
        ano = livro2.getAno();
        assertEquals(ano, anoEsperado);
        
        anoEsperado = 3;
        livro3.setAno(anoEsperado);
        ano = livro3.getAno();
        assertEquals(ano, anoEsperado);
    }

    /**
     * Test of getLink method, of class Livro.
     */
    @Test
    public void testGetLink() {
        System.out.println("getLink");
        String expResult = "http://gutenberg.net.au/ebooks06/0607201.txt";
        String result = livro1.getLink();
        assertEquals(expResult, result);
        
        expResult = "http://gutenberg.net.au/ebooks02/0201001h.zip";
        result = livro2.getLink();
        assertEquals(expResult, result);
        
        expResult = "http://gutenberg.net.au/ebooks07/0700341h.html";
        result = livro3.getLink();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLink method, of class Livro.
     */
    @Test
    public void testSetLink() {
        System.out.println("setLink");
        String linkEsperado = "Link1";
        livro1.setLink(linkEsperado);
        String link = livro1.getLink();
        assertEquals(link, linkEsperado);
        
        linkEsperado = "Link2";
        livro2.setLink(linkEsperado);
        link = livro2.getLink();
        assertEquals(link, linkEsperado);
        
        linkEsperado = "Link3";
        livro1.setLink(linkEsperado);
        link = livro1.getLink();
        assertEquals(link, linkEsperado);
        
    }
    
}
