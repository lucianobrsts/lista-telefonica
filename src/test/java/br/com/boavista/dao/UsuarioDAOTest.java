package br.com.boavista.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.boavista.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Antonio Marcos Silva");
		usuario.setLogin("lucianobrsts");
		usuario.setSenha("123456");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		System.out.println(resultado);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		System.out.println(usuario);
	}

	@Test
	public void excluir() {
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario= usuarioDAO.buscar(codigo);
		usuarioDAO.excluir(usuario);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		usuario.setNome("Carlinhos Maia");

		usuarioDAO.editar(usuario);
	}

}
