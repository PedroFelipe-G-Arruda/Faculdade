package visao.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FormularioIncluirProduto extends JDialog {

    private Connection conexaoBD;

    public FormularioIncluirProduto(Connection conexao) {
        this.conexaoBD = conexao;
        initComponents();
        this.preecheComboGrupoProduto();
    }

    private void confirmaOperacao() {
        String nome = null;
        int estoque = 0;
        float compra = 0;
        float margem = 0;
        float promocao = 0;
        String sGrupo = "";
        int grupo = 0;
        try {
            nome = this.campoNome.getText();
            estoque = Integer.parseInt(campoEstoque.getText());
            compra = Float.parseFloat(this.campoCompra.getText());
            margem = Float.parseFloat(this.campoMargem.getText());
            promocao = Float.parseFloat(this.campoPercentualPromocao.getText());
            sGrupo = (String)this.comboGrupoProduto.getSelectedItem();
            grupo = Integer.parseInt(sGrupo.substring(0, sGrupo.indexOf("-")));
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Digitacao inconscistente - "+ex.toString());
            return;
        }

        //exemplo de validacao - regra de negocio
        if (nome.length() == 0) {
            JOptionPane.showMessageDialog(this, "Nome não pode ser vazio");
            campoNome.requestFocus();
            return;
        }

        if (estoque < 0) {
            JOptionPane.showMessageDialog(this, "Estoque não pode ser negativo");
            campoEstoque.requestFocus();
            return;
        }

        if (compra <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de compra deve ser maior que zero");
            campoCompra.requestFocus();
            return;
        }

        if (margem < 0) {
            JOptionPane.showMessageDialog(this, "A margem de Lucro não pode ser negativa");
            campoMargem.requestFocus();
            return;
        }

        if (promocao < 0 || promocao > 100) {
            JOptionPane.showMessageDialog(this, "O Percentual de Promoção deve ser entre 0 e 100");
            campoPercentualPromocao.requestFocus();
            return;
        }

        try {
            PreparedStatement comando = conexaoBD.prepareStatement(
                "INSERT INTO PRODUTO ( NOME, ESTOQUE, VALORCOMPRA, MARGEMLUCRO, PROMOCAO, GRUPO )VALUES (? , ?, ?, ?, ?, ?)");
            comando.setString(1, nome);
            comando.setInt(2, estoque);
            comando.setFloat(3, compra);
            comando.setFloat(4, margem);
            comando.setFloat(5, promocao);
            comando.setInt(6, grupo);
            comando.executeUpdate();
            comando.close();
            JOptionPane.showMessageDialog(this, "Inclusão realizada com sucesso");
            this.limparCampos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao incluir novo produto" + ex.toString());
        }
    }

    private void preecheComboGrupoProduto(){
        try {
            PreparedStatement comando = conexaoBD.prepareStatement("SELECT * FROM GRUPOPRODUTO ORDER BY NOME");
            ResultSet rs = comando.executeQuery();
            List listaGrupo = new ArrayList();
            int codigo;
            String nome;
            while(rs.next()){
                codigo = rs.getInt("codigo");
                nome = rs.getString("nome");
                listaGrupo.add(codigo+"-"+nome);
            }
            this.comboGrupoProduto.setModel(new DefaultComboBoxModel(listaGrupo.toArray()));
            comando.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao incluir novo produto" + ex.toString());
        }
    }

    private void limparCampos() {
        this.campoCompra.setText("");
        this.campoEstoque.setText("");
        this.campoMargem.setText("");
        this.campoNome.setText("");
        this.campoNome.requestFocus();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        campoMargem = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoEstoque = new javax.swing.JTextField();
        campoCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboGrupoProduto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        campoPercentualPromocao = new javax.swing.JTextField();

        setTitle("Inclusão de Produtos");
        setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 60, 20);

        jLabel2.setText("Estoque");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 60, 20);

        jLabel3.setText("Valor Compra");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 80, 90, 20);

        jLabel4.setText("Grupo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 170, 90, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(50, 210, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(270, 210, 110, 30);
        getContentPane().add(campoMargem);
        campoMargem.setBounds(130, 110, 100, 20);
        getContentPane().add(campoNome);
        campoNome.setBounds(130, 20, 300, 20);
        getContentPane().add(campoEstoque);
        campoEstoque.setBounds(130, 50, 100, 20);
        getContentPane().add(campoCompra);
        campoCompra.setBounds(130, 80, 100, 20);

        jLabel5.setText("% Margem Lucro");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 110, 120, 20);

        getContentPane().add(comboGrupoProduto);
        comboGrupoProduto.setBounds(130, 170, 230, 27);

        jLabel7.setText("% Promocao");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 140, 90, 20);
        getContentPane().add(campoPercentualPromocao);
        campoPercentualPromocao.setBounds(130, 140, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-486)/2, (screenSize.height-296)/2, 486, 296);
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
    this.confirmaOperacao();
}//GEN-LAST:event_botaoConfirmaActionPerformed

private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    this.closeDialog(null);
}//GEN-LAST:event_botaoCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JTextField campoCompra;
    private javax.swing.JTextField campoEstoque;
    private javax.swing.JTextField campoMargem;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPercentualPromocao;
    private javax.swing.JComboBox comboGrupoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
