/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto_composicao_heranca;

/**
 *
 * @author sky
 */
public class ProdutoPromocao implements IProduto{
    private float percPromocao;
    private IProduto produto;
public ProdutoPromocao(IProduto pro){
    produto = pro;
}
public void setNome(String pNome){
    produto.setNome(pNome);
}
public String getNome(){
    return produto.getNome();
}
public void setEstoque(int pEstoque){
    produto.setEstoque(pEstoque);
}
public int getEstoque(){
    return produto.getEstoque();
}
public void setPercPromocao(float perc){
    if(perc >=0 && perc<50)
        percPromocao = perc;
}
public float getPercPromocao(){
    return percPromocao;
}
public float getPreco(){
    return produto.getPreco()-(produto.getPreco()*percPromocao/100);
}
}