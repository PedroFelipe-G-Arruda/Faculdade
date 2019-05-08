package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginMB {
	private String login = "";
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String autenticator() {
		if(login.equals("admin"))
			return "admin";
		else if(login.length()>6)
			return "sucesso";
		else
			return "erro";
	}
}
