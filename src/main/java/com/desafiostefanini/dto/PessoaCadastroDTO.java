package com.desafiostefanini.dto;

import com.desafiostefanini.domain.Contato;
import com.desafiostefanini.domain.Endereco;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PessoaCadastroDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Contato contato;
    private List<Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaCadastroDTO that = (PessoaCadastroDTO) o;
        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}
