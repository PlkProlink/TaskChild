/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.Model;
import br.com.tiagods.model.ModelDiretorios;
import static br.com.tiagods.view.Menu.jTextArea1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class FileOrganizar {
    Model model;
    SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");
    StringBuilder builder = new StringBuilder();
    
    public FileOrganizar(Model model){
        this.model=model;
    }
    //
    public void limparPasta(String diretorio){
        File file = new File(diretorio);
        File [] files = file.listFiles();
        for(File f : files)
            f.delete();
    }
    //
    public void organizar(String diretorio){
        File file = new File(diretorio);
        if(file.isDirectory()){
            File[] arquivos = file.listFiles();
            for(File f : arquivos){
                long modificao = f.lastModified();
                String data = sdf.format(modificao);                
                if(data.equals(model.getMes()+model.getAno())){
                    System.out.println("movendo arquivo "+f.getAbsoluteFile());
                    mover(f, model.getMes(),String.valueOf(model.getAno()));
                }
                else{
                    System.out.println("2 movendo arquivo "+f.getAbsoluteFile());
                    mover(f, data.substring(0,1), data.substring(2, 3));
                }
            }
        }
    }
    //mover o arquivo para um diretorio e organizar
    private void mover(File origem, String mes, String ano){
        File arq = new File(origem.getParentFile()+"\\"+ano);
        File sub = new File(arq.getAbsolutePath()+"\\"+model.getMesExtenso(mes));
        
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
    //mover Log
    public boolean moverLog(File fileInicial, File fileFinal){
        
        try {
            Path pathI = Paths.get(fileInicial.getAbsolutePath());
            Path pathO = Paths.get(fileFinal.getAbsolutePath());
            Files.copy(pathI, pathO, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }   
    //lista os arquivos dentro do diretorio
    public String listarArquivos(ModelDiretorios dir){
        StringBuilder sb = new StringBuilder();
        File[] files2 = new File(dir.getDiretorioDosArquivos()).listFiles();
        for(File f : files2){
            if(f.isFile()){
                sb.append(f.getName()).append(";");
            }
        }
        return sb.toString();
    }
    
    public void criarDiretorios(File dir){
        if(!dir.exists()){
            atualizarTela("Criando um novo diretorio para versao em "+dir.getAbsolutePath());
            dir.mkdir();//criar diretorio de versao caso não exista
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
