/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.controller;

import br.com.tiagods.model.DetalhesDao;
import br.com.tiagods.model.GeralDao;
import br.com.tiagods.model.GraficosDao;
import br.com.tiagods.model.ModelBat;
import br.com.tiagods.model.ModelConta;
import br.com.tiagods.model.ModelDiretorios;
import br.com.tiagods.model.ModelTabelaDetalhes;
import br.com.tiagods.model.ModelTabelaGeral;
import br.com.tiagods.utilitarios.Config;
import br.com.tiagods.utilitarios.Graficos;
import static br.com.tiagods.view.MenuView.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 * @author Tiago
 */
public class ControllerManager implements ActionListener, MouseListener{
    
    Config config;
    ModelBat bat;
    ModelDiretorios dir;
    ModelConta conta;
    ModelTabelaGeral jtableGeral;
    ModelTabelaDetalhes jtabledetalhes;
    
    GeralDao geralDao = new GeralDao();
    DetalhesDao detalhesDao = new DetalhesDao();
    
    boolean backup_excluirRar, backup_habilitarCopia, backup_receberAviso;
    String[] backupCampos;
        
    public void iniciar(){
        bat = new ModelBat();
        dir = new ModelDiretorios();
        conta = new ModelConta();
        jtableGeral=new ModelTabelaGeral();
        jtabledetalhes=new ModelTabelaDetalhes();
        
        config =  new Config();
        config.lerArquivos(bat, conta, dir);
        iniciarJTableGeral();
        enviarTexto();//enviar valores para a tela
        abrirGraficos();
        desabilitarCampos();
    }
    public void iniciarJTableGeral(){
        geralDao.listarGeral();
        try {
            jtableGeral.setResult(geralDao.resultset);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela geral!");
        }
        tbRotinas.setModel(jtableGeral);
        tbRotinas.getColumnModel().getColumn(0).setMaxWidth(50);
        geralDao.fechar();
    }
    private void iniciarDetalhes(){
        //campos de data
        Date dataIn=dataDetalhesIn.getDate();
        Date dataFim=dateDetalhesFim.getDate();
        if(dataIn.getTime()<=dataFim.getTime())
            buscarDetalhes();
        else
            JOptionPane.showMessageDialog(null,"Campo informado em data esta incorreto!");
    }
    private void buscarDetalhes(){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String dataIn = sdf.format(dataDetalhesIn.getDate());
       String dataFim = sdf.format(dateDetalhesFim.getDate());
       
       String sql = "SELECT A.ID, A.ID_ROTINA, A.HORA, A.DETALHES " +
                    "FROM DETALHES_ROTINAS AS A " +
                    "INNER JOIN ROTINAS AS B ON " +
                    "A.ID_ROTINA=B.ID " +
                    "where A.DETALHES like '%"+txBuscaDetalhes.getText()+"%' " +
                    "AND B.DATA BETWEEN '"+dataIn+" 00:00:00' " +
                    "AND '"+dataFim+" 23:59:59'";
       detalhesDao.buscarDetalhes(sql);
        try {
            jtabledetalhes.setResult(detalhesDao.resultset);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Detalhes!");
            ex.printStackTrace();
        }
        tbDetalhes.setModel(jtabledetalhes);
        tbDetalhes.getColumnModel().getColumn(0).setMaxWidth(50);
        tbDetalhes.getColumnModel().getColumn(1).setMaxWidth(90);
        detalhesDao.fechar();
    }
    //chamar graficos
    public void abrirGraficos(){
        GraficosDao sqlGrafico = new GraficosDao();
        sqlGrafico.buscarGrafico("select DATA, QUANTIDADE from ROTINAS group by Data order by Data desc limit 20");
        carregarGrafico(panProcessados, sqlGrafico.resultset, "Arquivos Processados nos Ultimos 20 dias");//criar graficos
        sqlGrafico.buscarGrafico("select DATA, QUANTIDADE_RESTANTE from ROTINAS group by Data order by Data desc limit 20");
        carregarGrafico(panNProcessados, sqlGrafico.resultset,"Arquivos Processados com Erros nos Ultimos 20 dias");
        sqlGrafico.fechar();
    }
    //criar graficos
    private void carregarGrafico(JPanel jpanel, ResultSet resultSet, String status){
        Graficos graficos = new Graficos();
        graficos.gerarGrafico(jpanel, resultSet, status);
    }
    
    //enviar texto para tela
    private void enviarTexto(){
        String[] camposDoArquivo = camposArquivo();
        int i = 0;
        for(JTextField jtextField : campos()){
            jtextField.setText(camposDoArquivo[i]);
            i++;
        }
        if(bat.getDeleteRar().equalsIgnoreCase("-DF"))
            rbExcluirCompactados.setSelected(true);
        else
            rbLixeiraCompactados.setSelected(true);
        if(bat.getHabilitarCopia()==1)
            rbHabilitarCopia.setSelected(true);
        else
            rbNaoHabilitarCopia.setSelected(true);
        if(conta.getAviso()==1)
            rbReceberAviso.setSelected(true);
        else
            rbNaoReceberAviso.setSelected(true);
    }
    
    private String[] camposArquivo(){
        String[] campos = {dir.getDiretorioVersao().replace("/", "\\"),dir.getDiretorioDosArquivos().replace("/", "\\"), 
            dir.getDiretorioDestinoVersaoRar().replace("/", "\\"),dir.getDiretorioInstalacao().replace("/", "\\"),
            dir.getDiretorioDoBatch().replace("/", "\\"),dir.getDiretorioDoLogBatch().replace("/", "\\"),
            dir.getDiretorioDoLog().replace("/", "\\"),dir.getDiretorioRar().replace("/", "\\"),
            bat.getNome(),bat.getExtensao(),String.valueOf(bat.getTempoEspera()),
            String.valueOf(bat.getDiaCopia()),conta.getEmail()
        };
        return campos;
    }
    //campos do menu configurações
    private JTextField[] campos(){
        JTextField[] textfield = {txDirArqVersoes,txDirArquivosRar,txDirBackup,
            txDirFileSync,txDirBat,txDirLogBat,txDirLogThis,txDirWinRar,txNomeBat,
            txExtensaoBat,txTempoEspera,txDiaCopia,txEmails};
        return textfield;
    }
    //campos do radiobutton
    private JRadioButton[] camposButton(){
        JRadioButton[] campos = {rbExcluirCompactados, rbLixeiraCompactados, 
        rbHabilitarCopia,rbNaoHabilitarCopia,rbReceberAviso,rbNaoReceberAviso};
        return campos;
    }
    private JButton[] botoesDiretorio(){
        JButton[] botoes = {btAlterarConfig, btArquivoBat,btArquivosCompactados,
            btArquivosVersoes,btBat,btFileSync,btLogBat,btLogThis,btWinrar,
            btnCancelarConfig,btnSalvarConfig};
            return botoes;
    }
    //desabilitar campos em configurações
    private void desabilitarCampos(){
        JTextField[] textField = campos();
        for(JTextField textfield : textField)
            textfield.setEnabled(false);
        JRadioButton[] radioButton = camposButton();
        for(JRadioButton radio : radioButton)
            radio.setEnabled(false);
        JButton[] jbutton = botoesDiretorio();
        for(JButton botao : jbutton)
            botao.setEnabled(false);
        btnCancelarConfig.setEnabled(false);
        btnSalvarConfig.setEnabled(false);
        btAlterarConfig.setEnabled(true);
    }
    //habilitar campos em configurações
    private void habilitarCampos(){
        JTextField[] textField = campos();
        for(JTextField textfield : textField)
            textfield.setEnabled(true);
        JRadioButton[] radioButton = camposButton();
        for(JRadioButton radio : radioButton)
            radio.setEnabled(true);
        JButton[] jbutton = botoesDiretorio();
        for(JButton botao : jbutton)
            botao.setEnabled(false);
        btnCancelarConfig.setEnabled(true);
        btnSalvarConfig.setEnabled(true);
        btAlterarConfig.setEnabled(false);
    }
    //backup da tela de configurações
    private void gerarBackup(){
        JTextField[] textField = campos();
        int i = 0;
        for(JTextField textfield : textField){
            backupCampos[i] = textfield.getText();
            i++;
        }
        backup_excluirRar = rbExcluirCompactados.isSelected();
        backup_habilitarCopia = rbHabilitarCopia.isSelected();
        backup_receberAviso = rbReceberAviso.isSelected();
        
    }
    //restaurar backup da tela de configurações
    private void restaurarBackup(){
        JTextField[] textField = campos();
        int i = 0;
        for(JTextField textfield : textField){
            textfield.setText(backupCampos[i]);
            i++;
        }
        if(backup_excluirRar==true)
            rbExcluirCompactados.setSelected(true);
        else
            rbLixeiraCompactados.setSelected(true);
        if(backup_habilitarCopia==true)
            rbHabilitarCopia.setSelected(true);
        else
            rbNaoHabilitarCopia.setSelected(true);
        if(backup_receberAviso==true)
            rbReceberAviso.setSelected(true);
        else
            rbNaoReceberAviso.setSelected(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "1":
                setText(txDirArqVersoes, getLocal());
                break;
            case "2":
                setText(txDirArquivosRar, getLocal());
                break;
            case "3":
                setText(txDirBackup, getLocal());
                break;
            case "4":
                setText(txDirFileSync, getLocal());
                break;
            case "5":
                setText(txDirBat, getLocal());
                break;
            case "6":
                setText(txDirLogBat, getLocal());
                break;
            case "7":
                setText(txDirLogThis, getLocal());
                break;
            case "8":
                setText(txDirWinRar, getLocal());
                break;
            case "Alterar":
                habilitarCampos();
                gerarBackup();
                break;
            case "Cancelar":
                desabilitarCampos();
                restaurarBackup();
                break;
            case "Salvar":
                if(salvar())
                    desabilitarCampos();
                break;
            case "CampoDetalhes":
                if(!txBuscaDetalhes.getText().trim().equals(""))
                    iniciarDetalhes();
                break;
            case "Indefinido2":
                break;
            case "Indefinido3":
                break;
        }
        
    }
    
    private boolean salvar(){
        if(iniciarCaptura()){
            dir.setDiretorioVersao(txDirArqVersoes.getText().replace("\\", "/"));
            dir.setDiretorioDosArquivos(txDirArquivosRar.getText().replace("\\", "/"));
            dir.setDiretorioDestinoVersaoRar(txDirBackup.getText().replace("\\", "/"));
            dir.setDiretorioInstalacao(txDirFileSync.getText().replace("\\", "/"));
            dir.setDiretorioDoBatch(txDirBat.getText().replace("\\", "/"));
            dir.setDiretorioDoLogBatch(txDirLogBat.getText().replace("\\", "/"));
            dir.setDiretorioDoLog(txDirLogThis.getText().replace("\\","/"));
            dir.setDiretorioRar(txDirWinRar.getText().replace("\\","/"));
            if(rbExcluirCompactados.isSelected())
                bat.setDeleteRar("-DF");
            else
                bat.setDeleteRar("-DR");
            bat.setNome(txNomeBat.getText());
            
            bat.setExtensao(txExtensaoBat.getText());
            bat.setTempoEspera(Integer.parseInt(txTempoEspera.getText()));
            
            if(rbHabilitarCopia.isSelected())
                bat.setHabilitarCopia(1);
            else
                bat.setHabilitarCopia(0);
            
            bat.setDiaCopia(txDiaCopia.getText());
            
            if(rbReceberAviso.isSelected())
                conta.setAviso(1);
            else
                conta.setAviso(0);
            conta.setEmail(txEmails.getText());
            
            Config config = new Config();
            config.criarConfig(dir, bat, conta);
            return true;
        }
        else
            return false;
    }
    //inicia tratamento antes de salvar
    private boolean iniciarCaptura(){
        JTextField[] textfield = {txDirArqVersoes,txDirArquivosRar,txDirBackup,
            txDirFileSync,txDirBat,txDirLogBat,txDirLogThis,txDirWinRar};
        for(JTextField textField : textfield){
            if(!textField.getText().equals("")){
                File diretorio = new File(textField.getText());
                if(!diretorio.exists()){
                    JOptionPane.showMessageDialog(null, "Diretorio "+diretorio+" não existe, informe outro local e tente de novo!");
                    return false;
                }
            }
        }
        //verificar se o campo dia de copia foi preenchido
        if(rbHabilitarCopia.isSelected()){
            if(txDiaCopia.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null, "Informe um ou mais dias para copia backup!");
                return false;
            }
        }
        //verificar se o campo email esta em branco
        if(rbReceberAviso.isSelected()){
            if(txEmails.getText().trim().length()==0){
                JOptionPane.showMessageDialog(null, "Informe um ou mais e-mail para receber os relatorios!");
                return false;
            }
        }
        //verificar nome do arquivo
        if(txNomeBat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nome do arquivo bat incorreto, informe um nome!");
            return false;
        }
        //verificar extensao do arquivo
        if(txExtensaoBat.getText().trim().equals("") || !txExtensaoBat.getText().contains(".")){
            JOptionPane.showMessageDialog(null, "Extensao do arquivo bat informado esta incorreto!");
            return false;
        }
        return true;
    }
    
    //enviar caminho para o jtextfield
    public void setText(JTextField textField, String local){
        if(!local.equals(""))
            textField.setText(local);
    }
    //pega o caminho informado
    public String getLocal(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Selecione um diretorio!");
        int retorno = chooser.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile().getAbsolutePath();
        else
            return "";
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String codigoLinha = (String) jtableGeral.getValueAt(tbRotinas.getSelectedRow(), 0);
        detalhesDao.listarClique(codigoLinha);
        try {
            jtabledetalhes.setResult(detalhesDao.resultset);
        } catch (SQLException ex) {
        }
        tbDetalhes.setModel(jtabledetalhes);
        tbDetalhes.getColumnModel().getColumn(0).setMaxWidth(50);
        tbDetalhes.getColumnModel().getColumn(1).setMaxWidth(90);
        detalhesDao.fechar();
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
