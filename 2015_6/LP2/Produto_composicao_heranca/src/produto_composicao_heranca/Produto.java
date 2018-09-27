package produto_composicao_heranca;

public abstract class Produto implements IProduto{
    private String nome;
    private int estoque;
    private float percMargem;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the percMargem
     */
    public float getPercMargem() {
        return percMargem;
    }

    /**
     * @param percMargem the percMargem to set
     */
    public void setPercMargem(float percMargem) {
        this.percMargem = percMargem;
    }
}