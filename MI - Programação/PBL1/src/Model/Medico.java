package Model;

import Sistema.FilaPacientes;

/**
 * A classe <b>Medico</b> define um tipo de dado, representando uma entidade do
 * profissional Médico.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class Medico {

    /**
     * O atributo nome, é utilizado para informar o nome do médico.
     */
    protected String nome;

    /**
     * O atributo crm, é utilizado para identificar um médico (atributo chave).
     */
    protected int crm;

    /**
     * O atributo filaPacientesAtendidos, do tipo <b>FilaPacientes</b>, é
     * utilizado para identificar os pacientes que o médico já atendeu.
     */
    protected FilaPacientes filaPacientesAtendidos;
    /**
     * O atributo filaPacientesNaoAtendidos, do tipo <b>FilaPacientes</b>, é
     * utilizado para identificar os pacientes que o médico ainda não atendeu.
     */
    protected FilaPacientes filaPacientesNaoAtendidos;

    /**
     * Construtor da classe <b>Medico</b>.<br><br>
     * <b>uso:</b><br>
     * Medico medio = new Medico("Fulano", 2202200);<br><br>
     * <b>onde:</b><br>
     *
     */
    public Medico(){};
    public Medico(String nome, int crm) {
        this.nome = nome;
        this.crm = crm;
        this.filaPacientesAtendidos = new FilaPacientes();
        this.filaPacientesNaoAtendidos = new FilaPacientes();
    }

    /**
     * Inclui o paciente na fila de atendimento do médico.
     *
     * @param paciente Paciente a ser incluido na fila de atendimento.
     */
    public void incluirPaciente(Paciente paciente) {
        filaPacientesNaoAtendidos.entrar(paciente);

    }

    /**
     * Calcula o tamanho da fila dos pacientes não atendidos
     *
     * @return <b>int</b> O tamanho da fila dos pacientes não atendidos.
     */
    public int tamanhoDaFilaDosNaoAtendidos() {
        return filaPacientesNaoAtendidos.getTamanho();
    }

    /**
     * Printa para o usuario a fila de pacientes do médico.
     */
    public void listarFilaDePacientes() {
        System.out.print("Fila do medico: ");
        System.out.print(nome);
        System.out.print(" --> ");

        filaPacientesNaoAtendidos.display();
    }

    /**
     * Realiza o atendimento do primeiro paciente da fila, encaminha o paciente
     * para a fila dos já atendido e retorna o ultimo paciente.
     *
     * @return <b>Paciente</b> Retorna o primeiro paciente, do tipo
     * <b>Paciente</b>, da lista dos pacientes a serem atendidos.
     */
    public Paciente realizarAtendimento() {
        Paciente paciente = filaPacientesNaoAtendidos.sair();
        filaPacientesAtendidos.entrar(paciente);
        return paciente;

    }

    /**
     * Permite ao médico, passar exames a serem realizados pelo paciente.
     *
     * @param pacienteAtual Paciente que esta participando do atendimento
     * @param exame Exame que o paciente deverar realizar.
     */
    public void solicitarExames(Paciente pacienteAtual, String exame) {
        Exame exameAux = new Exame(exame);
        pacienteAtual.getListaExames().add(exameAux);

    }

    public FilaPacientes getFilaPacientesAtendidos() {
        return filaPacientesAtendidos;
    }

    public FilaPacientes getFilaPacientesNaoAtendidos() {
        return filaPacientesNaoAtendidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

}
