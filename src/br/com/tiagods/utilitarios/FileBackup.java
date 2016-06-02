/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static br.com.tiagods.view.Menu.*;
/**
 *
 * @author User
 */
public class FileBackup {
    String dirInicial="";
    String dirFinal="";
    StringBuilder builder;
    
    Model model;
    
    public void atualizarTela(String texto){
        //mostrar informacao nao tela
        if(builder.length()>0)
            builder.append("\n").append(texto);
        else
            builder.append(texto);
        jTextArea1.setText(model.getMensagem(jTextArea1.getText(), texto));
    }
    
    public FileBackup(){
        builder = new StringBuilder();
    }
    public void iniciar(Model model,String dirOrigem, String dirDestino){
        this.model = model;
        this.dirInicial=dirOrigem;
        this.dirFinal=dirDestino;
        verificando();
    }
    
    private void verificando(){
        File input = new File(dirInicial);
        File output = new File(dirFinal);
        
        verificaDiretorioExist(output);
        
        if(input.isDirectory()){
            File[] file1 = input.listFiles();
            for(File fIn : file1){
                String nomeArq = fIn.getName();
                File fFim = new File(output+"\\"+nomeArq);
                if(fFim.exists()){
                    if(fIn.lastModified()>fFim.lastModified()){
                        atualizar(fIn, fFim, "Arquivo "+fFim+" ja existe, mas houve alteracao, atualizando...");
                    }
                    else
                        System.out.println("O arquivo ja existe e não foi modificado!");
                }
                else
                    atualizar(fIn, fFim, "Arquivo "+fFim+" não existe, copiando para "+fIn);
                if(fIn.isDirectory()){
                    dirInicial = fIn.getAbsolutePath();
                    dirFinal =  fFim.getAbsolutePath();
                    verificando();
                }    
            }
        }
    }
    public void atualizar(File fileInicial, File fileFinal, String mensagem){
        try{
            atualizarTela(mensagem);
            Path pathI = Paths.get(fileInicial.getAbsolutePath());
            Path pathO = Paths.get(fileFinal.getAbsolutePath());
            Files.move(pathI, pathO, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
        }
    }
    public void verificaDiretorioExist(File file){
        if(!file.exists()){
            atualizarTela("Diretorio "+file+" não existe! Criando...");
            file.mkdir();
        }
    }
}
