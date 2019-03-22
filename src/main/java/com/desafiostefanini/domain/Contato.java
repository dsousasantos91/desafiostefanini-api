package com.desafiostefanini.domain;

import com.desafiostefanini.utils.FormatarUtils;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Contato {

	private String ddd;

	@Size(max = 10)
	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@NotNull
	@Size(max = 10)
	private String celular;

	@Email
	private String email;

	public String getDdd() {
		return FormatarUtils.formatarDDD(ddd);
	}

	public void setDdd(String ddd) {
		this.ddd = ddd.replace("(", "")
				.replace(")", "");
	}

	public String getTelefoneFixo() {
		return FormatarUtils.formatarTelefoneFixo(telefoneFixo);
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo.replace("-", "");
	}

	public String getCelular() {
		return FormatarUtils.formatarCelular(celular);
	}

	public void setCelular(String celular) {
		this.celular = celular.replace("-", "");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
