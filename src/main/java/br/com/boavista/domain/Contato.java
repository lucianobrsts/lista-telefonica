package br.com.boavista.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Embeddable
@Data
public class Contato implements Serializable {

	private static final long serialVersionUID = -6244387740739026823L;

	@Size(max = 14)
	@Column(length = 14)
	private String telefone;

	@Size(max = 15)
	@Column(length = 15)
	private String celular;

	@Size(max = 15)
	@Column(length = 15)
	private String whatsapp;

	@Email
	private String email;

	public void setEmail(String email) {
		this.email = email.toUpperCase();
	}

}
