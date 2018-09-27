/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herancao_interface;

/**
 *
 * @author sky
 */
public class TesteColecoes2 {

    public static void main(String args[]){
        Disciplina disciplina;
        ColecaoDisciplina colecaoDisciplina = new ColecaoDisciplina();
        
        ImprimeColecao relatorio;
        
        disciplina = new Disciplina();
        disciplina.setCodigo(1010);
        disciplina.setNome("Programacao orientada a objetos");
        disciplina.setSemestre(2);
        disciplina.setCargaHoraria(60);
        colecaoDisciplina.adicionaDisciplina(disciplina);
    
            disciplina = new Disciplina();
        disciplina.setCodigo(1020);
        disciplina.setNome("Analise orientada a objetos");
        disciplina.setSemestre(5);
        disciplina.setCargaHoraria(60);
        colecaoDisciplina.adicionaDisciplina(disciplina);
        
                disciplina = new Disciplina();
        disciplina.setCodigo(1030);
        disciplina.setNome("Projeto orientada a objetos");
        disciplina.setSemestre(6);
        disciplina.setCargaHoraria(40);
        colecaoDisciplina.adicionaDisciplina(disciplina);
        
        colecaoDisciplina.ordena();
        relatorio = new ImprimeColecao(colecaoDisciplina);
        relatorio.imprimir();
    }
}