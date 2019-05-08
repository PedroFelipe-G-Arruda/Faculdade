package negocio;

import java.util.List;

import persistencia.ProdutoDAO;
import vo.ProdutoVO;

public class Produto {
	public void save(ProdutoVO vo) throws ProdutoException {
		if(vo.getNome() == null || vo.getNome().trim().equals(""))
			throw new ProdutoException(ProdutoException.NOME_OBRIGATORIO);
		if(vo.getNome().trim().length()<5 || vo.getNome().trim().length()>60)
			throw new ProdutoException(ProdutoException.NOME_TAMANHO);
		if(vo.getQtde() < 0)
			throw new ProdutoException(ProdutoException.TIPO_OBRIGATORIO);
		if(vo.getValorUnitario() < 0)
			throw new ProdutoException(ProdutoException.VALOR_UNITARIO);
		
		ProdutoDAO.getInstance().save(vo);
	}
	
	public void delete(ProdutoVO vo) throws ProdutoException {
		if(vo.getQtde() > 0)
			throw new ProdutoException(ProdutoException.QTDE_POSITIVA);
		ProdutoDAO.getInstance().delete(vo);
	}
	
	public ProdutoVO getById(long id) {
		return ProdutoDAO.getInstance().getById(id);
	}
	
	public List<ProdutoVO> getAll(){
		return ProdutoDAO.getInstance().getAll();
	}
	
	public List<ProdutoVO> getByNome(String nome){
		return ProdutoDAO.getInstance().getByNome(nome);
	}
}
