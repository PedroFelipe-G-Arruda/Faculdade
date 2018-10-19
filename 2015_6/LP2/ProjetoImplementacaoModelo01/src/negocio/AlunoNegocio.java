/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.AlunoDAO;
import persistencia.ConexaoBD;
import persistencia.PersistenciaException;
import vo.AlunoVO;

/**
 *
 * @author Pedro Arruda
 */
public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException {
        try {
            this.alunoDAO = new AlunoDAO(ConexaoBD.getInstancia());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar a Persistencia − " + ex.getMessage());
        }
    }

    public void inserir(AlunoVO alunoVO) throws NegocioException {
        String mensagemErros = this.validarDados(alunoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
            if (alunoDAO.incluir(alunoVO) == 0) {
                throw new NegocioException("InclusÃ£o nao realizada ! ! ");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir o produto − " + ex.getMessage());
        }
    }

    public void alterar(AlunoVO alunoVO) throws NegocioException {
        String mensagemErros = this.validarDados(alunoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
            if (alunoDAO.alterar(alunoVO) == 0) {
                throw new NegocioException("AlteraÃ§Ã£o nao realizada ! ! ");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar o aluno − " + ex.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException {
        try {
            if (alunoDAO.excluir(codigo) == 0) {
                throw new NegocioException("AlteraÃ§Ã£o nÃ£o realizada ! ! ");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o aluno − " + ex.getMessage());
        }
    }

    public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException {
        try {
            return alunoDAO.buscarPorNome(parteNome);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar aluno pelo nome − " + ex.getMessage());
        }
    }

    public AlunoVO pesquisaMatricula(int matricula) throws NegocioException {
        try {
            return alunoDAO.buscarPorMatricula(matricula);
        } catch (PersistenciaException ex) {
            throw new NegocioException(" Erro ao pesquisar aluno pela matricula − " + ex.getMessage());
        }
    }

    private String validarDados(AlunoVO alunoVO) {
        String mensagemErros = "";

        if (alunoVO.getNome() == null || alunoVO.getNome().length() == 0) {
            mensagemErros += "Nome do aluno nao pode ser vazio";
        }
        if (alunoVO.getNomeMae() == null || alunoVO.getNomeMae().length() == 0) {
            mensagemErros += "\nNome do mae nao pode ser vazio";
        }
        if (alunoVO.getNomePai() == null || alunoVO.getNomePai().length() == 0) {
            mensagemErros += "\nNome do pai nao pode ser vazio";
        }
        if (alunoVO.getSexo() == null) {
            mensagemErros += "\nSexo nao pode ser nulo";
        }
        if (alunoVO.getEndereco().getLogradouro() == null || alunoVO.getEndereco().getLogradouro().length() == 0) {
            mensagemErros += "\nLogradouro nao pode ser vazio";
        }
        if (alunoVO.getEndereco().getNumero() <= 0) {
            mensagemErros += "\nNumero deve ser maior que zero";
        }
        if (alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().length() == 0) {
            mensagemErros += "\nBairro nao pode ser vazio";
        }
        if (alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade().length() == 0) {
            mensagemErros += "\nCidade nao pode ser vazio";
        }
        if (alunoVO.getEndereco().getUf() == null) {
            mensagemErros += "\nUF nao pode ser vazio";
        }
        return mensagemErros;
    }

}
