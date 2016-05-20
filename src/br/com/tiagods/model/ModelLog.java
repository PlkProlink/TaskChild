/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class ModelLog {
    private String statusSync;
    private String elementosProcessados;
    private String tempoTotal;
    private List<String> hora = new ArrayList();
    private List<String> descricao = new ArrayList();

    /**
     * @return the statusSync
     */
    public String getStatusSync() {
        return statusSync;
    }

    /**
     * @param statusSync the statusSync to set
     */
    public void setStatusSync(String statusSync) {
        this.statusSync = statusSync;
    }

    /**
     * @return the elementosProcessados
     */
    public String getElementosProcessados() {
        return elementosProcessados;
    }

    /**
     * @param elementosProcessados the elementosProcessados to set
     */
    public void setElementosProcessados(String elementosProcessados) {
        this.elementosProcessados = elementosProcessados;
    }

    /**
     * @return the tempoTotal
     */
    public String getTempoTotal() {
        return tempoTotal;
    }

    /**
     * @param tempoTotal the tempoTotal to set
     */
    public void setTempoTotal(String tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    /**
     * @return the hora
     */
    public List<String> getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora.add(hora);
    }

    /**
     * @return the descricao
     */
    public List<String> getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao.add(descricao);
    }
}
