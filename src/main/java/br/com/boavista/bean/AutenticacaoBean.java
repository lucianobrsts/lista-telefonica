package br.com.boavista.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.boavista.dao.UsuarioDAO;
import br.com.boavista.domain.Usuario;
import br.com.boavista.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuarioLogado;

	public String autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
			if (usuarioLogado == null) {
				FacesUtil.addErrorMessage("autenticacao.erroLogin");
				return null;
			} else {
				if (usuarioLogado != null) {
					getSession().setAttribute("usuario", usuarioLogado);
				}
				FacesUtil.addSuccessMessage("autenticacao.sucesso");
				return "/pages/index.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("autenticacao.erro");
			return null;
		}
	}

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		FacesUtil.addSuccessMessage("autenticacao.sair");
		return "/pages/login/autenticacao.xhtml?faces-redirect=true;";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public HttpSession getSession() {
		return (HttpSession) getFacesContext().getExternalContext().getSession(false);
	}

}
