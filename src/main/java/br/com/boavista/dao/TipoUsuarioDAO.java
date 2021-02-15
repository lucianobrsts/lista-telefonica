package br.com.boavista.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.boavista.domain.TipoUsuario;
import br.com.boavista.util.HibernateUtil;

public class TipoUsuarioDAO extends GenericDAO<TipoUsuario>{
	
	@SuppressWarnings("unchecked")
	public boolean existeNome(String nome) throws RuntimeException {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<TipoUsuario> tipoUsuarios = null;

		Query consulta = sessao.getNamedQuery("Usuario.existeNome");
		consulta.setString(0, nome);
		tipoUsuarios = consulta.list();

		return tipoUsuarios.size() > 0;
	}

}
