/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class ModelLog implements Serializable{
    private String statusSync;
    private int elementos;
    private String tamanhoElementos;
    private String tempoTotal;
    private int elementosRestantes;
    private String tamanhoRestante="";
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
     * @return the elementos
     */
    public int getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    /**
     * @return the tamanhoElementos
     */
    public String getTamanhoElementos() {
        return tamanhoElementos;
    }

    /**
     * @param tamanhoElementos the tamanhoElementos to set
     */
    public void setTamanhoElementos(String tamanhoElementos) {
        this.tamanhoElementos = tamanhoElementos;
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
     * @return the elementosRestantes
     */
    public int getElementosRestantes() {
        return elementosRestantes;
    }

    /**
     * @param elementosRestantes the elementosRestantes to set
     */
    public void setElementosRestantes(int elementosRestantes) {
        this.elementosRestantes = elementosRestantes;
    }

    /**
     * @return the tamanhoRestante
     */
    public String getTamanhoRestante() {
        return tamanhoRestante;
    }

    /**
     * @param tamanhoRestante the tamanhoRestante to set
     */
    public void setTamanhoRestante(String tamanhoRestante) {
        this.tamanhoRestante = tamanhoRestante;
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
    public void setHora(List<String> hora) {
        this.hora = hora;
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
    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }

}