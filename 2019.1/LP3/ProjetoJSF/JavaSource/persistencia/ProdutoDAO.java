package persistencia;

import java.util.LinkedList;
import java.util.List;

import vo.ProdutoVO;

public class ProdutoDAO extends DAO<ProdutoVO> {
	private static ProdutoDAO dao;
	
	private ProdutoDAO(List<ProdutoVO> lista) {
		super(lista);
	}
	
	public static ProdutoDAO getInstance() {
		if(dao == null)
			dao = new ProdutoDAO(Database.produtos);
		return dao;
	}
	
	public List<ProdutoVO> getByNome(String nome){
		List<ProdutoVO> lista = new LinkedList<ProdutoVO>();
		for(ProdutoVO vo : getAll()) {
			if(vo.getNome().toUpperCase().indexOf(nome.toUpperCase()) >= 0)
				lista.add(vo);
		}
		return lista;
	}
}
