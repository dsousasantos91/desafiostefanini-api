package com.desafiostefanini.domain;

import com.desafiostefanini.utils.FormatarUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

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

    private Boolean ativo;

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

    public Boolean getAtivo() {
        return ativo;
    }

    @JsonIgnore
    @Transient
    public boolean isAtivo(Boolean ativo) {
        return !this.ativo;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Endereco endereco = (Endereco) o;
		return getId().equals(endereco.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
