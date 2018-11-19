/*
 * FormularioManutencaoProduto.java
 *
 * Created on 28 de Agosto de 2008, 11:06
 */
package visao.produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Evandro
 */
public class FormularioManutencaoProduto extends javax.swing.JFrame {

    private Connection conexao;

    public FormularioManutencaoProduto() {
        initComponents();
        this.ativaConexaoBD();
        //this.atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        botaoAlterar = new javax.swing.JButton();
        botaoIncluir = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
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
        tabelaProduto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabelaProduto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 660, 280);

        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAlterar);
        botaoAlterar.setBounds(110, 360, 90, 30);

        botaoIncluir.setText("Incluir");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoIncluir);
        botaoIncluir.setBounds(10, 360, 90, 30);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoExcluir);
        botaoExcluir.setBounds(210, 360, 80, 30);

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(580, 360, 80, 30);

        painelFiltro.setLayout(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
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
        campoFiltroNome.setBounds(270, 10, 250, 27);

        botaoFiltroNome.setText("Filtrar");
        botaoFiltroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFiltroNomeActionPerformed(evt);
            }
        });
        painelFiltro.add(botaoFiltroNome);
        botaoFiltroNome.setBounds(530, 10, 110, 29);

        getContentPane().add(painelFiltro);
        painelFiltro.setBounds(0, 10, 670, 50);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-683)/2, (screenSize.height-435)/2, 683, 435);
    }// </editor-fold>//GEN-END:initComponents

private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
    this.desativaConexaoBD();
    this.dispose();
}//GEN-LAST:event_botaoSairActionPerformed

private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed

    FormularioIncluirProduto tela = new FormularioIncluirProduto(this.conexao);
    tela.setModal(true);
    tela.setVisible(true);
    this.atualizaTabela();
}//GEN-LAST:event_botaoIncluirActionPerformed

private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
    if (this.tabelaProduto.getSelectedRowCount() > 0) {
        int codigo = ((Integer) this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0)).intValue();
        FormularioAlterarProduto tela = new FormularioAlterarProduto(this.conexao, codigo);
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoAlterarActionPerformed

private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
    if (this.tabelaProduto.getSelectedRowCount() > 0) {
        FormularioExcluirProduto tela = new FormularioExcluirProduto(this.conexao);
        tela.setCodigo(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 0).toString());
        tela.setNome(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 1).toString());
        tela.setEstoque(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 2).toString());
        tela.setCompra(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 3).toString());
        tela.setMargem(this.tabelaProduto.getValueAt(this.tabelaProduto.getSelectedRow(), 4).toString());
        tela.setModal(true);
        tela.setVisible(true);
        this.atualizaTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um item na tabela");
    }
}//GEN-LAST:event_botaoExcluirActionPerformed

private void botaoFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFiltroNomeActionPerformed
    this.atualizaTabela();
}//GEN-LAST:event_botaoFiltroNomeActionPerformed

private void campoFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFiltroNomeActionPerformed
    this.atualizaTabela();
}//GEN-LAST:event_campoFiltroNomeActionPerformed

    public void atualizaTabela() {

        String filtro = this.campoFiltroNome.getText().trim().toUpperCase();

        ArrayList listaLinha = new ArrayList();
        try {
            Statement comando = conexao.createStatement();
            String sql = "SELECT p.*, g.promocao as promocao_g, g.margemlucro as margem_g"
                + " FROM PRODUTO p INNER JOIN GRUPOPRODUTO g ON (p.GRUPO = g.CODIGO)"
                + " WHERE UPPER(p.NOME) LIKE '%" + filtro + "%'"
                + " ORDER BY p.NOME LIMIT 10";
            ResultSet rs = comando.executeQuery(sql);
            float valorCompra, margemLucro, promocao, venda;
            ArrayList linha;
            while (rs.next()) {

                linha = new ArrayList();
                linha.add(rs.getInt("codigo"));
                linha.add(rs.getString("nome").trim());
                linha.add(rs.getInt("estoque"));
                valorCompra = rs.getFloat("valorCompra");
                margemLucro = rs.getFloat("margemLucro");
                promocao = rs.getFloat("promocao");

                if (margemLucro == 0) {
                    margemLucro = rs.getFloat("margem_g");
                }

                if (promocao == 0) {
                    promocao = rs.getFloat("promocao_g");
                }

                venda = valorCompra + (valorCompra * margemLucro / 100);
                venda = venda - (venda * promocao / 100);

                linha.add(valorCompra);
                linha.add(margemLucro);
                linha.add(promocao);
                linha.add(venda);
                listaLinha.add(linha);
            }
            rs.close();
            comando.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível recuperar lista de produtos - " + ex.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            TableModel model = new TableModelProduto(listaLinha);
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
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoFiltroNome;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoFiltroNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelFiltro;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
