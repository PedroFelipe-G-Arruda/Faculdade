/*
 * FormularioManutencaoProduto.java
 *
 * Created on 28 de Agosto de 2008, 11:06
 */
package visao.baixaestoque;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Evandro
 */
public class FormularioBaixaEstoque extends javax.swing.JFrame {

    private Connection conexao;

    public FormularioBaixaEstoque() {
        initComponents();
        this.ativaConexaoBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        botaoSair = new javax.swing.JButton();
        botaoBaixarDefeito = new javax.swing.JButton();
        botaoBaixarVencimento = new javax.swing.JButton();
        painelFiltro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoFiltroNome = new javax.swing.JTextField();
        botaoFiltroNome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manutenção de Produto");
        setResizable(false);
        getContentPane().setLayout(null);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaProduto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 570, 190);

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(490, 270, 80, 30);

        botaoBaixarDefeito.setText("Baixar (Defeito)");
        botaoBaixarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBaixarDefeitoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBaixarDefeito);
        botaoBaixarDefeito.setBounds(210, 270, 170, 30);

        botaoBaixarVencimento.setText("Baixar (Vencimento)");
        botaoBaixarVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBaixarVencimentoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoBaixarVencimento);
        botaoBaixarVencimento.setBounds(10, 270, 170, 30);

        painelFiltro.setLayout(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setForeground(new java.awt.Color(159, 27, 27));
        jLabel1.setText("Digite parte do nome do produto");
        painelFiltro.add(jLabel1);
        jLabel1.setBounds(10, 10, 270, 30);

        campoFiltroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFiltroNomeActionPerformed(evt);
            }
        });
        painelFiltro.add(campoFiltroNome);
        campoFiltroNome.setBounds(280, 10, 200, 27);

        botaoFiltroNome.setText("Filtrar");
        botaoFiltroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFiltroNomeActionPerformed(evt);
            }
        });
        painelFiltro.add(botaoFiltroNome);
        botaoFiltroNome.setBounds(490, 10, 80, 29);

        getContentPane().add(painelFiltro);
        painelFiltro.setBounds(0, 10, 580, 50);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-598)/2, (screenSize.height-343)/2, 598, 343);
    }// </editor-fold>//GEN-END:initComponents

private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
    this.desativaConexaoBD();
    this.dispose();
}//GEN-LAST:event_botaoSairActionPerformed

private void botaoBaixarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBaixarDefeitoActionPerformed
    if (this.tabelaProduto.getSelectedRowCount() > 0) {
        FormularioBaixarProdutoDefeito tela = new FormularioBaixarProdutoDefeito();
        tela.setConexao(this.conexao);
        tela.setCodigo(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0).toString());
        tela.setNome(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 1).toString());
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoBaixarDefeitoActionPerformed

private void botaoBaixarVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBaixarVencimentoActionPerformed
    if (this.tabelaProduto.getSelectedRowCount() > 0) {
        FormularioBaixarProdutoVencimento tela = new FormularioBaixarProdutoVencimento();
        tela.setConexao(this.conexao);
        tela.setCodigo(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0).toString());
        tela.setNome(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 1).toString());
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }

}//GEN-LAST:event_botaoBaixarVencimentoActionPerformed

private void campoFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFiltroNomeActionPerformed
    this.atualizaTabela();
}//GEN-LAST:event_campoFiltroNomeActionPerformed

private void botaoFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFiltroNomeActionPerformed
    this.atualizaTabela();
}//GEN-LAST:event_botaoFiltroNomeActionPerformed

    public void atualizaTabela() {

        String filtro = this.campoFiltroNome.getText().trim().toUpperCase();

        ArrayList listaLinha = new ArrayList();

        try {
            Statement comando = (Statement) conexao.createStatement();
            String sql = "SELECT codigo, nome, estoque FROM PRODUTO WHERE UPPER(NOME) LIKE '%" + filtro + "%' ORDER BY NOME LIMIT 20";
            ResultSet rs = comando.executeQuery(sql);
            ArrayList linha;
            while (rs.next()) {
                linha = new ArrayList();
                linha.add(rs.getInt("codigo"));
                linha.add(rs.getString("nome"));
                linha.add(rs.getInt("estoque"));
                listaLinha.add(linha);
            }
            rs.close();
            comando.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível recuperar lista de produtos - " + ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            TableModel model = new TableModelBaixaProduto(listaLinha);
            this.tabelaProduto.setModel(model);
            this.tabelaProduto.getColumnModel().getColumn(1).setMinWidth(200);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível montar a visualização dos produtos - " + ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JButton botaoBaixarDefeito;
    private javax.swing.JButton botaoBaixarVencimento;
    private javax.swing.JButton botaoFiltroNome;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoFiltroNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelFiltro;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables

}
