package persistencia;

import java.sql.SQLException;

public class DAO {

    protected ConexaoBD conexao;

    public DAO(ConexaoBD conexao) throws PersistenciaException {
        this.conexao = conexao;
    }

    public void iniciarTransacao() throws PersistenciaException {
        try {
            if (this.conexao.getConexao().getAutoCommit()) {
                this.conexao.getConexao().setAutoCommit(false);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Transacao nao iniciada");
        }
    }

    public void confirmarTransacao() throws PersistenciaException {
        try {
            if (!this.conexao.getConexao().getAutoCommit()) {
                this.conexao.getConexao().commit();
                this.conexao.getConexao().setAutoCommit(true);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Transacao nao confirmada");
        }
    }

    public void cancelarTransacao(){
        try {
            if (!this.conexao.getConexao().getAutoCommit()) {
                this.conexao.getConexao().rollback();
                this.conexao.getConexao().setAutoCommit(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ConexaoBD getConexao() {
        return conexao;
    }

    public void setConexao(ConexaoBD conexao) {
        this.conexao = conexao;
    }
    
    public void desconectarBD() throws PersistenciaException {
        conexao.desconectar();
    }
}
