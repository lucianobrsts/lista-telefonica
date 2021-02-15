package br.com.boavista.util;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.boavista.bean.AutenticacaoBean;
import br.com.boavista.domain.Usuario;

public class AutenticacaoPhaseListener implements PhaseListener{

	private static final long serialVersionUID = -1843893160341384131L;

	@Override
	public void afterPhase(PhaseEvent event) {
		AutenticacaoBean autenticacaoBean = new AutenticacaoBean();

		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();

		boolean ehPaginaAutenticacao = paginaAtual.contains("autenticacao.xhtml");

		if (!ehPaginaAutenticacao) {
			Usuario usuario = (Usuario) autenticacaoBean.getSession().getAttribute("usuario");

			if (usuario == null) {
				FacesUtil.addErrorMessage("autenticacao.naoLogado.");

				Application application = facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/autenticacao.xhtml?faces-redirect=true");
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
