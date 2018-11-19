package vo;

public class ProdutoVO {

    private int codigo;
    private String Nome;
    private int estoque;
    private float precoCompra;
    private float margemLucro;
    private float promocao;
    private float venda;
    private GrupoProdutoVO grupo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getMargemLucro() {
        return this.margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public float getPromocao() {
        return this.promocao;
    }

    public void setPromocao(float promocao) {
        this.promocao = promocao;
    }

    public GrupoProdutoVO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProdutoVO grupo) {
        this.grupo = grupo;
    }

    public float getVenda() {
        return venda;
    }

    public void setVenda(float venda) {
        this.venda = venda;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoVO other = (ProdutoVO) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
        return hash;
    }
    
}
