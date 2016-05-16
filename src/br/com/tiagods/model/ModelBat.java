/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.model;

/**
 *
 * @author Tiago
 */
public class ModelBat {
    private String nome;
    private String extensao;
    private int TempoEspera;
    private int DiaCopia;
    private int HabilitarCopia;
    private String DeleteRar;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the extensao
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * @param extensao the extensao to set
     */
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    /**
     * @return the DeleteRar
     */
    public String getDeleteRar() {
        return DeleteRar;
    }

    /**
     * @param DeleteRar the DeleteRar to set
     */
    public void setDeleteRar(String DeleteRar) {
        this.DeleteRar = DeleteRar;
    }

    /**
     * @return the TempoEspera
     */
    public int getTempoEspera() {
        return TempoEspera;
    }

    /**
     * @param TempoEspera the TempoEspera to set
     */
    public void setTempoEspera(int TempoEspera) {
        this.TempoEspera = TempoEspera;
    }

    /**
     * @return the DiaCopia
     */
    public int getDiaCopia() {
        return DiaCopia;
    }

    /**
     * @param DiaCopia the DiaCopia to set
     */
    public void setDiaCopia(int DiaCopia) {
        this.DiaCopia = DiaCopia;
    }

    /**
     * @return the HabilitarCopia
     */
    public int getHabilitarCopia() {
        return HabilitarCopia;
    }

    /**
     * @param HabilitarCopia the HabilitarCopia to set
     */
    public void setHabilitarCopia(int HabilitarCopia) {
        this.HabilitarCopia = HabilitarCopia;
    }

}
