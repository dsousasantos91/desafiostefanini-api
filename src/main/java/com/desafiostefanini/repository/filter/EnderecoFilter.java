package com.desafiostefanini.repository.filter;

import com.desafiostefanini.domain.SiglaUnidadeFederativa;

public class EnderecoFilter {

    private String cep;
    private String cidade;
    private SiglaUnidadeFederativa uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
}
