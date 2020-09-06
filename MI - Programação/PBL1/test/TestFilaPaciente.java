
import Model.Paciente;
import Sistema.FilaPacientes;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class TestFilaPaciente{

    FilaPacientes fila;
    Paciente samuel;
    Paciente ludmilla;
    Paciente roberto;
    Paciente carlos;
    Paciente gelado;
    Paciente hiago;
    Paciente guilherme;
    Paciente daniel;
    Paciente moises;
    Paciente rafaela;
    Paciente gabriel;
    Paciente luan;
    Paciente catarina;
    Paciente juliano;

    @Before
    public void Instance() {
        fila = new FilaPacientes();
        samuel = new Paciente("Samuel Nunes", 19111221, false);
        ludmilla = new Paciente("Ludmilla", 1234, true);
        roberto = new Paciente("Roberto", 234, true);
        carlos = new Paciente("Carlos", 345, false);
    }

    /**
     * O testEntrar, testa o metodo "entrar". No inicio, ela insere na lista 3
     * pacientes, verificando se os pacientes estão sendo alocados de forma
     * correta, considerando a sua prioridade.
     */
    @Test
    public void testEntrar() {

        /**
         * Como a fila esta vazia, samuel será alocado para a primeira posição.
         * inicio->samuel->final
         */
        fila.entrar(samuel);
        assertEquals("Verifica se o paciente entrou na lista", samuel, fila.getPrimeiro().getObj());

        /**
         * Logo após, chega uma paciente prioritaria, passando a frente de todos
         * os pacientes normais. Assim, o sistema insere a paciente, e verifica
         * se ela assumiu a posição no inicio da fila.
         * inicio->ludmilla->samuel->final
         */
        fila.entrar(ludmilla);
        assertEquals("Verifica se o paciente prioritario entrou no inicio da fila", ludmilla, fila.getPrimeiro().getObj());
        assertEquals("Verifica se o paciente comum foi deslocado para a proxima posição da lista", samuel, fila.getPrimeiro().getProx().getObj());

        /**
         * Logo em seguida, chega outro paciente prioritario, passando a frente
         * de todos os pacientes normais e ficando logo atrás da primeira
         * prioritaria. Assim, o sistema insere este paciente, entre a primeira
         * e o ultimo, e verifica se ela assumiu a posição no meio da fila.
         * inicio->ludmilla->roberto->samuel->final
         */
        fila.entrar(roberto);
        assertEquals("Verifica se o paciente prioritario é incluido entre o ultimo prioritario e o primeiro normal", roberto, fila.getPrimeiro().getProx().getObj());
        /**
         * Por fim, chega um ultimo paciente normal, que é adicionado no final
         * da fila. E o programa verifica se ele realmente foi para o final.
         * inicio->ludmilla->roberto->samuel->carlos->final
         */
        fila.entrar(carlos);
        assertEquals("Verifica se o paciente normal é incluido entre no ultimo lugar", carlos, fila.getPrimeiro().getProx().getProx().getProx().getObj());

    }

    @Test
    public void testSair() {

        fila.entrar(samuel);
        fila.entrar(ludmilla);
        fila.entrar(roberto);
        
        /**
         * O testSair, testa o metodo "sair". Inicialmente, o programa possui na
         * fila, 3 pacientes. Ele verifica, pelo tamanho, se fexistem os 3
         * pacientes, e vai retirando o primeiro paciente da fila, sempre
         * verificando se o objeto esperado é igual ao adquirido. Depois, ele
         * verifica se realmente foram retirado os 3 objetos.Pelo tamanho.
         */
        assertEquals("Verifica se o tamanho é igual ao esperado", 3, fila.getTamanho());
        assertEquals("Verifica se o paciente entrou na lista", ludmilla, fila.getPrimeiro().getObj());
        fila.sair();
        assertEquals("Verifica se o paciente entrou na lista", roberto, fila.getPrimeiro().getObj());
        fila.sair();
        assertEquals("Verifica se o paciente entrou na lista", samuel, fila.getPrimeiro().getObj());
        fila.sair();
        assertEquals("Verifica se o tamanho é igual ao esperado", 0, fila.getTamanho());
    }

}
