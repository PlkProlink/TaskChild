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
public class ModelGeral implements Serializable{
    private String statusSync;
    private String elementos;
    private String tamanhoElementos;
    private String tempoTotal;
    private String elementosRestantes;
    private String tamanhoRestante;
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
    public String getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(String elementos) {
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
    public String getElementosRestantes() {
        return elementosRestantes;
    }

    /**
     * @param elementosRestantes the elementosRestantes to set
     */
    public void setElementosRestantes(String elementosRestantes) {
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

}