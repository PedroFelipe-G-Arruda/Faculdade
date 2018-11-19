/*
 * FormularioManutencaoProduto.java
 *
 * Created on 28 de Agosto de 2008, 11:06
 */
package visao.grupo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import negocio.ManutencaoGrupoProduto;
import negocio.NegocioException;
import vo.GrupoProdutoVO;

/**
 *
 * @author Evandro
 */
public class FormularioManutencaoGrupoProduto extends javax.swing.JFrame {

    ManutencaoGrupoProduto grupo;

    public FormularioManutencaoGrupoProduto() {
        initComponents();
        try {
            grupo = new ManutencaoGrupoProduto();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGrupoProduto = new javax.swing.JTable();
        botaoAlterar = new javax.swing.JButton();
        botaoIncluir = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manutenção de Grupo de Produto");
        setResizable(false);
        getContentPane().setLayout(null);

        tabelaGrupoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaGrupoProduto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 430, 260);

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAlterar);
        botaoAlterar.setBounds(110, 270, 90, 30);

        botaoIncluir.setText("Incluir");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoIncluir);
        botaoIncluir.setBounds(10, 270, 90, 30);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoExcluir);
        botaoExcluir.setBounds(210, 270, 80, 30);

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(340, 270, 80, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-441)/2, (screenSize.height-343)/2, 441, 343);
    }// </editor-fold>//GEN-END:initComponents

private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
    this.dispose();
}//GEN-LAST:event_botaoSairActionPerformed

private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed

    FormularioIncluirGrupoProduto tela = new FormularioIncluirGrupoProduto();
    tela.setModal(true);
    tela.setVisible(true);
    this.atualizaTabela();
}//GEN-LAST:event_botaoIncluirActionPerformed

private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
    if (this.tabelaGrupoProduto.getSelectedRowCount() > 0) {
        int codigo = ((Integer) this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 0)).intValue();
        FormularioAlterarGrupoProduto tela = new FormularioAlterarGrupoProduto(codigo);
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoAlterarActionPerformed

private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
    if (this.tabelaGrupoProduto.getSelectedRowCount() > 0) {
        int codigo = ((Integer) this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 0)).intValue();
        FormularioExcluirGrupoProduto tela = new FormularioExcluirGrupoProduto(codigo);
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoExcluirActionPerformed

    public void atualizaTabela() {
        List<GrupoProdutoVO> listaLinha = new ArrayList();
        try {
            listaLinha = grupo.buscarTodos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível recuperar lista de grupo", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            TableModel model = new TableModelGrupoProduto(listaLinha);
            this.tabelaGrupoProduto.setModel(model);
            this.tabelaGrupoProduto.getColumnModel().getColumn(1).setMinWidth(200);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível montar a visualização dos grupos de produtos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaGrupoProduto;
    // End of variables declaration//GEN-END:variables

}
