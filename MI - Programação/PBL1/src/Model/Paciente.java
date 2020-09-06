/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.ListaEncadeada;

/**
 *
  * @author Samuel da Costa Araujo Nunes
 */
public class Paciente {
    private String nome;
    private int matricula;
    private boolean prioridade;
    private ListaEncadeada listaExames;

    public ListaEncadeada getListaExames() {
        return listaExames;
    }

    public void setListaExames(ListaEncadeada listaExames) {
        this.listaExames = listaExames;
    }

    public Paciente() {}

    public Paciente(String nome, int matricula, boolean prioridade) {
        this.nome = nome;
        this.matricula = matricula;
        this.prioridade = prioridade;
        this.listaExames = new ListaEncadeada();
        
        
        /**
         * Cria o Objeto Médico.
         * @param nome Nome do Paciente.
         * @param matricula A Matricula do Paciente.
         * @param prioridade Se verdadeiro, existe prioridade, se falso, não existe.
         */
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
    
    
    
    
}
