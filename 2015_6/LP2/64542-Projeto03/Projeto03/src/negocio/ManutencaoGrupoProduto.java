package negocio;

import java.util.List;
import persistencia.ConexaoBD;
import persistencia.GrupoProdutoDAO;
import persistencia.PersistenciaException;
import vo.GrupoProdutoVO;

public class ManutencaoGrupoProduto {

    private GrupoProdutoDAO grupoDAO;

    public ManutencaoGrupoProduto() throws NegocioException {
        try {
            grupoDAO = new GrupoProdutoDAO(ConexaoBD.getInstancia());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar Persistência "+ex.getMessage());
        }
    }

    public void inserir(GrupoProdutoVO grupoVO) throws NegocioException {

        String mensagemErros = this.validarDados(grupoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
           grupoDAO.incluir(grupoVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir novo grupo de produto - " + ex.getMessage());
        }
    }

    public void alterar(GrupoProdutoVO grupoVO) throws NegocioException {

        String mensagemErros = this.validarDados(grupoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
           grupoDAO.alterar(grupoVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar o grupo de produto - " + ex.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException {
        try {
           grupoDAO.excluir(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir o grupo de produto - " + ex.getMessage());
        }
    }

    public GrupoProdutoVO buscarPorCodigo(int codigo) throws NegocioException{
        try {
            return grupoDAO.buscarPorCodigo(codigo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    public List<GrupoProdutoVO> buscarTodos() throws NegocioException {
        try {
            return grupoDAO.buscarTodos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro na seleção por codigo - "+ex.getMessage());
        }
    }

    private String validarDados(GrupoProdutoVO grupoVO) {

        String mensagemErros = "";

        if (grupoVO.getNome().length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }

        if (grupoVO.getMargemLucro() < 0) {
            mensagemErros += "\nA margem de Lucro não pode ser negativa";
        }

        if (grupoVO.getPromocao() < 0 || grupoVO.getPromocao() > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100";
        }

        return mensagemErros;
    }
}
