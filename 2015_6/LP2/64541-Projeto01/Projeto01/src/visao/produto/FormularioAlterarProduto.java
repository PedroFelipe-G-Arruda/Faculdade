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

public class FormularioAlterarProduto extends JDialog {

    private Connection conexaoBD;
    private int codigoProduto;

    public FormularioAlterarProduto(Connection conexaoBD, int codigo) {
        this.conexaoBD = conexaoBD;
        this.codigoProduto = codigo;
        initComponents();
        this.preecheCampos();
    }

    private void confirmaOperacao() {

        int codigo=0;
        String nome=null;
        float compra=0;
        float margem=0;
        float promocao=0;
        String sGrupo = "";
        int grupo = 0;

        try {
            codigo = Integer.parseInt(campoCodigo.getText());
            nome = this.campoNome.getText();
            compra = Float.parseFloat(this.campoCompra.getText());
            margem = Float.parseFloat(this.campoMargem.getText());
            promocao = Float.parseFloat(this.campoPercentualPromocao.getText());
            sGrupo = (String)this.comboGrupoProduto.getSelectedItem();
            grupo = Integer.parseInt(sGrupo.substring(0, sGrupo.indexOf("-")));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digitacao inconscistente");
            return;
        }

        if (nome.length() == 0) {
            JOptionPane.showMessageDialog(this, "Nome não pode ser vazio");
            campoNome.requestFocus();
            return;
        }

        if (compra <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de compra deve ser maior que zero");
            campoCompra.requestFocus();
            return;
        }

        if (margem < 0) {
            JOptionPane.showMessageDialog(this, "O percentual de Margem de Lucro deve ser maior ou igual a zero");
            campoMargem.requestFocus();
            return;
        }

        if (promocao < 0 || promocao > 100) {
            JOptionPane.showMessageDialog(this, "O Percentual de Promoção deve ser entre 0 e 100");
            campoPercentualPromocao.requestFocus();
            return;
        }

        try {

            PreparedStatement comando = conexaoBD.prepareStatement("UPDATE PRODUTO SET NOME=?, VALORCOMPRA=?, MARGEMLUCRO=?, PROMOCAO=?, GRUPO=? WHERE CODIGO=?");
            comando.setString(1, nome);
            comando.setFloat(2, compra);
            comando.setFloat(3, margem);
            comando.setFloat(4, promocao);
            comando.setFloat(5, grupo);
            comando.setInt(6, codigo);
            comando.executeUpdate();
            comando.close();
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao alterar o produto" + ex.toString());
        }
    }

    private void preecheCampos(){
        try {

            int codigoGrupo=0;
            int posicaoSelecao=0;
            PreparedStatement comandoProduto = conexaoBD.prepareStatement("SELECT * FROM PRODUTO WHERE CODIGO = ? ORDER BY NOME");
            comandoProduto.setInt(1,this.codigoProduto);
            ResultSet rsProduto = comandoProduto.executeQuery();

            if(rsProduto.next()){
                this.campoCodigo.setText(rsProduto.getString("codigo"));
                this.campoNome.setText(rsProduto.getString("nome").trim());
                this.campoCompra.setText(rsProduto.getString("valorCompra"));
                this.campoMargem.setText(rsProduto.getString("margemLucro"));
                this.campoPercentualPromocao.setText(rsProduto.getString("promocao"));
                codigoGrupo = rsProduto.getInt("grupo");
            }

            PreparedStatement comandoGrupo = conexaoBD.prepareStatement("SELECT * FROM GRUPOPRODUTO ORDER BY NOME");
            ResultSet rs = comandoGrupo.executeQuery();
            List listaGrupo = new ArrayList();
            int codigo;
            String nome;
            while(rs.next()){
                codigo = rs.getInt("codigo");
                nome = rs.getString("nome");
                listaGrupo.add(codigo+"-"+nome);
                if(codigoGrupo == codigo){
                    posicaoSelecao = listaGrupo.size()-1;
                }
            }
            this.comboGrupoProduto.setModel(new DefaultComboBoxModel(listaGrupo.toArray()));
            this.comboGrupoProduto.setSelectedIndex(posicaoSelecao);
            comandoGrupo.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao incluir novo produto" + ex.toString());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        campoMargem = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboGrupoProduto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        campoPercentualPromocao = new javax.swing.JTextField();

        setTitle("Alteração de Produtos");
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
        jLabel1.setBounds(30, 60, 60, 20);

        jLabel3.setText("Valor Compra");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 100, 20);

        jLabel4.setText("% Margem Lucro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 130, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(60, 240, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(350, 240, 110, 30);
        getContentPane().add(campoMargem);
        campoMargem.setBounds(170, 120, 100, 20);
        getContentPane().add(campoNome);
        campoNome.setBounds(170, 60, 320, 20);
        getContentPane().add(campoCompra);
        campoCompra.setBounds(170, 90, 100, 20);

        jLabel5.setText("Código");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 30, 60, 20);

        campoCodigo.setEditable(false);
        getContentPane().add(campoCodigo);
        campoCodigo.setBounds(170, 30, 100, 20);

        jLabel6.setText("Grupo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 180, 90, 20);

        getContentPane().add(comboGrupoProduto);
        comboGrupoProduto.setBounds(170, 180, 230, 27);

        jLabel7.setText("% Promocao");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 150, 90, 20);
        getContentPane().add(campoPercentualPromocao);
        campoPercentualPromocao.setBounds(170, 150, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-522)/2, (screenSize.height-312)/2, 522, 312);
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
    this.confirmaOperacao();
    this.closeDialog(null);
}//GEN-LAST:event_botaoConfirmaActionPerformed

private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
    this.closeDialog(null);
}//GEN-LAST:event_botaoCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoCompra;
    private javax.swing.JTextField campoMargem;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPercentualPromocao;
    private javax.swing.JComboBox comboGrupoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

}
