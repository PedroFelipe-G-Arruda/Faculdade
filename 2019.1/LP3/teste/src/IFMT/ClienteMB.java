package IFMT;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
public class ClienteMB {
	private Cliente cliente = new Cliente();
	private String mensagem = "";
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String validar() {
		FacesContext.getCurrentInstance().addMessage("frmCliente", new FacesMessage("Tudo Certo!"));
		mensagem = "Cliente Validado!";
		return null;
	}
}
