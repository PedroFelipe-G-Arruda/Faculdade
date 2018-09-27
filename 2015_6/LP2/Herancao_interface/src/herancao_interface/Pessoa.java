package herancao_interface;
public class Pessoa implements IPossuiNome{
    private int matricula;
    private String nome;
    
    public void setMatricula(int matricula){
        this.matricula=matricula;
    }
    public int getMatricula(){
        return matricula;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
}