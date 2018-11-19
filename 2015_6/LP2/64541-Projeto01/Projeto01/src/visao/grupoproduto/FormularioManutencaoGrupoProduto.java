/*
 * FormularioManutencaoProduto.java
 *
 * Created on 28 de Agosto de 2008, 11:06
 */
package visao.grupoproduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Evandro
 */
public class FormularioManutencaoGrupoProduto extends javax.swing.JFrame {

    private Connection conexao;

    public FormularioManutencaoGrupoProduto() {
        initComponents();
        this.ativaConexaoBD();
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
    this.desativaConexaoBD();
    this.dispose();
}//GEN-LAST:event_botaoSairActionPerformed

private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed

    FormularioIncluirGrupoProduto tela = new FormularioIncluirGrupoProduto();
    tela.setModal(true);
    tela.setConexao(this.conexao);
    tela.setVisible(true);
    this.atualizaTabela();
}//GEN-LAST:event_botaoIncluirActionPerformed

private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
    if (this.tabelaGrupoProduto.getSelectedRowCount() > 0) {
        int codigo = ((Integer) this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 0)).intValue();
        FormularioAlterarGrupoProduto tela = new FormularioAlterarGrupoProduto(this.conexao, codigo);
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoAlterarActionPerformed

private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
    if (this.tabelaGrupoProduto.getSelectedRowCount() > 0) {
        FormularioExcluirGrupoProduto tela = new FormularioExcluirGrupoProduto();
        tela.setConexao(this.conexao);
        tela.setCodigo(this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 0).toString());
        tela.setNome(this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 1).toString());
        tela.setMargem(this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 2).toString());
        tela.setPromocao(this.tabelaGrupoProduto.getValueAt(this.tabelaGrupoProduto.getSelectedRow(), 3).toString());
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoExcluirActionPerformed

    public void atualizaTabela() {

        ArrayList listaLinha = new ArrayList();
        try {
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM GrupoProduto ORDER BY NOME");
            ResultSet rs = comando.executeQuery();
            ArrayList linha;
            while (rs.next()) {
                linha = new ArrayList();
                linha.add(rs.getInt("codigo"));
                linha.add(rs.getString("nome").trim());
                linha.add(rs.getFloat("margemLucro"));
                linha.add(rs.getFloat("promocao"));
                listaLinha.add(linha);
            }
            rs.close();
            comando.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível recuperar lista de grupos de produtos - " + ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            TableModel model = new TableModelGrupoProduto(listaLinha);
            this.tabelaGrupoProduto.setModel(model);
            this.tabelaGrupoProduto.getColumnModel().getColumn(1).setMinWidth(200);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível montar a visualização dos grupos produtos - " + ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ativaConexaoBD() {

        String url = "jdbc:postgresql://localhost:5432/estoque";
        try {
            Class.forName("org.postgresql.Driver");
            this.conexao = DriverManager.getConnection(url, "postgres", "postgres");
        } catch (ClassNotFoundException cnf) {
            JOptionPane.showMessageDialog(this, "Classe do driver do banco não encontrada - " + cnf.getMessage());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(this, "Banco não encontrado - " + sqle.getMessage());
        }
    }

    private void desativaConexaoBD() {
        try {
            this.conexao.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(this, "Erro ao fechar o banco - " + sqle.getMessage());
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
