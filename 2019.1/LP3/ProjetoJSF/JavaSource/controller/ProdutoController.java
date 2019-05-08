package controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import negocio.Produto;
import negocio.ProdutoException;
import vo.ProdutoVO;

public class ProdutoController {

		private ProdutoVO vo = new ProdutoVO();
		private Produto produto = new Produto();
		private DataModel<ProdutoVO> produtos;
		private String nomePesquisa;
		
		public String getNomePesquisa() {
			return nomePesquisa;
		}
		
		public void setNomePesquisa(String nomePesquisa) {
			this.nomePesquisa = nomePesquisa;
		}
		
		public DataModel<PodutoVO> getProdutos(){
			if(nomePesquisa==null || nomePesquisa.trim().length()==0) {
				produtos = new ListDataModel<ProdutoVO>(produto.getAll());
			}else {
				produtos = new ListDataModel<ProdutoVO>(produto.getByNome(nomePesquisa));
			}
			return produtos;
		}
		
		public void novo(ActionEvent evt) {vo = new ProdutoVO();}
		
		public void setProdutos(DataModel<ProdutoVO> produtos) {
			this.produtos = produtos;
		}
		
		public ProdutoVO getVO() {return vo;}
		public void setVO
		public void prepararAçterarProduto(ActionEvent evt) {vo = (ProdutoVO)produtos.getRowData();}
		public void prepararAicionarProduto(ActionEvent evt) {vo = new ProdutoVO();}
		
		public void salvarProduto(ActionEvent evt) {
			try {
				if(vo.getId() == null)
					produto.save(vo);
				vo = new ProdutoVO();
				FacesContext.getCurrentInstance().addMessage("frmEdicaoProduto", new FacesMessage("Produto Salvo com Sucesso!"));
			}catch (ProdutoException e) {
				FacesContext.getCurrentInstance().addMessage("frmEdicaoProduto", new FacesMessage(e.getMessage()));
			}
		}
}
