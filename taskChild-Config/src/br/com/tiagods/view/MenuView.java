package br.com.tiagods.view;

import br.com.tiagods.controller.ControllerManager;
import com.sun.glass.events.KeyEvent;
/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
/**
 *
 * @author Tiago
 */
public class MenuView extends javax.swing.JFrame {

    ControllerManager controller;
    
    public MenuView() {
        controller =  new ControllerManager();
        initComponents();
        controller.iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRar = new javax.swing.ButtonGroup();
        groupCopia = new javax.swing.ButtonGroup();
        groupAvisos = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        license = new javax.swing.JLabel();
        direitos = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panInicio = new javax.swing.JPanel();
        lbBusca = new javax.swing.JLabel();
        ckSucesso = new javax.swing.JCheckBox();
        ckFalhou = new javax.swing.JCheckBox();
        ckInterrompido = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRotinas = new javax.swing.JTable();
        cbOrganizar = new javax.swing.JComboBox<>();
        lbOrganizar = new javax.swing.JLabel();
        rbCrescente = new javax.swing.JRadioButton();
        rbDecrescente = new javax.swing.JRadioButton();
        dateIn = new com.michaelbaranov.microba.calendar.DatePicker();
        dateFim = new com.michaelbaranov.microba.calendar.DatePicker();
        lbArquivos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetalhes = new javax.swing.JTable();
        tbVisao = new javax.swing.JLabel();
        lbBuscaDetalhes = new javax.swing.JLabel();
        txBuscaDetalhes = new javax.swing.JTextField();
        btOkDetalhes = new javax.swing.JButton();
        dataDetalhesIn = new com.michaelbaranov.microba.calendar.DatePicker();
        dateDetalhesFim = new com.michaelbaranov.microba.calendar.DatePicker();
        btOkGeral = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panProcessados = new javax.swing.JPanel();
        panNProcessados = new javax.swing.JPanel();
        panConfig = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txDirArqVersoes = new javax.swing.JTextField();
        txDirArquivosRar = new javax.swing.JTextField();
        txDirBackup = new javax.swing.JTextField();
        txDirFileSync = new javax.swing.JTextField();
        txDirLogThis = new javax.swing.JTextField();
        txDirWinRar = new javax.swing.JTextField();
        txDirBat = new javax.swing.JTextField();
        txDirLogBat = new javax.swing.JTextField();
        btWinrar = new javax.swing.JButton();
        btLogThis = new javax.swing.JButton();
        btArquivoBat = new javax.swing.JButton();
        btLogBat = new javax.swing.JButton();
        btBat = new javax.swing.JButton();
        btFileSync = new javax.swing.JButton();
        btArquivosVersoes = new javax.swing.JButton();
        btArquivosCompactados = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rbExcluirCompactados = new javax.swing.JRadioButton();
        rbLixeiraCompactados = new javax.swing.JRadioButton();
        txNomeBat = new javax.swing.JTextField();
        txExtensaoBat = new javax.swing.JTextField();
        txTempoEspera = new javax.swing.JTextField();
        rbHabilitarCopia = new javax.swing.JRadioButton();
        rbNaoHabilitarCopia = new javax.swing.JRadioButton();
        txDiaCopia = new javax.swing.JTextField();
        rbReceberAviso = new javax.swing.JRadioButton();
        rbNaoReceberAviso = new javax.swing.JRadioButton();
        txEmails = new javax.swing.JTextField();
        btAlterarConfig = new javax.swing.JButton();
        btnSalvarConfig = new javax.swing.JButton();
        btnCancelarConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 500));

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Task Child Manager");
        title.setToolTipText("");

        license.setBackground(new java.awt.Color(255, 255, 255));
        license.setForeground(new java.awt.Color(255, 255, 255));
        license.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        license.setText("Livre de Acordo com a GNU-GPL License");

        direitos.setForeground(new java.awt.Color(255, 255, 255));
        direitos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direitos.setText("Versão Disponível em: www.github.com/tiagods");

        lbBusca.setText("Busca:");

        ckSucesso.setText("Sucesso");

        ckFalhou.setText("Falhou");

        ckInterrompido.setText("Interrompido");

        tbRotinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "DATA", "STATUS", "ARQUIVOS", "TAMANHO(MB)", "TEMPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRotinas.addMouseListener(controller);
        jScrollPane1.setViewportView(tbRotinas);

        cbOrganizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Data", "Status", "Arquivos", "Tamanho", "Tempo" }));

        lbOrganizar.setText("Organizar por:");

        buttonGroup1.add(rbCrescente);
        rbCrescente.setText("Crescente");

        buttonGroup1.add(rbDecrescente);
        rbDecrescente.setText("Decrescente");

        dateIn.setShowNoneButton(false);
        dateIn.setShowNumberOfWeek(true);

        dateFim.setShowNoneButton(false);
        dateFim.setShowNumberOfWeek(true);

        lbArquivos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbArquivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbArquivos.setText("Arquivos do Periodo:");

        tbDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "DATA", "HORA", "DETALHES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDetalhes);
        if (tbDetalhes.getColumnModel().getColumnCount() > 0) {
            tbDetalhes.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbDetalhes.getColumnModel().getColumn(0).setMaxWidth(50);
            tbDetalhes.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbDetalhes.getColumnModel().getColumn(1).setMaxWidth(90);
            tbDetalhes.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbDetalhes.getColumnModel().getColumn(2).setMaxWidth(70);
        }

        tbVisao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbVisao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbVisao.setText("Visão Geral:");

        lbBuscaDetalhes.setText("Buscar Arquivo/Diretorio:");

        txBuscaDetalhes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txBuscaDetalhesPropertyChange(evt);
            }
        });
        txBuscaDetalhes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txBuscaDetalhesKeyPressed(evt);
            }
        });

        btOkDetalhes.setText("OK");
        btOkDetalhes.setActionCommand("CampoDetalhes");
        btOkDetalhes.addActionListener(controller);

        dataDetalhesIn.setShowNoneButton(false);
        dataDetalhesIn.setShowNumberOfWeek(true);
        dataDetalhesIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDetalhesInActionPerformed(evt);
            }
        });

        dateDetalhesFim.setShowNoneButton(false);
        dateDetalhesFim.setShowNumberOfWeek(true);

        btOkGeral.setText("OK");

        javax.swing.GroupLayout panInicioLayout = new javax.swing.GroupLayout(panInicio);
        panInicio.setLayout(panInicioLayout);
        panInicioLayout.setHorizontalGroup(
            panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addComponent(tbVisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOrganizar)
                    .addComponent(lbBusca))
                .addGap(18, 18, 18)
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panInicioLayout.createSequentialGroup()
                        .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOrganizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panInicioLayout.createSequentialGroup()
                                .addComponent(rbCrescente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbDecrescente))
                            .addComponent(dateFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panInicioLayout.createSequentialGroup()
                        .addComponent(ckFalhou)
                        .addGap(10, 10, 10)
                        .addComponent(ckSucesso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ckInterrompido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btOkGeral)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInicioLayout.createSequentialGroup()
                .addComponent(lbBuscaDetalhes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBuscaDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOkDetalhes)
                .addGap(46, 46, 46)
                .addComponent(dataDetalhesIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDetalhesFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(511, 511, 511))
        );
        panInicioLayout.setVerticalGroup(
            panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInicioLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOrganizar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOrganizar)
                    .addComponent(rbCrescente)
                    .addComponent(rbDecrescente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBusca)
                    .addComponent(dateFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckFalhou)
                    .addComponent(ckSucesso)
                    .addComponent(ckInterrompido)
                    .addComponent(btOkGeral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbVisao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataDetalhesIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbBuscaDetalhes)
                        .addComponent(txBuscaDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btOkDetalhes))
                    .addComponent(dateDetalhesFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbArquivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inicio", panInicio);

        panProcessados.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panProcessadosLayout = new javax.swing.GroupLayout(panProcessados);
        panProcessados.setLayout(panProcessadosLayout);
        panProcessadosLayout.setHorizontalGroup(
            panProcessadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        panProcessadosLayout.setVerticalGroup(
            panProcessadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        panNProcessados.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panNProcessadosLayout = new javax.swing.GroupLayout(panNProcessados);
        panNProcessados.setLayout(panNProcessadosLayout);
        panNProcessadosLayout.setHorizontalGroup(
            panNProcessadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panNProcessadosLayout.setVerticalGroup(
            panNProcessadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panNProcessados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panProcessados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panProcessados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panNProcessados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panNProcessados, panProcessados});

        jTabbedPane1.addTab("Historico", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Diretorios"));

        jLabel5.setText("Backup Externo:");

        jLabel6.setText("Arquivo Bat:");

        jLabel7.setText("Log do Bat:");

        jLabel8.setText("Log do TaskChild:");

        jLabel9.setText("Arquivos do FileSync(Versões):");

        jLabel10.setText("WinRaR:");

        jLabel11.setText("Arquivos Compactados:");

        jLabel12.setText("Programa Bat:");

        btWinrar.setText("...");
        btWinrar.setActionCommand("8");
        btWinrar.addActionListener(controller);
        btWinrar.setPreferredSize(new java.awt.Dimension(40, 20));

        btLogThis.setText("...");
        btLogThis.setActionCommand("7");
        btLogThis.addActionListener(controller);
        btLogThis.setPreferredSize(new java.awt.Dimension(40, 20));

        btArquivoBat.setText("...");
        btArquivoBat.setActionCommand("6");
        btArquivoBat.addActionListener(controller);
        btArquivoBat.setPreferredSize(new java.awt.Dimension(40, 20));

        btLogBat.setText("...");
        btLogBat.setActionCommand("6");
        btLogBat.addActionListener(controller);
        btLogBat.setPreferredSize(new java.awt.Dimension(40, 20));

        btBat.setText("...");
        btBat.setActionCommand("4");
        btBat.addActionListener(controller);
        btBat.setPreferredSize(new java.awt.Dimension(40, 20));

        btFileSync.setText("...");
        btFileSync.setActionCommand("3");
        btFileSync.addActionListener(controller);
        btFileSync.setPreferredSize(new java.awt.Dimension(40, 20));

        btArquivosVersoes.setText("...");
        btArquivosVersoes.setActionCommand("1");
        btArquivosVersoes.addActionListener(controller);
        btArquivosVersoes.setPreferredSize(new java.awt.Dimension(40, 20));

        btArquivosCompactados.setText("...");
        btArquivosCompactados.setActionCommand("2");
        btArquivosCompactados.addActionListener(controller);
        btArquivosCompactados.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txDirWinRar, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(txDirLogThis)
                    .addComponent(txDirLogBat)
                    .addComponent(txDirBat)
                    .addComponent(txDirFileSync)
                    .addComponent(txDirBackup)
                    .addComponent(txDirArquivosRar)
                    .addComponent(txDirArqVersoes))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btWinrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btLogThis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btLogBat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btArquivoBat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btFileSync, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btArquivosCompactados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btArquivosVersoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btArquivosVersoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btArquivosCompactados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btFileSync, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btArquivoBat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLogBat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLogThis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btWinrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txDirArqVersoes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txDirArquivosRar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(txDirBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txDirFileSync, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txDirBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDirLogBat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txDirLogThis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txDirWinRar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btArquivoBat, btArquivosCompactados, btArquivosVersoes, btBat, btFileSync, btLogBat, btLogThis, btWinrar, jLabel10, jLabel11, jLabel12, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, txDirArqVersoes, txDirArquivosRar, txDirBackup, txDirBat, txDirFileSync, txDirLogBat, txDirLogThis, txDirWinRar});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Outras Configurações"));

        jLabel13.setText("Tempo de Espera do Bat:");

        jLabel14.setText("Extensão do Bat:");

        jLabel15.setText("Habilitar Copia Backup:");

        jLabel16.setText("Copia Backup Todo Dia:");

        jLabel17.setText("Receber Avisos?:");

        jLabel18.setText("Arquivos Pos Compactados - Excluir ou Lixeira?");

        jLabel19.setText("Nome do Bat:");

        jLabel20.setText("Conta's:");

        groupRar.add(rbExcluirCompactados);
        rbExcluirCompactados.setText("Excluir");

        groupRar.add(rbLixeiraCompactados);
        rbLixeiraCompactados.setText("Lixeira");

        groupCopia.add(rbHabilitarCopia);
        rbHabilitarCopia.setText("Sim");

        groupCopia.add(rbNaoHabilitarCopia);
        rbNaoHabilitarCopia.setText("Não");

        groupAvisos.add(rbReceberAviso);
        rbReceberAviso.setText("Sim");

        groupAvisos.add(rbNaoReceberAviso);
        rbNaoReceberAviso.setText("Não");

        btAlterarConfig.setText("Alterar");
        btAlterarConfig.setActionCommand("Alterar");
        btAlterarConfig.addActionListener(controller);

        btnSalvarConfig.setText("Salvar");
        btnSalvarConfig.setActionCommand("Salvar");
        btnSalvarConfig.addActionListener(controller);

        btnCancelarConfig.setText("Cancelar");
        btnCancelarConfig.setActionCommand("Cancelar");
        btnCancelarConfig.addActionListener(controller);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(rbExcluirCompactados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbLixeiraCompactados))
                            .addComponent(txNomeBat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txExtensaoBat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTempoEspera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rbHabilitarCopia)
                                .addGap(18, 18, 18)
                                .addComponent(rbNaoHabilitarCopia))
                            .addComponent(txDiaCopia, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rbReceberAviso)
                                .addGap(18, 18, 18)
                                .addComponent(rbNaoReceberAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txEmails, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                        .addComponent(btAlterarConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarConfig)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterarConfig, btnCancelarConfig, btnSalvarConfig});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(rbExcluirCompactados)
                            .addComponent(rbLixeiraCompactados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txNomeBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txExtensaoBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rbHabilitarCopia)
                            .addComponent(rbNaoHabilitarCopia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txDiaCopia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(rbReceberAviso)
                            .addComponent(rbNaoReceberAviso))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txTempoEspera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txEmails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterarConfig)
                    .addComponent(btnSalvarConfig)
                    .addComponent(btnCancelarConfig))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panConfigLayout = new javax.swing.GroupLayout(panConfig);
        panConfig.setLayout(panConfigLayout);
        panConfigLayout.setHorizontalGroup(
            panConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panConfigLayout.setVerticalGroup(
            panConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configurações", panConfig);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(license, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(direitos)
                .addGap(271, 271, 271))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direitos)
                    .addComponent(license))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dataDetalhesInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDetalhesInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataDetalhesInActionPerformed

    private void txBuscaDetalhesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscaDetalhesKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txBuscaDetalhes.setActionCommand("CampoDetalhes");
            txBuscaDetalhes.addActionListener(controller);
        }
    }//GEN-LAST:event_txBuscaDetalhesKeyPressed

    private void txBuscaDetalhesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txBuscaDetalhesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txBuscaDetalhesPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btAlterarConfig;
    public static javax.swing.JButton btArquivoBat;
    public static javax.swing.JButton btArquivosCompactados;
    public static javax.swing.JButton btArquivosVersoes;
    public static javax.swing.JButton btBat;
    public static javax.swing.JButton btFileSync;
    public static javax.swing.JButton btLogBat;
    public static javax.swing.JButton btLogThis;
    private javax.swing.JButton btOkDetalhes;
    private javax.swing.JButton btOkGeral;
    public static javax.swing.JButton btWinrar;
    public static javax.swing.JButton btnCancelarConfig;
    public static javax.swing.JButton btnSalvarConfig;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbOrganizar;
    private javax.swing.JCheckBox ckFalhou;
    private javax.swing.JCheckBox ckInterrompido;
    private javax.swing.JCheckBox ckSucesso;
    public static com.michaelbaranov.microba.calendar.DatePicker dataDetalhesIn;
    public static com.michaelbaranov.microba.calendar.DatePicker dateDetalhesFim;
    public static com.michaelbaranov.microba.calendar.DatePicker dateFim;
    public static com.michaelbaranov.microba.calendar.DatePicker dateIn;
    private javax.swing.JLabel direitos;
    private javax.swing.ButtonGroup groupAvisos;
    private javax.swing.ButtonGroup groupCopia;
    private javax.swing.ButtonGroup groupRar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbArquivos;
    private javax.swing.JLabel lbBusca;
    private javax.swing.JLabel lbBuscaDetalhes;
    private javax.swing.JLabel lbOrganizar;
    private javax.swing.JLabel license;
    public static javax.swing.JPanel panConfig;
    private javax.swing.JPanel panInicio;
    public static javax.swing.JPanel panNProcessados;
    public static javax.swing.JPanel panProcessados;
    private javax.swing.JRadioButton rbCrescente;
    private javax.swing.JRadioButton rbDecrescente;
    public static javax.swing.JRadioButton rbExcluirCompactados;
    public static javax.swing.JRadioButton rbHabilitarCopia;
    public static javax.swing.JRadioButton rbLixeiraCompactados;
    public static javax.swing.JRadioButton rbNaoHabilitarCopia;
    public static javax.swing.JRadioButton rbNaoReceberAviso;
    public static javax.swing.JRadioButton rbReceberAviso;
    public static javax.swing.JTable tbDetalhes;
    public static javax.swing.JTable tbRotinas;
    private javax.swing.JLabel tbVisao;
    private javax.swing.JLabel title;
    public static javax.swing.JTextField txBuscaDetalhes;
    public static javax.swing.JTextField txDiaCopia;
    public static javax.swing.JTextField txDirArqVersoes;
    public static javax.swing.JTextField txDirArquivosRar;
    public static javax.swing.JTextField txDirBackup;
    public static javax.swing.JTextField txDirBat;
    public static javax.swing.JTextField txDirFileSync;
    public static javax.swing.JTextField txDirLogBat;
    public static javax.swing.JTextField txDirLogThis;
    public static javax.swing.JTextField txDirWinRar;
    public static javax.swing.JTextField txEmails;
    public static javax.swing.JTextField txExtensaoBat;
    public static javax.swing.JTextField txNomeBat;
    public static javax.swing.JTextField txTempoEspera;
    // End of variables declaration//GEN-END:variables
}
