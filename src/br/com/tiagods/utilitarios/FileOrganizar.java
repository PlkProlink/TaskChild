/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.Model;
import static br.com.tiagods.view.Menu.jTextArea1;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class FileOrganizar {
    String diretorio;
    Model model;
    SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");
    
    StringBuilder builder = new StringBuilder();
    
    public FileOrganizar(Model model, String diretorio){
        this.diretorio=diretorio;
        this.model=model;
        organizar();
    }
    //
    public void organizar(){
        File file = new File(diretorio);
        if(file.isDirectory()){
            File[] arquivos = file.listFiles();
            for(File f : arquivos){
                long modificao = f.lastModified();
                String data = sdf.format(modificao);                
                if(data.equals(model.getMes()+model.getAno())){
                    System.out.println("movendo arquivo "+f.getAbsoluteFile());
                    mover(f, model.getMes(),model.getAno());
                    
                }
                else{
                    System.out.println("2 movendo arquivo "+f.getAbsoluteFile());
                    mover(f, data.substring(0,1), data.substring(2, 3));
                }
            }
        }
    }
    //mover o arquivo para um diretorio organizado
    private void mover(File origem, String mes, String ano){
        File arq = new File(origem.getParentFile()+"\\"+ano);
        File sub = new File(arq.getAbsolutePath()+"\\"+mes);
        
        if(!arq.exists())
            arq.mkdir();
        if(!sub.exists())
            sub.mkdir();
        if(origem.isFile())
            atualizarTela("Organizando arquivo " +origem.getPath());
        File novocaminho= new File(sub.getAbsolutePath()+"\\"+origem.getName());
        if(novocaminho.exists() && novocaminho.isFile()){
            atualizarTela("Ja existe um arquivo de mesmo nome no diretorio " +novocaminho.getParent());
            atualizarTela("Arquivo "+origem.getAbsolutePath()+" ficará no diretorio aguardando intervenção manual!");
        }
        else{
            origem.renameTo(novocaminho);
            if(origem.isFile())
                atualizarTela("Arquivo enviado para " +novocaminho);
        }
    }
    private void atualizarTela(String texto){
        //mostrar informacao nao tela
        if(builder.length()>0)
            builder.append("\n").append(texto);
        else
            builder.append(texto);
        jTextArea1.setText(model.getMensagem(jTextArea1.getText(), texto));
    }
}
