/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.controller.ControllerMenu;
import br.com.tiagods.model.Model;
import static br.com.tiagods.view.Menu.jTextArea1;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Tiago
 */
public class BatJob {
    ControllerMenu controller;
    StringBuilder builder = new StringBuilder();
    Model model;
    public BatJob(Model model){
        this.model = model;
    }
    
    public void executarScript(String comando){
        lerSystem(comando);
    }
    //verificar se o programa esta aberto, se fechado gerara um relatorio de erro e não prosseguira
    public String verificarExecucaoImediata(String comando){
        String saida=lerSystem(comando);
        if(saida.contains("nenhuma tarefa")){
            return "Fechado";
        }
        else
            return "Aberto";
    }
    private String lerSystem(String comando){
        try{
            Process processo = Runtime.getRuntime().exec(comando);
            InputStream stream = processo.getInputStream();
            int v;
            String saida="";
            while((v=stream.read())!=-1){
                saida += ((char)v);
            }
            return saida;
        }catch(IOException e){
            atualizarTela("Não foi possivel executar o processo, programa ou caminho não existe!");
            model.setStatus(false);
            enviarEmail();
            return "";
        }
    }
    public void atualizarTela(String texto){
        //mostrar informacao nao tela
        if(builder.length()>0)
            builder.append("\n").append(texto);
        else
            builder.append(texto);
        jTextArea1.setText(model.getMensagem(jTextArea1.getText(), texto));
    }
    public void enviarEmail(){
        controller.EnviarEmail();
    }
}
