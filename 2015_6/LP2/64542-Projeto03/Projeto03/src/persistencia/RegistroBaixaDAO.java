package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import vo.BaixaVO;

public class RegistroBaixaDAO extends DAO {
    
    public RegistroBaixaDAO(ConexaoBD conexao) throws PersistenciaException {
        super(conexao);
    }

    public void registrarBaixaEstoque(BaixaVO baixaVO) throws PersistenciaException {
        try {
            PreparedStatement comando1 = conexao.getConexao().prepareStatement("INSERT INTO REGISTROBAIXA ( MOTIVO, DATA, PRODUTO, QUANTIDADE )VALUES (? , ?, ?, ?)");
            comando1.setInt(1, baixaVO.getMotivo());
            comando1.setDate(2, baixaVO.getData());
            comando1.setInt(3, baixaVO.getProduto());
            comando1.setInt(4, baixaVO.getQuantidade());

            comando1.executeUpdate();
            comando1.close();
            conexao.getConexao().commit();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao registrar a baixa estoque do produto" + ex.toString());
        }
    }


}
