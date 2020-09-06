package Sistema;

import Model.Medico;
import Model.Paciente;
import Util.ListaEncadeada;
import Util.No;

/**
 * * A classe <b>ListaMedicos</b> define as regras de negocio sobre a lista de
 * medicos.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class ListaMedicos extends ListaEncadeada {

    /**
     * Este metodo recebe um crm, pesquisa o médico com o mesmo crm, e retorna
     * ao program principal a lista de pacientes realizados.
     *
     * @param crm
     * @return Fila de pacientes atendidos pelo médico.
     */
    public FilaPacientes listarAtendimentosRealizados(int crm) {
        No current = primeiro;
        while (current != null) {
            Medico medico = (Medico) current.getObj();
            if (medico.getCrm() == crm) {
                return medico.getFilaPacientesAtendidos();
            }
            current = current.getProx();

        }
        return null;
    }

    /**
     * Este metodo recebe um crm, pesquisa o médico com o mesmo crm, e retorna
     * ao program principal o proprio Médico.
     *
     * @param crm
     * @return o médico com o crm.
     */
    public Medico acharMedicoPeloCrm(int crm) {
        No current = primeiro;
        while (current != null) {
            Medico medico = (Medico) current.getObj();
            if (medico.getCrm() == crm) {
                return medico;
            }
            current = current.getProx();

        }
        return null;
    }

    /**
     * Inclui um médico na lista.
     *
     * @param medico
     */
    public void incluirMedico(Medico medico) {
        add(medico);
    }

    /**
     * Acessa e retorna a fila de pacientes, de um médico.
     *
     * @param crm
     * @return fila de pacientes de um médico.
     */
    public FilaPacientes listarFilaPacientesPeloCrm(int crm) {
        No current = primeiro;
        Medico medico = (Medico) current.getObj();
        while (current != null) {
            medico = (Medico) current.getObj();
            if (medico.getCrm() == crm) {
                //medico.listarFilaDePacientes(); //Imprime a lista de pacientes
                return medico.getFilaPacientesNaoAtendidos();
            }
            current = current.getProx();

        }
        return null;
    }

    /**
     * Pesquisa, e atualiza um objeto Medico numa lista encadeada, usando como atributo chave o crm.
     * @param nome
     * @param crm
     * @return Uma variavel booleana, que indica se o processo foi realizado de forma correta.
     */
    public boolean editarNomePeloCrm(String nome, int crm) {
        No current = primeiro;
        while (current != null) {
            Medico medico = (Medico) current.getObj();
            if (medico.getCrm() == crm) {
                medico.setNome(nome);
                return true;
            }
            current = current.getProx();

        }
        return false;

    }
    /**
     * Este método, verifica a menor lista de pacientes entre os médicos cadastrados e os insere na mesma.
     * @param paciente
     * @return 
     */
    public Boolean encaminharPaciente(Paciente paciente) {
        if (isEmpty()) {
            System.out.print("Nenhum médico cadastrado!!");
            return false;
        }

        Medico medicoComMenorFila = (Medico) primeiro.getObj();
        if (tamanho == 1) {
            medicoComMenorFila.incluirPaciente(paciente);
            return true;
        } else {
            No corrente = primeiro;
            while (corrente != null) {
                Medico medicoDoNo = (Medico) corrente.getObj();
                if (medicoDoNo.tamanhoDaFilaDosNaoAtendidos() < medicoComMenorFila.tamanhoDaFilaDosNaoAtendidos()) {
                    medicoComMenorFila = medicoDoNo;
                }
                corrente = corrente.getProx();
            }
            medicoComMenorFila.incluirPaciente(paciente);
            return true;
        }
    }
    /**
     * Este metodo printa a lista.
     */
    @Override
    public void displayList() {
        No current = getPrimeiro();
        if (isEmpty()) {
            System.out.print("Nenhum médico cadastrado!!");
        }
        while (current != null) {
            Medico medico = (Medico) current.getObj();
            if (current.getProx() != null) {
                System.out.print(medico.getNome() + "(" + medico.getCrm() + ")" + " | ");
            } else {
                System.out.print(medico.getNome() + "(" + medico.getCrm() + ")" + ". ");
            }
            current = current.getProx();
        }
        System.out.println();

    }
/**
 * Este metodo, printa á fila da cada médico separadamente, mostrando todas as filas de atendimento simultaneamente.
 */
    public void displayTodasAsFilas() {
        No current = getPrimeiro();
        if (isEmpty()) {
            System.out.print("Nenhuma fila de atendimento cadastrada!!");
        }
        while (current != null) {
            Medico medico = (Medico) current.getObj();
            if (current.getProx() != null) {
                System.out.println(medico.getNome() + "(" + medico.getCrm() + ")" + ": ");
                medico.getFilaPacientesNaoAtendidos().display();
                System.out.println();
            }
            current = current.getProx();
        }

    }
}
