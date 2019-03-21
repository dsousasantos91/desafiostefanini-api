package com.desafiostefanini.dto;

import com.desafiostefanini.domain.Contato;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PessoaAtualizacaoDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Contato contato;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaAtualizacaoDTO that = (PessoaAtualizacaoDTO) o;
        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}
