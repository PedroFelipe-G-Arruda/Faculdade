package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.GrupoProdutoVO;

public class GrupoProdutoDAO extends DAO {

    public GrupoProdutoDAO(ConexaoBD conexao) throws PersistenciaException {
        super(conexao);
    }

    public boolean incluir(GrupoProdutoVO grupoProdutoVO) throws PersistenciaException {
        boolean retorno = false;
        try {
            PreparedStatement comando = this.conexao.getConexao().prepareStatement(
                    "INSERT INTO GRUPOPRODUTO ( NOME, MARGEMLUCRO, PROMOCAO ) VALUES (?, ?, ?)");
            comando.setString(1, grupoProdutoVO.getNome());
            comando.setFloat(2, grupoProdutoVO.getMargemLucro());
            comando.setFloat(3, grupoProdutoVO.getPromocao());
            comando.executeUpdate();
            comando.close();
            retorno = true;
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao incluir novo grupo de Produto - "+ex.getMessage());
        }
        return retorno;
    }

    public int alterar(GrupoProdutoVO grupoProdutoVO) throws PersistenciaException {
        int resu = -1;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("UPDATE GRUPOPRODUTO SET NOME=?, MARGEMLUCRO=?, PROMOCAO=? WHERE CODIGO=?");
            comando.setString(1, grupoProdutoVO.getNome());
            comando.setFloat(2, grupoProdutoVO.getMargemLucro());
            comando.setFloat(3, grupoProdutoVO.getPromocao());
            comando.setInt(4, grupoProdutoVO.getCodigo());
            resu = comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao alterar o Grupo Produto - "+ex.getMessage());
        }
        return resu;
    }

    public int excluir(int codigo) throws PersistenciaException {
        int resu = -1;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("DELETE FROM GRUPOPRODUTO WHERE CODIGO=?");
            comando.setInt(1, codigo);
            resu = comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao excluir o Grupo de Produto - "+ex.getMessage());
        }
        return resu;
    }

    public GrupoProdutoVO buscarPorCodigo(int codigo) throws PersistenciaException {

        GrupoProdutoVO gru = null;

        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM GRUPOPRODUTO WHERE CODIGO = ?");
            comando.setInt(1, codigo);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                gru = new GrupoProdutoVO();
                gru.setCodigo(rs.getInt("codigo"));
                gru.setNome(rs.getString("Nome").trim());
                gru.setMargemLucro(rs.getFloat("MargemLucro"));
                gru.setPromocao(rs.getFloat("Promocao"));
            }
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro na seleção por codigo - "+ex.getMessage());
        }
        return gru;
    }

    public List<GrupoProdutoVO> buscarTodos() throws PersistenciaException {
        List lista = new ArrayList();
        GrupoProdutoVO gru = null;

        String comandoSQL = "SELECT * FROM GrupoProduto ORDER BY NOME";

        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                gru = new GrupoProdutoVO();
                gru.setCodigo(rs.getInt("codigo"));
                gru.setNome(rs.getString("Nome").trim());
                gru.setMargemLucro(rs.getFloat("MargemLucro"));
                gru.setPromocao(rs.getFloat("Promocao"));
                lista.add(gru);
            }
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro na seleção - "+ex.getMessage());
        }
        return lista;
    }
}
