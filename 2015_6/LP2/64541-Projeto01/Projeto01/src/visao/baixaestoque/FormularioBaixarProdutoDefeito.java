package visao.baixaestoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FormularioBaixarProdutoDefeito extends JDialog {

    private Connection conexaoBD;

    public FormularioBaixarProdutoDefeito() {
        initComponents();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.campoData.setText(formato.format(Calendar.getInstance().getTime()));
    }

    private void confirmaOperacao() {

        java.sql.Date dataSQL;
        int codigo;
        int quantidade;

        try {
            codigo = Integer.parseInt(campoCodigo.getText());
            quantidade = Integer.parseInt(campoQuantidade.getText());
            dataSQL = this.converteData(this.campoData.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digitacao inconscistente " + ex.toString());
            return;
        }

        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(this, "A quantidade a ser baixada deve ser maior que zero");
            campoQuantidade.requestFocus();
            return;
        }

        try {
            PreparedStatement comando1 = conexaoBD.prepareStatement("INSERT INTO REGISTROBAIXA ( MOTIVO, DATA, PRODUTO, QUANTIDADE )VALUES (? , ?, ?, ?)");
            comando1.setInt(1, 1);
            comando1.setDate(2, dataSQL);
            comando1.setInt(3, codigo);
            comando1.setInt(4, quantidade);

            PreparedStatement comando2 = conexaoBD.prepareStatement("UPDATE PRODUTO SET ESTOQUE=(ESTOQUE - ?) WHERE CODIGO=?");
            comando2.setInt(1, quantidade);
            comando2.setInt(2, codigo);

            comando1.executeUpdate();
            comando1.close();
            comando2.executeUpdate();
            comando2.close();
            JOptionPane.showMessageDialog(this, "Baixa realizada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao baixar estoque do produto" + ex.toString());
            try {
                conexaoBD.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }

    private java.sql.Date converteData(String dataString) throws Exception {
        java.sql.Date retorno = null;
        try {
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            retorno = new java.sql.Date(((java.util.Date) formatador.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw new Exception("Data inválida");
        }
        return retorno;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoQuantidade = new javax.swing.JTextField();
        botaoConfirma = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();

        setTitle("Baixa de Estoque por Defeito");
        setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(campoQuantidade);
        campoQuantidade.setBounds(100, 80, 140, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(20, 150, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(270, 150, 110, 30);

        jLabel2.setText("Quantidade");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 80, 90, 20);

        jLabel5.setText("Código");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 20, 80, 20);

        campoCodigo.setEditable(false);
        getContentPane().add(campoCodigo);
        campoCodigo.setBounds(100, 20, 140, 20);

        jLabel3.setText("Data");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 110, 90, 20);
        getContentPane().add(campoData);
        campoData.setBounds(100, 110, 140, 20);

        jLabel4.setText("Nome");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 50, 90, 20);

        campoNome.setEditable(false);
        getContentPane().add(campoNome);
        campoNome.setBounds(100, 50, 270, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-409)/2, (screenSize.height-222)/2, 409, 222);
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
    private javax.swing.JTextField campoData;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoQuantidade;
    private javax.swing.JLabel jLabel2;
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
}
