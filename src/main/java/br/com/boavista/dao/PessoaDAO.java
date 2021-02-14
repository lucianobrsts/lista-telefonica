package br.com.boavista.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.boavista.domain.Pessoa;
import br.com.boavista.util.HibernateUtil;

public class PessoaDAO extends GenericDAO<Pessoa>{
	
	@SuppressWarnings("unchecked")
	public boolean existeNome(String nome) throws RuntimeException {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Pessoa> pessoas = null;

		Query consulta = sessao.getNamedQuery("Pessoa.existeNome");
		consulta.setString(0, nome);
		pessoas = consulta.list();

		return pessoas.size() > 0;
	}

}
