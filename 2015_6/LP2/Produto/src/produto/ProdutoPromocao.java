package produto;

public class ProdutoPromocao extends Produto {
    private float precPromocao;

    public float getPrecPromocao() {
        return precPromocao;
    }
    public void setPrecPromocao(float prec) {
        if(prec>=0 && prec<50)
        this.precPromocao = prec;
    }
    public float getPreco(){
        return preco-(preco*precPromocao/100);
    }
}