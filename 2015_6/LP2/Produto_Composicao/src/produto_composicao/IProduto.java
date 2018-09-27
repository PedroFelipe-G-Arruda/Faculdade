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
public interface IProduto {
    public void setNome(String pNome);
    public String getNome();
    public void setPreco(float pPreco);
    public float getPreco();
    public void setEstoque(int pEstoque);
    public int getEstoque();
}