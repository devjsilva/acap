package br.com.etec.acapi.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modeloDAO.BancoDAO;
import br.com.etec.acapi.util.Mensagem;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Funcionario funcionario = new Funcionario();
	

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public String entrar(){
		System.out.println("Efeituando a o login do usuario: " + funcionario.getUsuario());
		FacesContext context = FacesContext.getCurrentInstance();
		
		//boolean existe = new BancoDAO().existeFuncionario(funcionario);
		Funcionario funcionarioLogado = new BancoDAO().existeFuncionario(funcionario);
		
	    if (funcionarioLogado != null) {
	    	
	    	
	    	
	    	context.getExternalContext().getSessionMap().put("usuarioLogado", funcionarioLogado);
	    	
	    	return "bemVindo?faces-redirect=true";
	    	
	    }
	    context.getExternalContext().getFlash().setKeepMessages(true);
	    context.addMessage(null, new FacesMessage("Usuario não encontrado ou senha incorreta!!"));
	    return "login?faces-redirect=true";
	}
	
	public String deslogar(){
		FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().getSessionMap().remove("usuarioLogado");
    
		return "login?faces-redirect=true";
		
	}
	public Funcionario funcionarioLogado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		Funcionario funcionarioLogado =(Funcionario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		return funcionarioLogado;
		
	}


}
