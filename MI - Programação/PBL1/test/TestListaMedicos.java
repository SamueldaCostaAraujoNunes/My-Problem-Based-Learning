/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Medico;
import Model.Paciente;
import Sistema.ListaMedicos;
import Util.ListaEncadeada;
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
public class TestListaMedicos{

    ListaMedicos lista;
    Paciente ludmilla;
    Paciente roberto;
    Paciente carlos;
    Paciente alberto;
    Paciente gelado;
    Paciente hiago;
    Paciente guilherme;
    Paciente daniel;
    Paciente moises;

    /**
     * Antes de iniciar os testes, ele instancia os objetos dentro do before.
     */
    @Before
    public void Instance() {
        lista = new ListaMedicos();
        
        Medico medico1 = new Medico("Dr. Samuel Lima", 1);
        Medico medico2 = new Medico("Dr. Robert Luiz", 2);
        Medico medico3 = new Medico("Dr. Douglas Lima", 3);
        
        
        lista.incluirMedico(medico1);
        lista.incluirMedico(medico2);
        lista.incluirMedico(medico3);

        ludmilla = new Paciente("Ludmilla", 1234, false);
        roberto = new Paciente("Roberto", 234, false);
        carlos = new Paciente("Carlos", 345, true);

        alberto = new Paciente("Alberto", 456, true);
        gelado = new Paciente("Gelado", 456, true);
        hiago = new Paciente("Hiago", 567, false);

        guilherme = new Paciente("Guilherme", 678, true);
        daniel = new Paciente("Daniel", 789, true);
        moises = new Paciente("Moises", 890, true);

    }

    /**
     * Inicialmente, ele verifica o tamanho da lista, insere 3 medicos, verifica
     * se o metodo de busca pelo crm retorna o medico correto, ou seja, se os
     * medicos foram realmente incluidos na lista, e depois verifica se o
     * tamanho mudou.
     */
    @Test
    public void testInclusaoListaMedicos() {

        assertEquals("Ver tamanho", 3, lista.tamanho());

        Medico medico4 = new Medico("Medico adicionado1", 4);
        Medico medico5 = new Medico("Medico adicionado2", 5);
        Medico medico6 = new Medico("Medico adicionado3", 6);
        
        
        lista.incluirMedico(medico4);
        lista.incluirMedico(medico5);
        lista.incluirMedico(medico6);

        assertEquals("Ver se o medico foi adicionado", "Medico adicionado1", lista.acharMedicoPeloCrm(4).getNome());
        assertEquals("Ver se o medico foi adicionado", "Medico adicionado2", lista.acharMedicoPeloCrm(5).getNome());
        assertEquals("Ver se o medico foi adicionado", "Medico adicionado3", lista.acharMedicoPeloCrm(6).getNome());
        assertEquals("Ver se o tamanho mudou", 6, lista.tamanho());
    }

    /**
     * Inicialmente, ele verifica chama o metodo acharMedicoPeloCrm, com o
     * parametro, o crm do médico, com o objeto retornado (do tipo Medico), ele
     * chama o metodo getNome, e compara o nome esperado com o retorno do
     * metodo. Ele repete isso, para todos os médico existentes.
     */
    @Test
    public void testAcharMedicoPeloCrm() {

        assertEquals("Ver se a lista realmente mudou", "Dr. Samuel Lima", lista.acharMedicoPeloCrm(1).getNome());
        assertEquals("Ver se a lista realmente mudou", "Dr. Robert Luiz", lista.acharMedicoPeloCrm(2).getNome());
        assertEquals("Ver se a lista realmente mudou", "Dr. Douglas Lima", lista.acharMedicoPeloCrm(3).getNome());
    }

    /**
     * O testEditarNomePeloCrm testa o metodo "editarNomePeloCrm". No inicio,
     * ele procura um médico já existente, verificando o seu nome. Após, ele
     * altera o nome, usando o metodo e em seguida, verifica se o nome do médico
     * foi alterado, de forma eficaz. Por fim, ele verifica se o retorno do
     * metodo varia a depender da eficiencia da edição do nome.
     */
    @Test
    public void testEditarNomePeloCrm() {

        assertEquals("Ver se a lista realmente mudou", "Dr. Douglas Lima", lista.acharMedicoPeloCrm(3).getNome());
        lista.editarNomePeloCrm("Nome Trocado", 3);
        assertEquals("Ver se a lista realmente mudou", "Nome Trocado", lista.acharMedicoPeloCrm(3).getNome());

        assertTrue("Se a função de editar o nome pelo CRM, achou o CRM", (lista.editarNomePeloCrm("Nome Trocado 2", 3)));
        assertFalse("Se não achou o CRM do médico", (lista.editarNomePeloCrm("CRM INEXISTENTE", 4)));
    }

    /**
     * O testListarFilaPacientesPeloCrm testa o metodo
     * "ListarFilaPacientesPeloCrm". Inicialmente, o teste encaminha 1 paciente
     * diferente para cada medico. E depois, testa o paciente na lista de cada
     * medico corresponde ao paciente esperado.
     */
    @Test
    public void testListarFilaPacientesPeloCrm() {

        lista.encaminharPaciente(ludmilla);
        assertSame("Verifica se o metodo retorna uma lista com os pacientes", ludmilla, lista.listarFilaPacientesPeloCrm(1).getPrimeiro().getObj());
        lista.encaminharPaciente(roberto);
        assertSame("Verifica se o metodo retorna uma lista com os pacientes", roberto, lista.listarFilaPacientesPeloCrm(2).getPrimeiro().getObj());
        lista.encaminharPaciente(carlos);
        assertSame("Verifica se o metodo retorna uma lista com os pacientes", carlos, lista.listarFilaPacientesPeloCrm(3).getPrimeiro().getObj());

        lista.encaminharPaciente(alberto);

        assertSame("Verifica a lista do medico de CRM 3 permanece igual", carlos, lista.listarFilaPacientesPeloCrm(3).getPrimeiro().getObj());
        assertSame("Verifica a lista do medico de CRM 2 permanece igual", roberto, lista.listarFilaPacientesPeloCrm(2).getPrimeiro().getObj());
        assertSame("Verifica a lista do medico de CRM 1 mudou", alberto, lista.listarFilaPacientesPeloCrm(1).getPrimeiro().getObj());

    }

    /**
     * Inicialmente, o teste encaminha o paciente para a menor fila, como os 3
     * médicos estão com a lista vazia, o primeiro paciente é incluido na lista
     * do primeiro médico, e o segundo por sua vez no segundo médico e assim por
     * diante(Até ocorrer algum atendimento). Ao escolher a menor fila, o
     * programa avalia a prioridade do paciente, caso True, ele insere o
     * paciente, entre o ultimo prioritario e o primeiro normal. caso False, ele
     * adiciona o paciente diretamente ao final da fila.
     */
    @Test
    public void testEncaminharPaciente() {
        
        lista.encaminharPaciente(ludmilla);
        lista.encaminharPaciente(roberto);
        lista.encaminharPaciente(carlos);

        lista.encaminharPaciente(alberto);
        lista.encaminharPaciente(gelado);
        lista.encaminharPaciente(hiago);

        lista.encaminharPaciente(guilherme);
        lista.encaminharPaciente(daniel);
        lista.encaminharPaciente(moises);

        assertEquals("Verifica se o primeiro paciente da fila é o esperado", alberto, lista.listarFilaPacientesPeloCrm(1).getPrimeiro().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", gelado, lista.listarFilaPacientesPeloCrm(2).getPrimeiro().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", carlos, lista.listarFilaPacientesPeloCrm(3).getPrimeiro().getObj());

        assertEquals("Verifica se o primeiro paciente da fila é o esperado", guilherme, lista.listarFilaPacientesPeloCrm(1).getPrimeiro().getProx().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", daniel, lista.listarFilaPacientesPeloCrm(2).getPrimeiro().getProx().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", moises, lista.listarFilaPacientesPeloCrm(3).getPrimeiro().getProx().getObj());

        assertEquals("Verifica se o primeiro paciente da fila é o esperado", ludmilla, lista.listarFilaPacientesPeloCrm(1).getPrimeiro().getProx().getProx().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", roberto, lista.listarFilaPacientesPeloCrm(2).getPrimeiro().getProx().getProx().getObj());
        assertEquals("Verifica se o primeiro paciente da fila é o esperado", hiago, lista.listarFilaPacientesPeloCrm(3).getPrimeiro().getProx().getProx().getObj());

    }

    /**
     * O testListaAtendimentosRealizados, observa se quando o metodo
     * realizarAtendimento é chamado, o primeiro paciente da fila do medico, é
     * retornado, se ele sai da lista dos não atendidos e se ele entra na lista
     * dos atendidos. Repentindo o processo 3 vezes, com pacientes diferentes.
     */
    @Test
    public void testListarAtendimentosRealizados() {
        Medico medico = (Medico) lista.getPrimeiro().getObj();

        medico.incluirPaciente(ludmilla);
        medico.incluirPaciente(roberto);
        medico.incluirPaciente(carlos);

        assertTrue("Ver se a fila está vazia", medico.getFilaPacientesAtendidos().isEmpty());
        assertEquals("Ver se o tamanho da lista dos pacientes a serem atendidos é 3", 3, medico.getFilaPacientesNaoAtendidos().getTamanho());

        medico.realizarAtendimento();

        assertSame("Ver se o paciente está na fila dos atendidos", carlos, medico.getFilaPacientesAtendidos().getPrimeiro().getObj());
        assertEquals("Ver se o tamanho da lista dos atendidos é igual a 1", 1, medico.getFilaPacientesAtendidos().getTamanho());
        assertEquals("Ver se o tamanho da lista dos pacientes a serem atendidos diminuiu", 2, medico.getFilaPacientesNaoAtendidos().getTamanho());

        medico.realizarAtendimento();

        assertSame("Ver se o paciente está na fila dos atendidos", ludmilla, medico.getFilaPacientesAtendidos().getPrimeiro().getProx().getObj());
        assertEquals("Ver se o tamanho da lista dos atendidos é igual a 2", 2, medico.getFilaPacientesAtendidos().getTamanho());
        assertEquals("Ver se o tamanho da lista dos pacientes a serem atendidos diminuiu", 1, medico.getFilaPacientesNaoAtendidos().getTamanho());

        medico.realizarAtendimento();

        assertSame("Ver se o paciente está na fila dos atendidos", roberto, medico.getFilaPacientesAtendidos().getPrimeiro().getProx().getProx().getObj());
        assertEquals("Ver se o tamanho da lista dos atendidos é igual a 3", 3, medico.getFilaPacientesAtendidos().getTamanho());
        assertTrue("VVer se a fila dos não atendidos está vazia", medico.getFilaPacientesNaoAtendidos().isEmpty());
    }

}
