package visao.produto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import negocio.ManutencaoGrupoProduto;
import negocio.ManutencaoProduto;
import negocio.NegocioException;
import vo.GrupoProdutoVO;
import vo.ProdutoVO;

public class FormularioAlterarProduto extends JDialog {

    private int codigoProduto;
    private ManutencaoProduto produto;
    private ManutencaoGrupoProduto grupo;

    public FormularioAlterarProduto(int codigo) {
        this.codigoProduto = codigo;
        initComponents();
        try {
            produto = new ManutencaoProduto();
            grupo = new ManutencaoGrupoProduto();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.preecheCampos();
    }

    private void confirmaOperacao() {

        String nome = null;
        float compra = 0;
        float margem = 0;
        float promocao = 0;
        try {
            nome = this.campoNome.getText();
            compra = Float.parseFloat(this.campoCompra.getText());
            margem = Float.parseFloat(this.campoMargem.getText());
            promocao = Float.parseFloat(this.campoPercentualPromocao.getText());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Digitacao inconscistente");
            return;
        }


        try {
            ManutencaoProduto manutencaoProduto = new ManutencaoProduto();
            ProdutoVO produtoVO = new ProdutoVO();
            produtoVO.setCodigo(this.codigoProduto);
            produtoVO.setNome(nome);
            produtoVO.setPrecoCompra(compra);
            produtoVO.setMargemLucro(margem);
            produtoVO.setPromocao(promocao);
            produtoVO.setGrupo((GrupoProdutoVO)this.comboGrupoProduto.getSelectedItem());
            manutencaoProduto.alterar(produtoVO);
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void preecheCampos() {
        try {
            ProdutoVO produtoVO = produto.pesquisaCodigo(codigoProduto);

            if (produtoVO != null) {
                this.campoCodigo.setText(String.valueOf(produtoVO.getCodigo()));
                this.campoNome.setText(produtoVO.getNome());
                this.campoCompra.setText(String.valueOf(produtoVO.getPrecoCompra()));
                this.campoMargem.setText(String.valueOf(produtoVO.getMargemLucro()));
                this.campoPercentualPromocao.setText(String.valueOf(produtoVO.getPromocao()));
            }
            this.comboGrupoProduto.setModel(new DefaultComboBoxModel(grupo.buscarTodos().toArray()));
            this.comboGrupoProduto.setSelectedItem(produtoVO.getGrupo());
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar dados de produtos \n" + ex.toString());
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
        comboGrupoProduto.setBounds(170, 180, 230, 20);

        jLabel7.setText("% Promocao");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 150, 90, 20);
        getContentPane().add(campoPercentualPromocao);
        campoPercentualPromocao.setBounds(170, 150, 100, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-522)/2, (screenSize.height-325)/2, 522, 325);
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
