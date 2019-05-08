package persistencia;

import java.util.LinkedList;
import java.util.List;

import vo.ProdutoVO;
import vo.enumerado.TipoProdutoEnum;

public class Database {
	public static final List<ProdutoVO> produtos = new LinkedList<ProdutoVO>();
	
	static {
		ProdutoVO vo = new ProdutoVO();
		vo.setId(1L);
		vo.setNome("Teste");
		vo.setQtde(10);
		vo.setTipo(TipoProdutoEnum.ALIMENTICIO);
		vo.setValorUnitario(1.2f);
		produtos.add(vo);
	}
	
	private Database(){}
}
