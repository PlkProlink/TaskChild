/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolinkcontabil.utilitarios;

import br.com.prolinkcontabil.model.ModelDiretorios;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tiago
 */
public class Config {
    File file;
    FileWriter fWriter;
    
    public boolean criarConfig(ModelDiretorios diretorios){
        if(!file.exists()){
            try{
            file.createNewFile();
            fWriter= new FileWriter(diretorios.getDiretorioDoConfig()+"/config.txt", true);
            String str ="#Diretorio do arquivo de configuração, esse arquivo, deixar vazio se caminho for o mesmo onde fica o sistema\n" +
                        "DiretorioDoConfig=\n" +
                        "#Declarar onde fica os arquivos da rotina, deixar vazio se caminho for o mesmo onde fica o sistema\n" +
                        "DiretorioDosArquivos=\n" +
                        "#Diretorio dos arquivos de log, por padrao fica no mesmo diretorio do sistema\n" +
                        "DiretorioDoLog=log\n" +
                        "#Diretorio dos arquivos de log do arquivo bat\n" +
                        "DiretorioDoLogBatch=logBat\n" +
                        "#Nome do arquivo bat sem extensao do dia\n" +
                        "NomeDoBat=versao\n" +
                        "#Extensao do arquivo, .bat ou .batch\n" +
                        "ExtensaoDoBat=.batch\n" +
                        "#Receber log por e-mail 0=Nao, 1=Sim, \n" +
                        "Avisos=0\n" +
                        "#Conta's de e-mail(no maximo 3) separado por ponto e virgula (;)\n" +
                        "Contas=suporte.ti@prolinkcontabil.com.br";
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
