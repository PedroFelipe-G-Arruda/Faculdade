package visao.grupo;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import negocio.ManutencaoGrupoProduto;
import negocio.NegocioException;
import vo.GrupoProdutoVO;

public class FormularioIncluirGrupoProduto extends JDialog {

    private ManutencaoGrupoProduto grupo;

    public FormularioIncluirGrupoProduto() {
        initComponents();
        try {
            grupo = new ManutencaoGrupoProduto();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void confirmaOperacao() {
        String nome = null;
        float promocao = 0;
        float margem = 0;

        try {
            nome = this.campoNome.getText();
            promocao = Float.parseFloat(this.campoPromocao.getText());
            margem = Float.parseFloat(this.campoMargem.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digitacao inconscistente");
            return;
        }

        try {
            GrupoProdutoVO grupoVO = new GrupoProdutoVO();
            grupoVO.setNome(nome);
            grupoVO.setMargemLucro(margem);
            grupoVO.setPromocao(promocao);
            grupo.inserir(grupoVO);
            JOptionPane.showMessageDialog(this, "Inclusão realizada com sucesso");
            this.limparCampos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void limparCampos() {
        this.campoPromocao.setText("");
        this.campoMargem.setText("");
        this.campoNome.setText("");
        this.campoNome.requestFocus();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        campoMargem = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoPromocao = new javax.swing.JTextField();

        setTitle("Inclusão de Grupos de Produtos");
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
        jLabel1.setBounds(30, 30, 60, 20);

        jLabel2.setText("% Promoção");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 100, 20);

        jLabel4.setText("% Margem Lucro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 90, 130, 20);

        botaoConfirma.setText("Confirmar");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirma);
        botaoConfirma.setBounds(50, 140, 110, 30);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoCancelar);
        botaoCancelar.setBounds(330, 140, 110, 30);
        getContentPane().add(campoMargem);
        campoMargem.setBounds(180, 90, 100, 20);
        getContentPane().add(campoNome);
        campoNome.setBounds(180, 30, 300, 20);
        getContentPane().add(campoPromocao);
        campoPromocao.setBounds(180, 60, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-511)/2, (screenSize.height-214)/2, 511, 214);
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
    private javax.swing.JTextField campoMargem;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPromocao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
