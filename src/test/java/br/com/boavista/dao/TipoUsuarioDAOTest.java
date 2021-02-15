package br.com.boavista.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.boavista.domain.TipoUsuario;

public class TipoUsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setNome("Administrador");

		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		tipoUsuarioDAO.salvar(tipoUsuario);
	}

	@Test
	@Ignore
	public void listar() {
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		List<TipoUsuario> resultado = tipoUsuarioDAO.listar();
		System.out.println(resultado);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		TipoUsuario tipoUsuario = tipoUsuarioDAO.buscar(codigo);
		System.out.println(tipoUsuario);
	}

	@Test
	public void excluir() {
		Long codigo = 1L;
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		TipoUsuario tipoUsuario = tipoUsuarioDAO.buscar(codigo);
		tipoUsuarioDAO.excluir(tipoUsuario);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
		TipoUsuario tipoUsuario = tipoUsuarioDAO.buscar(codigo);
		tipoUsuario.setNome("Vendedor");

		tipoUsuarioDAO.editar(tipoUsuario);
	}

}
