package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.BaixaVO;
import vo.ProdutoVO;

public class ProdutoDAO extends DAO {
    
    private GrupoProdutoDAO grupoDAO;

    public ProdutoDAO(ConexaoBD conexao) throws PersistenciaException {
        super(conexao);
        this.grupoDAO = new GrupoProdutoDAO(conexao);
    }

    public int incluir(ProdutoVO produto) throws PersistenciaException {
        int retorno = 0;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(
                    "INSERT INTO PRODUTO ( NOME, ESTOQUE, VALORCOMPRA, MARGEMLUCRO, " +
                    "PROMOCAO, GRUPO )VALUES (? , ?, ?, ?, ?, ?)");
            comando.setString(1, produto.getNome());
            comando.setInt(2, produto.getEstoque());
            comando.setFloat(3, produto.getPrecoCompra());
            comando.setFloat(4, produto.getMargemLucro());
            comando.setFloat(5, produto.getPromocao());
            comando.setInt(6, produto.getGrupo().getCodigo());
            retorno = comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao incluir novo produto - "+ex.getMessage());
        }
        return retorno;
    }

    public int alterar(ProdutoVO produto) throws PersistenciaException {
        int retorno = 0;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(
                    "UPDATE PRODUTO SET NOME=?, VALORCOMPRA=?, MARGEMLUCRO=?, " +
                    "PROMOCAO=?, GRUPO=?  WHERE CODIGO=?");
            comando.setString(1, produto.getNome());
            comando.setFloat(2, produto.getPrecoCompra());
            comando.setFloat(3, produto.getMargemLucro());
            comando.setFloat(4, produto.getPromocao());
            comando.setInt(5, produto.getGrupo().getCodigo());
            comando.setInt(6, produto.getCodigo());
            retorno = comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao alterar o produto - "+ex.getMessage());
        }
        return retorno;
    }

    public int excluir(int codigo) throws PersistenciaException {
        int retorno = 0;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE CODIGO=?");
            comando.setInt(1, codigo);
            retorno = comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao excluir o produto - "+ex.getMessage());
        }
        return retorno;
    }

    public ProdutoVO buscarPorCodigo(int codigo) throws PersistenciaException {

        ProdutoVO pro = null;

        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE CODIGO = ?");
            comando.setInt(1, codigo);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                pro = new ProdutoVO();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNome(rs.getString("Nome").trim());
                pro.setEstoque(rs.getInt("Estoque"));
                pro.setPrecoCompra(rs.getFloat("ValorCompra"));
                pro.setMargemLucro(rs.getFloat("MargemLucro"));
                pro.setPromocao(rs.getFloat("promocao"));
                pro.setGrupo(grupoDAO.buscarPorCodigo(rs.getInt("grupo")));
            }
            comando.close();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na seleção por codigo - "+ex.getMessage());
        }
        return pro;
    }

    public List buscarPorNome(String nome) throws PersistenciaException {
        List lista = new ArrayList();
        ProdutoVO pro = null;

        String comandoSQL = "SELECT * FROM PRODUTO WHERE UPPER(NOME) LIKE '" + nome.trim().toUpperCase() + "%' ORDER BY NOME LIMIT 10";

        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                pro = new ProdutoVO();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNome(rs.getString("Nome").trim());
                pro.setEstoque(rs.getInt("Estoque"));
                pro.setPrecoCompra(rs.getFloat("ValorCompra"));
                pro.setMargemLucro(rs.getFloat("MargemLucro"));
                pro.setPromocao(rs.getFloat("promocao"));
                pro.setGrupo(grupoDAO.buscarPorCodigo(rs.getInt("grupo")));
                lista.add(pro);
            }
            comando.close();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na seleção por nome - "+ex.getMessage());
        }
        return lista;
    }

    public List buscarPorGrupo(int codigoGrupo) throws PersistenciaException {
        List lista = new ArrayList();
        ProdutoVO pro = null;
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE GRUPO = ?");
            comando.setInt(1, codigoGrupo);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                pro = new ProdutoVO();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNome(rs.getString("Nome").trim());
                pro.setEstoque(rs.getInt("Estoque"));
                pro.setPrecoCompra(rs.getFloat("ValorCompra"));
                pro.setMargemLucro(rs.getFloat("MargemLucro"));
                pro.setPromocao(rs.getFloat("promocao"));
                pro.setGrupo(grupoDAO.buscarPorCodigo(rs.getInt("grupo")));
                lista.add(pro);
            }
            comando.close();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na seleção por grupo - "+ex.getMessage());
        }
        return lista;
    }
    
    public void baixarEstoque(BaixaVO baixaVO) throws PersistenciaException {
        try {
            PreparedStatement comando1 = conexao.getConexao().prepareStatement("UPDATE PRODUTO SET ESTOQUE=(ESTOQUE - ?) WHERE CODIGO=?");
            comando1.setInt(1, baixaVO.getQuantidade());
            comando1.setInt(2, baixaVO.getProduto());
            comando1.executeUpdate();
            comando1.close();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao baixar estoque do produto" + ex.toString());
        }
    }


}
