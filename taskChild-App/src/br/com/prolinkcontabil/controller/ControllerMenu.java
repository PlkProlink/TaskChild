/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolinkcontabil.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Tiago
 */
public class ControllerMenu {
    public int pegaDia(){
        Date data = new Date();
        GregorianCalendar calendario = new GregorianCalendar();
        calendario.setTime(data);
        int diaHoje = calendario.get(Calendar.DAY_OF_MONTH);
        return diaHoje;
    }
    
    public String pegaNome(){
        return "";
    }
    
    public static void main(String[] args) {
        new ControllerMenu();
    }
    
    
    public ControllerMenu(){
        System.out.println("Dia: " +pegaDia());
    }
    
}
