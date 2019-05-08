package persistencia;

import java.util.List;

public abstract class DAO<VO extends Unique> {
	private List<VO> lista;
	
	public DAO(List<VO> lista) {
		this.lista = lista;
	}
	
	public void save(VO vo) {
		lista.add(vo);
	}
	
	public void delete(VO vo) {
		lista.remove(vo);
	}
	
	public VO getById(long id) {
		for(VO vo : lista)
			if(vo.getId() == id)
				return vo;
		return null;
	}
	
	public List<VO> getAll() {
		return lista;
	}
}
