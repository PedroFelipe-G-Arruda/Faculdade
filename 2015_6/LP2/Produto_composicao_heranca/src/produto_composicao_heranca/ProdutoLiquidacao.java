package produto_composicao_heranca;

/**
 *
 * @author sky
 */
public class ProdutoLiquidacao implements IProduto{
    private IProduto produto;
    
public ProdutoLiquidacao(IProduto pro){
    produto = pro;
}
    /**
     * @return the nome
     */
    public String getNome() {
        return produto.getNome();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        produto.setNome(nome);
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return produto.getEstoque();
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        produto.setEstoque(estoque);
    }
public float getPreco(){
    return produto.getPreco()/2;
}
}