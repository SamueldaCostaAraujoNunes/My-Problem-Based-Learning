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
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel da Costa Araujo Nunes
 */
public class ArvoreBinariaBuscaTest {

    static ArvoreBinariaBusca arvore;
    static Livro livro1;
    static Livro livro2;
    static Livro livro3;
    static Livro livro4;
    static Livro livro5;
    static Livro livro6;
    static Livro livro7;

    /**
     *Metodo do Junit que prepara o ambiente antes da execução da classe.
     */
    @BeforeClass
    public static void setUpClass() {
        livro1 = new Livro(74634, "Killed At Resaca", "Ambrose Bierce", "Sep", 2006, "http://gutenberg.net.au/ebooks06/0607201.txt");
        livro2 = new Livro(79008, "Australian Discovery", "Ernest Scott", "Nov", 2002, "http://gutenberg.net.au/ebooks02/0201001h.zip");
        livro3 = new Livro(84090, "Stories of the Foreign Legion", "P. C. Wren", "Mar", 2007, "http://gutenberg.net.au/ebooks07/0700341h.html");
        livro4 = new Livro(84298, "Mother Goose Rhymes", "Kendall Banning", "Mar", 2007, "http://gutenberg.net.au/ebooks07/0700411h.html");
        livro5 = new Livro(87712, "Thomas Mitchell", "J. H. L. Cumpston", "Apr", 2007, "http://gutenberg.net.au/ebooks07/0700531h.html");
        livro6 = new Livro(267114, "Leathermouth", "Carlton Dawe", "Oct", 2019, "http://gutenberg.net.au/ebooks19/1901061h.html");
        livro7 = new Livro(267322, "The Opal Pin", "Rufus H Gillmore", "Nov", 2019, "http://gutenberg.net.au/ebooks19/1901131h.html");
    }

    /**
     *Metodo do Junit que prepara o ambiente antes da execução de cada metodo teste.
     */
    @Before
    public void setUp() {
        arvore = new ArvoreBinariaBusca();
    }

    /**
     * Test of inserir method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");

        arvore.inserir(livro3);
        assertSame("Verifica se o metodo inserir adiciona o primeiro item na raiz", livro3, arvore.getRaiz().getLivro());

        arvore.inserir(livro2);
        assertSame("Verifica se o metodo inserir adicionou o nó contendo o livro2 a esquerda do nó raiz", livro2, arvore.getRaiz().getEsquerda().getLivro());

        arvore.inserir(livro4);
        assertSame("Verifica se o metodo inserir adicionou o nó contendo o livro3 a direita do nó raiz", livro4, arvore.getRaiz().getDireita().getLivro());

        arvore.inserir(livro1);
        assertSame("Verifica se o metodo inserir adicionou o nó contendo o livro1 a esquerda do filho da esquerda da raiz", livro1, arvore.getRaiz().getEsquerda().getEsquerda().getLivro());

        arvore.inserir(livro5);
        assertSame("Verifica se o metodo inserir adicionou o nó contendo o livro5 a direita do filho da direita da raiz", livro5, arvore.getRaiz().getDireita().getDireita().getLivro());

        //                      livro3
        //                         |
        //                ------------------
        //                |                |
        //              livro2           livro4
        //                |                |
        //          ----------          ----------
        //          |        |          |        |
        //       livro1                        livro5
    }

    /**
     * Test of deletar method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testRemover() {
        System.out.println("deletar");
        arvore.inserir(livro7);
        arvore.inserir(livro4);
        arvore.inserir(livro2);
        arvore.inserir(livro6);
        arvore.inserir(livro1);
        arvore.inserir(livro5);

        //                                 livro7
        //                                    |
        //                    -----------------
        //                    |          
        //                  livro4      
        //                    |                
        //             -----------------------------------         
        //             |                                 |
        //           livro2                           livro6      
        //             |                                 |
        //     ---------                        ---------- 
        //     |                                |    
        //  livro1                           livro5
        //1o Caso: Deletar um nó com dois filhos.
        Livro livroRetornado = arvore.remover(livro4.getNumEbook());// Deletando o  livro 4

        //Arvoré após remover o livro 4.
        //                                 livro7
        //                                    |
        //                    -----------------
        //                    |          
        //                  livro5      
        //                    |                
        //             -----------------------------------         
        //             |                                 |
        //           livro2                           livro6      
        //             |                  
        //     ---------      
        //     |            
        //  livro1                  
        assertSame(arvore.getRaiz().getEsquerda().getLivro(), livro5);//Verificando se o livro5 assumiu o lugar do livro4
        assertSame(livroRetornado, livro4); //Verifica se o livro retornado pela função é o mesmo que ela deveria ter deletado.

        //2o Caso: Deletar um nó com um filho
        livroRetornado = arvore.remover(livro2.getNumEbook());// Deletando o  livro 2

        //                                 livro7
        //                                    |
        //                    -----------------
        //                    |          
        //                  livro5      
        //                    |                
        //             -------------------         
        //             |                 |
        //           livro1            livro6
        assertSame(arvore.getRaiz().getEsquerda().getEsquerda().getLivro(), livro1);// Verifica se o livro1 assumiu a posição do livro2
        assertSame(livroRetornado, livro2);//Verifica se o livro retornado pela função é o mesmpo que ela deveria ter deletado.        

        //3o Caso: Deletar um nó sem filhos
        livroRetornado = arvore.remover(livro1.getNumEbook());// Deletando o  livro 1

        //                                 livro7
        //                                    |
        //                    -----------------
        //                    |          
        //                  livro5      
        //                    |                
        //                    ------------         
        //                               |
        //                            livro6
        assertNull(arvore.getRaiz().getEsquerda().getEsquerda().getLivro());// Verifica se o livro1 assumiu a posição do livro2
        assertSame(livroRetornado, livro1);//Verifica se o livro retornado pela função é o mesmpo que ela deveria ter deletado.        
    }

    /**
     * Test of temFilhos method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testTemFilhos() {
        System.out.println("temFilhos");
        No pai = new No();
        No filho = new No();

        //Inicialmente, verifica se o nó possui filho ou não
        assertEquals(false, arvore.temFilhos(pai));
        pai.setDireita(filho);

        //Inicialmente, verifica se o nó possui filho ou não
        assertEquals(true, arvore.temFilhos(pai));

    }

    /**
     * Test of find method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testFind() {
        System.out.println("find");

        arvore.inserir(livro1);
        arvore.inserir(livro2);
        arvore.inserir(livro3);
        arvore.inserir(livro4);
        arvore.inserir(livro5);

        Livro expResult;
        Livro result;

        expResult = livro1;
        result = arvore.find(livro1.getNumEbook());
        assertEquals(expResult, result);

        expResult = livro2;
        result = arvore.find(livro2.getNumEbook());
        assertEquals(expResult, result);

        expResult = livro3;
        result = arvore.find(livro3.getNumEbook());
        assertEquals(expResult, result);

        expResult = livro4;
        result = arvore.find(livro4.getNumEbook());
        assertEquals(expResult, result);

        expResult = livro5;
        result = arvore.find(livro5.getNumEbook());
        assertEquals(expResult, result);

        //Testa um livro inexistente
        result = arvore.find(12345);
        assertNull(result);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isEmpty method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result;

        result = arvore.isEmpty();
        assertEquals(expResult, result);

        arvore.inserir(livro1);

        result = arvore.isEmpty();
        assertEquals(!expResult, result);
    }

    /**
     * Test of displayOrdem method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testDisplayOrdem() {
        System.out.println("displayOrdem");
        //Não é possivel testar.
    }

    /**
     * Test of getRaiz method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testGetRaiz() {
        System.out.println("getRaiz");
        arvore.inserir(livro1);
        assertSame(arvore.getRaiz().getLivro(), livro1);
    }

    /**
     * Test of listarAutorPorQuantidade method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testListarAutorPorQuantidade() {
        System.out.println("listarAutorPorQuantidade");
        //Não é possivel testar, pois ele printa direto na tela.
    }

    /**
     * Test of listLivrosDoAutor method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testListLivrosDoAutor() {
        System.out.println("listLivrosDoAutor");
        //Não é possivel testar, pois ele printa direto na tela. 
    }

    /**
     * Test of findAno method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testFindAno() {
        System.out.println("findAno");
        arvore.inserir(livro1);
        arvore.inserir(livro2);
        arvore.inserir(livro3);
        arvore.inserir(livro4);
        arvore.inserir(livro5);
        arvore.inserir(livro6);
        arvore.inserir(livro7);

        int ano = 2007;
        ArrayList<Livro> expResult = new ArrayList();
        expResult.add(livro3);
        expResult.add(livro4);
        expResult.add(livro5);
        ArrayList<Livro> result = arvore.findAno(ano);
        assertEquals(expResult, result);
    }

    /**
     * Test of gerarListaEmPreOrdem method, of class ArvoreBinariaBusca.
     */
    @Test
    public void testGerarListaEmPreOrdem() {
        System.out.println("gerarListaEmPreOrdem");
        arvore.inserir(livro4);
        arvore.inserir(livro2);
        arvore.inserir(livro5);
        arvore.inserir(livro1);
        arvore.inserir(livro3);
        arvore.inserir(livro6);
        arvore.inserir(livro7);
        
         //                      livro4
        //                         |
        //                ------------------
        //                |                |
        //              livro2           livro5
        //                |                |
        //          ----------          ----------
        //          |        |          |        |
        //       livro1    livro3    livro6    livro7

        ArrayList<Livro> arrayTeste = new ArrayList();

        
        //Ou seja, a arvore organizada em pré-ordem ficaria
        //livro4,livro2,livro1,livro3,livro5,livro6,livro7
        arrayTeste.add(livro4);
        arrayTeste.add(livro2);
        arrayTeste.add(livro1);
        arrayTeste.add(livro3);
        arrayTeste.add(livro5);
        arrayTeste.add(livro6);
        arrayTeste.add(livro7);

        ArrayList<Livro> array = arvore.gerarListaEmPreOrdem();
        
        int cont = 0;
        for (Livro livroLista1 : arrayTeste){
            assertTrue(livroLista1.equals(array.get(cont)));
            cont++;
        }

    }

}
