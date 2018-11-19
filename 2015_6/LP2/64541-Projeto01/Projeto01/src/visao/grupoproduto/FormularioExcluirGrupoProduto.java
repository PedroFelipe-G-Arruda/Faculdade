package visao.grupoproduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FormularioExcluirGrupoProduto extends JDialog {

    private Connection conexaoBD;

    public FormularioExcluirGrupoProduto() {
        initComponents();
    }

    private void confirmaOperacao() {

        int codigo = Integer.parseInt(campoCodigo.getText());

        try {

            PreparedStatement comando = conexaoBD.prepareStatement("DELETE FROM GRUPOPRODUTO WHERE CODIGO=?");
            comando.setInt(1, codigo);
            comando.executeUpdate();
            comando.close();
            JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao excluir o grupo de produto" + ex.toString());
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
        campoPromocao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();

        setTitle("Exclusão de Grupo de Produtos");
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

        jLabel3.setText("% Promoção");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 90, 90, 20);

        jLabel4.setText("% Margem Lucro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 120, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(50, 160, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(300, 160, 110, 30);

        campoMargem.setEditable(false);
        getContentPane().add(campoMargem);
        campoMargem.setBounds(150, 120, 100, 20);

        campoNome.setEditable(false);
        getContentPane().add(campoNome);
        campoNome.setBounds(150, 60, 310, 20);

        campoPromocao.setEditable(false);
        getContentPane().add(campoPromocao);
        campoPromocao.setBounds(150, 90, 100, 20);

        jLabel5.setText("Código");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 30, 60, 20);

        campoCodigo.setEditable(false);
        getContentPane().add(campoCodigo);
        campoCodigo.setBounds(150, 30, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-499)/2, (screenSize.height-235)/2, 499, 235);
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
    private javax.swing.JTextField campoMargem;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPromocao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    public void setConexao(Connection conexao) {
        this.conexaoBD = conexao;
    }

    public void setCodigo(String codigo) {
        this.campoCodigo.setText(codigo);
    }

    public void setNome(String nome) {
        this.campoNome.setText(nome);
    }

    public void setPromocao(String promocao) {
        this.campoPromocao.setText(promocao);
    }

    public void setMargem(String margem) {
        this.campoMargem.setText(margem);
    }
}
