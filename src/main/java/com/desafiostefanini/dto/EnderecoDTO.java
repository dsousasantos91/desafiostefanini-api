package com.desafiostefanini.dto;

import com.desafiostefanini.domain.SiglaUnidadeFederativa;
import com.desafiostefanini.domain.TipoEndereco;
import com.desafiostefanini.utils.FormatarUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class EnderecoDTO {

    private Long id;

    @Size(max = 8)
    private String cep;

    @NotNull
    @Size(max = 100)
    private String logradouro;

    @NotNull
    @Max(999)
    private Integer numero;

    private String complemento;

    @NotNull
    @Size(max = 50)
    private String bairro;

    @NotNull
    @Size(max = 50)
    private String cidade;

    @NotNull
    private Boolean ativo;

    @NotNull
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
        this.cep = cep.replace(".", "").replace("-", "");
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
