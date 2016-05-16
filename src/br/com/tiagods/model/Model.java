package br.com.tiagods.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago Dias
 */
public class Model {
        
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");
    
    private boolean status=false;
    private String horaAgora;
    private String dataAgora;
    private String dia;
    private String mes;
    private String ano;
    
    public void setHoraAgora(String hora){
        this.horaAgora=hora;
    }
    
    public String getHoraAgora(){
        Date data = new Date();
        this.horaAgora = getSdh().format(data);
        //model.setHoraAgora(hora);
        return horaAgora;
    }
    
    public String getDataAgora(){
        Date data=new Date();
        this.dataAgora = getSdf().format(data);
        
        return dataAgora;
        
    }
    public String getMensagem(String textArea, String msg){
        StringBuilder builder = new StringBuilder();
        String quebra="";
        if(textArea.length()>=1){
            quebra="\n";
        }
        builder.append(textArea)
                .append(quebra)
                .append(getDataAgora())
                .append("=")
                .append(getHoraAgora())
                .append("=")
                .append(msg);
        return builder.toString();
    }

    /**
     * @return the sdf
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * @param sdf the sdf to set
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    /**
     * @return the sdh
     */
    public SimpleDateFormat getSdh() {
        return sdh;
    }

    /**
     * @param sdh the sdh to set
     */
    public void setSdh(SimpleDateFormat sdh) {
        this.sdh = sdh;
    }

    /**
     * @param dataAgora the dataAgora to set
     */
    public void setDataAgora(String dataAgora) {
        this.dataAgora = dataAgora;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
