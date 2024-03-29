/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Estoque;
import DAO.EstoqueDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class TransporteQuantidade extends javax.swing.JFrame {
    Estoque estoque;
    EstoqueDAO estoqueDAO = EstoqueDAO.getInstance();
    static Long idSelec;
    /**
     * Creates new form TransporteQuantidade
     */
    public TransporteQuantidade() throws Exception {
        initComponents();
        estoque = new Estoque();
        preencheCamposSelecionados();
        preencheComboBoxFiliais();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloSecao1 = new javax.swing.JLabel();
        txtProdutoSelecionado1 = new javax.swing.JTextField();
        lblProdutoSelecionado1 = new javax.swing.JLabel();
        lblFilialSelecionada1 = new javax.swing.JLabel();
        txtFilialSelecionada1 = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbbListaFiliais = new javax.swing.JComboBox();
        btnTransportar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTituloSecao1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTituloSecao1.setText("Transportar quantidade de um produto para outra Filial");

        txtProdutoSelecionado1.setEditable(false);

        lblProdutoSelecionado1.setText("Produto selecionado:");

        lblFilialSelecionada1.setText("Filial selecionada:");

        txtFilialSelecionada1.setEditable(false);

        lblQuantidade.setText("Quantidade:");

        jLabel1.setText("Filial de destino:");

        cbbListaFiliais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbListaFiliais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbListaFiliaisActionPerformed(evt);
            }
        });

        btnTransportar.setText("Transportar");
        btnTransportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransportarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloSecao1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbListaFiliais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblProdutoSelecionado1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProdutoSelecionado1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFilialSelecionada1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFilialSelecionada1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTransportar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSecao1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdutoSelecionado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdutoSelecionado1)
                    .addComponent(txtFilialSelecionada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFilialSelecionada1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbbListaFiliais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbListaFiliaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbListaFiliaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbListaFiliaisActionPerformed

    private void btnTransportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransportarActionPerformed
        try {
            // TODO add your handling code here:
            estoque = estoqueDAO.getById(idSelec);
            int intNovaQuantidade = Integer.parseInt(txtQuantidade.getText());
            if(intNovaQuantidade <= estoque.getQuantidade())
            {
                Estoque e = estoqueDAO.getByProdutoByFilial(estoque.getProduto(), (String)cbbListaFiliais.getSelectedItem());
                if(e != null)
                {
                    e.setQuantidade(intNovaQuantidade + e.getQuantidade());
                    estoqueDAO.atualizaEstoque(e.getId(), e);
                    
                    //DESCONTA DO PRODUTO DA PRIMEIRA FILIAL                
                    e = estoqueDAO.getById(idSelec);
                    e.setQuantidade(e.getQuantidade() - intNovaQuantidade);
                    estoqueDAO.atualizaEstoque(idSelec, e);
                    JOptionPane.showMessageDialog(null, "Produto já existente na filial de destino. \n Sua quantidade foi alterada.", "Cadastro de produto.", JOptionPane.DEFAULT_OPTION);
                }
                else
                {
                    e = new Estoque();
                    e.setFilial((String)cbbListaFiliais.getSelectedItem());
                    e.setProduto(txtProdutoSelecionado1.getText());
                    e.setQuantidade(intNovaQuantidade);
                    estoqueDAO.criarEstoque(e);
                    
                    //DESCONTA DO PRODUTO DA PRIMEIRA FILIAL
                    e = estoqueDAO.getById(idSelec);
                    e.setQuantidade(e.getQuantidade() - intNovaQuantidade);
                    estoqueDAO.atualizaEstoque(idSelec, e);
                    JOptionPane.showMessageDialog(null, "Produto não existente na filial de destino.\n Produto criado com a quantidade selecionada na filial selecionada.", "Cadastro de produto.", JOptionPane.DEFAULT_OPTION);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Quantidade maior do que a que esta no estoque.", "Quantidade maior do que a que esta no estoque.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no processo de transporte de quantidade entre filiais.", "Erro no processo de transporte de quantidade entre filiais.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(TransporteQuantidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnTransportarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        idSelec = Long.parseLong(args[0]);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TransporteQuantidade().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TransporteQuantidade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
    }
    
    public void preencheCamposSelecionados()
    {
        Estoque estoque = estoqueDAO.getById(idSelec);
        txtProdutoSelecionado1.setText(estoque.getProduto());
        txtFilialSelecionada1.setText(estoque.getFilial());
    }
    
    public void preencheComboBoxFiliais()
    {
        //PREENCHE LISTAGEM DE FILIAIS PARA SELEÇÃO
        cbbListaFiliais.removeAllItems();
        try {
            List<String> lista = estoqueDAO.getAllFiliais();
            if(lista.size() > 0)
            {
                for (String f : lista)
                {
                    if(!f.equals(txtFilialSelecionada1.getText()))
                        cbbListaFiliais.addItem(f);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não foi encontrada nenhuma filial para listagem", "Erro de Listagem", JOptionPane.ERROR_MESSAGE);    
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel lista os registros", "Erro de Listagem", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InterfaceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnTransportar;
    private javax.swing.JComboBox cbbListaFiliais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFilialSelecionada1;
    private javax.swing.JLabel lblProdutoSelecionado1;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTituloSecao1;
    private javax.swing.JTextField txtFilialSelecionada1;
    private javax.swing.JTextField txtProdutoSelecionado1;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
