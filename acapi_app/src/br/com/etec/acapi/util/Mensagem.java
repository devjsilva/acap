package br.com.etec.acapi.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {

	
	public void exibirMensagem(String mensagem1, String mensagem2) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem1,mensagem2));
    }
}
