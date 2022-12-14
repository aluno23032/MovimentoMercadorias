package trackingEncomendas;

import blockChain.p2p.miner.InterfaceRemoteMiner;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import utils.RMI;

/**
 *
 * @author Eduardo Gomes a23032 e Pedro Martinho a23299
 */

public class GUI_Distribuidor extends javax.swing.JFrame {

    InterfaceRemoteMiner miner;
    String user;

    /**
     * Creates new form GUI
     */
    public GUI_Distribuidor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPanePrincipal = new javax.swing.JTabbedPane();
        painelServer = new javax.swing.JPanel();
        btStartServer = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        painelMovimentos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btAtualizarEncomenda = new javax.swing.JButton();
        txtOrigem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLocalizacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMovimentos = new javax.swing.JList<>();
        painelUtilizadores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUtilizadores = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEncomendas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tracking Encomendas");

        tbPanePrincipal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbPanePrincipalStateChanged(evt);
            }
        });

        btStartServer.setText("Connect To Server ");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        txtAddress.setText("//10.10.209.111:10010/miner");
        txtAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Address"));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelServerLayout = new javax.swing.GroupLayout(painelServer);
        painelServer.setLayout(painelServerLayout);
        painelServerLayout.setHorizontalGroup(
            painelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btStartServer)
                .addContainerGap())
        );
        painelServerLayout.setVerticalGroup(
            painelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        tbPanePrincipal.addTab("Server", painelServer);

        jLabel3.setText("De:");

        btAtualizarEncomenda.setText("Atualizar Encomenda");
        btAtualizarEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarEncomendaActionPerformed(evt);
            }
        });

        txtOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrigemActionPerformed(evt);
            }
        });

        jLabel4.setText("Para:");

        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        jLabel6.setText("Localiza????o Atual:");

        txtLocalizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizacaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Id Encomenda:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de Movimentos");

        jScrollPane3.setViewportView(listMovimentos);

        javax.swing.GroupLayout painelMovimentosLayout = new javax.swing.GroupLayout(painelMovimentos);
        painelMovimentos.setLayout(painelMovimentosLayout);
        painelMovimentosLayout.setHorizontalGroup(
            painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMovimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addComponent(btAtualizarEncomenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGroup(painelMovimentosLayout.createSequentialGroup()
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMovimentosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtID))))
                .addContainerGap())
        );
        painelMovimentosLayout.setVerticalGroup(
            painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMovimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentosLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(28, 28, 28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizarEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbPanePrincipal.addTab("Movimento", painelMovimentos);

        listUtilizadores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUtilizadoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listUtilizadores);

        jScrollPane2.setViewportView(listEncomendas);

        jLabel1.setText("Utilizadores");

        jLabel7.setText("Lista de Encomendas");

        javax.swing.GroupLayout painelUtilizadoresLayout = new javax.swing.GroupLayout(painelUtilizadores);
        painelUtilizadores.setLayout(painelUtilizadoresLayout);
        painelUtilizadoresLayout.setHorizontalGroup(
            painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelUtilizadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(painelUtilizadoresLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelUtilizadoresLayout.setVerticalGroup(
            painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelUtilizadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelUtilizadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        tbPanePrincipal.addTab("Utilizadores", painelUtilizadores);
        painelUtilizadores.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanePrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbPanePrincipal.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPanePrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbPanePrincipalStateChanged
        //se o painel principal for selecionado
        if (tbPanePrincipal.getSelectedComponent() == painelUtilizadores) {
            DefaultListModel model = new DefaultListModel();
            try {
                
                //adicionar users ao model
                model.addAll(miner.getBlockChain().getUsers());
                
            } catch (RemoteException ex) {
                Logger.getLogger(GUI_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //mostrar o model na lista de users
            listUtilizadores.setModel(model);
        }
    }//GEN-LAST:event_tbPanePrincipalStateChanged

    private void listUtilizadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUtilizadoresValueChanged
        //guardar user que e selecionado
        user = listUtilizadores.getSelectedValue();
        
        DefaultListModel model2 = new DefaultListModel();
        try {
            
            //adicionar encomendas do user ao model
            model2.addAll(miner.getBlockChain().getUserEncomendas(user, "d"));
            
        } catch (RemoteException ex) {
            Logger.getLogger(GUI_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //mostrar o model na lista das encomendas
        listEncomendas.setModel(model2);
    }//GEN-LAST:event_listUtilizadoresValueChanged

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtLocalizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizacaoActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigemActionPerformed

    private void btAtualizarEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarEncomendaActionPerformed
        //novo movimento
        Movimento m = new Movimento(txtOrigem.getText(), txtDestino.getText(), txtLocalizacao.getText(), Integer.parseInt(txtID.getText()), LocalDateTime.now(ZoneId.of("GMT")));
        try {
            
            //se o mineiro estiver a minar 
            if (miner.isMining()) {
                
                //parar o mineiro
                miner.stopMining(9999);
                
            } else {
                new Thread(() -> {
                    try {
                        
                        //minar
                        miner.mine(m.toString(), 3);
                        
                    } catch (RemoteException ex) {
                    }
                }).start();
            }
            Timer t = new Timer(250, (ActionEvent e) -> {
                DefaultListModel model = new DefaultListModel();
                try {
                    
                    //adicionar movimentos ao model
                    for (int i = 0; i < miner.getBlockChain().getLength(); i++) {
                        model.add(i, miner.getBlockChain().get(i));
                    }
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(GUI_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //mostrar o model na lista de movimentos
                listMovimentos.setModel(model);
            });

            t.start();

        } catch (RemoteException ex) {
        }

    }//GEN-LAST:event_btAtualizarEncomendaActionPerformed

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        try {
            
            //guardar endere??o do remote miner
            miner = (InterfaceRemoteMiner) RMI.getRemote(txtAddress.getText());
            
            //seleceionar o painel de movimentos
            tbPanePrincipal.setSelectedComponent(painelMovimentos);
            
            DefaultListModel model = new DefaultListModel();
            try {
                
                //adicionar movimentos ao model
                for (int i = 0; i < miner.getBlockChain().getLength(); i++) {
                    model.add(i, miner.getBlockChain().get(i));
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(GUI_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //mostar o model na lista de movimentos
            listMovimentos.setModel(model);
            
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btStartServerActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Distribuidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GUI_Distribuidor().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUI_Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizarEncomenda;
    private javax.swing.JButton btStartServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listEncomendas;
    private javax.swing.JList<String> listMovimentos;
    private javax.swing.JList<String> listUtilizadores;
    private javax.swing.JPanel painelMovimentos;
    private javax.swing.JPanel painelServer;
    private javax.swing.JPanel painelUtilizadores;
    private javax.swing.JTabbedPane tbPanePrincipal;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLocalizacao;
    private javax.swing.JTextField txtOrigem;
    // End of variables declaration//GEN-END:variables
}
