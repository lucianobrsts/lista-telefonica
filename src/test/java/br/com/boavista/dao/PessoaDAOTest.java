package br.com.boavista.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.boavista.domain.Contato;
import br.com.boavista.domain.Endereco;
import br.com.boavista.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Antonio Marcos Silva");
		pessoa.setDataNascimento(new Date());
		;

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Goiás");
		endereco.setNumero(674);
		endereco.setBairro("Pan-Americano");
		pessoa.setEndereco(endereco);

		Contato contato = new Contato();
		contato.setEmail("marcos@teste.com.br");
		contato.setCelular("(85) 97654-0281");
		pessoa.setContato(contato);

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		System.out.println(resultado);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		System.out.println(pessoa);
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		pessoaDAO.excluir(pessoa);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		pessoa.setNome("Antonio Lucas");

		Contato contato = new Contato();
		contato.setEmail("antoniolucas@teste.com");
		pessoa.setContato(contato);

		pessoaDAO.editar(pessoa);
	}

}
