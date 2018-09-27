/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herancao_interface;
import java.util.Comparator;
/**
 *
 * @author sky
 */
public class ComparaNome implements Comparator{
    public int compare(Object objeto1, Object objeto2){
        String nome1 = ((IPossuiNome)objeto1).getNome();
        String nome2 = ((IPossuiNome)objeto2).getNome();
        return nome1.compareTo(nome2);
    }
}