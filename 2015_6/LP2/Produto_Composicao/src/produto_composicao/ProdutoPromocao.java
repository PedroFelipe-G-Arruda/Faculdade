/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto_composicao;

/**
 *
 * @author osana
 */
public class ProdutoPromocao implements IProduto{
    
    private float percPromocao;
    private IProduto produto;
    
    public ProdutoPromocao(){
        produto = new Produto();
    }
    public ProdutoPromocao(IProduto pro){
        produto = pro;
    }
    public void setNome(String pNome){
        produto.setNome(pNome);
    }
    public String getNome(){
        return produto.getNome();
    }
    public void setPreco(float pPreco){
        produto.setPreco(pPreco);
    }
    public float getPreco(){
        return produto.getPreco() - (produto.getPreco()* percPromocao/100);
    }
    public void setEstoque(int pEstoque){
        produto.setEstoque(pEstoque);
    }
    public int getEstoque(){
        return produto.getEstoque();
    }
    /**
     * @return the percPromocao
     */
    public float getPercPromocao() {
        return percPromocao;
    }

    /**
     * @param percPromocao the percPromocao to set
     */
    public void setPercPromocao(float percPromocao) {
        if(percPromocao>=0 && percPromocao<50)
        this.percPromocao = percPromocao;
    }
    
    
}