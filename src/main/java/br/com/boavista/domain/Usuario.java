package br.com.boavista.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuario")
@EqualsAndHashCode(callSuper = true)
@Data
@NamedQueries({
	@NamedQuery(name = "Usuario.existeNome", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = ?"),
	@NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha = :senha") })
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 717443138100890749L;

	@NotEmpty(message = "O preenchimento do campo nome é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome (5 - 50)")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotEmpty(message = "O preenchimento do campo login é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo login (5 - 15)")
	@Column(name = "login", nullable = false)
	private String login;

	@NotEmpty(message = "O preenchimento do campo senha é obrigatório.")
	@Size(min = 5, max = 10, message = "Tamanho inválido para o campo senha (5 - 10)")
	@Column(name = "senha", nullable = false)
	private String senha;

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

}
