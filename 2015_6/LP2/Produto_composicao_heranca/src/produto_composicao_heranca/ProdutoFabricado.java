/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto_composicao_heranca;

public class ProdutoFabricado extends Produto{
    private float valorMateriaPrima;
    private float valorMaoObra;
    
public float getPreco(){
    float valorBase, valorMargem;
    valorBase = valorMateriaPrima + valorMaoObra;
valorMargem = valorBase * getPercMargem()/100;
return valorBase+valorMargem;
}
    /**
     * @return the valorMateriaPrima
     */
    public float getValorMateriaPrima() {
        return valorMateriaPrima;
    }

    /**
     * @param valorMateriaPrima the valorMateriaPrima to set
     */
    public void setValorMateriaPrima(float valorMateriaPrima) {
        this.valorMateriaPrima = valorMateriaPrima;
    }

    /**
     * @return the valorMaoObra
     */
    public float getValorMaoObra() {
        return valorMaoObra;
    }

    /**
     * @param valorMaoObra the valorMaoObra to set
     */
    public void setValorMaoObra(float valorMaoObra) {
        this.valorMaoObra = valorMaoObra;
    }
}