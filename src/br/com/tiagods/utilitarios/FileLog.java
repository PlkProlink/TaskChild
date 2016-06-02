/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import br.com.tiagods.model.Model;
import br.com.tiagods.model.ModelLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class FileLog {
    List<String> hora = new ArrayList<>();
    List<String> descricao = new ArrayList<>();
    
    //funcao para retornar o arquivo mais novo do diretorio
    public String pegaArquivoMaisNovo(String diretorioDoLog){
        File file = new File(diretorioDoLog);
        File[] files = file.listFiles();
        String arquivoRecente="";
        int i=0;
        if(files.length==0)//se estiver fazio retorno falso
            return "";
        else{
            for(File f : files){
                if(i==0)//setar o primeiro arquivo encontrado como mais novo como contador i
                    arquivoRecente = f.getAbsolutePath();
                else{//indico que irei comparar
                    File file2 = new File(arquivoRecente);
                    if(f.lastModified()>file2.lastModified()){
                        arquivoRecente = f.getAbsolutePath();//assumindo arquivo mais recente modificado
                    }
                }
                i++;
            }
            return arquivoRecente;
        }
    }
    
    //metodo para ler o arquivo pego pelo metodo pegaArquivo mais novo
    public boolean lerLog(ModelLog log, String arquivo){
        if(!arquivo.equals("")){
            File file = new File(arquivo);
            try{
                if(file.isFile()){
                    if(file.getName().contains(".txt") || file.getName().contains(".log")){
                        BufferedReader ler = ler(file.getAbsoluteFile());
                        String linha = ler.readLine();
                        String[] valor;
        
                        int num =0;
                        while(linha!=null){
                            if(num==1){//linha do status
                                valor = linha.split(":");
                                if(valor[1].contains("interrompida"))
                                    log.setStatusSync("Interrompido");
                                else if(valor[1].contains("erros"))
                                    log.setStatusSync("Erro");
                                else
                                    log.setStatusSync("Sucesso");
                            }
                            if(num>1){
                                if(num==3){
                                    //verificando a ª4 linha
                                    if(linha.contains("Elementos processados")){//usar metodo para quebrar elementos
                                        valor = quebraElementos(linha);
                                        log.setElementos(Integer.parseInt(valor[0]));
                                        log.setTamanhoElementos(convertToMb(valor[1].replace(",",".")));
                                    }
                                }
                                if(num==4){
                                    if(linha.contains("Elementos restantes")){
                                        valor = quebraElementos(linha);
                                        log.setElementosRestantes(Integer.parseInt(valor[0]));
                                        log.setTamanhoRestante(convertToMb(valor[1].replace(",",".")));
                                    }
                                    else if(linha.contains("Tempo"))//se a informação do tempo não estiver na 4 linha estara na 5ª obrigatoriamente
                                        log.setTempoTotal(quebraTempo(linha));
                                }
                                if(num==5){
                                    if(linha.contains("Tempo"))
                                        log.setTempoTotal(quebraTempo(linha));
                                }
                                else if(linha.contains("[") && linha.contains("]") && !linha.contains("->")
                                        && !linha.contains("Sincronização finalizada") //ignorando a ultima linha do arquivo
                                        && !linha.contains("Sincronização interrompida"))
                                    quebraDetalhes(linha);

                            }
                            linha = ler.readLine();
                            num++;
                        }
                        log.setHora(hora);
                        log.setDescricao(descricao);
                    }
                    else
                        return false;
                }
                return true;
            }catch(IOException e){
                e.printStackTrace();
                return false;
            }
        }
        else
            return false;
    }
    
    private BufferedReader ler(File file) throws FileNotFoundException{
        FileReader reader = new FileReader(file);
        BufferedReader ler  = new BufferedReader(reader);
        return ler;
    }
    
    //trata as linhas que contem hora e descrição
    private void quebraDetalhes(String linha){
        String[] novo = linha.split("]");
        hora.add(novo[0]
                .replace("[", "").trim());
        descricao.add(novo[1].trim());
    }
    //trata as linhas que contem informação dos elementos processados
    private String[] quebraElementos(String linha){
        String[] valor = linha.split(":");
        valor[1] = valor[1].replace("(","=").replace("|", "");//trocar para = pois dive problema com split de parenteses
        valor = valor[1].split("=");//dividindo a 2 string em 2
        valor[0]=valor[0].replace(".", "").trim();//pegando quantidade de arquivos
        valor[1]=valor[1].replace(")", "").trim();//pegando o tamanho
        return valor;
    }
    //trata a linha de informação do tempo em execucao
    private String quebraTempo(String linha){
        String[] valor = linha.split(":");
        valor[0]="";
        String tempo="";
        int m=0;
            do{//loop para incrementar o tempo
                if(m>0){
                    tempo=valor[m].trim()+":";
                    m++;
                    tempo+=valor[m].trim()+":";
                    m++;
                    tempo+=valor[m].replace("|", "").trim();
                    break;
                }
                m++;
            }while(m<valor.length);
        return tempo;
    }
    //trata e converte para MegaByte a linha que informa o tamanho dos arquivos
    private String convertToMb(String valor){//converter para megabytes
        String novo;
        if(valor.contains("TB")){
            String aux = valor.replace("TB", "").replace("|", "").trim();
            novo = String.valueOf((Double.parseDouble(aux)*1024)*1024);
        }
        else if(valor.contains("GB")){
            String aux = valor.replace("GB", "").replace("|", "").trim();
            novo = String.valueOf(Double.parseDouble(aux)*1024);
        }
        else if(valor.contains("KB")){
            String aux = valor.replace("KB", "").replace("|", "").trim();
            novo = String.valueOf(Double.parseDouble(aux)/1024); 
        }
        else if(valor.contains("bytes")){
            String aux = valor.replace("bytes", "").replace("|", "").trim();
            novo = String.valueOf((Double.parseDouble(aux)/1024)/1024);
        }
        else 
            novo = valor.replace("MB", "").replace(",", ".").replace("|", "").trim();
        return novo; 
    }
}
