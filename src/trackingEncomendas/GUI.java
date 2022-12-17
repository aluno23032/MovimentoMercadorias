package trackingEncomendas;

import blockChain.p2p.miner.InterfaceRemoteMiner;
import java.awt.Color;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Key;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import utils.BlockChain;
import utils.GuiUtils;
import utils.Miner;
import utils.RMI;
import utils.SecurityUtils;

/**
 *
 * @author Eduardo Gomes a23032 e Pedro Martinho a23299
 */
public class GUI extends javax.swing.JFrame {

    private static Key loadKeyInicial() throws Exception {
        byte[] data = Files.readAllBytes(Paths.get("edu.priv"));
        //Decriptar ficheiro com password
        data = SecurityUtils.decrypt(data, "edu");
        //Guardar chave privada decriptada num ficheiro temporário
        Files.write(Paths.get("temp.priv"), data);
        //Carregar a chave privada (Key) a partir do ficheiro temporário
        PrivateKey chavetemp = SecurityUtils.loadPrivateKey("temp.priv");
        //Eliminar ficheiro temporário
        Files.deleteIfExists(Paths.get("temp.priv"));
        return chavetemp;
    }

    InterfaceRemoteMiner miner;
    Key privatekey;
    String user;

    /**
     * Creates new form GUI
     *
     * @param publickey
     * @param privatekey
     * @param simetrickey
     */
    public GUI(Key publickey, Key privatekey, Key simetrickey) {
        this.privatekey = privatekey;
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
        btGuardarBloco1 = new javax.swing.JButton();
        btCarregarBloco1 = new javax.swing.JButton();
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

        javax.swing.GroupLayout painelServerLayout = new javax.swing.GroupLayout(painelServer);
        painelServer.setLayout(painelServerLayout);
        painelServerLayout.setHorizontalGroup(
            painelServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelServerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
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
                .addContainerGap(297, Short.MAX_VALUE))
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

        jLabel6.setText("Localização Atual:");

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

        btGuardarBloco1.setText("Guardar");
        btGuardarBloco1.setToolTipText("");
        btGuardarBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarBloco1ActionPerformed(evt);
            }
        });

        btCarregarBloco1.setText("Carregar");
        btCarregarBloco1.setToolTipText("");
        btCarregarBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarBloco1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMovimentosLayout = new javax.swing.GroupLayout(painelMovimentos);
        painelMovimentos.setLayout(painelMovimentosLayout);
        painelMovimentosLayout.setHorizontalGroup(
            painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMovimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btAtualizarEncomenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelMovimentosLayout.createSequentialGroup()
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMovimentosLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMovimentosLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelMovimentosLayout.createSequentialGroup()
                                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap())
            .addGroup(painelMovimentosLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btGuardarBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btCarregarBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelMovimentosLayout.setVerticalGroup(
            painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMovimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMovimentosLayout.createSequentialGroup()
                            .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizarEncomenda, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardarBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCarregarBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 134, Short.MAX_VALUE)))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(tbPanePrincipal)
                .addContainerGap())
        );

        tbPanePrincipal.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtLocalizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizacaoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigemActionPerformed

    private void btAtualizarEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarEncomendaActionPerformed
        Movimento m = new Movimento(txtOrigem.getText(), txtDestino.getText(), txtLocalizacao.getText(), Integer.parseInt(txtID.getText()), LocalDateTime.now(ZoneId.of("GMT")));
        try {
            if (miner.isMining()) {
                miner.stopMining(9999);
            } else {
                new Thread(() -> {
                    try {
                        miner.mine(m.toString(), 3);
                    } catch (RemoteException ex) {
                    }
                }).start();
            }
            DefaultListModel model = new DefaultListModel();
            //adicionar movimentos à lista de movimentos
            for (int i = 0; i < miner.getBlockChain().getLength(); i++) {
                model.add(i, miner.getBlockChain().get(i));
            }
        listMovimentos.setModel(model);
        } catch (RemoteException ex) {
        }
        
    }//GEN-LAST:event_btAtualizarEncomendaActionPerformed

    private void tbPanePrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbPanePrincipalStateChanged
        // TODO add your handling code here:
        if (tbPanePrincipal.getSelectedComponent() == painelUtilizadores) {
            DefaultListModel model = new DefaultListModel();
            try {
                model.addAll(miner.getBlockChain().getUsers());
            } catch (RemoteException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            listUtilizadores.setModel(model);
        }
    }//GEN-LAST:event_tbPanePrincipalStateChanged

    private void listUtilizadoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUtilizadoresValueChanged
        // TODO add your handling code here:
        user = listUtilizadores.getSelectedValue();
        DefaultListModel model2 = new DefaultListModel();
        try {
            model2.addAll(miner.getBlockChain().getUserEncomendas(user));
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        listEncomendas.setModel(model2);
    }//GEN-LAST:event_listUtilizadoresValueChanged

    private void btGuardarBloco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarBloco1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                miner.getBlockChain().save(fc.getSelectedFile().getAbsolutePath());
                byte[] data = SecurityUtils.sign(Files.readAllBytes(Paths.get(fc.getSelectedFile().getAbsolutePath() + ".bc")), (PrivateKey) privatekey);
                Files.write(Paths.get(fc.getSelectedFile().getName() + ".sign"), data);
                JOptionPane.showMessageDialog(new JFrame(), "O ficheiro foi salvo com sucesso.", "Salvo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btGuardarBloco1ActionPerformed

    private void btCarregarBloco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarBloco1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                miner.getBlockChain().load(fc.getSelectedFile().getAbsolutePath());
                DefaultListModel model = new DefaultListModel();
                //adicionar movimentos à lista de movimentos
                for (int i = 0; i < miner.getBlockChain().getLength(); i++) {
                    model.add(i, miner.getBlockChain().get(i).getData());
                }
                listMovimentos.setModel(model);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCarregarBloco1ActionPerformed

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed
        try {
            miner = (InterfaceRemoteMiner) RMI.getRemote(txtAddress.getText());
            tbPanePrincipal.setSelectedComponent(painelMovimentos);
            DefaultListModel model = new DefaultListModel();
            try {
                //adicionar movimentos à lista de movimentos
                for (int i = 0; i < miner.getBlockChain().getLength(); i++) {
                    model.add(i, miner.getBlockChain().get(i));
                }
            } catch (RemoteException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            listMovimentos.setModel(model);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btStartServerActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GUI(
                        SecurityUtils.loadPublicKey("edu" + ".pub"),
                        loadKeyInicial(),
                        SecurityUtils.loadKey("edu" + ".sim")).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizarEncomenda;
    private javax.swing.JButton btCarregarBloco1;
    private javax.swing.JButton btGuardarBloco1;
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
