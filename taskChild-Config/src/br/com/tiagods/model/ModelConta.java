/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.model;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class ModelConta {
    private String email;
    private int aviso;
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setAviso(int aviso){
        this.aviso=aviso;
    }
    public int getAviso(){
        return this.aviso;
    }
}
