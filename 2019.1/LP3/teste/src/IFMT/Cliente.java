package IFMT;

import java.util.Date;

public class Cliente {
	
	
	private long id;
	private String nome;
	private Date dataNasc;
	private float salario;
	private int pontosFidelidades;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public int getPontosFidelidades() {
		return pontosFidelidades;
	}
	public void setPontosFidelidades(int pontosFidelidades) {
		this.pontosFidelidades = pontosFidelidades;
	}
	
}
