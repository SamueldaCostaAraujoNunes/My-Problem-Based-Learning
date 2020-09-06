
import Model.Exame;
import Model.Medico;
import Model.Paciente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class TestMedico {

    Medico medico;
    Paciente paciente1;
    Paciente paciente2;
    Paciente paciente3;

    /**
     * Antes de iniciar os testes, ele instancia os objetos dentro do before.
     */
    @Before
    public void Instance() {
        medico = new Medico("Dr. Samuel Lima", 1);
        paciente1 = new Paciente("Samuel Nunes", 19111221, false);
        paciente2 = new Paciente("Ludmilla", 1234, true);
        paciente3 = new Paciente("Roberto", 234, true);

    }

    /**
     * O testRealizarAtendimento testa o metodo "realizarAtendimento". No
     * inicio, ela adicionada na lista 3 pacientes, verificando se os pacientes
     * estão sendo atendidos seguindo a fila de pacientes(considerando
     * prioridade) e se o retorno do metodó é igual ao primeiro paciente
     * atendido.
     */
    @Test
    public void testRealizarAtendimento() {
        medico.incluirPaciente(paciente1);//normal
        medico.incluirPaciente(paciente2);//prioritario
        medico.incluirPaciente(paciente3);//prioritario

        //inicio->paciente2->paciente3->paciente1->final
        assertSame("Verifica se o metodo retorna o primeiro paciente da fila", paciente2, medico.realizarAtendimento());
        assertSame("Verifica se o metodo retorna o primeiro paciente da fila", paciente3, medico.realizarAtendimento());
        assertSame("Verifica se o metodo retorna o primeiro paciente da fila", paciente1, medico.realizarAtendimento());

    }

    /**
     * O testSolicitarExames testa o metodo "solicitarExames". Inicialmente, o
     * médico solicita os exames para dois pacientes, o teste verifica cada
     * paciente e se a lista de exames foi declarada para as pessoas certas e na
     * ordem certa.
     */
    @Test
    public void testSolicitarExames() {
        medico.incluirPaciente(paciente1);
        medico.incluirPaciente(paciente2);

        medico.solicitarExames(paciente1, "Exame de Sangue");
        medico.solicitarExames(paciente1, "Raio-x");
        medico.solicitarExames(paciente2, "Raio-x");

        Exame exame;

        Paciente paciente = medico.realizarAtendimento();

        exame = (Exame) paciente.getListaExames().getPrimeiro().getObj();

        assertEquals("Verifica se o exame foi adicionado no paciente2", "Raio-x", exame.getNomeDoExame());

        paciente = medico.realizarAtendimento();

        exame = (Exame) paciente.getListaExames().getPrimeiro().getProx().getObj();

        assertEquals("Verifica se o exame foi adicionado no paciente certo", "Raio-x", exame.getNomeDoExame());

        exame = (Exame) paciente.getListaExames().getPrimeiro().getObj();

        assertEquals("Verifica se o exame foi adicionado no paciente certo", "Exame de Sangue", exame.getNomeDoExame());
    }
}
