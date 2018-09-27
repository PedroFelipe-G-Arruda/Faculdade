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
public class ColecaoAluno implements IColecaoGenerica{
    private ArrayList listaAluno;
    public ColecaoAluno(){
        listaAluno = new ArrayList();
    }
    public void adicionaAluno(Aluno aluno){
        listaAluno.add(aluno);
    }
    public Iterator getIterator(){
        return listaAluno.iterator();
    }
    public void ordena(){
        Collections.sort(listaAluno, new ComparaNome());
    }
}