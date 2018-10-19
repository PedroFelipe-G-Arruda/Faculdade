/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.AlunoVO;
import vo.EnumSexo;
import vo.EnumUF;

/**
 *
 * @author Pedro Arruda
 */
public class AlunoDAO extends DAO {

    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscarMatricula;

    public AlunoDAO(ConexaoBD conexao) throws PersistenciaException {
        super(conexao);
        try {
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO Aluno ( nome, nomemae, nomepai, sexo, " + "logradouro, numero, bairro, cidade ,uf ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Aluno SET nome=?, nomemae=?, nomepai=?, sexo=?," + "logradouro=?, numero=?, bairro=?, cidade=?, uf=? WHERE matricula=?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM Aluno WHERE matricula=?");
            comandoBuscarMatricula = conexao.getConexao().prepareStatement("SELECT * FROM Aluno WHERE matricula=?");
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao incluir novo aluno - " + ex.getMessage());
        }
    }

    public int incluir(AlunoVO alunoVO) throws PersistenciaException {
        int retorno = 0;
        try {
            comandoIncluir.setString(1, alunoVO.getNome());
            comandoIncluir.setString(2, alunoVO.getNome());
            comandoIncluir.setString(3, alunoVO.getNomePai());
            comandoIncluir.setInt(4, alunoVO.getSexo().ordinal());
            comandoIncluir.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoIncluir.setInt(6, alunoVO.getEndereco().getNumero());
            comandoIncluir.setString(7, alunoVO.getEndereco().getBairro());
            comandoIncluir.setString(8, alunoVO.getEndereco().getCidade());
            comandoIncluir.setString(9, alunoVO.getEndereco().getUf().name());
            retorno = comandoIncluir.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao incluir novo aluno - " + ex.getMessage());
        }
        return retorno;
    }

    public int alterar(AlunoVO alunoVO) throws PersistenciaException {
        int retorno = 0;
        try {
            comandoAlterar.setString(1, alunoVO.getNome());
            comandoAlterar.setString(2, alunoVO.getNome());
            comandoAlterar.setString(3, alunoVO.getNomePai());
            comandoAlterar.setInt(4, alunoVO.getSexo().ordinal());
            comandoAlterar.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoAlterar.setInt(6, alunoVO.getEndereco().getNumero());
            comandoAlterar.setString(7, alunoVO.getEndereco().getBairro());
            comandoAlterar.setString(8, alunoVO.getEndereco().getCidade());
            comandoAlterar.setString(9, alunoVO.getEndereco().getUf().name());
            retorno = comandoAlterar.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao alterar o aluno - " + ex.getMessage());
        }
        return retorno;
    }

    public int excluir(int matricula) throws PersistenciaException {
        int retorno = 0;
        try {
            comandoExcluir.setInt(1, matricula);
            retorno = comandoExcluir.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Erro ao excluir o aluno - " + ex.getMessage());
        }
        return retorno;
    }

    public AlunoVO buscaPorMatricula(int matricula) throws PersistenciaException {
        AlunoVO alu = null;
        try {
            comandoBuscarMatricula.setInt(1, matricula);
            ResultSet rs = comandoBuscarMatricula.executeQuery();
            if (rs.next()) {
                alu = new AlunoVO();
                alu.setMatricula(rs.getInt("matricula"));
                alu.setNome(rs.getString("Nome").trim());
                alu.setNomeMae(rs.getString("nomemae"));
                alu.setNomePai(rs.getString("nomeapai"));
                alu.setSexo(EnumSexo.values()[rs.getInt("sexo")]);
                alu.getEndereco().setLogradouro(rs.getString("logradouro"));
                alu.getEndereco().setNumero(rs.getInt("numero"));
                alu.getEndereco().setBairro(rs.getString("bairro"));
                alu.getEndereco().setCidade(rs.getString("cidade"));
                alu.getEndereco().setUf(EnumUF.valueOf(rs.getString("uf")));
            }
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na seleção por codigo-  " + ex.getMessage());
        }
        return alu;
    }

    public List<AlunoVO> buscarPorNome(String nome) throws PersistenciaException {
        List<AlunoVO> listaAluno = new ArrayList();
        AlunoVO alu = null;

        String comandoSQL = "SELECT * FROM Aluno WHERE UPPER(nome) LIKE'" + nome.trim().toUpperCase() + "%'ORDER BY NOME LITIME 10";
        try {
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                alu = new AlunoVO();
                alu.setMatricula(rs.getInt("matricula"));
                alu.setNome(rs.getString("Nome").trim());
                alu.setNomeMae(rs.getString("nomemae"));
                alu.setNomePai(rs.getString("nomeapai"));
                alu.setSexo(EnumSexo.values()[rs.getInt("sexo")]);
                alu.getEndereco().setLogradouro(rs.getString("logradouro"));
                alu.getEndereco().setNumero(rs.getInt("numero"));
                alu.getEndereco().setBairro(rs.getString("bairro"));
                alu.getEndereco().setCidade(rs.getString("cidade"));
                alu.getEndereco().setUf(EnumUF.valueOf(rs.getString("uf")));
            }
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na seleção por nome - " + ex.getMessage());
        }
        return listaAluno;
    }
}
