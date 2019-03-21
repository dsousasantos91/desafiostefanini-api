package com.desafiostefanini.dto;

import com.desafiostefanini.domain.Endereco;

import java.util.List;

public class PessoaEnderecoDTO {

    List<Endereco> enderecos;

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
