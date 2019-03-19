package com.desafiostefanini.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contato {

	private String ddd;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	private String celular;

	@Email
	private String email;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
