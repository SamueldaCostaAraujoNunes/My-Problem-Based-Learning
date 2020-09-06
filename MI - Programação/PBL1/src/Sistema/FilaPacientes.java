package Sistema;

import Model.Paciente;
import Util.Fila;
import Util.No;

/**
 * @author Samuel da Costa Araujo Nunes
 * @since out 2019.
 * @version 1.0
 *
 * A classe <b>FilaPacientes</b> funciona como uma fila normal, porém, ela
 * considera a prioridade dos pacientes e os insere na fila de formas
 * diferentes.
 */
public class FilaPacientes extends Fila {

    /**
     * O metódo entrar, recebe como parametro um Paciente da classe
     * <b>Paciente</b> e o insere numa fila, considerando sua prioridade.
     *
     * @param paciente
     */
    public void entrar(Paciente paciente) {
        No noPaciente = new No(paciente);// Cria um nó, contendo o paciente.
        if (isEmpty()) {//Se a lista, estiver vazia, ele indica que o primeiro nó da lista, será o nó com com o paciente passado por parametro, e incrementa o tamanho da lista.
            primeiro = noPaciente;
            tamanho++;
            return;
        }
        boolean prioridade = paciente.isPrioridade();//Gera uma variavel booleana, contendo o estado logico da prioridade.
        No corrente = primeiro;
        No noAnterior = null;
        if (prioridade) {// Caso, exista prioridade, o programa procurará o ultimo prioritario, e irá inserir o novo nó entre o ultimo prioritario e o primeiro normal.
            Paciente pacientesNaFila = (Paciente) corrente.getObj();

            while (pacientesNaFila.isPrioridade() == true) {
                noAnterior = corrente;
                if (corrente.getProx() != null) {
                    corrente = corrente.getProx();
                    pacientesNaFila = (Paciente) corrente.getObj();
                } else {//Se a fila, so tiver prioridade ele adiciona no fim da fila.
                    corrente.setProx(noPaciente);
                    tamanho++;
                    return;
                }
            }
            if (noAnterior == null) {//Considera que se o noAnterior permaneceu null, logo, o programa não entrou no While. Logo, não existem prioritarios até esse momento!
                primeiro = noPaciente;
                noPaciente.setProx(corrente);
            } else {
                noAnterior.setProx(noPaciente);
                noPaciente.setProx(corrente);
            }
        } else {//Se, não existir prioridade, o nó contendo o paciente será alocado depois do  ultimo nó.
            while (corrente.getProx() != null) {
                corrente = corrente.getProx();
            }
            corrente.setProx(noPaciente);
        }
        tamanho++;
    }

    @Override
    public Paciente sair() {//O metodo sair, retira o primeiro nó da lista e o retorna ao programa principal.
        No pacienteQueVaiSair = primeiro;
        primeiro = primeiro.getProx();
        tamanho--;
        return (Paciente) pacienteQueVaiSair.getObj();
    }

    public void display() {//O display, printa o conteudo da lista para o usuario!
        No current = primeiro;
        if (isEmpty()) {
            System.out.print("Ainda não há pacientes nesta fila!!");
        }
        while (current != null) {
            Paciente paciente = (Paciente) current.getObj();
            System.out.print(paciente.getNome());
            System.out.print(" |" + paciente.getMatricula() + "| ");
            if (current.getProx() != null) {
                System.out.print(" -> ");
            }
            current = current.getProx();
        }
        System.out.println(".");
    }

}
