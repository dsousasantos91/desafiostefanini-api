package com.desafiostefanini.model;

import com.desafiostefanini.utils.FormatarUtils;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private SiglaUnidadeFederativa uf;

	@Enumerated(EnumType.STRING)
	private TipoEndereco tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return FormatarUtils.formatarCEP(cep);
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public SiglaUnidadeFederativa getUf() {
		return uf;
	}

	public void setUf(SiglaUnidadeFederativa uf) {
		this.uf = uf;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
