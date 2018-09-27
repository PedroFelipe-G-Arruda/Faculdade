package produto_composicao;

public class ProdutoLiquidacao implements IProduto{
    
    private IProduto produto;
    
    public ProdutoLiquidacao(){
        produto=new Produto();
    }
    public ProdutoLiquidacao(IProduto pro){
        produto =pro;
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
    public void setEstoque(int pEstoque){
        produto.setEstoque(pEstoque);
    }
    public int getEstoque(){
        return produto.getEstoque();
    }
    public float getPreco(){
        return produto.getPreco()/2;
    }
}