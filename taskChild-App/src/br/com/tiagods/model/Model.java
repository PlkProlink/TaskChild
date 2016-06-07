package br.com.tiagods.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago Dias
 */
public class Model {  
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");
    Date data = new Date();
    GregorianCalendar calendario = new GregorianCalendar();
    
    private boolean status=false;
    private String horaAgora;
    private String dataAgora;
        
    public Model(){
        calendario.setTime(data);
    }
    
    
    public String getHoraAgora(){
        data = new Date();
        this.horaAgora = sdh.format(data);
        //model.setHoraAgora(hora);
        return horaAgora;
    }
    public String getDataAgora(){
        this.dataAgora = sdf.format(data);
        
        return dataAgora;
        
    }
    //mensagem será incrementada
    public String getMensagem(String textArea, String msg){
        StringBuilder builder = new StringBuilder();
        String quebra="";
        //quebra de linha na txtArea
        if(textArea.length()>=1){
            quebra="\n";
        }
        //mensagem na tela
        builder.append(textArea)
                .append(quebra)
                .append(getDataAgora())
                .append("-")
                .append(getHoraAgora())
                .append("=")
                .append(msg);
        return builder.toString();//retornar a mensagem na tela, completando com o que ja foi impresso na tela.
    }

    /**
     * @return the dia
     */
    public String getDia() {
        //*pegando data hoje
        int diaHoje = calendario.get(Calendar.DAY_OF_MONTH);
        if(diaHoje>=0 && diaHoje<=9)
            return "0"+diaHoje;
        else
            return ""+diaHoje;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        int mesAtual = calendario.get(Calendar.MONTH);
        switch(mesAtual){
            case 0:
                mesAtual=1;
                break;
            case 1:
                mesAtual=2;
                break;
            case 2:
                mesAtual=3;
                break;
            case 3:
                mesAtual=4;
                break;
            case 4:
                mesAtual=5;
                break;
            case 5:
                mesAtual=6;
                break;
            case 6:
                mesAtual=7;
                break;
            case 7:
                mesAtual=8;
                break;
            case 8:
                mesAtual=9;
                break;
            case 9:
                mesAtual=10;
                break;
            case 10:
                mesAtual=11;
                break;
            case 11:
                mesAtual=12;
                break;
        }
        if(mesAtual>=0 && mesAtual<=9)
            return "0"+mesAtual;
        else
            return ""+mesAtual;
    }

    public String getMesExtenso(String mes){
        switch(mes){
            case "01":
                return "Janeiro";
            case "02":
                return "Fevereiro";
            case "03":
                return "Março";
            case "04":
                return "Abril";
            case "05":
                return "Maio";
            case "06":
                return "Junho";
            case "07":
                return "Julho";
            case "08":
                return "Agosto";
            case "09":
                return "Setembro";
            case "10":
                return "Outubro";
            case "11":
                return "Novembro";
            case "12":
                return "Dezembro";
        }
        return mes;
    }
    /**
     * @return the ano
     */
    public int getAno() {
        return calendario.get(Calendar.YEAR);
    }
    /**
     * @return the DiaDoMes
     */
    public int getDiaDoMes() {
        return calendario.get(Calendar.DAY_OF_MONTH);
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
