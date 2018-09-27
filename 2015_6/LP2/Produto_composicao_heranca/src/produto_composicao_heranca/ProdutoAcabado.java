/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto_composicao_heranca;

public class ProdutoAcabado extends Produto{
    private float valorCompra;

    public float getPreco(){
        float valorMargem;
        valorMargem = valorCompra * getPercMargem()/100;
        return valorCompra+valorMargem;
    }
    public void setValorCompra(float valor){
        valorCompra = valor;
    }
    public float getValorCompra(){
        return valorCompra;
    }
}