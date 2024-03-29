/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Estoque;
import DAO.EstoqueDAO;
import static View.TransporteQuantidade.idSelec;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class DesativaFilial extends javax.swing.JFrame {
    static Estoque estoque = new Estoque();
    static EstoqueDAO estoqueDAO = EstoqueDAO.getInstance();
    static Long idSelec;

    /**
     * Creates new form DesativaFilial
     */
    public DesativaFilial() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        lblFilialEscolhida = new javax.swing.JLabel();
        cbbListaFiliais = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnTransportar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filial escolhida:");

        cbbListaFiliais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Escolha a filial:");

        btnTransportar.setText("Transportar");
        btnTransportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransportarActionPerformed(evt);
            }
        });

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbListaFiliais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                        .addComponent(btnTransportar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFilialEscolhida))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblFilialEscolhida))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbListaFiliais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransportarActionPerformed
        // TODO add your handling code here:
        try
        {
            List<Estoque> estoques = estoqueDAO.getByFilial(lblFilialEscolhida.getText());
            String filialDestino = (String)cbbListaFiliais.getSelectedItem();
            if(filialDestino.length() > 0)
            {
                for(Estoque e : estoques)
                {
                    Estoque newE = estoqueDAO.getByProdutoByFilial(e.getProduto(), filialDestino);
                    if(newE != null)
                    {
                        newE.setQuantidade(newE.getQuantidade() + e.getQuantidade());
                        newE.setFilial(filialDestino);
                        estoqueDAO.atualizaEstoque(newE.getId(), newE);
                        estoqueDAO.excluiEstoque(e);
                    }
                    else
                    {
                        e.setFilial(filialDestino);
                        estoqueDAO.atualizaEstoque(e.getId(), e);
                    }
                }
                JOptionPane.showMessageDialog(null, "Filial de desativada e produtos remanejados.", "Cadastro de produto.", JOptionPane.DEFAULT_OPTION);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nenhuma filial encontrada para remanejamento.", "Nenhuma filial encontrada para remanejamento.", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(null, "Nenhuma filial encontrada para remanejamento.", "Nenhuma filial encontrada para remanejamento.", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Erro no processo de desativação da filial.", "Erro no processo de desativação de filiais.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTransportarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(DesativaFilial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesativaFilial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesativaFilial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesativaFilial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        idSelec = Long.parseLong(args[0]);
        estoque = estoqueDAO.getById(idSelec);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesativaFilial().setVisible(true);
            }
        });
    }
    public void preencheCamposSelecionados()
    {
        lblFilialEscolhida.setText(estoque.getFilial());
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
                    if(!f.equals(estoque.getFilial()))
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
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTransportar;
    private javax.swing.JComboBox cbbListaFiliais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFilialEscolhida;
    // End of variables declaration//GEN-END:variables
}
