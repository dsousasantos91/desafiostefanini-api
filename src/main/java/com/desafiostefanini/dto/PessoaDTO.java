package com.desafiostefanini.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = -8384553028144399183L;

    private Long id;

    @NotNull
    @Size(min = 3, max = 80)
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    private Integer idade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return getId().equals(pessoaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
