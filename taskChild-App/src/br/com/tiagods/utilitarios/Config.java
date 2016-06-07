/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.ModelBat;
import br.com.tiagods.model.ModelConta;
import br.com.tiagods.model.ModelDiretorios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Tiago
 */
public class Config {
    File file;
    FileWriter fWriter;
    String dirConfig ="config.properties";
    
    public String lerArquivos(ModelBat bat, ModelConta conta, ModelDiretorios diretorios){
        file = new File(dirConfig);
        criarConfig();
        
        Properties properties;
        try{
            properties = new Properties();
            FileInputStream stream = new FileInputStream(dirConfig);
            properties.load(stream);
            
            diretorios.setDiretorioDoLog(trataValores(properties.getProperty("DiretorioDoLog")));
            diretorios.setDiretorioDoLogBatch(trataValores(properties.getProperty("DiretorioDoLogBatch")));
            diretorios.setDiretorioInstalacao(trataValores(properties.getProperty("DiretorioDoExecutavel")));
            diretorios.setDiretorioRar(trataValores(properties.getProperty("DiretorioDoRar")));
            diretorios.setDiretorioDosArquivos(trataValores(properties.getProperty("DiretorioDosArquivos")));
            diretorios.setDiretorioDoBatch(trataValores(properties.getProperty("DiretorioDoBatch")));
            diretorios.setDiretorioVersao(trataValores(properties.getProperty("DiretorioVersao")));
            diretorios.setDiretorioDestinoVersaoRar(trataValores(properties.getProperty("DiretorioDestinoVersaoRar")));
            bat.setNome(properties.getProperty("NomeDoBat"));
            bat.setExtensao(properties.getProperty("ExtensaoDoBat"));
            bat.setDeleteRar(properties.getProperty("DeleteRar"));
            conta.setEmail(properties.getProperty("Contas"));
            bat.setDiaCopia(properties.getProperty("DiaCopia"));
            try{
                bat.setHabilitarCopia(Integer.parseInt(properties.getProperty("HabilitarCopia")));
                bat.setTempoEspera(Integer.parseInt(properties.getProperty("TempoExecucao")));
                bat.setSalvarEmBanco(Integer.parseInt(properties.getProperty("SalvarEmBanco")));
            conta.setAviso(Integer.parseInt(properties.getProperty("Avisos")));
                //System.out.println(conta.getAviso());
            }catch(NumberFormatException e){
                criarConfig();
                return lerArquivos(bat, conta, diretorios);
            }
            stream.close();
            return "Arquivo config legivel!";
        }catch(IOException e){}
        return "";
    }
    private String trataValores(String valor){
        if(valor.length()==0) 
            return System.getProperty("user.dir");
        else{
            return valor.replace("\"", "").replace("/", "\\");
        }
    }
    private boolean criarConfig(){
        if(!file.exists()){
            try{
                file.createNewFile();
                fWriter= new FileWriter(dirConfig, true);
                String str ="#Regras: \n" +
                            "#.Para caminhos use \\\\ no lugar de \\\n" +
                            "#.Se for em rede \\\\\\\\ no lugar de \\\\\n" +
                            "#.Não precisa informar aspas(\") \n" +
                            "#.Para localização dentro do diretorio do sistema deixe em branco\n" +
                            "#Deixar Diretorios em branco se mesma localização do sistema\n" +
                            "#Diretorio pai onde ficarao os arquivo compactados, pastas de anos e meses serao criados automaticamente deixar vazio se caminho for o mesmo onde fica o sistema\n" +
                            "DiretorioDosArquivos=c:\\\\Arquivos\n" +
                            "#Declarar onde fica o arquivo da rotina do FreeFileSync\n" +
                            "DiretorioDoBatch=\n" +
                            "#Diretorio dos arquivos de log do sistema\n" +
                            "DiretorioDoLog=log\n" +
                            "#Diretorio dos arquivos de log do arquivo bat\n" +
                            "DiretorioDoLogBatch=C:\\\\log\n" +
                            "#Diretorio das versoes\n" +
                            "DiretorioVersao=C:\\\\teste\n" +
                            "#Diretorio do Compactador .rar\n" +
                            "DiretorioDoRar=C:\\\\Program Files\\\\WinRAR\n" +
                            "#Opcao do WinRar deletar(-DF) ou mandar para lixeira (-DR)? -DF ou -DR\n" +
                            "DeleteRar=-DF\n" +
                            "#Caminho do executavel FreeFileSync\n" +
                            "DiretorioDoExecutavel=C:\\\\Program Files\\\\FreeFileSync\\\\FreeFileSync.exe\n" +
                            "#Nome do arquivo bat sem extensao do dia\n" +
                            "NomeDoBat=versao\n" +
                            "#Extensao do arquivo, .bat ou .batch\n" +
                            "ExtensaoDoBat=.ffs_batch\n" +
                            "#Tempo de espera do backup em minutos\n" +
                            "TempoExecucao=2400\n" +
                            "#Habilitar copia automatica dos arquivos .rar 0=Não 1=Sim para diretorio\n" +
                            "HabilitarCopia=0\n" +
                            "#Copia automatica dos arquivos de versao .rar do mes anterior todo dia ?\n" +
                            "DiaCopia=1\n" +
                            "#Diretorio destino para copia dos arquivos .rar\n" +
                            "DiretorioDestinoVersaoRar=C:\\\\Backup\n" +
                            "#Receber log por e-mail 0=Nao, 1=Sim, \n" +
                            "Avisos=1\n" +
                            "#Conta's de e-mail(no maximo 3) separado por ponto e virgula (;)\n" +
                            "Contas=tiago.dias@prolinkcontabil.com.br"+
                            "#Salvar Log de em banco de dados? 1-Sim, 0-Nao\n"+
                            "SalvarEmBanco=1";
                fWriter.write(str);
                fWriter.close();
                return true;
            }catch(IOException e){
                System.out.println("Falha ao criar o arquivo config!");
                return false;
            }
            
        }
        return true;
    }
}
