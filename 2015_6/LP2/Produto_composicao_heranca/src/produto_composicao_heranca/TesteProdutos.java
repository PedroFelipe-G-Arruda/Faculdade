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
public class TesteProdutos {
    public static void main(String args[]){
    ProdutoAcabado produtoA;
    ProdutoFabricado produtoF;
    ProdutoPromocao produtoProm;
    ProdutoLiquidacao produtoLiq, produtoSuperLiq;

    produtoA = new ProdutoAcabado();
    produtoA.setNome("cerveja lata");
    produtoA.setPercMargem(50);
    produtoA.setValorCompra(2.00f);
    System.out.println(produtoA.getNome()+" - "+produtoA.getPreco());
    
    produtoF = new ProdutoFabricado();
    produtoF.setNome("sanduiche");
    produtoF.setPercMargem(20.00f);
    produtoF.setValorMateriaPrima(2.00f);
    produtoF.setValorMaoObra(2.00f);
    System.out.println(produtoA.getNome()+" - "+produtoF.getPreco());

    produtoProm = new ProdutoPromocao(produtoA);
    produtoProm.setPercPromocao(10.00f);
    System.out.println(produtoProm.getNome()+" - "+produtoProm.getPreco());

    produtoLiq = new ProdutoLiquidacao(produtoF);
    System.out.println(produtoLiq.getNome()+" - "+produtoLiq.getPreco());

    produtoSuperLiq = new ProdutoLiquidacao(produtoProm);
    System.out.println(produtoSuperLiq.getNome()+" - "+produtoSuperLiq.getPreco());
}
 
}