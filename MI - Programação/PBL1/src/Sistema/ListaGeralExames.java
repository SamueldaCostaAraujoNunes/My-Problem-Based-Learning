
package Sistema;

import Model.Exame;
import Model.Paciente;
import Util.ListaEncadeada;
import Util.No;

/**
 * A classe <b>ListaGeralExames</b> define as regras de negocio sobre a fila de
 * pessoas que esperam a realização dos seus exames.
 *
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 */
public class ListaGeralExames extends ListaEncadeada {

    /**
     * Este metodo, é responsavel por gerar e retornar uma lista encadeada
     * contendo todos os pacientes, que ainda não realizaram o exame.
     *
     * @param exameParaPesquisar
     * @return
     */
    public ListaEncadeada listarPacientesNaEsperaDoExame(String exameParaPesquisar) {

        ListaEncadeada listaDePacientes = new ListaEncadeada();

        No currentPaciente = primeiro;
        while (currentPaciente != null) {//O While, percorre toda a lista de pacientes e puxa a lista de exames dessa pessoa
            Paciente paciente = (Paciente) currentPaciente.getObj();

            No currentExame = paciente.getListaExames().getPrimeiro();
            while (currentExame != null) {//Agora, percorrendo a lista de exames do paciente, o programa verifica se o exame é igual ao esperado e se ele ainda não foi realizado.
                Exame exame = (Exame) currentExame.getObj();
                if (exame.getNomeDoExame().equals(exameParaPesquisar) && exame.getStatusDoExame() == false) {
                    listaDePacientes.add(paciente);
                }
                currentExame = currentExame.getProx();
            }
            currentPaciente = currentPaciente.getProx();
        }
        return listaDePacientes;

    }

    /**
     * Procura um paciente na fila, usando sua matricula como atributo chave, e
     * assim q o acha retorna o uma Lista Encadeada contendo os seus exames.
     *
     * @param matricula
     * @return Retorna uma lista contendo todos os exames solicitados pelo
     * médico.
     */
    public ListaEncadeada listarExamesSolicitados(int matricula) {
        No current = primeiro;
        while (current != null) {
            Paciente paciente = (Paciente) current.getObj();
            if (paciente.getMatricula() == matricula) {
                return paciente.getListaExames();
            }
            current = current.getProx();
        }
        return null;
    }

    /**
     * Esse metodo, pesquisa a primeira ocorrencia do exame na fila, realiza o
     * exame, alterando o status do exame para Verdadeiro, e por fim, verifica
     * se o paciente já realizou todos os exames, caso sim, o programa o deleta
     * do lista.
     *
     * @param exameParaPesquisar
     */
    public void realizarExame(String exameParaPesquisar) {
        int posicao = 0;
        Boolean foiVerificado = false;
        No currentPaciente = primeiro;
        while (currentPaciente != null) {
            Paciente paciente = (Paciente) currentPaciente.getObj();

            Boolean Verificador = true;

            No currentExame = paciente.getListaExames().getPrimeiro();
            while (currentExame != null) {
                Exame exame = (Exame) currentExame.getObj();
                if ((exame.getNomeDoExame().equals(exameParaPesquisar)) && exame.getStatusDoExame() == false) {
                    exame.setStatusDoExame(true);
                    foiVerificado = true;
                }
                if (!exame.getStatusDoExame()) {
                    Verificador = false;
                }
                currentExame = currentExame.getProx();
            }
            if (Verificador) {
                del(posicao);
            }
            if (foiVerificado) {
                return;
            }
            currentPaciente = currentPaciente.getProx();
            posicao++;
        }
    }

    /**
     * Este metodo printa para o usuario, uma lista de exames.
     */
    public void displayComExames() {
        No current = primeiro;
        if (current != null) {
            System.out.print("Lista Geral de Exames: ");
        }
        while (current != null) {
            Paciente paciente = (Paciente) current.getObj();
            System.out.print(paciente.getNome() + ": ");
            paciente.getListaExames().displayList();
            current = current.getProx();
        }
        System.out.println("null.");
    }

}
