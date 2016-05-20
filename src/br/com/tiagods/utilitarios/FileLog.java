/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.ModelDiretorios;
import br.com.tiagods.model.ModelLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author User
 */
public class FileLog {
    //funcao para retornar o arquivo mais novo do diretorio
    public String pegaArquivoMaisNovo(String diretorioDoLog){
        File file = new File(diretorioDoLog);
        File[] files = file.listFiles();
        String arquivoRecente="";
        int i=0;
        for(File f : files){
            if(i==0)
                arquivoRecente = f.getAbsolutePath();
            else{
                File file2 = new File(arquivoRecente);
                if(f.lastModified()>file2.lastModified()){
                    arquivoRecente = f.getAbsolutePath();
                }
            }
            i++;
        }
        return arquivoRecente;
    }
    //metodo para ler o arquivo pego pelo metodo pegaArquivo mais novo
    public boolean lerLog(ModelLog log, File file){
        try{
            if(file.isFile()){
                if(file.getName().contains(".txt") || file.getName().contains(".log")){
                    BufferedReader ler = ler(file.getAbsoluteFile());
                    String linha = ler.readLine();

                    String[] info = null; //pegara os dados de status
                    String elementos = null;//linha de quantidade e tamanho
                    String tempo = null;//tempo de trabalho
                    int num=0;

                    while(linha!=null){
                        if(num==1)
                            info=linha.split(":");//separar, mas vou excluir informações de data, isso não é importante para mim
                        else if(num==3)//linha de quantidade
                            elementos=linha.replace("|", "").trim();
                        else if(num==4)//linha de tempo
                            tempo=linha.replace("|", "").trim();
                        else if(linha.contains("[") && linha.contains("]") && !linha.contains("->")){
                            acionaEGrava(linha, log);
                        }
                        linha = ler.readLine();
                        num++;
                    }
                    log.setStatusSync(info[1].replace("Sincronização","").trim());
                    log.setElementosProcessados(elementos.replace("Elementos processados:", "").trim());
                    log.setTempoTotal(tempo.replace("Tempo total:", "").trim());
                    imprimir(log);
                    return true;
                }
            }
        }catch(IOException e){e.printStackTrace();}
        return false;
    }
    //gravar valores na array
    private static void acionaEGrava(String valor, ModelLog log){
        String[] novo = valor.split("]");
        log.setHora(novo[0].replace("[", "").trim());
        log.setDescricao(novo[1].trim());
    }
    
    private static void imprimir(ModelLog log){
        System.out.println("Status: " +log.getStatusSync());
        System.out.println("Elementos: " +log.getElementosProcessados());
        System.out.println("Tempo: " +log.getTempoTotal());
//        List<String> listaHora = new ArrayList<>();
//        List<String> listaDescricao = new ArrayList<>();
//        listaHora = log.getHora();
//        listaDescricao = log.getDescricao();
//        for(int i =0; i<log.getHora().size() ; i++){
//            System.out.println(listaHora.get(i)+"\t"+listaDescricao.get(i));
//        }
                
    }
    private static BufferedReader ler(File file) throws FileNotFoundException{
        FileReader reader = new FileReader(file);
        BufferedReader ler  = new BufferedReader(reader);
        return ler;
    }
    
}
