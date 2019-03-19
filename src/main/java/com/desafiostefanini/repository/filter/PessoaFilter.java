package com.desafiostefanini.repository.filter;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PessoaFilter {

	private String nome;

	@CPF
	private String cpf;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimentoDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimentoAte;

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

	public LocalDate getDataNascimentoDe() {
		return dataNascimentoDe;
	}

	public void setDataNascimentoDe(LocalDate dataNascimentoDe) {
		this.dataNascimentoDe = dataNascimentoDe;
	}

	public LocalDate getDataNascimentoAte() {
		return dataNascimentoAte;
	}

	public void setDataNascimentoAte(LocalDate dataNascimentoAte) {
		this.dataNascimentoAte = dataNascimentoAte;
	}

}
