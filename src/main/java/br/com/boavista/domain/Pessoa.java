package br.com.boavista.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pessoa")
@EqualsAndHashCode(callSuper = true)
@Data
@NamedQueries({
	@NamedQuery(name = "Pessoa.existeNome", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.nome = ?") })
public class Pessoa extends AbstractEntity {

	private static final long serialVersionUID = -4461687923626275439L;

	@NotEmpty(message = "O preenchimento do campo nome é obrigatório.")
	@Size(min = 3, max = 50, message = "Tamanho inválido para o campo nome (3 - 50)")
	@Column(name = "nome", nullable = false)
	private String nome;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "observacao", length = 150)
	private String observacao;

	@Embedded
	protected Endereco endereco;

	@Embedded
	protected Contato contato;

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao.toUpperCase();
	}

	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public Contato getContato() {
		if (contato == null) {
			contato = new Contato();
		}
		return contato;
	}

}
