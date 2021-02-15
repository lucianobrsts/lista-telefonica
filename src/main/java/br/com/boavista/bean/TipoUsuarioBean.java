package br.com.boavista.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.boavista.dao.TipoUsuarioDAO;
import br.com.boavista.domain.TipoUsuario;
import br.com.boavista.util.FacesUtil;
import lombok.Data;

@ManagedBean(name = "tipoUsuarioBean")
@ViewScoped
@Data
public class TipoUsuarioBean implements Serializable {

	private static final long serialVersionUID = -1920692048518468781L;
	private TipoUsuario tipoUsuarioCadastro;
	private List<TipoUsuario> listaTipoUsuarios;
	private Long codigo;
	
	@PostConstruct
	public void init() {
		tipoUsuarioCadastro = new TipoUsuario();
	}
	
	public void salvar() {
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();

		try {
			if (tipoUsuarioDAO.existeNome(tipoUsuarioCadastro.getNome())) {
				FacesUtil.addErrorMessage("crud.jaExistente");
			} else {
				tipoUsuarioDAO.salvar(tipoUsuarioCadastro);
				tipoUsuarioCadastro = new TipoUsuario();
				FacesUtil.addSuccessMessage("crud.sucesso");
			}
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}
	
	public void carregarPesquisa() {
		try {
			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			listaTipoUsuarios = tipoUsuarioDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erroListar");
		}
	}
	
	public void excluir() {
		try {
			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			tipoUsuarioDAO.excluir(tipoUsuarioCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}

	public void editar() {
		try {
			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			tipoUsuarioDAO.editar(tipoUsuarioCadastro);
			FacesUtil.addSuccessMessage("crud.sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.addErrorMessage("crud.erro");
		}
	}

}
