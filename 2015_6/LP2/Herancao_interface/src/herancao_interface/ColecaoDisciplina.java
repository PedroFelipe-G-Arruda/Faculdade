/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herancao_interface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
/**
 *
 * @author sky
 */
public class ColecaoDisciplina implements IColecaoGenerica{
    private ArrayList listaDisciplina;
    
    public ColecaoDisciplina(){
        listaDisciplina = new ArrayList();
    }
    public void adicionaDisciplina(Disciplina disciplina){
        listaDisciplina.add(disciplina);
    }
    public Iterator getIterator(){
        return listaDisciplina.iterator();
    }
    public void ordena(){
        Collections.sort(listaDisciplina, new ComparaNome());
    }
    
}