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

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tipo_usuario")
@NamedQueries({
		@NamedQuery(name = "TipoUsuario.existeNome", query = "SELECT tipoUsuario FROM TipoUsuario tipoUsuario WHERE tipoUsuario.nome = ?") })
public class TipoUsuario extends AbstractEntity {

	private static final long serialVersionUID = 5453954709255516306L;

	@NotEmpty(message = "O preenchimento do campo nome é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome (5 - 50)")
	@Column(name = "nome", nullable = false)
	private String nome;

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

}
