package com.desafiostefanini.domain;

import com.desafiostefanini.utils.FormatarUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Size(min = 3, max = 80)
    private String nome;

    @NotNull
    @CPF
    @Pattern(regexp = "[0-9]{11}")
    private String cpf;

    @NotNull
	@Column(name = "data_nascimento")
    private LocalDate dataNascimento;

	@Transient
	private Integer idade;

	private Contato contato;

	@JsonIgnoreProperties("pessoa")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id")
	private List<Endereco> enderecos;

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
		this.nome = FormatarUtils.removerAcentos(nome);
	}

	public String getCpf() {
		return FormatarUtils.formatarCPF(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replace(".", "")
				.replace("-", "");
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@JsonIgnore
	public Integer getIdade() {
		Period idade = Period.between(this.getDataNascimento(), LocalDate.now());
		return idade.getYears();
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
        Pessoa pessoa = (Pessoa) o;
        return getId().equals(pessoa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
