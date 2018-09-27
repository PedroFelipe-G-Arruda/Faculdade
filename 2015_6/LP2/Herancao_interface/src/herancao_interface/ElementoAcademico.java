package herancao_interface;

public class ElementoAcademico implements IPossuiNome{
    private int codigo;
    private String nome;
    
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }   
}