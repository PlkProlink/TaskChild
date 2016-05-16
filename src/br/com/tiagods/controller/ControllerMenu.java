/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.controller;

import br.com.tiagods.model.Model;
import br.com.tiagods.model.ModelBat;
import br.com.tiagods.model.ModelConta;
import br.com.tiagods.model.ModelDiretorios;
import br.com.tiagods.utilitarios.BatJob;
import br.com.tiagods.utilitarios.Config;
import br.com.tiagods.utilitarios.Email;
import br.com.tiagods.utilitarios.FileBackup;
import br.com.tiagods.utilitarios.FileOrganizar;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static br.com.tiagods.view.Menu.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Tiago
 */

public class ControllerMenu{
    
    BatJob job;
    Model model = new Model();
    ModelBat bat = new ModelBat();
    ModelDiretorios dir = new ModelDiretorios();
    ModelConta contas = new ModelConta();
    Date data = new Date();
    GregorianCalendar calendario = new GregorianCalendar();
    StringBuilder builder = new StringBuilder();
    String script;
    
    public ControllerMenu(){
        
        calendario.setTime(data);
        pegaDia();
        pegaMes();
        pegaAno();
        Thread();
    }
    
    private void pegaDia(){
        //*pegando data hoje
        int diaHoje = calendario.get(Calendar.DAY_OF_MONTH);
        if(diaHoje>=0 && diaHoje<=9)
            model.setDia("0"+diaHoje);
        else
            model.setDia(""+diaHoje);
    }
    
    private void pegaMes(){
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
            model.setMes("0"+mesAtual);
        else
            model.setMes(""+mesAtual);
    }
        
    private void pegaAno(){
        model.setAno(String.valueOf(this.calendario.get(Calendar.YEAR)));
    }
    private void Thread(){
        Executa ex = new Executa();
        Thread thread = new Thread(ex);
        thread.start();
    }
    public class Executa implements Runnable{
        @Override
        public void run() {
            atualizarTela("Verificando data: "+model.getDia()+"/"+model.getMes()+"/"+model.getAno());
            
            Config config = new Config();
            String valor = config.lerArquivos(bat, contas, dir);
            atualizarTela(valor);
            job = new BatJob(model);
            
            atualizarTela("Chamando FreeFileSync "+"\""+dir.getDiretorioInstalacao()+"\" \""+dir.getDiretorioDoBatch()+"\\"+bat.getNome()+bat.getExtensao()+"\"");
            script = "\""+dir.getDiretorioInstalacao()+"\" \""+dir.getDiretorioDoBatch()+"\\"+bat.getNome()+bat.getExtensao()+"\"";
            ThreadScript();
            
            for(int i=0; job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"").equals("Fechado"); i++){//verificar se o programa foi aberto
                try {
                    if(i==10){
                        atualizarTela("Não foi identificado a execução do FreeFileSync!Encerrando...");
                        EnviarEmail();
                    }
                    else
                        Thread.sleep(30*1000);//30 segundos
                } catch (InterruptedException ex) {
                    atualizarTela("Sistema interrompido(Abertura Script): Detalhes do erro: "+ex);
                }
            }
            atualizarTela("Identificado a execução do FreeFileSync...");
            atualizarTela("FreeFileSync identificado...aguardando termino...");
            
            for(int i =0; job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"").equals("Aberto"); i++){//aqui é o contrario, verificarei quando o job ira terminar para tentar proxima etapa
                try {
                    if(i==bat.getTempoEspera()){
                        atualizarTela("FreeFileSync demorou "+bat.getTempoEspera()+" minutos para finalizar! Encerrando...");
                        script="tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"";
                        ThreadScript();
                        EnviarEmail();
                    }
                    else
                        Thread.sleep(5*1000);
                } catch (InterruptedException ex) {
                    atualizarTela("Sistema interrompido(Aguardando encerramento FreeFileSync): Detalhes do erro: "+ex);}
            }
  
            atualizarTela("FreeFileSync concluido...pegando diretorio "+dir.getDiretorioVersao());
            
            File file1 = new File(dir.getDiretorioVersao());
            if(!file1.exists()){
                atualizarTela("Diretorio de versão não existe! Criei um novo, encerrando por segurança..." );
                file1.mkdir();
                EnviarEmail();
            }
            
            File arq = new File(dir.getDiretorioDosArquivos());
            if(!arq.exists()){
                arq.mkdir();
            }
            atualizarTela("Zipando a pasta "+dir.getDiretorioVersao());
            
            script="\""+dir.getDiretorioRar()+"\\winrar\" a "+bat.getDeleteRar()+" \""+dir.getDiretorioDosArquivos()+"\\"+model.getDia()+model.getMes()+".rar\" "+"\""+dir.getDiretorioVersao()+"\"";
            ThreadScript();
            for(int i =0; job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq winrar.exe\"").equals("Aberto"); i++){//aqui é o contrario, verificarei quando o job ira terminar para tentar proxima etapa
                try {
                    if(i==bat.getTempoEspera()){
                        atualizarTela("Winrar demorou "+bat.getTempoEspera()+" minutos para finalizar! Encerrando...");
                        script="tasklist /FI \"IMAGENAME eq winrar.exe\"";
                        ThreadScript();
                        EnviarEmail();
                    }
                    else
                        Thread.sleep(5*1000);
                } catch (InterruptedException ex) {
                    atualizarTela("Sistema interrompido(Aguardando encerramento Compactador): Detalhes do erro: "+ex);}
            }
            atualizarTela("Diretorio comprimido para "+dir.getDiretorioDosArquivos());
            StringBuilder sb = new StringBuilder();
            File[] files = new File(dir.getDiretorioDosArquivos()).listFiles();
            for(File f : files){
                if(f.isFile()){
                    sb.append(f.getName()).append(";");
                }
            }
            atualizarTela("Arquivos disponiveis no diretorio: "+sb);
            if(!file1.exists()){
                atualizarTela("Criando um novo diretorio para versao em "+dir.getDiretorioVersao());
                file1.mkdir();//criar diretorio de versao caso não exista
            }
            atualizarTela("Organizando pastas de arquivos em " +dir.getDiretorioDosArquivos());
            FileOrganizar organizar = new FileOrganizar(model, dir.getDiretorioDosArquivos());
            atualizarTela("Organização pronta");
            File backup = new File(dir.getDiretorioDestinoVersaoRar());
            if(!backup.exists())
                backup.mkdir();
            
            if(bat.getHabilitarCopia()==1){
                if(calendario.get(Calendar.DAY_OF_MONTH)==bat.getDiaCopia()){
                    atualizarTela("Dia apontado para backup de arquivos");
                    FileBackup fileBackup = new FileBackup(model, dir.getDiretorioDosArquivos(), dir.getDiretorioDestinoVersaoRar());
                }
            }
            atualizarTela("Processo concluido!");
            model.setStatus(true);
            EnviarEmail();
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
    //executa file sync em outra thread
    public class ExecucaoScript implements Runnable{
        @Override
        public void run() {
            job.executarScript(script);
        }
    }
    private void ThreadScript(){
        ExecucaoScript ex = new ExecucaoScript();
        Thread script = new Thread(ex);
        script.start();
    }
    
    public void EnviarEmail(){
        AlertaEmail email = new AlertaEmail();
        Thread thread = new Thread(email);
        thread.start();
    }
    //para enviar email
    public class AlertaEmail implements Runnable{
        @Override
        public void run(){
            if(contas.getAviso()==1){
                String[] conta = contas.getEmail().split(";|; ");
                File file = new File(dir.getDiretorioDoLogBatch());
                File[] files = file.listFiles();
                
                File f1=null;
                if(files.length==0){//verifica se diretorio esta vazio
                    try {
                        f1= new File(dir.getDiretorioDoLogBatch()+"\\NaoExiseLog.txt");
                        f1.createNewFile();
                    } catch (IOException ex) {
                    }
                }
                else{//senão estiver vazio
                    for(File f : files){
                        f1= new File(f.getAbsolutePath());
                    }
                }
                for (String conta1 : conta) {
                    if (conta1.equals("")) {break;}

                    int tentativas = 1;
                    Email email = new Email();
                    //email enviado com sucesso para
                    String resumo;
                    if(model.isStatus())
                        resumo = "SUCESSO";
                    else
                        resumo = "FALHA";
                    
                    String log = "O ChildTask terminou a rotina diaria com "+resumo+"! Detalhes abaixo!\n\n"+jTextArea1.getText();

                    while(email.enviarEmail(f1.getAbsolutePath(), resumo, log, conta1)==false){
                        try {
                            tentativas++;
                            if(tentativas<=3){
                                int time = 600;
                                Thread.sleep(time*1000);
                            }
                            else{
                                atualizarTela("Numero de tentativas se esgotou! Necessita de intervenção humana!");
                                gravaLog();
                                for(File f:files)
                                    f.delete();
                                System.exit(0);
                            }
                        } catch (InterruptedException ex) {
                            atualizarTela("Falha, o processo foi interrompido");
                        }
                    }
                    for(File f:files){
                        f.delete();
                    }
                    atualizarTela("Email enviado com sucesso!");
                    System.exit(0);
                }
            }
        }
    }
    
    void gravaLog(){
        File file = new File(dir.getDiretorioDoLog()+"\\"+model.getDia()+model.getMes()+model.getHoraAgora().replace(":", "")+".txt");
        try{
        file.createNewFile();
            try (FileWriter fWriter = new FileWriter(file, true)) {
                fWriter.write(jTextArea1.getText());
            }
        }catch(IOException e){    
        }
    }
}
