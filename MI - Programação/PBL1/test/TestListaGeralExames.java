
import Model.Exame;
import Model.Medico;
import Model.Paciente;
import Sistema.ListaGeralExames;
import Util.ListaEncadeada;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class TestListaGeralExames {

    ListaGeralExames lista;
    Medico medico;
    Paciente paciente1;
    Paciente paciente2;

    /**
     * Antes de iniciar os testes, ele instancia os objetos dentro do before.
     */
    @Before
    public void inicio() {
        lista = new ListaGeralExames();
        medico = new Medico("Dr. Samuel Nunes", 1234);
        paciente1 = new Paciente("Samuel Nunes", 19111221, false);
        paciente2 = new Paciente("Ludmilla", 1234, false);

        medico.solicitarExames(paciente1, "Exame de Sangue");
        medico.solicitarExames(paciente1, "Raio-x");
        medico.solicitarExames(paciente1, "Exame de Vista");

        medico.solicitarExames(paciente2, "Exame de Vista");
        medico.solicitarExames(paciente2, "Exame de Sangue");

        lista.add(paciente1);
        lista.add(paciente2);
    }

    /**
     * O testListarPacientesNaEsperaDoExame testa o metodo
     * "ListarPacientesNaEsperaDoExame". Inicialmente, ele chama o metodo, com o
     * parametro("Exame de Sangue"), o retorno será o objeto "lista", do tipo,
     * "ListaEncadeada", essa lista irá conter todos os pacientes que necessitam
     * realizar o exame passado por parametro. Assim, ele verifica se os
     * pacientes listados correspondem ao esperado, e se eles estão em ordem.
     * Para uma segunda validação, o metodo é chamado novamente recebendo com
     * parametro, o exame "Raio-x", dessa vez a lista deverá retornar apenas um
     * paciente.
     */
    @Test
    public void testListarPacientesNaEsperaDoExame() {
        ListaEncadeada listPacientesEsperaExame = lista.listarPacientesNaEsperaDoExame("Exame de Sangue");
        assertSame("Verifica se o metodo retornou uma lista contendo o paciente1", paciente1, listPacientesEsperaExame.getPrimeiro().getObj());
        assertSame("Verifica se o metodo retornou uma lista contendo o paciente2", paciente2, listPacientesEsperaExame.getPrimeiro().getProx().getObj());
        assertEquals("Verifica o tamanho da lista que retornou", 2, listPacientesEsperaExame.tamanho());

        listPacientesEsperaExame = lista.listarPacientesNaEsperaDoExame("Raio-x");
        assertSame("Verifica se o metodo retornou uma lista contendo apenas o paciente1", paciente1, listPacientesEsperaExame.getPrimeiro().getObj());
        assertEquals("Verifica o tamanho da lista que retornou", 1, listPacientesEsperaExame.tamanho());
    }

    /**
     * O testListarExamesSolicitados testa o metodo "listarExamesSolicitados".
     * Inicialmente, ele chama o metodo, com o parametro("19111221"), o retorno
     * será o objeto "lista", do tipo, "ListaEncadeada", esta lista conterá,
     * todos os exames do paciente. Ele verifica se a lista retornada do metodo
     * é igual ao atributo listaExames, do paciente. Depois, ele verifica se uma
     * matricula inexistente retorna null.
     */
    @Test
    public void testListarExamesSolicitados() {
        ListaEncadeada listExamesSolicitados = lista.listarExamesSolicitados(19111221);

        assertSame("Verificar se a lista retornada é igual a esperada", paciente1.getListaExames(), listExamesSolicitados);

        assertNull("Requisitar uma matricula inexistente", lista.listarExamesSolicitados(123456789));

        listExamesSolicitados = lista.listarExamesSolicitados(1234);

        assertSame("Verificar se a lista retornada é igual a esperada", paciente2.getListaExames(), listExamesSolicitados);
    }

    /**
     * O testRealizarExame testa o metodo "realizarExame". Inicialmente, ele
     * instancia o objeto primeiroExame, do tipo, "Exame", sendo exatamente o
     * mesmo que o primeiro exame solicitado ao paciente1. Ou seja, "Exame de
     * Sangue". O mesmo procedimento é realizado com o paciente2. Após, ele
     * verifica se os exames dos pacientes são iguais ao esperado e se os exames
     * ainda não foram realizados.
     * 
     * Assim, ele chama o metodo realizarExame, com o parametro "Exame de Sangue".
     * 
     * Seguindo a logica do problema, quem tem a prioridade pelo exame é quem esta na frente da fila. Logo, o primeiroExame deve ser realizado e o segundoExame não.
     * 
     * Ele verifica se o exame do paciente1 foi realizado, e se o do paciente2 ainda não foi.
     * 
     * Depois, ele chama o metodo novamente, com o mesmo metodo. E dessa vez, o paciente2 deve ser atendido.
     * 
     * Ele verifica se o exame foi atualizado.
     * 
     * Após, ele realizar todos os exames restantes do paciente1 e verifica se o mesmo saiu da fila, e se na fila atual só resta o paciente2
     */
    @Test
    public void testRealizarExame() {
        Exame primeiroExame = (Exame) paciente1.getListaExames().getPrimeiro().getObj();
        Exame segundoExame = (Exame) paciente2.getListaExames().getPrimeiro().getProx().getObj();

        assertEquals("Verifica se o metodo vai conseguir achar o exame corretamente", "Exame de Sangue", primeiroExame.getNomeDoExame());
        assertEquals("Verifica se o metodo vai conseguir achar o exame corretamente o segundo exame", "Exame de Sangue", segundoExame.getNomeDoExame());

        assertFalse("Verifica se o exame ainda não foi realizado", primeiroExame.getStatusDoExame());
        assertFalse("Verifica se o exame ainda não foi realizado", segundoExame.getStatusDoExame());

        lista.realizarExame("Exame de Sangue");

        assertTrue("Verifica se o exame ainda foi realizado", primeiroExame.getStatusDoExame());
        assertFalse("Verifica se o exame não foi realizado", segundoExame.getStatusDoExame());

        lista.realizarExame("Exame de Sangue");

        assertTrue("Verifica se o exame foi realizado", segundoExame.getStatusDoExame());

        lista.realizarExame("Exame de Vista");
        lista.realizarExame("Raio-x");

        assertEquals("Verificar se depois de realizar todos os exames, o paciente realmente saiu da fila", 1, lista.tamanho());
        assertEquals("Verifica se o paciente restante é igual ao paciente2", paciente2, lista.getPrimeiro().getObj());
    }

}
