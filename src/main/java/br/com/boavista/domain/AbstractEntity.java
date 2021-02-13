package br.com.boavista.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -7384098769743867517L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long codigo;

}
