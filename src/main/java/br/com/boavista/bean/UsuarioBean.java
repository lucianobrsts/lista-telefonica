package br.com.boavista.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.boavista.dao.UsuarioDAO;
import br.com.boavista.domain.Usuario;
import br.com.boavista.util.FacesUtil;
import lombok.Data;

@ManagedBean(name = "usuarioBean")
@ViewScoped
@Data
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -1920692048518468781L;
	private Usuario usuarioCadastro;
	private List<Usuario> listaUsuarios;
	private Long codigo;
	
	@PostConstruct
	public void init() {
		usuarioCadastro = new Usuario();
	}
	
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		try {
			if (usuarioDAO.existeNome(usuarioCadastro.getLogin())) {
				FacesUtil.addErrorMessage("crud.jaExistente");
			} else {
				usuarioDAO.salvar(usuarioCadastro);
				usuarioCadastro = new Usuario();
				FacesUtil.addSuccessMessage("crud.sucesso");
			}
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}
	
	public void carregarPesquisa() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erroListar");
		}
	}
	
	public void excluir() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuarioCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}

	public void editar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.editar(usuarioCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}

}
