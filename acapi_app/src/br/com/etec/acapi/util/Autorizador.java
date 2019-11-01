package br.com.etec.acapi.util;

import javax.faces.application.NavigationHandler;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.etec.acapi.modelo.Funcionario;

public class Autorizador implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext  context = event.getFacesContext();
		String pagina = context.getViewRoot().getViewId();
		System.out.println(pagina);
		
		if(pagina.equals("/login.xhtml")){
			return;
		}
		Funcionario usuarioLogador = (Funcionario)context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if (usuarioLogador != null) {
			return;
		}
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "login?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		  System.out.println("FASE: " + event.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		 return PhaseId.RESTORE_VIEW;
	}

}
