/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.controller;

import br.com.tiagods.model.Model;
import br.com.tiagods.model.ModelBat;
import br.com.tiagods.model.ModelConta;
import br.com.tiagods.model.ModelDao;
import br.com.tiagods.model.ModelDiretorios;
import br.com.tiagods.model.ModelLog;
import br.com.tiagods.utilitarios.BatJob;
import br.com.tiagods.utilitarios.Config;
import br.com.tiagods.utilitarios.Email;
import br.com.tiagods.utilitarios.FileBackup;
import br.com.tiagods.utilitarios.FileOrganizar;
import br.com.tiagods.utilitarios.FileLog;
import static br.com.tiagods.view.Menu.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
import java.text.DecimalFormat;
=======
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
import java.util.ArrayList;
import java.util.List;
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
    
    StringBuilder builder = new StringBuilder();
    String script;
    
    public ControllerMenu(){
        Thread();//chamando a thread principal
    }
    private void Thread(){
        Executa ex = new Executa();
        Thread thread = new Thread(ex);
        thread.start();
    }
    public class Executa implements Runnable{
        @Override
        public void run() {
            Config config = new Config();
            
            atualizarTela(config.lerArquivos(bat, contas, dir));
            
                job = new BatJob(model);

                atualizarTela("Chamando FreeFileSync "+"\""+dir.getDiretorioInstalacao()+"\" \""+dir.getDiretorioDoBatch()+"\\"+bat.getNome()+bat.getExtensao()+"\"");

                script = "\""+dir.getDiretorioInstalacao()+"\" \""+dir.getDiretorioDoBatch()+"\\"+bat.getNome()+bat.getExtensao()+"\"";
                job.executarScript(script, model);
                if(model.isStatus()==true){
                    for(int i=0; ; i++){//verificar se o programa foi aberto
                        try {
                            if(job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"").equals("Aberto")){
                                model.setStatus(true);
                                break;
                            }
                            else if(i==20){
                                atualizarTela("Não foi identificado a execução do FreeFileSync!Encerrando...");
                                script="tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"";
                                job.executarScript(script, model);
                                model.setStatus(false);
                                EnviarEmail();
                                Thread.interrupted();
                            }
                            else
                                Thread.sleep(10*1000);//30 segundos
                        } catch (InterruptedException ex) {
                            atualizarTela("Sistema interrompido(Abertura Script): Detalhes do erro: "+ex);
                            model.setStatus(false);
                            EnviarEmail();
                        }
                    }
                    if(model.isStatus()==true){
                        atualizarTela("Identificado a execução do FreeFileSync...");
                        atualizarTela("FreeFileSync identificado...aguardando termino...");
                        for(int i =0; ; i++){//aqui é o contrario, verificarei quando o job ira terminar para tentar proxima etapa
                            try {
                                if(job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq FreeFileSync.exe\"").equals("Fechado")){
                                    model.setStatus(true);
                                    break;
                                }
                                else if(i==bat.getTempoEspera()){
                                    atualizarTela("FreeFileSync demorou "+bat.getTempoEspera()+" minutos para finalizar! Encerrando...");
                                    script="taskkill /FI \"IMAGENAME eq FreeFileSync.exe\"";
                                    job.executarScript(script, model);
                                    model.setStatus(false);
                                    EnviarEmail();
                                    Thread.interrupted();
                                }
                                else
                                    Thread.sleep(5*1000);
                            } catch (InterruptedException ex) {
                                atualizarTela("Sistema interrompido(Aguardando encerramento FreeFileSync): Detalhes do erro: "+ex);
                                model.setStatus(false);
                                EnviarEmail();
                            }
                        }
                        atualizarTela("FreeFileSync concluido...pegando diretorio "+dir.getDiretorioVersao());
                        File file1 = new File(dir.getDiretorioVersao());
                        if(!file1.exists())
                            file1.mkdir();
                        if(file1.exists()){
                            File[] files = file1.listFiles();
                            if(files.length>0){
                            //criar diretorio dos arquivos caso não exista
                            File arq = new File(dir.getDiretorioDosArquivos());
                            if(!arq.exists()){
                                arq.mkdir();
                            }
                            atualizarTela("Zipando a pasta "+dir.getDiretorioVersao());
                            script="\""+dir.getDiretorioRar()+"\\winrar\" a -inul "+bat.getDeleteRar()+" \""+dir.getDiretorioDosArquivos()+"\\"+model.getDia()+"-"+model.getMes()+"-"+model.getAno()+"-"+model.getHoraAgora().replace(":","")+".rar\" "+"\""+dir.getDiretorioVersao()+"\"";
                            job.executarScript(script, model);
                            if(model.isStatus()==true){
                                for(int i =0; ; i++){//aqui é o contrario, verificarei quando o job ira terminar para tentar proxima etapa
                                    try {
                                        if(job.verificarExecucaoImediata("tasklist /FI \"IMAGENAME eq winrar.exe\"").equals("Fechado")){
                                            model.setStatus(true);
                                            break;
                                        }
                                        else if(i==bat.getTempoEspera()){
                                            atualizarTela("Winrar demorou "+bat.getTempoEspera()+" minutos para finalizar! Encerrando...");
                                            script="taskkill /FI \"IMAGENAME eq winrar.exe\"";
                                            job.executarScript(script, model);
                                            model.setStatus(false);
                                            EnviarEmail();
                                            Thread.interrupted();
                                        }
                                        else
                                            Thread.sleep(5*1000);
                                    } catch (InterruptedException ex) {
                                        atualizarTela("Sistema interrompido(Aguardando encerramento Compactador): Detalhes do erro: "+ex);
                                        model.setStatus(false);
                                        EnviarEmail();
                                    }
                                }
                                if(model.isStatus()==true){
                                    atualizarTela("Diretorio comprimido para "+dir.getDiretorioDosArquivos());
                                    FileOrganizar organizar = new FileOrganizar(model);
                                    atualizarTela("Arquivos disponiveis no diretorio: "+organizar.listarArquivos(dir));
                                    organizar.criarDiretorios(file1);
                                    atualizarTela("Organizando pastas de arquivos em " +dir.getDiretorioDosArquivos());
                                    organizar.organizar(dir.getDiretorioDosArquivos());
                                    atualizarTela("Organização pronta");
                                    if(bat.getHabilitarCopia()==1){
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
                                        String[] diaMes = bat.getDiaCopia().split(";");
                                        for(String diaHoje : diaMes){
                                            if(model.getDiaDoMes()==Integer.parseInt(diaHoje.trim())){//pegará a relação do config, se o dia de hoje for igual a um dos dias informados, o backup será realizado
=======
                                        String[] diaMes = bat.getDiaCopia().split(";|; ");
                                        for(String diaHoje : diaMes){
                                            if(model.getDiaDoMes()==Integer.parseInt(diaHoje)){//pegará a relação do config, se o dia de hoje for igual a um dos dias informados, o backup será realizado
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                                                atualizarTela("Dia apontado para backup de arquivos...iniciando!");
                                                atualizarTela("Arquivos serão copiados para "+dir.getDiretorioDestinoVersaoRar());
                                                FileBackup fileBackup = new FileBackup();
                                                fileBackup.iniciar(model, dir.getDiretorioDosArquivos(), dir.getDiretorioDestinoVersaoRar());
                                                break;
                                            }
                                        }
                                    }
                                    atualizarTela("Processo concluido!");
                                    EnviarEmail();
                                }
                                else
                                    EnviarEmail();
                            }
                            else
                                EnviarEmail();
                            }
                        else{
                            model.setStatus(true);
                            atualizarTela("Nenhuma ação será realizada. Não existe arquivos no diretorio: "+dir.getDiretorioVersao());
                            EnviarEmail();
                        }
                    }
                    else{
                        model.setStatus(false);
                        atualizarTela("Nenhuma ação será realizada. Não encontrado o diretorio: "+dir.getDiretorioVersao());
                        EnviarEmail();
                    }    
                }
                else{
                    model.setStatus(false);
                    atualizarTela("Problema com o comando FreeFileSync");
                    EnviarEmail();                }
            }
            else{
                model.setStatus(false);
                atualizarTela("Nenhuma ação será tomada! Diretorio "+dir.getDiretorioVersao()+" não existe!");
                EnviarEmail();
            }
            Thread.interrupted();
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
    public void EnviarEmail(){
        AlertaEmail email = new AlertaEmail();
        Thread thread = new Thread(email);
        thread.start();
    }
    //para enviar email
    public class AlertaEmail implements Runnable{
        @Override
        public void run(){
            FileLog logSync = new FileLog();//classe que trata o arquivo do log
            String arquivo = logSync.pegaArquivoMaisNovo(dir.getDiretorioDoLogBatch());//pegar o arquivo log mais novo
            atualizarTela("Ultimo log gerado: "+arquivo);
            File fileLog = new File(arquivo);
            ModelLog modelLog = new ModelLog();
            if(fileLog.isFile()){
                atualizarTela("Tratando arquivo!");
                logSync.lerLog(modelLog, arquivo);//iniciando tratamento do log
                ModelDao dao = new ModelDao();
                atualizarTela("Salvando log no banco de dados!Aguarde alguns minutos...");
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
                if(bat.getSalvarEmBanco()==1)
                {
                    if(dao.gravaLog(model, modelLog)){//gravar no banco de dados
                        List<String> lista = new ArrayList<>();
                        lista = modelLog.getDescricao();
                        atualizarTela("Concluindo...");
                        atualizarTela(+lista.size()+" novos registros foram salvos! Para consultar execute o TaskManager");
                    }else
                        atualizarTela("Falha ao salvar arquivo no banco de dados!");
                }
            }
            if(contas.getAviso()==1){
                String[] conta = contas.getEmail().split(";");
=======
                if(dao.gravaLog(model, modelLog)){//gravar no banco de dados
                    List<String> lista = new ArrayList<>();
                    lista = modelLog.getDescricao();
                    atualizarTela("Concluindo...");
                    atualizarTela(+lista.size()+" novos registros foram salvos! Para consultar execute o TaskManager");
                }else
                    atualizarTela("Falha ao salvar arquivo no banco de dados!");
            }
            if(contas.getAviso()==1){
                String[] conta = contas.getEmail().split(";|; ");
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                atualizarTela("Contas informadas: "+contas.getEmail());
                for (String conta1 : conta) {
                    if (conta1.equals("")) {break;}
                    atualizarTela("Enviando e-mail para: "+conta1);
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
=======
                    int tentativas = 1;
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                    Email email = new Email();
                    //email enviado
                    String status="SUCESSO",status2="", linhaExtra="";//a linha extra incrementa a frase caso alguma coisa tenha dado errado na sincronizacao
                    if(model.isStatus()==true){
                        if(modelLog.getStatusSync().contains("Sucesso") || modelLog.getStatusSync().contains("Interrompido")){
                            status = "SUCESSO";
                            if(modelLog.getStatusSync().contains("Interrompido")){
                                linhaExtra="Arquivos Pendentes: "+modelLog.getElementosRestantes()
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
                                    +"\nTamanho dos Arquivos(MB): "+modelLog.getTamanhoRestante();
                            }
                        }
                        else if(modelLog.getStatusSync().contains("Erro")){
                            double porcentagem = modelLog.getPorcentagemSuceso();
                            //calculo para pegar qual a porcentagem de arquivo backupeado
                            DecimalFormat df2 = new DecimalFormat("##.##");
                            //---double novo = Double.parseDouble((df2.format(porcentagem)).replace(",", "."));
                            status=df2.format(porcentagem)+"% Sincronizado";
                            status2="\nÉ provavel que algum arquivo estava sendo usado no momento da sincronização e não pôde ser copiado,\n"
                                    + "Não se preocupe, ele deverá entrar no proximo backup agendado!";
                            linhaExtra="Arquivos Pendentes: "+modelLog.getElementosRestantes()
                                +"\nTamanho dos Arquivos: "+modelLog.getTamanhoRestante()+"\n";
=======
                                    +"\tTamanho dos Arquivos: "+modelLog.getTamanhoRestante();
                            }
                        }
                        else if(modelLog.getStatusSync().contains("Erro")){
                            int porcentagem = 100 - (modelLog.getElementosRestantes()*100)
                                    /(modelLog.getElementos()+modelLog.getElementosRestantes());
                            //calculo para pegar qual a porcentagem de arquivo backupeado
                            status=porcentagem+"% Sincronizado";
                            status2="\nAlgum arquivo estava sendo usado no momento da transferencia e não pode ser copiado,\n"
                                    + "Não se preocupe, ele deverá entrar no proximo backup agendado!";
                            
                            linhaExtra="Arquivos Pendentes: "+modelLog.getElementosRestantes()
                                +"\tTamanho dos Arquivos: "+modelLog.getTamanhoRestante();
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                        }
                        else
                            status="ERRO";
                    }
                    else
                        status = "ERRO";
                    String mensagem = "O TaskChild terminou a rotina diaria com "+status+"!"+status2
                            +" Detalhes abaixo!\n\n"
                            +"Resumo do Backup:\n"
                            +"Status da Sincronização: "+modelLog.getStatusSync()+"!\n"
                            +"Arquivos Modificados/Excluidos: "+modelLog.getElementos()+"\n"
                            +"Tamanho dos Arquivos(MB): "+modelLog.getTamanhoElementos()+"\n"
                            +linhaExtra
                            +"Tempo de Execução: "+modelLog.getTempoTotal()+"\n\n"
                            +"Tarefa em paralelo:\n\n"
                            +jTextArea1.getText();
                    //tentando enviar e-mail por 3 vezes, caso falhe, gravarei log e irei sair
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
                    for(int i=0; ;i++){
=======
                    while(email.enviarEmail(arquivo, status, mensagem, conta1)==false){
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                        try {
                            if(email.enviarEmail(arquivo, status, mensagem, conta1.trim())==true) break; //sair se conseguir enviar o alerta
                            else if(i<3){//tentará realizar 3 envios, se falhar vai encerrar programa
                                int time = 600;
                                Thread.sleep(time*1000);
                            }
                            else{
                                atualizarTela("Numero de tentativas se esgotou! Necessita de intervenção humana!");
                                gravaLog();
                                System.exit(0);
                            }
                        } catch (InterruptedException ex) {
                            atualizarTela("Falha, o processo foi interrompido");
                        }
                    }
<<<<<<< HEAD:taskChild-App/src/br/com/tiagods/controller/ControllerMenu.java
=======
                    
>>>>>>> origin/master:src/br/com/tiagods/controller/ControllerMenu.java
                    atualizarTela("Email enviado com sucesso!");
                }
            }
            try {
                gravaLog();
                FileOrganizar organizar = new FileOrganizar(model);
                File fileDest = new File(dir.getDiretorioDoLog()+"\\"+fileLog.getName());
                organizar.moverLog(fileLog, fileDest);
                organizar.limparPasta(dir.getDiretorioDoLog());
                Thread.sleep(30*1000);
            } catch (InterruptedException ex) {
                atualizarTela("Falha, o processo foi interrompido");
            } finally{
                System.exit(0);
            }
        }
    }
    
    void gravaLog(){
        //gerar um arquivo de log por segurança do sistema
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
