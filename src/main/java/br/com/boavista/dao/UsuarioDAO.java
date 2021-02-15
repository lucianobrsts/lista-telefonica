package br.com.boavista.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.boavista.domain.Usuario;
import br.com.boavista.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	
	@SuppressWarnings("unchecked")
	public boolean existeNome(String nome) throws RuntimeException {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Usuario> usuarios = null;

		Query consulta = sessao.getNamedQuery("Usuario.existeNome");
		consulta.setString(0, nome);
		usuarios = consulta.list();

		return usuarios.size() > 0;
	}

}
