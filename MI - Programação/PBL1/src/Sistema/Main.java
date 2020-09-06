
package Sistema;

import Model.Exame;
import Model.Medico;
import Model.Paciente;
import Util.ListaEncadeada;
import Util.No;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * * A classe <b>Main</b> gerencia as classes e gera a interface para o usuario.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class Main {

    static ListaMedicos listaMedico = new ListaMedicos();
    static FilaPacientes filaPacientes = new FilaPacientes();
    static ListaGeralExames filaExames = new ListaGeralExames();
    static Scanner scanf = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        limparSaida();
        System.out.println(
                "Menu da UPA\n"
                + "1- Lista de Medicos\n"
                + "2- Fila para atendimento\n"
                + "3- Fila para exames\n"
                + "4- Sair"
        );

        int primeiraEscolha = scanf.nextInt();

        limparSaida();
        switch (primeiraEscolha) {
            case 1:
                menuListaMedico();
                break;
            case 2:
                menuFilaAtendimentos();
                break;
            case 3:
                menuFilaExames();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Esta não é uma opção válida!");
                menuPrincipal();
        }
    }

    public static void menuListaMedico() {
        limparSaida();
        System.out.println(
                "Menu da Lista de Medicos\n"
                + "1- Incluir novo médico.\n"
                + "2- Editar dados do médico.\n"
                + "3- Listar atendimentos realizados por um médico.\n"
                + "4- Listar médicos cadastrados.\n"
                + "5- Retornar ao menu principal."
        );

        int segundaEscolha = scanf.nextInt();
        int crm;
        limparSaida();
        switch (segundaEscolha) {
            case 1:
                System.out.print("Digite o nome do médico: ");
                scanf.nextLine();
                String nome = scanf.nextLine();

                System.out.print("Digite o CRM do médico: ");
                crm = scanf.nextInt();

                Medico medico = new Medico(nome, crm);

                System.out.print("Médico cadastrado!\n");

                listaMedico.incluirMedico(medico);
                retornarOuSair();
                break;
            case 2:
                System.out.print("Digite o CRM do médico: ");

                crm = scanf.nextInt();

                System.out.print("Digite o nome atualizado do médico: ");

                scanf.nextLine();

                String novoNome = scanf.nextLine();

                if (listaMedico.editarNomePeloCrm(novoNome, crm)) {
                    System.out.print("Médico editado com sucesso!!\n");
                } else {
                    System.out.print("CRM não cadastrado!!\n");
                }
                retornarOuSair();
                break;
            case 3:
                System.out.print("Digite o CRM do médico: ");
                crm = scanf.nextInt();
                listaMedico.listarAtendimentosRealizados(crm).display();
                retornarOuSair();
                break;
            case 4:
                listaMedico.displayList();
                retornarOuSair();
                break;
            case 5:
                menuPrincipal();
                break;
            default:
                System.out.println("Esta não é uma opção válida!");
                menuListaMedico();
        }
        menuPrincipal();
    }

    public static void menuFilaAtendimentos() {
        limparSaida();
        System.out.println(
                "Menu da Fila de Atendimentos\n"
                + "1- Encaminhar paciente.\n"
                + "2- Lista fila de pacientes.\n"
                + "3- Realizar atendimento.\n"
                + "4- Retornar ao menu principal."
        );

        int crm;
        Paciente paciente;
        int segundaEscolha = scanf.nextInt();
        limparSaida();
        switch (segundaEscolha) {
            case 1:

                System.out.print("Digite o nome do paciente: ");
                scanf.nextLine();

                String nome = scanf.nextLine();

                System.out.print("Digite a matricula do paciente: ");

                int matricula = scanf.nextInt();
                scanf.nextLine();

                System.out.print("O paciente é prioritario?(s/n): ");

                Boolean prioridade = "s".equals(scanf.nextLine());

                paciente = new Paciente(nome, matricula, prioridade);

                if (listaMedico.encaminharPaciente(paciente)) {
                    System.out.println("O paciente foi encaminhado!!");
                } else {
                    System.out.println("Ocorreu algum erro!!");
                }
                retornarOuSair();
                break;
            case 2:
                System.out.print("Digite o CRM do médico: ");
                crm = scanf.nextInt();

                System.out.println("Lista do médico: " + listaMedico.acharMedicoPeloCrm(crm).getNome());
                listaMedico.listarFilaPacientesPeloCrm(crm).display();
                retornarOuSair();
                break;
            case 3:
                listaMedico.displayTodasAsFilas();
                System.out.print("Digite o CRM do médico que realizará o atendimento: ");
                crm = scanf.nextInt();

                Medico medico = listaMedico.acharMedicoPeloCrm(crm);

                if (medico.getFilaPacientesNaoAtendidos().isEmpty()) {
                    System.out.println("Esse médico não possui pacientes para realizar atendimento!!");
                    retornarOuSair();
                    break;
                }

                System.out.println();
                paciente = medico.realizarAtendimento();
                Boolean sair = false;
                while (!sair) {
                    System.out.print("O médico " + medico.getNome() + ", deseja solicitar algum exame?(s/n): ");
                    scanf.nextLine();
                    Boolean escolha = "s".equals(scanf.nextLine());
                    if (escolha) {
                        System.out.print("Qual o tipo de exame, deseja solicitar?? ");
                        String nomeExame = scanf.nextLine();
                        medico.solicitarExames(paciente, nomeExame);
                    } else {
                        sair = true;
                    }
                }

                if (!paciente.getListaExames().isEmpty()) {
                    filaExames.add(paciente);
                }
                System.out.println("Atendimento realizado!!");
                listaMedico.displayTodasAsFilas();
                retornarOuSair();
                break;
            case 4:
                menuPrincipal();
            default:
                System.out.println("Esta não é uma opção válida!");
                menuFilaAtendimentos();
        }
    }

    public static void menuFilaExames() {
        limparSaida();
        System.out.println(
                "Menu da Fila de Exames\n"
                + "1- Listagem de Exames(Pacietes que estão na espera do exame).\n"
                + "2- Listar exames solicitados(Exames que um paciente deve realizar).\n"
                + "3- Realizar Exame.\n"
                + "4- Retornar ao menu principal."
        );

        int segundaEscolha = scanf.nextInt();
        limparSaida();
        No current;
        String tipoDoExame;
        switch (segundaEscolha) {
            case 1:
                System.out.print("Digite o tipo do exame: ");
                scanf.nextLine();
                tipoDoExame = scanf.nextLine();
                System.out.println();
                ListaEncadeada listaPacientes = filaExames.listarPacientesNaEsperaDoExame(tipoDoExame);

                current = listaPacientes.getPrimeiro();
                System.out.println("Pacientes aguardando este exame: ");
                while (current != null) {
                    Paciente pacienteAtual = (Paciente) current.getObj();
                    if (current.getProx() != null) {
                        System.out.print(pacienteAtual.getNome() + "->");
                    } else {
                        System.out.print(pacienteAtual.getNome() + ".");
                    }
                    current = current.getProx();
                }
                System.out.println();
                retornarOuSair();
                break;
            case 2:
                System.out.print("Digite a matricula do paciente: ");
                int matricula = scanf.nextInt();
                System.out.println();
                ListaEncadeada examesPaciente = filaExames.listarExamesSolicitados(matricula);
                current = examesPaciente.getPrimeiro();
                if (current != null) {
                    System.out.print("Exames do paciente : (");
                }
                while (current != null) {
                    Exame exame = (Exame) current.getObj();
                    if (current.getProx() == null) {
                        System.out.print(exame.getNomeDoExame() + ")");
                    } else {
                        System.out.print(exame.getNomeDoExame() + ", ");
                    }
                    current = current.getProx();
                }
                System.out.println();
                retornarOuSair();
                break;
            case 3:
                System.out.print("Digite o tipo do exame: ");
                scanf.nextLine();
                tipoDoExame = scanf.nextLine();
                System.out.println();
                filaExames.realizarExame(tipoDoExame);
                retornarOuSair();
                
                break;
            case 4:
                menuPrincipal();
            default:
                System.out.println("Esta não é uma opção válida!");
                menuFilaExames();
        }
    }

    public static void retornarOuSair() {
        System.out.print(
                "1 - Voltar ao Menu.\n"
                + "2 - Sair.");
        if (scanf.nextInt() == 1) {
            menuPrincipal();
        } else if (scanf.nextInt() == 2) {
            System.exit(0);
        }
    }

    public final static void limparSaida() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }
}
